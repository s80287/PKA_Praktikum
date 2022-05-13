package de.htwdd.edtma.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.File;

import de.htwdd.edtma.jdbc.db.client.*;

/**
 * Datenbankzugriff ohne Verwendung der Klassen DBClient und DBClientUI
 * 
 * @author Alexander Wülfing
 *
 */
public class TestClientFull {

	public static void main(String[] args) {

		// Einlesen der Properties Datei
		// Diese enthält die Verbindungsdaten
		Properties prop = DBClient.readProperties("MSSQL.properties");
		System.out.println(Paths
				.get(System.getProperty("user.dir") + File.separator + "lib" + File.separator + "MSSQL.properties"));
		String server, user, passwd;
		server = prop.getProperty("SERVER");
		user = prop.getProperty("USER");
		passwd = prop.getProperty("PASSWORT");
		System.out.println("Server: " + server);
		System.out.println("User: " + user);

		Connection con = null;
		try {
			// Verbindung zur Datenbank (s99999) herstellen
			con = DriverManager.getConnection("jdbc:sqlserver://" + server + ";user=" + user + ";password=" + passwd);

			String dbName = con.getCatalog();
			System.out.println("Verbindung mit Datenbank " + dbName + " war erfolgreich\n");
			System.out.println("Wechsel zur Datenbank \"Verkauf\"");

			// Wechsel zur Datenbank "Verkauf"
			// setCatalog muss von Treiber unterstützt werden
			// Alternativ mittels "use" und stmt.execute
			con.setCatalog("Verkauf");

			// Eingabe durch Benutzer
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.print("Ort eingeben: ");
			String ort = sc.next();

			// Query zusammenbauen und an MSSQL-Server schicken
			String sql = "SELECT * FROM Kunde WHERE Ort='" + ort + "'";
			Statement stmt = con.createStatement();
			boolean ok = stmt.execute(sql);

			// Ergebnisse auswerten
			System.out.println(ok);
			if (ok) {
				// Ergebnisse ausgeben
				ResultSet rs = stmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				int colNumber = rsmd.getColumnCount();
				while (rs.next()) {
					for (int i = 1; i <= colNumber; i++) {
						String columnValue = rs.getString(i);
						System.out.print(columnValue + " ");
					}
					System.out.println("");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}

	}

}
