package de.htwdd.edtma.jdbc.db.client;

public class MSSQLClient extends DBClient {

	public MSSQLClient(String server, String user, String password) {
		// Aufruf mit connection url für MSSQL-Server
		super("jdbc:sqlserver://" + server + ";user=" + user + ";password=" + password);
	}

}
