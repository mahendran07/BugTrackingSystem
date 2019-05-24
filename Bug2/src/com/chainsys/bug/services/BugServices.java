package com.chainsys.bug.services;

import java.util.ArrayList;

import com.chainsys.bug.dao.BugDAO;
import com.chainsys.bug.exception.BugException;
import com.chainsys.bug.model.Bug;

public class BugServices {

	public void addBugServices(Bug bug) throws BugException {
		BugDAO bugDAO = new BugDAO();
		try {
			bugDAO.addBug(bug);
		}
		
		catch(BugException e)
		{
			throw new BugException(e.getMessage());
		}
	

	
	}

	public ArrayList<Bug> ViewBugServices(Bug bug) throws Exception {
		BugDAO bugDAO = new BugDAO();
		ArrayList<Bug> bugList = new ArrayList<>();
		try {
			bugList = bugDAO.findByTester(bug);
		} catch (Exception e) {
			System.out.println("unable to insert");
		}

		return bugList;
	}

	public ArrayList<Bug> viewRaisedMember(Bug bug) throws Exception {
		BugDAO bugDAO = new BugDAO();
		ArrayList<Bug> bugList = new ArrayList<>();
		try {
			bugList = bugDAO.findByProgrammer(bug);
		} catch (Exception e) {
			System.out.println("unable to insert");
		}

		return bugList;
	}
	
	
	public void updateBugStatus(Bug bug) throws Exception {
		BugDAO bugDAO = new BugDAO();
		try {
			 bugDAO.updateBugStatus(bug);
		} catch (Exception e) {
			System.out.println("unable to update");
		}


	}
}
