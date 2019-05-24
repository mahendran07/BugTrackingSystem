package com.chainsys.bug.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bug.exception.TeamMembersException;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.Team;
import com.chainsys.bug.model.TeamMembers;
import com.chainsys.bug.util.ConnectionUtil;

public class TeamMembersDAO {
	/**
	 * addTeam() method is used to add team
	 * 
	 * @param teammembers
	 * @throws SQLException
	 */
	public void addTeam(TeamMembers teammembers) throws TeamMembersException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into trn_bug_team(id,member_id,leader,created_date,modified_by,modified_date,team_id) values(seq_team_id.NEXTVAL,?,109,'12-May-2019 12:00:00.000000000 AM',109,'12-May-2019 12:00:00.000000000 AM')";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, teammembers.getMember());
			preparedStatement.setLong(2, teammembers.getLeader());
			preparedStatement.setLong(3, teammembers.getMember());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new TeamMembersException("No team members Inserted");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}

	}

	/**
	 * selectTeam() method is used to select the team
	 * 
	 * @return ArrayList<Team>
	 * @throws Exception
	 */
	public ArrayList<Team> selectTeam() throws TeamMembersException {
		Connection connection = null;
		ResultSet resultSet = null;
		Team team = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Team> teamlist = new ArrayList<Team>();
		try {
			connection = ConnectionUtil.getConnection();

			String sql4 = "select from trn_bug_team order by id";
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
			throw new TeamMembersException("Unable to Search");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}

	}

	/**
	 * selectTeamMembers() method is used to the Team Members
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public ArrayList<TeamMembers> selectTeamMembers(Project project) throws TeamMembersException {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		ArrayList<TeamMembers> employeelist = new ArrayList<TeamMembers>();
		TeamMembers teamMember = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,name from employee where id in(select member_id from trn_bug_team where team_id=(select assign_to from trn_project where id=?))";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, project.getId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				teamMember = new TeamMembers();
				teamMember.setMember((resultSet.getLong("id")));
				teamMember.setMembername((resultSet.getString("name")));
				employeelist.add(teamMember);
			}
			return employeelist;
		} catch (Exception e) {
			throw new TeamMembersException("unable to search");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}
}
