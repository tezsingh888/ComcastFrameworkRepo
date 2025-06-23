package com.comCast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileUtility {
	public String getDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis =new FileInputStream("./configAppData/commondata.properties");
	Properties pObj= new Properties();
	pObj.load(fis);
	String data= pObj.getProperty(key);
	return data;
	}
}

