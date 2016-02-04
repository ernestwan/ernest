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
package cn.openjpa.demos.jpa.service;

import java.util.HashMap;
import java.util.Map;

/**
 * A container of persistence units. Typically a JEE container will create, manage and inject
 * the persistence units to the user artifacts.  
 * 
 * @author Pinaki Poddar
 *
 */
public class ServiceFactory {
	
    private static final Map<String, Object> _services = new HashMap<String, Object>();
    
    /**
     * Creates a persistence unit of given name configured with the given
     * name-value parameters. 
     * 
     * @param unit name of the persistence unit. A <code>META-INF/persistence.xml</code> must be 
     * available with the same unit name in the classpath.
     */
    public synchronized static Object getService(Class<?> unit) {
    	String name = unit.getName();
    	Object service = _services.get(name);
        if (service == null) {
            // new a UserServiceImpl instance
            if (unit == UserService.class) {
            	service = new UserServiceImpl(true);
            } else if (unit == MessageService.class) {
            	service = new MessageServiceImpl(true); 
            }
            _services.put(name, service);
        }
        return service;
    }
    
}
