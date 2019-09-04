package com.hotdog.smartshop;

public class HotDogMenuFactory {
	public static final hotDogMenu[] HOT_DOG_MENUS = new hotDogMenu[] {
			new hotDogMenu(new hotDog[] {new hotDog(0, 2)}, 40, "Wheat"),
			new hotDogMenu(new hotDog[] {new hotDog(1, 0)}, 50, "Wheat"),
			new hotDogMenu(new hotDog[] {new hotDog(2, 0)}, 40, "Wheat"),
			new hotDogMenu(new hotDog[] {new hotDog(1, 1)}, 50, "Wheat")
	};
	
	public static hotDogMenu[] viewMenu() {
		return HOT_DOG_MENUS;
	}
	
	public static hotDogMenu viewTheHotDog(int pick) {
		return (hotDogMenu) HOT_DOG_MENUS[pick];
	}
}
