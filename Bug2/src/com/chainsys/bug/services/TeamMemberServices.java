package com.chainsys.bug.services;

import java.util.ArrayList;
import com.chainsys.bug.dao.TeamMembersDAO;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.TeamMembers;

public class TeamMemberServices {
	ArrayList<TeamMembers> viewmember(Project project) {
		ArrayList<TeamMembers> teamMemberList = new ArrayList<>();
		TeamMembersDAO teamMembersDAO = new TeamMembersDAO();
		try {
			teamMemberList = teamMembersDAO.selectTeamMembers(project);
		}

		catch (Exception e) {
			System.out.println("hh");
		}

		return teamMemberList;
	}

}
