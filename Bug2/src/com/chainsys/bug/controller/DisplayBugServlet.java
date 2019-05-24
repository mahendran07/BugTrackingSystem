package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.bug.model.Bug;
import com.chainsys.bug.services.BugServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/DisplayBugServlet")
public class DisplayBugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayBugServlet() {
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
			request.setAttribute("bugList", bugList);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String buglist = gson.toJson(bugList);
			response.getWriter().write(buglist);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
