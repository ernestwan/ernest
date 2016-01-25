/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package cn.openjpa.demos.jpa.server;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContextType;

import cn.openjpa.demos.jpa.service.UserService;
import cn.openjpa.demos.jpa.service.UserServiceImpl;

/**
 * A container of persistence units. Typically a JEE container will create, manage and inject
 * the persistence units to the user artifacts.  
 * 
 * @author Pinaki Poddar
 *
 */
public class ServiceFactory {
    private static final Map<String, UserService> _services = new HashMap<String, UserService>();
    
    public synchronized static Object getService(String unit) {
        return getService(unit, null);
    }
    
    /**
     * Creates a persistence unit of given name configured with the given
     * name-value parameters. 
     * 
     * @param unit name of the persistence unit. A <code>META-INF/persistence.xml</code> must be 
     * available with the same unit name in the classpath.
     */
    public synchronized static Object getService(String unit, Map<String,Object> config) {
    	UserService service = _services.get(unit);
        if (service == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(unit, config);
            service = new UserServiceImpl(unit, emf, false, PersistenceContextType.TRANSACTION); // new a UserServiceImpl instance
            _services.put(unit, service);
        }
        return service;
    }
}
