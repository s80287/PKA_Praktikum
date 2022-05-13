package pka.excercise.solution;

import java.sql.*;

public class UpdateChessClub {

	public static void main(String[] args) {
		
		// file location, zps-code, name, street, streetnr, zip, city
		insertChessClub("U:/temp/Turnierverwaltung.accdb", "F2208", "Schachzentrum Seeblick e.V.",
				"Talsperrenstraﬂe", "56", "01744", "Dippoldiswalde/Paulsdorf");
		
		/*
		Connection conn;
		
		
		try {
			// db connect
			conn = DriverManager.getConnection("jdbc:ucanaccess://U:/temp/Turnierverwaltung.accdb");
			
			// update table "Adresse"
			// sql statement
			String sql = "INSERT INTO Adresse([Strasse], [Hausnummer], [PLZ], [Ort]) "
					+ "VALUES(?, ?, ?, ?);";
			
			// statement
			PreparedStatement s = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			// set parameter
			s.setString(1, "Talsperrenstraﬂe");
			s.setString(2, "56");
			s.setString(3, "01744");
			s.setString(4, "Dippoldiswalde/Paulsdorf");

			// execute update
			s.executeUpdate();
			
			// update table "Schachverein"
			// sql statement
			String q2 = "INSERT INTO Schachverein([ZPS-Code], [Vereinsname], [Adresse]) "
					+ "VALUES(?, ?, ?)";
			
			// statement
			PreparedStatement s2 = conn.prepareStatement(q2);
			
			// set parameter
			s2.setString(1, "F2208");
			s2.setString(2, "Schachzentrum Seeblick e.V.");
			
			ResultSet rs = s.getGeneratedKeys();
			
			while (rs.next()) {
				s2.setLong(3, rs.getLong(1));
			}
			
			
			// execute update
			s2.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		*/
	}
	
	public static void insertChessClub(String fileLocation, String zpsCode, String name,
			String street, String streetNumber, String zip, String city) {
		
		Connection conn;
		
		try {
			// db connect
			conn = DriverManager.getConnection("jdbc:ucanaccess://" + fileLocation);
		
			// update table "Adresse"
			// sql
			String sql = "INSERT INTO Adresse([Strasse], [Hausnummer], [PLZ], [Ort])\n"
					+ "VALUES(?, ?, ?, ?);";
			
			// statement
			PreparedStatement s = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			// set parameter
			s.setString(1, street);
			s.setString(2, streetNumber);
			s.setString(3, zip);
			s.setString(4, city);
			
			// execute update
			s.executeUpdate();
			
			// update table "Schachverein"
			// sql
			sql = "INSERT INTO Schachverein([ZPS-Code], [Vereinsname], [Adresse])\n"
					+ "VALUES(?, ?, ?);";
			
			// statement
			PreparedStatement s2 = conn.prepareStatement(sql);
			
			// set parameter
			s2.setString(1, zpsCode);
			s2.setString(2, name);
			
			ResultSet rs = s.getGeneratedKeys();
			
			while (rs.next()) {
				s2.setLong(3, rs.getLong(1));
			}
			
			s2.executeUpdate();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
