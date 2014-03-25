package com.test.fun;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Refrigerator {
	
	List<Item> items;
	Map<RACKTYPE, Integer> capacityMap;
	
	
	public Refrigerator(Map<RACKTYPE, Integer> capacity)throws Exception{
		if(capacity == null || capacity.size() < 3){
			throw new Exception("Please specify capacity for all types of racks");
		}
		items = new ArrayList<Refrigerator.Item>();
		capacityMap = capacity;
	}
	
	
	public class Item{
		
		int itemId;
		RACKTYPE itemSize;
		String name;
		Date expiryDate;
		
		public Item(int itemId, int itemCount, RACKTYPE size, String name, Date expiry){
			this.itemId = itemId;
			this.itemSize = size;
			this.name = name;
			this.expiryDate = expiry;
		}
		
		public Item(int itemId){
			this.itemId = itemId;
		}
		public int getItemId() {
			return itemId;
		}
		public String getName() {
			return name;
		}
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		public RACKTYPE getItemSize(){
			return itemSize;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + itemId;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (itemId != other.itemId)
				return false;
			return true;
		}

		private Refrigerator getOuterType() {
			return Refrigerator.this;
		}
		
		
		
	}
	
	public class NotEnoughSpaceException extends Exception{
		public NotEnoughSpaceException(String msg){
			super(msg);
		}
	}
	
	public enum RACKTYPE{
		SMALL,
		MEDIUM,
		LARGE
	}
	
	
	
	public boolean addItem(Item item)throws NotEnoughSpaceException{
		if(item == null){
			return false;
		}
		if(capacityMap.get(item.getItemSize()) < 1){
			throw new NotEnoughSpaceException("Not Enough Space. Please consider buying a bigger refrigerator");
		}
		items.add(item);
		capacityMap.put(item.getItemSize(), Integer.valueOf(capacityMap.get(item.getItemSize()).intValue() + 1));
		return true;
	}
	
	
	public Item removeItem(int itemId)throws Exception{
		Item toBeRemoved = new Item(itemId);
		int index = items.indexOf(toBeRemoved);
		if(index >=0){
			Item item = items.get(index);
			capacityMap.put(item.getItemSize(), Integer.valueOf(capacityMap.get(item.getItemSize()).intValue() - 1));
			return item;
			
		}else{
			throw new Exception("No Item found");
		}
		
		
		
	}
	
	public List<Item> removeExpiredItems() throws Exception{
		
		List<Item> expiredItems = new LinkedList<Refrigerator.Item>();
		
		for(Item item: items){
			if(item.getExpiryDate().getTime() < System.currentTimeMillis()){
				expiredItems.add(removeItem(item.getItemId()));
				
			}
		}
		return expiredItems;
	}
	
	
	
	
	
	
	
	
	
	
}
