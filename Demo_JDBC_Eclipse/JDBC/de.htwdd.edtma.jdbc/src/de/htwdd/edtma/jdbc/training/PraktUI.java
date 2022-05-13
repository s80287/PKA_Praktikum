package de.htwdd.edtma.jdbc.training;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Properties;

import de.htwdd.edtma.jdbc.db.client.*;
import de.htwdd.edtma.jdbc.db.util.*;

public class PraktUI extends DBClientUI {

	private Connection con;
	private DBClient client;

	public PraktUI(DBClient client) throws SQLException {
		this.con = client.connect();
	}

	public void showTransactionLevels(Connection con) throws SQLException {
		System.out.println("TRANSACTION_NONE: " + Connection.TRANSACTION_NONE);
		System.out.println("TRANSACTION_READ_COMMITED: " + Connection.TRANSACTION_READ_COMMITTED);
		System.out.println("TRANSACTION_READ_UNCOMMITED: " + Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println("TRANSACTION_REPEATABLE_READ: " + Connection.TRANSACTION_REPEATABLE_READ);
		System.out.println("TRANSACTION_SERIALIZABLE: " + Connection.TRANSACTION_SERIALIZABLE);
		System.out.println("Current Transaction Status: " + con.getTransactionIsolation());
	}

	public void dirtyRead(Connection con) throws SQLException {
		showTransactionLevels(con);
		// Standard ist TRANSACTION_READ_UNCOMMITTED
		// TRANSACTION_READ_COMMITTED --> will not allow a value to be accessed until
		// after it has been committed.
		String readOrt = "SELECT Ort FROM Mitarbeiterkopie WHERE MitID='101'";
		String readBeruf = "SELECT Beruf FROM Mitarbeiterkopie WHERE MitID='101'";
		Statement stmt = con.createStatement();
		stmt.execute(readOrt);
		showRows(stmt.getResultSet());
		stmt.execute(readBeruf);
		showRows(stmt.getResultSet());
	}

	public static void main(String[] args) {
		// Einlesen der Properties Datei
		// Diese enthält die Verbindungsdaten
		// Properties prop = DBClient.readProperties("ORACLE.properties");
		Properties prop = DBClient.readProperties("MSSQL.properties");

		// DBClient client = new OracleClient(prop.getProperty("SERVER"),
		// prop.getProperty("USER"), prop.getProperty("PASSWORT"),
		// prop.getProperty("SID"));
		DBClient client = new MSSQLClient(prop.getProperty("SERVER"), prop.getProperty("USER"),
				prop.getProperty("PASSWORT"));
		DBClient client2 = new MSSQLClient(prop.getProperty("SERVER"), prop.getProperty("USER"),
				prop.getProperty("PASSWORT"));

		try {

			PraktUI ui = new PraktUI(client);

			System.out.println("---------- [MENÜ] ----------\n");
			System.out.println("1. Berufe anzeigen\n");
			System.out.println("6. Grundlegende Transaktionen\n");

			int auswahl = ui.readInt("Treffen Sie eine Auswahl:");

			switch (auswahl) {
			case 1:
				// TODO
				// Einlesen eines Strings kann z.B.
				// mittels ui.readString bzw. ui.readStringLe (komplette Zeile bis Zeilenende)
				// erfolgen
				break;

			case 2:
				// TODO
				break;
			case 3:
				// TODO
				break;
			case 4:
				// TODO
				break;

			case 5:
				// TODO
				break;
			case 6:
				// Standard ist TRANSACTION_READ_UNCOMMITTED
				// TRANSACTION_READ_COMMITTED --> will not allow a value to be accessed until
				// after it has been committed.
				// TODO
				break;

			default:
				System.out.println("Ungültige Eingabe");
				break;
			}

		} catch (SQLException e) {
			// TODO
			e.printStackTrace();
		} catch (InputMismatchException ime) {
			// TODO: handle exception
		}

	}

}
