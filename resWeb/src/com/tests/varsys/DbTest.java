package com.tests.varsys;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.resUtil.varsys.DbConnect;

public class DbTest {

	@Test
	public void testQueryDb() throws SQLException{
		
		//String[] test = new String[]{"userinfo","zipplus","1234","iduserinfo","1"};
		String[] test = new String[]{"0000","1"};
		
		System.out.println(test.getClass().toString());
		
		DbConnect conn = new DbConnect("resumebuilder");
		
		conn.update(test);
		
		ResultSet result = new DbConnect("resumeBuilder").query("select * from userinfo;");
		
		assertEquals(result.getMetaData().getColumnCount(),14);
		
		System.out.println(new DbConnect().query("select * from userinfo;").getMetaData().getColumnCount());

		while(result.next())
		{
			
			System.out.println(result.getString("firstName")+" "+result.getString("lastName"));
			for(int i = 1; i <= result.getMetaData().getColumnCount(); i++) System.out.print(result.getString(i) + " ");
			System.out.println();
						
		}
		
	}

}
