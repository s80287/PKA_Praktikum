package de.htwdd.edtma.jdbc.db.client;

public class OracleClient extends DBClient {
	public OracleClient(String server, String user, String password, String sid) {
		// Aufruf mit connection url für Oracle-Server
		super("jdbc:oracle:thin:" + user + "/" + password + "@" + server + ":" + sid);
	}

}
