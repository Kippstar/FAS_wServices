package util;

import com.sun.jersey.spi.resource.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/mysql";
	private static final String MYSQL_USER = "root";
	//KIP: FürdenServerMussHierNochDasPWrein, lokal habe ich kein PW drin fabkip
	private static final String MYSQL_PASSWORD = "";

	/**
	 * Opens a database connection to mysql database. User has to make sure that
	 * the connection will be closed.
	 * 
	 * @return database connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(MYSQL_DRIVER);
			conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER,
					MYSQL_PASSWORD);
			System.out.println("DB-Verbindung aufgebaut");
		} catch (SQLException e) {
			System.out.println("DB-Fehler(SQL-Fehler): " + e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DB-Fehler(Class-Fehler): " + e);
			e.printStackTrace();
		}
		return conn;
	}
}
