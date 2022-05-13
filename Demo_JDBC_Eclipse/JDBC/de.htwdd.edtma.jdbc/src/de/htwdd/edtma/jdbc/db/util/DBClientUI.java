package de.htwdd.edtma.jdbc.db.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBClientUI {

	private Scanner sc = new Scanner(System.in);

	public void showRows(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int colNumber = rsmd.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= colNumber; i++) {
				// if (i > 1) System.out.print(", ");
				String columnValue = rs.getString(i);
				// System.out.print(rsmd.getColumnName(i));
				System.out.print(columnValue + " ");
			}
			System.out.println("");
		}

	}

	// Liest einen String von stdin
	public String readString(String label) {
		System.out.print(label);
		String input = sc.next();

		return input;
	}

	// Liest einen String von stdin bis zum Zeilenende
	public String readStringLe(String label) {

		System.out.print(label);
		String input = sc.nextLine();

		return input;
	}

	// Liest ein int von stdin
	public int readInt(String label) throws InputMismatchException {
		System.out.print(label);
		int input = sc.nextInt();

		return input;
	}

}