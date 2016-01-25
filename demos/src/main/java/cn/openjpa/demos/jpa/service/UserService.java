package cn.openjpa.demos.jpa.service;

import java.util.List;
import java.util.Map;

import cn.openjpa.demos.jpa.domain.User;

public interface UserService extends ServiceManager {
	
	void clean();
	boolean initialize(Map<String,Object> config);
	
	List<User> findAll();

}
