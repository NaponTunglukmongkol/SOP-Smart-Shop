package com.hotdog.smartshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileContactor {
	
	public FileContactor() {
	}
	
	public void writeToFile(JSONArray hand) throws IOException {
		try {
			FileWriter fw = new FileWriter("database.json");
			fw.write(hand.toJSONString());
			fw.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JSONArray readFile() throws IOException, ParseException{
		try {
			JSONParser jp = new JSONParser();
			FileReader fr = new FileReader("database.json");
			Object obj = jp.parse(fr);
			JSONArray htdm = (JSONArray) obj;
			return htdm;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
