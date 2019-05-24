package com.chainsys.bug.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.bug.exception.BugTrackingException;
import com.chainsys.bug.model.Bug;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.TeamMembers;
import com.chainsys.bug.services.BugServices;

public class BugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(BugServlet.class.toString());

	public BugServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		Bug bug = new Bug();
		String status = "";
		log.info(" ---  BugServlet  ---- ");

		Project project = new Project();
		TeamMembers teamMembers = new TeamMembers();
		try {
			bug.setName(request.getParameter("Bugname"));
			project.setId(Long.parseLong(request.getParameter("second")));
			HttpSession session = request.getSession(false);
			Long n = (Long) session.getAttribute("username");
			bug.setProject(project);
			bug.setRaisedDate(LocalDate.parse(request.getParameter("RaisedDate")));
			bug.setDescription(request.getParameter("Description"));
			bug.setPriority(request.getParameter("Bugpriority"));
			bug.setType(request.getParameter("Bugtype"));
			bug.setRaisedby(n);
			teamMembers.setMember(Long.parseLong(request.getParameter("first")));
			bug.setTeamMembers(teamMembers);
			BugServices bugServices = new BugServices();
			bugServices.addBugServices(bug);
			status = "Bug inserted";
			request.setAttribute("status", status);
			RequestDispatcher rs = request.getRequestDispatcher("Bug.jsp");

			rs.forward(request, response);
		} catch (BugTrackingException e) {
			String status1 = e.getMessage();
			request.setAttribute("status", status1);
			RequestDispatcher rs = request.getRequestDispatcher("Bug.jsp");
			rs.forward(request, response);
		}

	}

}
