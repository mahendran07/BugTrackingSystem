package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.bug.model.Bug;
import com.chainsys.bug.services.BugServices;

@WebServlet("/ViewEmpBugServlet")
public class ViewEmpBugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewEmpBugServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Long n = (Long) session.getAttribute("username");
		Bug bug = new Bug();

		BugServices bugservices = new BugServices();
		try {
			ArrayList<Bug> bugList = new ArrayList<>();
			bug.setRaisedTo(n);
			bugList = bugservices.viewRaisedMember(bug);
			System.out.println(bugList);
			System.out.println(bugList.size());
			request.setAttribute("bugList", bugList);
			RequestDispatcher rd = request.getRequestDispatcher("ViewEmpBug.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
