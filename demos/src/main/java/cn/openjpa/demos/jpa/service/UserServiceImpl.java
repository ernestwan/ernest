package cn.openjpa.demos.jpa.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import cn.openjpa.demos.jpa.domain.User;
import cn.openjpa.demos.jpa.server.PersistenceService;
import cn.openjpa.demos.utils.PropertyHelper;

@SuppressWarnings({"serial", "unchecked"})
public class UserServiceImpl extends PersistenceService implements UserService {

	public static final int USER_COUNT = 10;
	
	public UserServiceImpl(String unit, EntityManagerFactory emf, boolean managed, PersistenceContextType scope) {
		super(unit, emf, managed, scope);
	}
	
	//public UserServiceImpl() {}

	@Override
	public void clean() {
		EntityManager em = begin();
		Set<EntityType<?>> entities = em.getMetamodel().getEntities();
		for (EntityType<?> type : entities) {
			System.err.println("Deleting all instances of " + type.getName());
			em.createQuery("delete from " + type.getName() + " p").executeUpdate();
		}
		commit();
	}
	
	@Override
	public boolean initialize(Map<String, Object> config) {
		if (isInitialized()) {
            return false;
        }
        EntityManager em = begin();
        if (config == null) {
            config = Collections.EMPTY_MAP;
        }
        int nCustomer  = PropertyHelper.getInteger(config, "openjpa.demos.User.Count",  USER_COUNT);
        
        System.err.println("Creating " + nCustomer + " new Customer");
        for (int i = 1; i < nCustomer; i++) {
            User customer = new User();
            customer.setUsername("Customer-" + i);
            em.persist(customer);
        }
        commit();
        return true;
	}

	public boolean isInitialized() {
        return count(User.class) > 0;
    }
	
	public long count(Class<?> cls) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> c = cb.createQuery(Long.class);
        Root<?> from = c.from(cls);
        c.select(cb.count(from));
        return em.createQuery(c).getSingleResult();
    }

	@Override
	public List<User> findAll() {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("select u from User u");
		return (List<User>) q.getResultList();
	}

}
