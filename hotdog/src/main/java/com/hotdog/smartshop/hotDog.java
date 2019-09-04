package com.hotdog.smartshop;

public class hotDog {
	
	public static String[] HOT_DOG_TYPES = new String[] {"Foot long", "Big bite", "Smoke bite"};
	public static String[] INSIDE_TYPES = new String[] {"Cheese", "Chilli", "None"};
	private int choose;
	private int inside;
	
	public hotDog(int choose, int inside) {
		this.setHotdog(choose);
		this.setInside(inside);
	}

	public int getHotdog() {
		return choose;
	}

	public void setHotdog(int hotdog) {
		this.choose = hotdog;
	}

	public int getInside() {
		return inside;
	}

	public void setInside(int inside) {
		this.inside = inside;
	}
	
	public String getHotDogType(int choose) {
		return hotDog.HOT_DOG_TYPES[choose];
	}
	
	public String getInsideType(int inside) {
		return hotDog.INSIDE_TYPES[inside];
	}
	
}
