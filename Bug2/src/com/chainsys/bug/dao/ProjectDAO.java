package com.chainsys.bug.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import com.chainsys.bug.exception.ProjectException;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.Team;
import com.chainsys.bug.util.ConnectionUtil;

public class ProjectDAO {
	/**
	 * addProject() is used to add project
	 * 
	 * @param project
	 * @throws SQLException
	 */

	public void addProject(Project project) throws ProjectException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into trn_project(id,name,description,start_date,end_date,assign_to,client_name,client_address,client_mobile,client_email,created_by,created_date,modified_by,modified_date,status) values(seq_project_id.NEXTVAL,?,?,?,?,?,?,?,?,?,109,'09-May-2019 12:00:00.000000000 AM',109,'09-May-2019 12:00:00.000000000 AM','inprogress')";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, project.getName());
			preparedStatement.setString(2, project.getDescription());
			preparedStatement.setDate(3, Date.valueOf(project.getStartDate()));
			preparedStatement.setDate(4, Date.valueOf(project.getEndDate()));
			preparedStatement.setLong(5, project.getTeam().getId());
			preparedStatement.setString(6, project.getClient_name());
			preparedStatement.setString(7, project.getClient_address());
			preparedStatement.setLong(8, project.getClient_mobile());
			preparedStatement.setString(9, project.getClient_email());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new ProjectException("Project not added");

		}
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	/**
	 * findAll() method is used to find all the project details
	 * 
	 * @param
	 * @return ArrayList<Project>
	 * @throws SQLException
	 */
	public ArrayList<Project> findAll() throws ProjectException {
		Connection connection = null;
		ArrayList<Project> projectlist = new ArrayList<Project>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select p.id, p.name,p.description,p.start_date,p.end_date,p.assign_to as assign,p.client_name,p.client_address,p.client_mobile,p.client_email,p.status,t.id,t.name as teamname from trn_project p LEFT OUTER JOIN trn_team t ON p.assign_to=t.id";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			Team team1 = null;
			Project project = null;
			while (resultSet.next()) {
				project = new Project();
				team1 = new Team();
				project.setId(resultSet.getLong("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setStartDate(resultSet.getDate("start_date").toLocalDate());
				project.setEndDate(resultSet.getDate("end_date").toLocalDate());
				team1.setId(resultSet.getLong("assign"));
				team1.setName(resultSet.getString("teamname"));
				project.setTeam(team1);
				project.setClient_name(resultSet.getString("client_name"));
				project.setClient_address(resultSet.getString("client_address"));
				project.setClient_mobile(resultSet.getLong("client_mobile"));
				project.setClient_email(resultSet.getString("client_email"));
				project.setStatus(resultSet.getString("status"));
				projectlist.add(project);
			}
		} catch (SQLException e) {
			throw new ProjectException("No Projects Found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return projectlist;
	}

	/**
	 * findProjectName() method is used to find the project name
	 * 
	 * @param Project
	 * @return project
	 * @throws SQLException
	 */
	public Project findProjectName(Project project1) throws ProjectException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Project project = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,name from trn_project where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, project1.getId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				project = new Project();
				project.setId(resultSet.getLong("id"));
				project.setName(resultSet.getString("name"));

			}
		}

		catch (SQLException e) {
			throw new ProjectException("No Projects Found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return project;
	}

	/**
	 * findProjectId() method is used to find the project id from project name
	 * 
	 * @param Project
	 * @return project
	 * @throws SQLException
	 */
	public Project findProjectId(Project project1) throws ProjectException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Project project = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,name from trn_project where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, project1.getName());
			ResultSet resultset = preparedStatement.executeQuery();
			Team team1 = null;
			if (resultset.next()) {
				project = new Project();
				team1 = new Team();
				project.setId(resultset.getLong("id"));
				project.setName(resultset.getString("name"));
				project.setDescription(resultset.getString("description"));
				project.setStartDate(resultset.getDate("start_date").toLocalDate());
				project.setEndDate(resultset.getDate("end_date").toLocalDate());
				team1.setId(resultset.getLong("assign_to"));
				team1.setName(resultset.getString(12));
				project.setTeam(team1);
				project.setClient_name(resultset.getString("client_name"));
				project.setClient_address(resultset.getString("client_address"));
				project.setClient_mobile(resultset.getLong("client_mobile"));
				project.setClient_email(resultset.getString("client_email"));
				project.setStatus(resultset.getString("status"));

			}
		} catch (SQLException e) {
			throw new ProjectException("No Projects Found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return project;
	}

	/**
	 * findProject() method is used to find the project details
	 * 
	 * @param n
	 * @return project
	 * @throws SQLException
	 */
	public ArrayList<Project> findProject(Long n) throws ProjectException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Project project = null;
		ResultSet resultSet = null;
		ArrayList<Project> projectlist = new ArrayList<Project>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,name,description,start_date,end_date,client_name,client_address,client_mobile,client_email from trn_project where assign_to in(select team_id from trn_bug_team where member_id=?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, n);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				project = new Project();
				project.setId(resultset.getLong("id"));
				project.setName(resultset.getString("name"));
				project.setDescription(resultset.getString("description"));
				project.setStartDate(resultset.getDate("start_date").toLocalDate());
				project.setEndDate(resultset.getDate("end_date").toLocalDate());
				project.setClient_name(resultset.getString("client_name"));
				project.setClient_address(resultset.getString("client_address"));
				project.setClient_mobile(resultset.getLong("client_mobile"));
				project.setClient_email(resultset.getString("client_email"));
				projectlist.add(project);

			}
		} catch (SQLException e) {
			throw new ProjectException("No Projects Found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return projectlist;
	}

	public boolean dateValidation(LocalDate d, LocalDate f) {
		boolean status;

		if (d.isAfter(f) && (d.isBefore(LocalDate.now()))) {
			status = false;
		}

		else {
			status = true;
		}

		return status;
	}
}
