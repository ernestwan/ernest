package cn.openjpa.demos.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cn.openjpa.demos.jpa.domain.User;

@SuppressWarnings({"serial", "unchecked"})
public class UserServiceImpl extends PersistenceService implements UserService {

	public static final int USER_COUNT = 10;
	
	public UserServiceImpl(boolean managed) {
		super(managed);
	}

	@Override
	public List<User> findAll() {
		Query q = getEntityManager().createQuery("select u from User u");
		return (List<User>) q.getResultList();
	}

	@Override
	public User find(int userid) {
		return getEntityManager().find(User.class, userid);
	}
	
	@Override
	public boolean create(User u) {
		return save(null, u); 
	}
	
	@Override
	public boolean update(int userid) {
		return save(userid, null); 
	}
	
	private boolean save(Integer userid, User user) {
		EntityManager em = begin();
		User u = find(userid);
		if (null != u) {
			if (null == em.merge(u)) {
				return false;
			}
		} else {
			if (null == user) {
				return false;
			}
			em.persist(user);
		}
		commit();
		return true;
	}
	
}
