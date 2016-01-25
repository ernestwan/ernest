package cn.openjpa.demos.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class User implements EntityWithTechnicalColumns{

	@Embedded
	private TechnicalColumns technicalColumns;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String username;
	
	@Version
	private int version;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getVersion() {
		return version;
	}
	
	
	@Override
	public TechnicalColumns getTechnicalColumns() {
		// TODO Auto-generated method stub
		return technicalColumns;
	}
	@Override
	public void setTechnicalColumns(TechnicalColumns technicalColumns) {
		// TODO Auto-generated method stub
		this.technicalColumns = technicalColumns;
	}
	
}
