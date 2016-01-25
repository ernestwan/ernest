package cn.openjpa.demos.jpa.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TechnicalColumns {

	@Column(name="UPDATE_TIME", insertable=false, updatable=true)
	private Timestamp updateTime;
	
	@Column(name="CREATION_TIME", insertable=true, updatable=false)
	private Timestamp createTime;

	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
