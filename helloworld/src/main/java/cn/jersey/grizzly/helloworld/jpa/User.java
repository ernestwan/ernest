package cn.jersey.grizzly.helloworld.jpa;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="users")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     @Basic
     private String Name;
     @Basic
     private String Login;
     @Basic
     private String Password;

	 
	 
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Version
     private int version;
     public int getVersion() {
         return version;
     }
}

