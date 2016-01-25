package cn.openjpa.demos.jpa.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity {

	private Timestamp createDate;
	private Timestamp updateDate;
	
	@Column(name = "updatetime", insertable = false, updatable = true)
	public Timestamp getCreateDate() {
		return createDate;
	}
	
	@Column(name = "createtime", insertable = true, updatable = false)
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@PrePersist
	void onCreate() {
	    this.setCreateDate(new Timestamp((new Date()).getTime()));
	}

	@PreUpdate
	void onPersist() {
		this.setUpdateDate(new Timestamp((new Date()).getTime()));
	}
	
}
