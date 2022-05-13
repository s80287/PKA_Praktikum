package de.htwdd.edtma.jdbc.db.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import de.htwdd.edtma.jdbc.db.client.DBClient;
import de.htwdd.edtma.jdbc.db.client.MSSQLClient;

public class Transaction extends DBClientUI {

	public void showTransactionLevels(Connection con) throws SQLException {
		System.out.println("TRANSACTION_NONE: " + Connection.TRANSACTION_NONE);
		System.out.println("TRANSACTION_READ_COMMITED: " + Connection.TRANSACTION_READ_COMMITTED);
		System.out.println("TRANSACTION_READ_UNCOMMITED: " + Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println("TRANSACTION_REPEATABLE_READ: " + Connection.TRANSACTION_REPEATABLE_READ);
		System.out.println("TRANSACTION_SERIALIZABLE: " + Connection.TRANSACTION_SERIALIZABLE);
		System.out.println("Current Transaction Status: " + con.getTransactionIsolation());
	}

	public Connection startTransaction(DBClient client, int isolationLevel, String sqlString) throws SQLException {
		Connection transCon = client.getConnection();
		if (transCon == null)
			transCon = client.connect();
		transCon.setAutoCommit(false);
		transCon.setTransactionIsolation(isolationLevel);
		showTransactionLevels(transCon);
		System.out.println();
		System.out.println("start transaction...");
		System.out.println(sqlString);
		Statement stmt = transCon.createStatement();
		boolean result = stmt.execute(sqlString);
		if (result)
			showRows(stmt.getResultSet());

		return transCon;
	}

	public void endTransaction(Connection myCon) throws SQLException {
		myCon.commit();
		System.out.println("transaction done...");
		myCon.close();

	}

	public static void main(String[] args) {

		Properties prop = DBClient.readProperties("MSSQL.properties");
		Transaction t = new Transaction();
		DBClient client = new MSSQLClient(prop.getProperty("SERVER"), prop.getProperty("USER"),
				prop.getProperty("PASSWORT"));
		String sqlString = args[0];
		// "UPDATE Mitarbeiterkopie2 SET Ort = 'Radebeul' WHERE MitID='101'" 1
		// "SELECT Ort FROM Mitarbeiterkopie2 WHERE MitID='101'" 2

		try {
			Connection c = t.startTransaction(client, Integer.parseInt(args[1]), sqlString);
			System.out.println("Press any key to commit");

			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			s.nextLine();
			t.endTransaction(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
