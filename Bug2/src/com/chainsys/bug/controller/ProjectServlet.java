package com.chainsys.bug.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.bug.dao.ProjectDAO;
import com.chainsys.bug.exception.BugTrackingException;
import com.chainsys.bug.exception.ProjectException;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.Team;
import com.chainsys.bug.services.ProjectServices;

public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(ProjectServlet.class.toString());
	
	public ProjectServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Project project = new Project();
		ProjectDAO projectDAO = null;
		Team team = null;
		String status;
		Boolean value = null;
	ProjectServices projectServices=new ProjectServices();
		log.info(" ---  ProjectServlet  ---- ");
		LocalDate d=LocalDate.parse(request.getParameter("StartDate"));
		LocalDate f=LocalDate.parse(request.getParameter("EndDate"));	
try {
	value=projectServices.datevalidation(d,f);
} catch (ProjectException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
if(value==true)
{
		try {
			team = new Team();
			project.setName(request.getParameter("Projectname"));
			project.setDescription(request.getParameter("description"));
			project.setStartDate((LocalDate.parse(request.getParameter("StartDate"))));
			project.setEndDate(LocalDate.parse(request.getParameter("EndDate")));
		
			
			team.setId(Long.parseLong(request.getParameter("team")));
			project.setTeam(team);
			project.setClient_name(request.getParameter("clientname"));
			project.setClient_address(request.getParameter("clientaddress"));
			project.setClient_mobile(Long.parseLong(request.getParameter("clientmobile")));
			project.setClient_email(request.getParameter("clientemail"));
			
			
			projectDAO = new ProjectDAO();
			projectDAO.addProject(project);
			 status = "Project Added";
			request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
			rd.forward(request, response);
		}

		catch (BugTrackingException e) {
			
		 status=e.getMessage();
		 request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
			rd.forward(request, response);
			
		}
			}
			
			else if(value==false)
			{
				String display="Enter the valid date(End Date not less than start date";
				 request.setAttribute("display",display);
					RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
					rd.forward(request, response);
				
			}

	}
}