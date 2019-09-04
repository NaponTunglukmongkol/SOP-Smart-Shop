package com.hotdog.smartshop;

import java.util.ArrayList;

public class hotDogMenu {
	
	private String sauce;
	private hotDog[] hd;
	private int price;
	private String bread;
	
	public hotDogMenu (hotDog[] hd, int price, String bread) {
		this.setHd(hd);
		this.price = price;
		this.setBread(bread);
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	
	public void removeSauce() {
		this.sauce = null;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public hotDog[] getHd() {
		return hd;
	}

	public void setHd(hotDog[] hd) {
		this.hd = hd;
	}

	public String getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}

}
