package com.chainsys.bug.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	/**
	 * getConnection() method is used to make jdbc connection to the database by
	 * providing url, username , password.
	 *
	 * @exception ClassNotFoundException
	 *                , SQLException
	 * @return the Connection object
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			connection = DriverManager.getConnection(url, "hr", "hr");
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	/**
	 * close() method is used to close the jdbc connection to the database
	 *
	 * @param connection
	 * @param pstmt
	 * @param rs
	 *            Exception SQLException
	 */
	public static void close(Connection connection, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {

		}
	}

}
