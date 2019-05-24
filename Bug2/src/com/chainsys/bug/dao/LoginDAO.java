package com.chainsys.bug.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.chainsys.bug.util.ConnectionUtil;

public class LoginDAO {

	/**
	 * validLogin() method is used validate the username and password is valid or
	 * not
	 *
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public HashMap<String, String> getDesignation(Long username, String password) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String designation = null;
		String status = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql4 = "select id,password,designation from employee where id=? and password=?";
			preparedStatement = connection.prepareStatement(sql4);
			preparedStatement.setLong(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				designation = resultSet.getString("designation");

			} else {
				status = "Invalid username or password";
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = "";
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}

		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("Designation", designation);
		hashMap.put("Status", status);
		return hashMap;

	}
}
