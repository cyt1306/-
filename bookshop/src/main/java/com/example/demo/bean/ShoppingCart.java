package com.example.demo.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
	private ArrayList<Book> cart=null;
	private float total;
	
	public ShoppingCart()
	{
		cart=new ArrayList<Book>();
	}
	public ArrayList<Book> getCart()
	{
		return cart;
	}
	public void addCartItem(Book item)
	{
		Book oldItem=null;
		if(item!=null)
		{
			for(int i=0;i<cart.size();i++)
			{
				oldItem=cart.get(i);
				if(oldItem.getId()==item.getId())
				{
					oldItem.setQuantity(item.getQuantity()+oldItem.getQuantity());
					return;
				}
			}
			cart.add(item);
		}
	}
	public boolean removeCartItem(int id)
	{
		Book item=null;
		for(int i=0;i<cart.size();i++)
		{
			item=cart.get(i);
			if(item.getId()==id)
			{
				cart.remove(i);
				return true;
			}
		}
		return false;
	}
	public float getTotal()
	{
		Iterator<Book> it=cart.iterator();
		float sum=0;
		Book item=null;
		while(it.hasNext())
		{
			item=it.next();
			sum=sum+item.getSum();
		}
		total=sum;
		return sum;
	}
	
	
	
}