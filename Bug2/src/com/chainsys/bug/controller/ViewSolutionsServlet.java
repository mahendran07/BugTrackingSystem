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
import com.chainsys.bug.model.Solution;
import com.chainsys.bug.services.SolutionServices;

@WebServlet("/ViewSolutionsServlet")
public class ViewSolutionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewSolutionsServlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ArrayList<Solution> solutionList = new ArrayList<>();
		Long n = (Long) session.getAttribute("username");
		SolutionServices solutionServices = new SolutionServices();
	Solution solution=new Solution();
		solution.setResolvedBy(n);
		solutionList = solutionServices.viewSolutionByProgrammer(solution);
		request.setAttribute("solutionList", solutionList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewSolutions.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
