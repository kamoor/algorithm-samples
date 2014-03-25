package com.test.designpatterns.prototype;

public class PrototypeBean implements Cloneable {

	InnerObject object;

	public PrototypeBean(String objName) {
		object = new InnerObject(objName);

	}

	public PrototypeBean(InnerObject object) {
		this.object = object;
	}

	public InnerObject getObject() {
		return object;
	}

	@Override
	protected Object clone() {

		return new PrototypeBean(new InnerObject(object.name));
	}

	class InnerObject {

		String name;

		InnerObject(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		
		public void setName(String name){
			this.name = name;
		}
		

	}

}
