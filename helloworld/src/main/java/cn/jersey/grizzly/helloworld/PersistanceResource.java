package cn.jersey.grizzly.helloworld;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContextType;

@SuppressWarnings("serial")
public class PersistanceResource implements Serializable {
	private final EntityManagerFactory emf;
	private final String unitName;
    private final boolean isManaged;
    private final PersistenceContextType scope;
    
    private ThreadLocal<EntityManager> thread = new ThreadLocal<EntityManager>();
    private ReentrantLock lock = new ReentrantLock();
    
	public PersistanceResource(String unit, EntityManagerFactory emf, boolean managed, 
            PersistenceContextType scope) {
		this.unitName = unit;
        this.emf = emf;
        this.isManaged = managed;
        this.scope = scope;
	}
	
	public final EntityManagerFactory getUnit() {
        return emf;
    }

    public final String getUnitName() {
        return unitName;
    }
    
    public final boolean isManaged() {
        return isManaged;
    }
    
    public final PersistenceContextType getContextType() {
        return scope;
    }
    
    protected EntityManager getEntityManager() {
        try {
            lock.lock();
            EntityManager em = thread.get();
            if (em == null || !em.isOpen()) {
                em = emf.createEntityManager();
                thread.set(em);
            }
            return em;
        } finally {
            lock.unlock();
        }
    }
    
    protected EntityManager newEntityManager() {
        return emf.createEntityManager();
    }
    
    protected EntityManager begin() {
        try {
            lock.lock();
            EntityManager em = getEntityManager();
            if (isManaged) {
                em.joinTransaction();
            } else {
                if (!em.getTransaction().isActive()) {
                    em.getTransaction().begin();
                }
            }
            return em;
        } finally {
            lock.unlock();
        }
    }
    
    protected void commit() {
        try {
            lock.lock();
            EntityManager em = getEntityManager();
            if (isManaged) {
                em.flush();
            } else {
                assertActive();
                em.getTransaction().commit();
            }
            if (scope == PersistenceContextType.TRANSACTION) {
                em.clear();
            }
        } finally {
            lock.unlock();
        }
    }
    
    protected void rollback() {
        try {
            lock.lock();
            EntityManager em = getEntityManager();
            if (isManaged) {
                
            } else {
                em.getTransaction().rollback();
            }
            if (scope == PersistenceContextType.TRANSACTION) {
                em.clear();
            }
        } finally {
            lock.unlock();
        }
    }
    
    protected void assertActive() {
        EntityManager em = thread.get();
        String thread = Thread.currentThread().getName();
        assertTrue("No persistent context is associated with " + thread, em != null);
        assertTrue("Persistent context " + em + " associated with " + thread + " has been closed", em.isOpen());
        if (!isManaged) {
            assertTrue("Persistent context " + em + " associated with " + thread + " has no active transaction", 
                    em.getTransaction().isActive());
        }
    }

    protected void assertTrue(String s, boolean p) {
        if (!p) {
            System.err.println(s);
            throw new RuntimeException(s);
        }
    }
	
}
