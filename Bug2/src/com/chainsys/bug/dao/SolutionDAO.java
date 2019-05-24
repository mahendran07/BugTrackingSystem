package com.chainsys.bug.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bug.exception.SolutionException;
import com.chainsys.bug.model.Bug;
import com.chainsys.bug.model.Solution;
import com.chainsys.bug.util.ConnectionUtil;

public class SolutionDAO {
	/**
	 * addSolution() is used to add solution
	 * 
	 * @param solution
	 */
	public void addSolution(Solution solution) throws SolutionException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into trn_solution(id,bug_id,solved_by,solved_date,created_by,created_date,modified_by,modified_date,rootcause,correctiveness,summary) values(seq_solution_id.NEXTVAL,?,?,?,109,'09-May-2019 12:00:00.000000000 AM',109,'09-May-2019 12:00:00.000000000 AM',?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, solution.getBug().getId());
			preparedStatement.setLong(2, solution.getResolvedBy());
			preparedStatement.setDate(3, Date.valueOf(solution.getDateofSolved()));
			preparedStatement.setString(4, solution.getRootcause());
			preparedStatement.setString(5, solution.getCorrectiveness());
			preparedStatement.setString(6, solution.getSummary());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new SolutionException("Solution not added");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}

	}

	/**
	 * findSolution is used to find the solution
	 * 
	 * @param bug
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Solution> findSolution(Bug bug) throws SolutionException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Solution> solutionList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "\r\n"
					+ "select s.id as solutionid, e.designation as d,p.name as project, s.solved_date as solved_date,b.name as bugname,e.name as emp,s.rootcause as root,s.correctiveness as correct,s.summary as summary from trn_solution s join trn_bug b on s.bug_id=b.id inner join employee e on  e.id=s.solved_by join trn_project p on b.project_id=p.id where b.RAISED_BY=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, bug.getRaisedby());
			resultSet = preparedStatement.executeQuery();
			Solution solution = null;
			while (resultSet.next()) {
				solution = new Solution();
				solution.setId(resultSet.getLong("solutionid"));
				solution.setDesignation(resultSet.getString("d"));
				solution.setProjectName(resultSet.getString("project"));
				solution.setDateofSolved(resultSet.getDate("solved_date").toLocalDate());
				solution.setBugName(resultSet.getString("bugname"));
				solution.setEmpname(resultSet.getString("emp"));
				solution.setRootcause(resultSet.getString("root"));
				solution.setCorrectiveness(resultSet.getString("correct"));
				solution.setSummary(resultSet.getString("summary"));
				solutionList.add(solution);
			}
		} catch (SQLException e) {
			throw new SolutionException("Solution not found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return solutionList;
	}

	/**
	 * findSolutions() method is used to find solution
	 * 
	 * @param solution
	 * @return ArrayList<Solution>
	 * @throws SQLException
	 */
	public ArrayList<Solution> findSolutions(Solution solution) throws SolutionException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Solution> solutionList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select s.id as solutionid,p.name as project, s.solved_date as solved_date,b.name as bugname,e.name as emp,s.rootcause as root,s.correctiveness as correct,s.summary as summary from trn_solution s join trn_bug b on s.bug_id=b.id inner join employee e on  e.id=s.SOLVED_BY join trn_project p on b.project_id=p.id where s.SOLVED_BY=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, solution.getResolvedBy());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				solution = new Solution();
				solution.setId(resultSet.getLong("solutionid"));
				solution.setBugName(resultSet.getString("bugname"));
				solution.setProjectName(resultSet.getString("project"));
				solution.setDateofSolved(resultSet.getDate("solved_date").toLocalDate());
				solution.setEmpname(resultSet.getString("emp"));
				solution.setRootcause(resultSet.getString("root"));
				solution.setCorrectiveness(resultSet.getString("correct"));
				solution.setSummary(resultSet.getString("summary"));
				solutionList.add(solution);
			}
		} catch (SQLException e) {
			throw new SolutionException("Solution not found");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return solutionList;
	}
}
