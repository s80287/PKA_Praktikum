package de.htwdd.edtma.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import de.htwdd.edtma.jdbc.db.client.*;
import de.htwdd.edtma.jdbc.db.util.*;

public class TestClient {

	public static void main(String[] args) {
		DBClient client = null;

		// Einlesen der Properties Datei
		// Diese enthält die Verbindungsdaten
		Properties prop = DBClient.readProperties("MSSQL.properties");
		String server, user, passwd;
		server = prop.getProperty("SERVER");
		user = prop.getProperty("USER");
		passwd = prop.getProperty("PASSWORT");
		System.out.println("Server: " + server);
		System.out.println("User: " + user);

		try {
			client = new MSSQLClient(server, user, passwd);
			DBClientUI clientUI = new DBClientUI();
			// Verbindung zur Datenbank (s99999) herstellen
			Connection con = client.connect();
			String dbName = con.getCatalog();
			System.out.println("Verbindung mit Datenbank " + dbName + " war erfolgreich\n");
			System.out.println("Wechsel zur Datenbank \"Verkauf\"");
			client.changeDatabase("Verkauf");

			// Eingabe durch Benutzer
			String bezeich = clientUI.readString("Bezeichnung eingeben: ");

			String sql = "SELECT * FROM Artikel WHERE Bezeichnung='" + bezeich + "'";
			Statement stmt = con.createStatement();
			boolean ok = stmt.execute(sql);
			System.out.println(ok);
			if (ok)
				clientUI.showRows(stmt.getResultSet());

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
