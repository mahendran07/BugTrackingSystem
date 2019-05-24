package com.chainsys.bug.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.chainsys.bug.model.Team;
import com.chainsys.bug.model.TeamMembers;
import com.chainsys.bug.util.ConnectionUtil;

public class EmployeeDAO {

	/*
	 * public ArrayList<String> selectTeamName() throws Exception { Connection
	 * connection = null; ResultSet resultSet = null;
	 * 
	 * PreparedStatement preparedStatement = null; ArrayList<String> strlist = new
	 * ArrayList<String>(); try { connection = ConnectionUtil.getConnection();
	 * 
	 * String sql4 = "select * from employee where designation='Programmer'";
	 * 
	 * preparedStatement = connection.prepareStatement(sql4);
	 * 
	 * resultSet = preparedStatement.executeQuery(); while (resultSet.next()) {
	 * 
	 * String name = resultSet.getString("name");
	 * 
	 * strlist.add(name);
	 * 
	 * }
	 * 
	 * System.out.println(strlist.size()); return strlist;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); throw new
	 * Exception("unable to search"); } finally { ConnectionUtil.close(connection,
	 * preparedStatement, resultSet); }
	 * 
	 * }
	 */
	/**
	 * login() is used to validate the username and password
	 * 
	 * @param id
	 * @param password
	 * @return boolean value
	 * @throws Exception
	 */
	public Boolean login(Long id, String password) throws Exception {
		Boolean isFound = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,password from employee where id=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			isFound = true;
		}
		return isFound;
	}

	/**
	 * select() is used to select the team members
	 * 
	 * @param team
	 * @return ArrayList<TeaMembers>
	 * @throws Exception
	 */
	public ArrayList<TeamMembers> select(Team team) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatement = null;
		ArrayList<TeamMembers> employeelist = new ArrayList<TeamMembers>();
		TeamMembers teamMember = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select name from employee where id in(select member_id from trn_bug_team where team_id=(select id from trn_team where name=?))";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, team.getName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				teamMember = new TeamMembers();
				teamMember.setMembername((resultSet.getString("name")));
				employeelist.add(teamMember);
			}
			System.out.println("size" + employeelist.size());
			return employeelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to search");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}

	}

	/**
	 * selectLeader() method is used to select the leader
	 * 
	 * @param team
	 * @return ArrayList<TeamMembers>
	 * @throws Exception
	 */
	public ArrayList<TeamMembers> selectLeader(Team team) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatement = null;
		ArrayList<TeamMembers> leaderlist = new ArrayList<>();
		TeamMembers teamMembers = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql4 = "select name from employee where id in(select distinct(leader) from trn_bug_team where team_id=(select id from trn_team where name=?))";

			preparedStatement = connection.prepareStatement(sql4);
			preparedStatement.setString(1, team.getName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				teamMembers = new TeamMembers();
				teamMembers.setLeadername((resultSet.getString("name")));
				leaderlist.add(teamMembers);

			}

			System.out.println("size" + leaderlist.size());
			return leaderlist;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to search");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}

	}

	/**
	 * findMemberName is used to find the members
	 * 
	 * @param id
	 * @return string
	 * @throws Exception
	 */
	public String findMemberName(Long id) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatement = null;

		String name = "";
		try {
			connection = ConnectionUtil.getConnection();

			String sql4 = "select name from employee where id=?";

			preparedStatement = connection.prepareStatement(sql4);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				name = resultSet.getString("name");

			}

			return name;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to search");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}

	}

}
