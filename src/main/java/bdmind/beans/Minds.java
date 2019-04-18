package bdmind.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Minds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	String name;
	
	String xmind;
	
	public String getXmind() {
		return xmind;
	}

	public void setXmind(String xmind) {
		this.xmind = xmind;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	Date update_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
}
