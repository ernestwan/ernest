package cn.openjpa.demos.jpa.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExtraColumns {

	@Column(name="updateTime", insertable=false, updatable=true)
	private Timestamp updateTime;
	
	@Column(name="createTime", insertable=true, updatable=false)
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
