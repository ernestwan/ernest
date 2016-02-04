package cn.openjpa.demos.jpa.service;

import java.util.List;

import cn.openjpa.demos.jpa.domain.User;

public interface UserService {
	
	List<User> findAll();
	User find(int userid);
	boolean create(User u);
	boolean update(int userid);
	
}
