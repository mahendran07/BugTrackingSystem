package com.chainsys.bug.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bug.model.Team;
import com.chainsys.bug.util.ConnectionUtil;

public class TeamDAO {
	/**
	 * addTeam() method is used to add team
	 * 
	 * @param team
	 * @throws SQLException
	 */
	public void addTeam(Team team) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into trn_team(id,name,created_by,created_date,modified_by,modified_date) values(seq_trn_teamid.NEXTVAL,?,109,'09-May-2019 12:00:00.000000000 AM',109,'09-May-2019 12:00:00.000000000 AM')";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, team.getName());
			System.out.println(team.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	/**
	 * selectTeam is used to select the team
	 * 
	 * @return ArrayList<Team>
	 * @throws Exception
	 */
	public ArrayList<Team> selectTeam() throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		Team team = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Team> teamlist = new ArrayList<Team>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql4 = "select id,name from trn_team order by id";
			preparedStatement = connection.prepareStatement(sql4);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				team = new Team();
				team.setId(resultSet.getLong("id"));
				team.setName(resultSet.getString("name"));
				teamlist.add(team);
			}
			System.out.println(teamlist.size());
			return teamlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to search");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}

	/**
	 * selectTeamID() method is used to select the team id
	 * 
	 * @param teamm
	 * @return
	 * @throws Exception
	 */
	public Team selectTeamID(Team teamm) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		Team team = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Team> teamlist = new ArrayList<Team>();

		try {
			connection = ConnectionUtil.getConnection();
			String sql4 = "select id,name from trn_team where name=?";
			preparedStatement = connection.prepareStatement(sql4);
			preparedStatement.setString(1, teamm.getName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				team = new Team();
				team.setId(resultSet.getLong("id"));
				team.setName(resultSet.getString("name"));
			}
			System.out.println(teamlist.size());

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to search");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return team;

	}
}
