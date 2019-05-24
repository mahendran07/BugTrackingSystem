package com.chainsys.bug.services;

import java.util.ArrayList;

import com.chainsys.bug.dao.SolutionDAO;
import com.chainsys.bug.exception.SolutionException;
import com.chainsys.bug.model.Bug;
import com.chainsys.bug.model.Solution;

public class SolutionServices {

	public void addSolutionServices(Solution solution) throws SolutionException {
		SolutionDAO solutionDAO = new SolutionDAO();
		try {
			solutionDAO.addSolution(solution);
		} catch (Exception e) {
			throw new SolutionException(e.getMessage());
		}

	}

	public ArrayList<Solution> viewSolutionByTester(Bug bug) {
		ArrayList<Solution> solutionList = new ArrayList<>();
		SolutionDAO solutionDAO = new SolutionDAO();
		try {
			solutionList = solutionDAO.findSolution(bug);

		} catch (Exception e) {
			System.out.println("unable to view");
		}

		return solutionList;
	}

	public ArrayList<Solution> viewSolutionByProgrammer(Solution solution) {
		ArrayList<Solution> solutionList = new ArrayList<>();
		SolutionDAO solutionDAO = new SolutionDAO();
		try {
			solutionList = solutionDAO.findSolutions(solution);
		} catch (Exception e) {
			System.out.println("unable to view");
		}

		return solutionList;
	}
}
