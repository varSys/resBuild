package com.resUtil.varsys;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class GetPropertyValues {
	
public String getVal(String propertyName){
	
    String result = "";
    Properties prop = new Properties();
    String propFileName = "db.properties";
	
	try{

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		prop.load(inputStream);
		
    if (inputStream == null) {
        throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
    }

    Date time = new Date(System.currentTimeMillis());
   
    result = prop.getProperty(propertyName);

    //System.out.println(result + "\nProgram Ran on " + time);
	}
	catch(IOException ioe){
		
		ioe.printStackTrace();
		
	}
	
    
    return result;

	
}

public String getVal(String propertyName, String propFile) throws IOException{
	
    String result = "";
    Properties prop = new Properties();
    String propFileName = propFile;

    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
    prop.load(inputStream);
    if (inputStream == null) {
        throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
    }

    Date time = new Date(System.currentTimeMillis());
   
    result = prop.getProperty(propertyName);

    System.out.println(result + "\nProgram Ran on " + time);
    return result;

	
}



}
