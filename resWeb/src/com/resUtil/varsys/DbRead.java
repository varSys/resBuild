/*package com.resUtil.varsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DbRead {
	
	Statement stmt = null;
	ResultSet rs = null;
	
	//Queries
	
	public String[] returnColumn(){
		
		 String[] column = new String[]{};
		
		return column;
	}
	
	public String[][] returnRow(){
		
		HashMap<String, String> resultHash = new HashMap<String, String>();
		String[][] row = new String[][]{};
		
		return row;
	}
	
	public String returnCell(){
		
		String result = null; 
		
		return result;
	}

	public ResultSet queryDb(Connection conn, String query){

		HashMap<Integer, String> resultHash = new HashMap<Integer, String>();
		int colCount = 0;

			try{			
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
			}
			catch(SQLException se){
				
				se.printStackTrace();
			}

		return rs;
	}

	public ResultSet queryDb(String query){

		String sqlResult = null;
		
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://192.168.0.125:3306/resumeBuilder","dmmaharry","Noodle12");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from userinfo;");

				while(rs.next())
				{
					System.out.println(rs.getString("firstName"));
								
				}
				
			}
			catch(SQLException se){
				
				se.printStackTrace();
			}

		return rs;
	}



}
*/