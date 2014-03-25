package com.test.clone;

/**
 * Cloneable example
 * @author kamoorr
 *
 */
public class CObject implements Cloneable {
	
	
	String name;
    String dept;
 	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
    
	
	public CObject clone(){
		try{
			return (CObject)super.clone();
		}catch(Exception e){
			return null;
		}
	}
    

}
