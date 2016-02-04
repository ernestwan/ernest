package cn.openjpa.demos.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Message implements EntityWithColumns {
	
	@Embedded
	private ExtraColumns extraColumns;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="message")
	private String info;
	
	@Version
	private int version;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	@Override
	public ExtraColumns getExtraColumns() {
		// TODO Auto-generated method stub
		return extraColumns;
	}

	@Override
	public void setExtraColumns(ExtraColumns extraColumns) {
		// TODO Auto-generated method stub
		this.extraColumns = extraColumns;
	}

}
