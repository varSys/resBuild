package com.resUtil.varsys;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

import java.util.*;

import javax.el.MethodNotFoundException;

import com.mysql.jdbc.PreparedStatement;

public class DbConnect{
	
	GetPropertyValues config = new GetPropertyValues();

	Statement stmt = null;
	ResultSet rs = null;
	Connection conn = null;

	//Connections
	public DbConnect(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			this.conn = DriverManager.getConnection("jdbc:mysql://"+config.getVal("server")+"/resumeBuilder",
															   config.getVal("user"), 
															   config.getVal("password"));
		}
		catch(SQLException  | ClassNotFoundException sqe){
			
			sqe.printStackTrace();
			
		}
	
	}
	
	public DbConnect(String db){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://"+ config.getVal("server") +"/" + db, 
																config.getVal("user"), 
																config.getVal("password"));
		}
		catch(SQLException  | ClassNotFoundException sqe){
			
			sqe.printStackTrace();
			
		}
	
	}
	
	public DbConnect(String user, String password, String db){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://"+ config.getVal("server") +"/"+db, user, password);
		}
		catch(SQLException  | ClassNotFoundException sqe){
			
			sqe.printStackTrace();
			
		}
	
	}
	
	public DbConnect(String user, String password, String db, String server){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+db, user, password);
		}
		catch(SQLException  | ClassNotFoundException sqe){
			
			sqe.printStackTrace();
			
		}
	
	}
	
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
		
		//need to implement this method 
		
		return result;
	}
	
	public ResultSet query(String query){

			try{			
				
				Class.forName("com.mysql.jdbc.Driver");
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
			}
			catch(SQLException | ClassNotFoundException se){
				
				se.printStackTrace();
			}
	
		return rs;
	}
	
	public ResultSet query(Connection conn, String query){
		
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://192.168.0.125:3306/resumeBuilder",config.getVal("user"),config.getVal("password"));
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from userinfo;");
	
				while(rs.next())
				{
					System.out.println(rs.getString("firstName"));
								
				}
				
			}
			catch(SQLException | ClassNotFoundException se){
				
				se.printStackTrace();
			}
	
		return rs;
	}
	
	public void close(Boolean commit){
	try {
		
		if(commit) conn.commit();
		else conn.rollback();

		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

	//Write

	public void insert(){

	}

	public void update(String[] vals){
		
		String stmt = "UPDATE userinfo SET zipplus = ? WHERE iduserinfo = ?";
		
		if(vals.length > 5)
			for(int i = 0; i < vals.length-5; i++) 
				stmt += " ?";
		
		stmt += ";";
				
		System.out.println(stmt);
		
		try {
				java.sql.PreparedStatement script = conn.prepareStatement(stmt);
		
				for(int i = 0; i < vals.length; i++) 
					script.setString(i+1, vals[i]);

				script.execute();
				
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public void update(String[] vals, String custom){
		
		try {
						
			java.sql.PreparedStatement script = conn.prepareStatement("UPDATE ? SET ? = ? WHERE ? = ?");
			
			for(int i = 0; i < 5; i++){
				
				script.setString(i, vals[i]);
				
			}
									
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
}
///


///





















/*package com.resUtil.varsys;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class DbConnect{

Connection conn = null;
GetPropertyValues config = new GetPropertyValues();

//Connections
public Connection create(){
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://"+config.getVal("server")+"/resumeBuilder",
														   config.getVal("user"), 
														   config.getVal("password"));
	}
	catch(SQLException  | ClassNotFoundException sqe){
		
		sqe.printStackTrace();
		
	}
	
	return conn;
}

public Connection create(String db){
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://192.168.0.125:3306/" + db, config.getVal("user"), 
																					config.getVal("password"));
	}
	catch(SQLException  | ClassNotFoundException sqe){
		
		sqe.printStackTrace();
		
	}
	
	return conn;
}

public Connection create(String user, String password, String db){
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://192.168.0.125:3306/"+db, user, password);
	}
	catch(SQLException  | ClassNotFoundException sqe){
		
		sqe.printStackTrace();
		
	}
	
	return conn;
}

public Connection create(String user, String password, String db, String server){
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+db, user, password);
	}
	catch(SQLException  | ClassNotFoundException sqe){
		
		sqe.printStackTrace();
		
	}
	
	return conn;
}

public void close(Boolean commit){
	try {
		
		if(commit) conn.commit();
		else conn.rollback();

		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

}
*/