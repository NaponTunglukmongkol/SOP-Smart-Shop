package com.hotdog.smartshop;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
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
	public static JSONArray HAND = new JSONArray();
	public static FileContactor fc = new FileContactor();
	
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		HAND = fc.readFile();
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
    String orderHotDog(@PathVariable int pick) throws IOException {
		hotDogMenu select = HotDogMenuFactory.viewTheHotDog(pick);
		JSONObject jo = new JSONObject();
		jo.put("sauce", select.getSauce());
		hotDog[] htd = select.getHd();
		jo.put("price", select.getPrice());
		jo.put("bread", select.getBread());
		for(hotDog ht: htd) {
			JSONObject joo = new JSONObject();
			JSONObject jooo = new JSONObject();
			jooo.put("inside", ht.getInside());
			jooo.put("hotdog", ht.getHotdog());
			joo.put("0", jooo);
			jo.put("hd", joo);
		}
        SpringBoot.HAND.add(jo);
        fc.writeToFile(HAND);
        return "Your hot dog is now in your hand.";
    }
	
	@RequestMapping(value = "/hand")
	JSONArray viewHand() throws IOException, ParseException {
		return fc.readFile();
	}
	
	@RequestMapping(value = "/eat")
	String eat() throws IOException, ParseException {
		int total = 0;
		JSONArray keep = fc.readFile();
		for(Object i : keep) {
			JSONObject k = (JSONObject) i;
			long price = (Long) k.get("price");
			total += price;
		}
		String text = "You eat the hot dog and run away without paying " + total + " baht";
		SpringBoot.HAND.clear();
		fc.writeToFile(HAND);
		return text;
	}
}

