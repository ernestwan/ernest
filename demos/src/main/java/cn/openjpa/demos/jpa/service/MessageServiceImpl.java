package cn.openjpa.demos.jpa.service;

import java.util.List;

import javax.persistence.Query;

import cn.openjpa.demos.jpa.domain.Message;

@SuppressWarnings({"serial", "unchecked"})
public class MessageServiceImpl extends PersistenceService implements MessageService {

	public MessageServiceImpl(boolean managed) {
		super(managed);
	}
	
	@Override
	public List<Message> findAll() {
		Query q = getEntityManager().createQuery("select m from Message m");
		return (List<Message>) q.getResultList();
	}

}
