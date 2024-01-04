package com.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConnect {
	private static Connection con;
	PreparedStatement stm;
	DataConnect(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zk","root","Santosh@123");
          System.out.println("connection established");
	}catch(Exception e) {
		e.getMessage();
		}
	}
	public boolean checkWord(String word) throws SQLException {
		stm=con.prepareStatement("select * from gusessword where words=?");
		stm.setString(1, word);
		ResultSet result=stm.executeQuery();
		if(result.next()) {
		return true; 
		}else {
			return false;
		}
	}
}
