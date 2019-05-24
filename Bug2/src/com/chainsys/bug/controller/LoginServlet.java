package com.chainsys.bug.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bug.dao.LoginDAO;
import com.chainsys.bug.services.EmployeeServices;

/**
 * Servlet implementation class LoginServlet
 * It is used to call the login the method
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(LoginServlet.class.toString());

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status1;
		HashMap<String, String> hashMap = new HashMap<>();
		Long empid = Long.parseLong(request.getParameter("empid"));

		log.info(" ---  LoginServlet  ---- ");

		String password = request.getParameter("password");
		LoginDAO loginDAO = new LoginDAO();
		EmployeeServices employeeServices=new EmployeeServices();
		Boolean status=null;
		try {
			status = employeeServices.login(empid, password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(status==true)
		{
			try {
				status1="";

				hashMap = loginDAO.getDesignation(empid, password);

				if (hashMap.get("Designation").equalsIgnoreCase("Programmer")) {
					HttpSession session = request.getSession();
					session.setAttribute("username", empid);

					RequestDispatcher rd = request.getRequestDispatcher("home1.jsp");
					rd.forward(request, response);
				} else if (hashMap.get("Designation").equalsIgnoreCase("Tester")) {
					HttpSession session = request.getSession();
					session.setAttribute("username", empid);

					RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
					rd.forward(request, response);
				}
				else if (hashMap.get("Designation").equalsIgnoreCase("Manager")) {
					HttpSession session = request.getSession();
					session.setAttribute("username", empid);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				hashMap.get("Status");

			}
		}
		else
		{
		status1="Invalid username or password!!!";
		request.setAttribute("status1", status1);
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
		}
	}
}

// String subject= "Account verification-Confirmation link";
// String content="<html><head></head><body>Click the link for email
// verification:<a
// href='http://localhost:8082/Bug/team.jsp'>Link</a></body></html>";
//
// Services.sendHtmlMail(subject, content);
//
