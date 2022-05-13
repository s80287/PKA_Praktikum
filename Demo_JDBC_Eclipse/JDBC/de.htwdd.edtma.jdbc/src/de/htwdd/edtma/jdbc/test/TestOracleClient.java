package de.htwdd.edtma.jdbc.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import de.htwdd.edtma.jdbc.db.client.*;
import de.htwdd.edtma.jdbc.db.util.*;

public class TestOracleClient {

	public static void main(String[] args) {
		DBClient client = null;

		// Einlesen der Properties Datei
		// Diese enth lt die Verbindungsdaten
		Properties prop = DBClient.readProperties("ORACLE.properties");
		String server, user, passwd, sid;
		server = prop.getProperty("SERVER");
		user = prop.getProperty("USER");
		passwd = prop.getProperty("PASSWORT");
		sid = prop.getProperty("SID");
		System.out.println("Server: " + server);
		System.out.println("User: " + user);

		try {
			client = new OracleClient(server, user, passwd, sid);

			DBClientUI clientUI = new DBClientUI();
			// Verbindung zur Datenbank (s99999) herstellen
			Connection con = client.connect();
			System.out.println("Verbindung mit Datenbank war erfolgreich\n");
			DatabaseMetaData md = con.getMetaData();

			ResultSet rs = md.getTables(null, null, "%", new String[] { "TABLE" });
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (client != null)
					client.closeConnection();
			} catch (Exception e) {
			}
		}

	}

}