package com.chainsys.bug.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bug.dao.EmployeeDAO;
import com.chainsys.bug.dao.TeamMembersDAO;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.Team;
import com.chainsys.bug.model.TeamMembers;

public class EmployeeServices {

	public ArrayList<TeamMembers> viewEmployeeServices(Team team) throws Exception {
		EmployeeDAO employeeDAO = new EmployeeDAO();

		ArrayList<TeamMembers> memberList = new ArrayList<>();

		try {
			memberList = employeeDAO.select(team);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberList;
	}

	public ArrayList<TeamMembers> viewLeaderServices(Team team) throws Exception {
		EmployeeDAO employeeDAO = new EmployeeDAO();

		ArrayList<TeamMembers> leaderList = new ArrayList<>();

		try {

			leaderList = employeeDAO.selectLeader(team);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return leaderList;
	}

	public ArrayList<TeamMembers> viewTeamServices(Project project) throws Exception {
		TeamMembersDAO teamDAO = new TeamMembersDAO();

		ArrayList<TeamMembers> leaderList = new ArrayList<>();

		try {

			leaderList = teamDAO.selectTeamMembers(project);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return leaderList;
	}

	public Boolean login(Long id, String password) throws Exception {
		Boolean s;
		EmployeeDAO employeeDAO = new EmployeeDAO();
		s = employeeDAO.login(id, password);
		return s;
	}

}