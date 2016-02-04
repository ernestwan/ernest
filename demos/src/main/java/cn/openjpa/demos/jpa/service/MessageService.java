package cn.openjpa.demos.jpa.service;

import java.util.List;

import cn.openjpa.demos.jpa.domain.Message;

public interface MessageService {
	List<Message> findAll();
}
