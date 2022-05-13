package pka.excercise.solution;

import java.sql.*;

public class PrintSortedListChessClubWithAddress {

	public static void main(String[] args) {
		
		Connection conn;
		
		try {
			// connection
			conn = DriverManager.getConnection("jdbc:ucanaccess://U:/temp/Turnierverwaltung.accdb");
			
			// create statement
			Statement s = conn.createStatement();
			
			// sql query
			ResultSet rs = s.executeQuery("SELECT [Schachverein].[Vereinsname], [Adresse].[Strasse], "
					+ "[Adresse].[Hausnummer], [Adresse].[PLZ], [Adresse].[Ort]\n"
					+ "FROM [Schachverein]\n"
					+ "INNER JOIN [Adresse]\n"
					+ "ON [Schachverein].[Adresse] = [Adresse].[ID]\n"
					+ "ORDER BY [Schachverein].[Vereinsname];");
			
			// print out
			while (rs.next()) {
				// name
				System.out.println(rs.getString(1));
				// address
				System.out.println("\t" + rs.getString(2) + " " + rs.getString(3)
						+ ", " + rs.getString(4) + " " + rs.getString(5));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
