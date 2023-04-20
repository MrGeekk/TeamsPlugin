package fr.mrgeekk.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbmanager {
	
	private String urlBase;
	private String host;
	private String database;
	private String username;
	private String password;
	private static Connection connection;
	
	public dbmanager(String urlbase, String host, String database, String username, String password) {
		this.urlBase = urlbase;
		this.host = host;
		this.database = database;
		this.username = username;
		this.password = password;
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	/**
	 * Connection a la Database
	 */
	
	public void connection() {
		
		if(!IsOnline()) {
			try {
				connection = DriverManager.getConnection(this.urlBase+ this.host + "/" + this.database, this.username, this.password);
				System.out.println("[NationsRunner] DB CONNECT OK");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * Deconnection
	 */
	
	public void deconnection() {
		if(IsOnline()) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean IsOnline() {
		try {
			
			if((connection == null) || (connection.isClosed())) {
				return false;
			}
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}