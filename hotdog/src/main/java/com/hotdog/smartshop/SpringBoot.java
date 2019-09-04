package com.hotdog.smartshop;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SpringBoot {
	public static ArrayList<hotDogMenu> HAND = new ArrayList<hotDogMenu>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringBoot.class, args);
	}
	
	@RequestMapping("/")
	String home() {
		return "Welcome to HotDog Stand";
	}
	
	@RequestMapping("/hungry")
	hotDogMenu[] viewMenu() {
		return HotDogMenuFactory.viewMenu();
	}
	
	@RequestMapping(value = "/hungry/{pick}")
	hotDogMenu viewTheHotDog(@PathVariable int pick) {
		return HotDogMenuFactory.viewTheHotDog(pick);
	}
	
	@RequestMapping(value = "/hungry/{pick}/add_sauce/{sauce}")
	String addSauce(@PathVariable int pick, @PathVariable String sauce) {
		hotDogMenu hdm = HotDogMenuFactory.viewTheHotDog(pick);
		hdm.setSauce(sauce);
		System.out.println(hdm);
		String text = "You pour " + sauce + " on your hot dog";
		return text;
	}
	
	@RequestMapping(value = "/hungry/{pick}/remove_sauce")
	String remove(@PathVariable int pick) {
		hotDogMenu hdm = HotDogMenuFactory.viewTheHotDog(pick);
		hdm.removeSauce();
		return "The sauce is removed";
	}

	@RequestMapping(value = "/hungry/{pick}/order")
    String orderHotDog(@PathVariable int pick) {
        SpringBoot.HAND.add(HotDogMenuFactory.viewTheHotDog(pick));
        return "Your hot dog is now in your hand.";
    }
	
	@RequestMapping(value = "/hand")
	ArrayList<hotDogMenu> viewHand() {
		return SpringBoot.HAND;
	}
	
	@RequestMapping(value = "/eat")
	String eat() {
		int total = 0;
		for(hotDogMenu i : SpringBoot.HAND) {
			total += i.getPrice();
		}
		String text = "You eat the hot dog and run away without paying " + total + " baht";
		SpringBoot.HAND.clear();
		return text;
	}
}

