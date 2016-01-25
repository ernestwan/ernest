package cn.openjpa.demos.jpa.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TimestampEntityListener {

	@PrePersist
	
	    void onCreate(Object entity) {
	
	        if(entity instanceof EntityWithTechnicalColumns) {
	
	            EntityWithTechnicalColumns eact = (EntityWithTechnicalColumns)entity;
	
	            if(eact.getTechnicalColumns() == null) {
	
	                eact.setTechnicalColumns(new TechnicalColumns());
	
	            }
	
	            eact.getTechnicalColumns().setCreateTime((new Timestamp((new Date()).getTime())));
	
	        }
	
	    }
	
	     
	
	    @PreUpdate
	
	    void onPersist(Object entity) {
	
	        if(entity instanceof EntityWithTechnicalColumns) {
	
	            EntityWithTechnicalColumns eact = (EntityWithTechnicalColumns)entity;
	
	            if(eact.getTechnicalColumns() == null) {
	
	                eact.setTechnicalColumns(new TechnicalColumns());
	
	            }
	
	            eact.getTechnicalColumns().setUpdateTime(new Timestamp((new Date()).getTime()));
	
	        }
	
	    }

	
}
