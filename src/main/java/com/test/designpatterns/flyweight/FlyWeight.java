package com.test.designpatterns.flyweight;

public interface FlyWeight {
	
	

	public String getServiceURL();
	public FlyWeight getService(ServiceE serviceType);
	
	
	public enum ServiceE{
		
		FIND_USER("find.user"),
		CREATE_USER("create.user");
		
		private String property;
		
		
		ServiceE(String property){
			this.property = property;
		}
		
		
		
		
	}
}



