package com.akkasample.bean;

import java.io.Serializable;

/**
 * Order bean to pass as a message in the network.
 * @author rakeshc
 *
 */
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4996267588389110958L;
	private String itemName;
	private double price;
	public Order(String itemName, double price){
		this.itemName = itemName;
		this.price = price;
	}
	
	public String getItemName() {
		return itemName;
	}
	public double getPrice() {
		return price;
	}
	

}
