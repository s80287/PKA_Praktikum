package de.htwdd.edtma.jdbc.db.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.nio.file.Path;
import java.io.FileInputStream;

public abstract class DBClient {

	private String connectionUrl;

	// Verbindung zur Datenbank herstellen
	public Connection connect() throws SQLException {
		con = DriverManager.getConnection(connectionUrl);
		return con;
	}

	// Verbindung zur Datenbank trennen
	public void closeConnection() throws SQLException {
		if (con != null)
			con.close();

	}

	// Verbindung zur Datenbank
	protected Connection con;

	public Connection getConnection() {
		return con;
	}

	public DBClient(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public static Properties readProperties(String name) {
		Properties prop = new Properties();
		InputStream is = DBClient.class.getClassLoader().getResourceAsStream(name);
		try {
			prop.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static Properties readProperties(Path p) {
		Properties prop = new Properties();
		try {
			InputStream is = new FileInputStream(p.toString());
			prop.load(is);
			is.close();
		} catch (IOException e) {
			System.out.println("--> " + p.toString());
			e.printStackTrace();
		}
		return prop;
	}

	public void changeDatabase(String dbName) throws SQLException {
		// Wechsel zur Datenbank "Verkauf"
		// setCatalog muss von Treiber unterstützt werden
		// Alternativ mittels "use" und stmt.execute
		con.setCatalog("Verkauf");

	}

}
