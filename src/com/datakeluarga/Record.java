package com.datakeluarga;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Record {
	private String name;
	private String phone;
	private String email;
	private String city;
	
	private String child;
	private String parent;
	
	@XmlElementWrapper
	@XmlAnyElement
	public List<Keluarga> keluarga;
	
	public String getName(){
		return name;
	}
	
	@XmlElement
	public void setName(String name){
		this.name=name;
	}
	
	public String getPhone(){
		return phone;
	}
	
	@XmlElement
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getEmail(){
		return email;
	}
	
	@XmlElement
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getCity(){
		return city;
	}
	
	@XmlElement
	public void setCity(String city){
		this.city=city;
	}
	
	public String getChild(){
		return child;
	}
	
	@XmlElement
	public void setChild(String child){
		this.child=child;
	}
	
	public String getParent(){
		return parent;
	}
	
	@XmlElement
	public void setParent(String parent){
		this.parent=parent;
	}
	
	
	public interface Keluarga{
		public void setAnak(String anak);
		
	}

}








