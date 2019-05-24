package com.chainsys.bug.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bug.exception.BugTrackingException;
import com.chainsys.bug.model.Bug;
import com.chainsys.bug.model.Solution;
import com.chainsys.bug.services.BugServices;
import com.chainsys.bug.services.SolutionServices;

@WebServlet("/SolutionServlet")
public class SolutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SolutionServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession(false);
		Long n = (Long) session.getAttribute("username");
		Solution solution = new Solution();
		BugServices bugServices=new BugServices();
		SolutionServices solutionServices = new SolutionServices();
		Bug bug = new Bug();
		solution.setSolution(request.getParameter("name"));
		bug.setId(Long.parseLong(request.getParameter("bugid")));
		bug.setStatus("validated");
		solution.setBug(bug);
		solution.setDateofSolved(LocalDate.parse(request.getParameter("solveddate")));
		solution.setResolvedBy(n);
		solution.setDescription(request.getParameter("description"));
		solution.setRootcause(request.getParameter("rootcause"));
		solution.setCorrectiveness(request.getParameter("correctiveness"));
		solution.setSummary(request.getParameter("summary"));
		try {
			solutionServices.addSolutionServices(solution);
			bugServices.updateBugStatus(bug);
			String status = "Solution Added";
			request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("addsolution.jsp");
			rd.forward(request, response);

		} catch (BugTrackingException e) {
			String message=e.getMessage();
			request.setAttribute("status", message);
			RequestDispatcher rd = request.getRequestDispatcher("addsolution.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
