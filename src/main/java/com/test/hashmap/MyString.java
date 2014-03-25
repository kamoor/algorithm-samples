package com.test.hashmap;

public class MyString{
	
	private String name;
	
	
	public MyString(String name){
		this.name = name;
	}

	@Override
	public int hashCode() {
		return (int)(Math.random() * 5000d);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyString other = (MyString) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
