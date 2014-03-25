package com.test.designpatterns.iterator;

public class List<X> {

	X data[];
	int size = 0;

	public List(X data[]) {
		this.data = data;
		if(data !=null)
			size = data.length;
	}

	public Iterator<X> getIterator() {
		return new ListIterator();
	}

	class ListIterator implements Iterator<X> {

		int index = 0;

		public X next() {
			if (size ==0 || index == size) {
				return null;
			} else {
				index++;
				return data[index - 1];
			}

		}

		public boolean hasNext() {
			if (size==0 || index == size) {
				return false;
			} else {
				return true;
			}
		}
	}

}
