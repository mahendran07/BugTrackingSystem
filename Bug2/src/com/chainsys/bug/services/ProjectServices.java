package com.chainsys.bug.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.chainsys.bug.dao.ProjectDAO;
import com.chainsys.bug.exception.BugException;
import com.chainsys.bug.exception.ProjectException;
import com.chainsys.bug.model.Project;

public class ProjectServices {

	public ArrayList<Project> viewProjectServices() throws ProjectException {
		ProjectDAO projectDAO = new ProjectDAO();
		ArrayList<Project> projectList = new ArrayList<>();

		try {
			projectList = projectDAO.findAll();
		} catch (ProjectException e) {
		
			throw new ProjectException(e.getMessage());
			
		}

		return projectList;

	}
	public boolean datevalidation(LocalDate d,LocalDate f) throws ProjectException
	{
		ProjectDAO dao=new ProjectDAO();
		boolean status=dao.dateValidation(d,f);
		return status;
	}

	public ArrayList<Project> viewProjectName(Long n) throws ProjectException {
		ProjectDAO projectDAO = new ProjectDAO();
		ArrayList<Project> projectList = new ArrayList<>();

		try {
			projectList = projectDAO.findProject(n);
		} catch (ProjectException e) {
			
			throw new ProjectException(e.getMessage());
		}

		return projectList;

	}

	public Project findProjectID(Project project) throws ProjectException{
		ProjectDAO projectDAO = new ProjectDAO();
		Project project1 = new Project();
		try {
			project1 = projectDAO.findProjectId(project);
		} catch (ProjectException e) {
			throw new ProjectException(e.getMessage());
		}

		return project1;

	}

	public Project findProjectName(Project project) throws ProjectException  {
		ProjectDAO projectDAO = new ProjectDAO();
		Project project1 = new Project();
		try {
			project1 = projectDAO.findProjectName(project);
		} catch (ProjectException e) {
			throw new ProjectException(e.getMessage());
		}

		return project1;

	}

}
