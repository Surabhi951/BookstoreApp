package com.qapitolqa.utility;

import com.qapitolqa.baseclass.BaseClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile extends BaseClass{

    String propertyFilePath = "C:\\Users\\surabhi.bhagat\\IdeaProjects\\AutomateBookStore\\config.properties";
    public Properties properties;

    public ReadPropertyFile() throws FileNotFoundException {
        FileReader reader = new FileReader(propertyFilePath);
        properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        }catch (
                IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e + "config.properties file not found");
        }
    }
}
