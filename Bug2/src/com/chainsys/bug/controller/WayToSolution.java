package com.chainsys.bug.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bug.model.Bug;
import com.chainsys.bug.model.Solution;

@WebServlet("/WayToSolution")
public class WayToSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WayToSolution() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Solution solution = new Solution();
		Bug bug = new Bug();
		bug.setName(request.getParameter("raisesolution"));
		bug.setId(Long.parseLong(request.getParameter("hiddenid")));
		solution.setBug(bug);
		request.setAttribute("solution", solution);
		RequestDispatcher rd = request.getRequestDispatcher("addsolution.jsp");
		rd.forward(request, response);

	}

}
