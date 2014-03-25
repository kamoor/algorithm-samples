package com.test.arraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Create an arraylist by yourself with out java.util
 * @author kamoorr
 *
 * @param <X>
 */
public class MyArrayList<X> implements List<X> {

	private X[] data = null;
	int length =  0;
	int allocatedSize = 0;
	
	
	public MyArrayList(){
		this(10);
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public MyArrayList(int allocatedSize){
		this.allocatedSize = allocatedSize;
		data = (X[])new Object[allocatedSize];
	}
	
	@SuppressWarnings("unchecked")
	public boolean add(X object){
		
		
		if(allocatedSize <= length ){
			//resize this array
			allocatedSize = allocatedSize * 2;
			X[] newData = (X[])new Object[allocatedSize];
			int lengthHalf = length >> 1;
			for(int i=0; i<lengthHalf;i++){
				newData[i] = data[i];
				int halfPlus = lengthHalf + i;
				newData[halfPlus] = data[halfPlus];
			}
			data = newData;
			
		}
		data[length++] = object;
		return true;
	}
	
	
	public X get(int position){
		if(position >= length){
			throw new IndexOutOfBoundsException();
		}else{
			return data[position];
		}
		
	}
	
	
	
	public int size(){
		return length;
	}
	
	
	public static void main(String[] args) {
		
		long t = System.currentTimeMillis();
		List<Integer> l = new MyArrayList<Integer>(3);
		for(int i=0;i<1000000;i++){
			l.add(new Integer(i));
		}
		
		System.out.println("Kamoor List Inserted in "+ (System.currentTimeMillis() - t));
		
		t = System.currentTimeMillis();
		List<Integer> l1 = new ArrayList<Integer>(3);
		for(int i=0;i<1000000;i++){
			l1.add(new Integer(i));
		}
		System.out.println("java arraylist Inserted in "+ (System.currentTimeMillis() - t));
		
		System.out.println("Get 500th element for testing purpose "+ l.get(500).toString());
		
		//for(int i =0 ;i<l.size(); i++){
			//System.out.println(l.get(i));
		//}

	}


	@Override
	public void add(int index, X element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean addAll(Collection<? extends X> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(int index, Collection<? extends X> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterator<X> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ListIterator<X> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListIterator<X> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public X remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public X set(int index, X element) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<X> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
