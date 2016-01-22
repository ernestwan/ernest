package cn.jersey.grizzly.helloworld;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContextType;

public class ServiceFactory {

private static final Map<String, SecondResource> _services = new HashMap<String, SecondResource>();
    
    public synchronized static SecondResource getService(String unit) {
        return getService(unit, null);
    }
    
    /**
     * Creates a persistence unit of given name configured with the given
     * name-value parameters. 
     * 
     * @param unit name of the persistence unit. A <code>META-INF/persistence.xml</code> must be 
     * available with the same unit name in the classpath.
     */
    public synchronized static SecondResource getService(String unit, Map<String,Object> config) {
    	SecondResource service = _services.get(unit);
        if (service == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(unit, config);
            service = new SecondResource(unit, emf, false, PersistenceContextType.TRANSACTION);
            _services.put(unit, service);
        }
        return service;
    }
	
}
