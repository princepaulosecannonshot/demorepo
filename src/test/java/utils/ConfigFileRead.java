package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import DriverFactory.DriverFact;

public class ConfigFileRead extends DriverFact {
	BufferedReader reader;
	private Properties properties;
	private String propertiesPath = "src//test//resources//properties//config.properties";
	
	public ConfigFileRead() throws FileNotFoundException, IOException{
		try(BufferedReader reader = new BufferedReader(new FileReader(propertiesPath))){
			properties = new Properties();
			 try {
			 properties.load(reader);
			 System.out.println("Properties loaded");
			 reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readPropertyFromConfig(String prop) {
		return properties.getProperty(prop);
	}
	
	public void writeToPropertyFile(String key, String value) {
		if(properties.containsKey(key)) {
		properties.replace(key, value);
		}
		else {
			properties.setProperty(key, value);
		}
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(propertiesPath))){
		properties.store(writer,null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
