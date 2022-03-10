package com.example.demo.bean;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int quantity;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public float getSum()
	{
		return this.quantity*this.price;
	}
	
}