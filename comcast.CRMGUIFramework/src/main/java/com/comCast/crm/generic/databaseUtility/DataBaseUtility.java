package com.comCast.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
Connection conn;
public void getDBConnection(String Url,String UserName,String password) {
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(Url,UserName,password);
	}
	catch(Exception e) {
	}
}
public void getDBCOnnection2() {
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/mysql", "root", "root");
	}
	catch(Exception e) {
		
	}
}
public void closeDBConnection() {
	try {
		conn.close();
	}
	catch(Exception e) {
		
	}
}
public ResultSet executeSelectQuery(String query) {
	ResultSet result= null;
	try {
		Statement stat= conn.createStatement();
	}
	catch(Exception e) {
		
	}
	return result;
}
public int executeNonSelectQuery(String query) {
	int result=0;
	try {
		Statement stat=conn.createStatement();
		result=stat.executeUpdate(query);
	}
	catch(Exception e) {
		
	}
	return result;
	
}
}
