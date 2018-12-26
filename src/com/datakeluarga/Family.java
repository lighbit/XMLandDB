package com.datakeluarga;

/**
 * @author zulkarnaen
 */

public class Family {
	private String name;
	private String phone;
	private String email;
	private String city;
	
	private String child;
	private String parent;
	
	public Family(){
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	public String getChild(){
		return child;
	}
	
	public void setChild(String child){
		this.child=child;
	}
	
	public String getParent(){
		return parent;
	}
	
	public void setParent(String parent){
		this.parent=parent;
	}
}
