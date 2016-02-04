package cn.openjpa.demos.jpa.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TimestampEntityListener {

	@PrePersist
	
	    void onCreate(Object entity) {
	
	        if(entity instanceof EntityWithColumns) {
	
	            EntityWithColumns eact = (EntityWithColumns)entity;
	
	            if(eact.getExtraColumns() == null) {
	
	                eact.setExtraColumns(new ExtraColumns());
	
	            }
	
	            eact.getExtraColumns().setCreateTime((new Timestamp((new Date()).getTime())));
	
	        }
	
	    }
	
	     
	
	    @PreUpdate
	
	    void onPersist(Object entity) {
	
	        if(entity instanceof EntityWithColumns) {
	
	            EntityWithColumns eact = (EntityWithColumns)entity;
	
	            if(eact.getExtraColumns() == null) {
	
	                eact.setExtraColumns(new ExtraColumns());
	
	            }
	
	            eact.getExtraColumns().setUpdateTime(new Timestamp((new Date()).getTime()));
	
	        }
	
	    }

	
}
