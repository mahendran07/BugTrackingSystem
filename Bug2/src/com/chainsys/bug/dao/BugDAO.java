package com.chainsys.bug.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bug.exception.BugException;
import com.chainsys.bug.exception.ProjectException;
import com.chainsys.bug.model.Bug;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.TeamMembers;
import com.chainsys.bug.services.ProjectServices;
import com.chainsys.bug.util.ConnectionUtil;

public class BugDAO {
	/**
	 * addBug() is used to add bugs
	 * 
	 * @param bug
	 * @throws SQLException
	 */
	public void addBug(Bug bug) throws BugException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into trn_bug(id,name,project_id,raiseddate,raised_by,description,bug_type,bug_priority,raised_to,bug_status,created_by,created_date,modified_by,modified_date) values(seq_bug_id.NEXTVAL,?,?,?,?,?,?,?,?,'inprogress',109,'09-May-2019 12:00:00.000000000 AM',109,'09-May-2019 12:00:00.000000000 AM')";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bug.getName());
			preparedStatement.setLong(2, bug.getProject().getId());
			preparedStatement.setDate(3, Date.valueOf(bug.getRaisedDate()));
			preparedStatement.setLong(4, bug.getRaisedby());
			preparedStatement.setString(5, bug.getDescription());
			preparedStatement.setString(6, bug.getType());
			preparedStatement.setString(7, bug.getPriority());
			preparedStatement.setLong(8, bug.getTeamMembers().getMember());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new BugException("Bug Details not added");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	/**
	 * updateBugStatus() method is used to update bug status
	 * 
	 * @param bug
	 * @throws SQLException
	 */
	public void updateBugStatus(Bug bug) throws BugException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update trn_bug set bug_status=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bug.getStatus());
			preparedStatement.setLong(2, bug.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new BugException("Bug Status not updated");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}

	}

	/**
	 * findAll() method is used to find all the bug details
	 * 
	 * @return ArrayList<Bug>
	 * @throws SQLException
	 */
	public ArrayList<Bug> findAll() throws BugException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Bug> buglist = new ArrayList<Bug>();
		connection = ConnectionUtil.getConnection();
		try {
			String sql = "select name,project_id,raiseddate,raised_by,description,bug_type,bug_priority,raised_to from trn_bug";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			Project project = null;
			TeamMembers teamMembers = null;
			Bug bug = null;
			while (resultSet.next()) {
				bug = new Bug();
				project = new Project();
				bug.setName(resultSet.getString("name"));
				project.setId(resultSet.getLong("project_id"));
				bug.setRaisedDate(resultSet.getDate(("raisedDate")).toLocalDate());
				project = new Project();
				project.setId(resultSet.getLong("project_id"));
				bug.setProject(project);
				bug.setDescription(resultSet.getString("description"));
				bug.setType(resultSet.getString("type"));
				bug.setPriority(resultSet.getString("priority"));
				teamMembers = new TeamMembers();
				teamMembers.setMember((resultSet.getLong("raised_to")));
				bug.setTeamMembers(teamMembers);
				buglist.add(bug);
			}
		} catch (SQLException e) {
			throw new BugException("No Bugs Found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return buglist;
	}

	/**
	 * findByTester is used to find the bug details based on the tester
	 * 
	 * @param bug
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Bug> findByTester(Bug bug) throws BugException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Bug> buglist = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name,project_id,raiseddate,description,bug_type,bug_priority,raised_to,bug_status from trn_bug where raised_by=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, bug.getRaisedby());
			resultSet = preparedStatement.executeQuery();
			Bug bug1 = null;
			Project project = null;
			Project project1 = null;
			TeamMembers teamMembers = null;
			ProjectServices projectServices = new ProjectServices();
			while (resultSet.next()) {
				bug1 = new Bug();
				project = new Project();
				bug1.setName(resultSet.getString("name"));
				project.setId(resultSet.getLong("project_id"));
				try {
					project1 = (projectServices.findProjectName(project));
				} catch (ProjectException e) {
				e.printStackTrace();
				}
				bug1.setProject(project1);
				bug1.setRaisedDate(resultSet.getDate(("raiseddate")).toLocalDate());
				bug1.setDescription(resultSet.getString("description"));
				bug1.setType(resultSet.getString("bug_type"));
				bug1.setPriority(resultSet.getString("bug_priority"));
				teamMembers = new TeamMembers();
				teamMembers.setMember(resultSet.getLong("raised_to"));
				bug1.setTeamMembers(teamMembers);
				bug1.setStatus(resultSet.getString("bug_status"));
				buglist.add(bug1);

			}
		} catch (SQLException e) {
			throw new BugException("No Bugs Found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}

		return buglist;

	}

	/**
	 * findByProgrammmer() is used to find the bug details by programmmer
	 * 
	 * @param bug
	 * @return
	 * @throws BugException 
	 * @throws SQLException
	 */
	public ArrayList<Bug> findByProgrammer(Bug bug) throws BugException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Bug> buglist = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,name,project_id,raiseddate,description,bug_type,bug_priority,raised_by,bug_status from trn_bug where raised_to=? and bug_status='inprogress'";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, bug.getRaisedTo());
			resultSet = preparedStatement.executeQuery();
			Bug bug1 = null;
			Project project = null;
			Project project1 = null;
			ProjectServices projectServices = new ProjectServices();
			EmployeeDAO employeeDAO = new EmployeeDAO();
			while (resultSet.next()) {
				bug1 = new Bug();
				project = new Project();
				bug1.setId(resultSet.getLong("id"));
				bug1.setName(resultSet.getString("name"));
				project.setId(resultSet.getLong("project_id"));
				project1 = (projectServices.findProjectName(project));
				bug1.setProject(project1);
				bug1.setRaisedDate(resultSet.getDate(("raiseddate")).toLocalDate());
				bug1.setDescription(resultSet.getString("description"));
				bug1.setType(resultSet.getString("bug_type"));
				bug1.setPriority(resultSet.getString("bug_priority"));
				bug1.setRaisedby(resultSet.getLong("raised_by"));
				bug1.setRaisedbyname(employeeDAO.findMemberName(bug1.getRaisedby()));
				bug1.setStatus(resultSet.getString("bug_status"));
				buglist.add(bug1);
			}
		} catch (SQLException e) {
			throw new BugException("No Bugs Found");
		} catch (Exception e) {
			throw new BugException("No Bugs Found");
			
		}
		finally
		{
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return buglist;

	}
}
