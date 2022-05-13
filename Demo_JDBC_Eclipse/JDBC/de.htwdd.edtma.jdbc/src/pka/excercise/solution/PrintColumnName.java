package pka.excercise.solution;

import java.sql.*;

public class PrintColumnName {

	public static void main(String[] args) {
		
		Connection conn;
		
		try {
			// driver
			conn = DriverManager.getConnection("jdbc:ucanaccess://U:/temp/Turnierverwaltung.accdb");
			
			// statement
			Statement s = conn.createStatement();
			
			// result set
			String sql = "SELECT * FROM [Schachverein];";
			ResultSet rs = s.executeQuery(sql);
			
			// metadata
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			//System.out.println("Number columns: " + numberOfColumns);
			String[] columnName = new String[numberOfColumns];
			
			// store column name in array
			for (int i = 0; i < numberOfColumns; i++) {
				columnName[i] = rsmd.getColumnName(i + 1);
				//System.out.println(i + ": " + columnName[i]);
			}

			// print out column names
			for (int j = 0; j < columnName.length; j++) {
				System.out.printf("%-40s", columnName[j]);
			}
			
			System.out.println();
			
			// print out data
			while (rs.next()) {
				System.out.printf("%-40s%-40s%-40s%-12s\n",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
					
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
