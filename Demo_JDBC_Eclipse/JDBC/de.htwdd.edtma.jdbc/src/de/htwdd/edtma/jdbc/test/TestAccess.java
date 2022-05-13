package de.htwdd.edtma.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import pka.excercise.Address;


public class TestAccess {

	public static void main(String[] args) {
		Connection conn;
		try {
			
			
			conn=DriverManager.getConnection( "jdbc:ucanaccess://U:/temp/Turnierverwaltung.accdb");
		
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery("SELECT [Name] FROM [Person]");
			// ResultSet rs = s.executeQuery("SELECT Name FROM Person"); // geht auch
			
			
			while (rs.next()) {
			    System.out.println(rs.getString(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
