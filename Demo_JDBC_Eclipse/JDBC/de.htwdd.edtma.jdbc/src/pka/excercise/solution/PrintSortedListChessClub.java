package pka.excercise.solution;

import java.sql.*;

public class PrintSortedListChessClub {

	public static void main(String[] args) {
		
		Connection conn;
		
		try {
			// connection
			conn = DriverManager.getConnection("jdbc:ucanaccess://U:/temp/Turnierverwaltung.accdb");
			
			// statement
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT [Vereinsname] FROM [Schachverein] ORDER BY [Vereinsname]");
			
			// print out
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		catch (SQLException e) {
			// auto-generated exception
			e.printStackTrace();
		}

	}

}
