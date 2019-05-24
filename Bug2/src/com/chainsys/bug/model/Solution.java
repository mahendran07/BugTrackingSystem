package com.chainsys.bug.model;

import java.time.LocalDate;

/**
 * Solution class is used to add solution to the bug raised by the tester
 * 
 * @author durg2128
 *
 */
public class Solution {

	private Long id;
	private Bug bug;
	private String solution;
	private Long resolvedBy;
	private LocalDate dateofSolved;
	private String description;
	private String rootCause;
	private String correctiveness;
	private String projectName;
	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	private String bugName;
	private String empName;

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public String getEmpname() {
		return empName;
	}

	public void setEmpname(String empname) {
		this.empName = empname;
	}

	public String getCorrectiveness() {
		return correctiveness;
	}

	public void setCorrectiveness(String correctiveness) {
		this.correctiveness = correctiveness;
	}

	private String summary;

	public Long getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Long resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRootcause() {
		return rootCause;
	}

	public void setRootcause(String rootcause) {
		this.rootCause = rootcause;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Long getResovedBy() {
		return resolvedBy;
	}

	public void setResovedBy(Long resovedBy) {
		this.resolvedBy = resovedBy;
	}

	public LocalDate getDateofSolved() {
		return dateofSolved;
	}

	public void setDateofSolved(LocalDate dateofSolved) {
		this.dateofSolved = dateofSolved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bug == null) ? 0 : bug.hashCode());
		result = prime * result + ((bugName == null) ? 0 : bugName.hashCode());
		result = prime * result + ((correctiveness == null) ? 0 : correctiveness.hashCode());
		result = prime * result + ((dateofSolved == null) ? 0 : dateofSolved.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((resolvedBy == null) ? 0 : resolvedBy.hashCode());
		result = prime * result + ((rootCause == null) ? 0 : rootCause.hashCode());
		result = prime * result + ((solution == null) ? 0 : solution.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solution other = (Solution) obj;
		if (bug == null) {
			if (other.bug != null)
				return false;
		} else if (!bug.equals(other.bug))
			return false;
		if (bugName == null) {
			if (other.bugName != null)
				return false;
		} else if (!bugName.equals(other.bugName))
			return false;
		if (correctiveness == null) {
			if (other.correctiveness != null)
				return false;
		} else if (!correctiveness.equals(other.correctiveness))
			return false;
		if (dateofSolved == null) {
			if (other.dateofSolved != null)
				return false;
		} else if (!dateofSolved.equals(other.dateofSolved))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (resolvedBy == null) {
			if (other.resolvedBy != null)
				return false;
		} else if (!resolvedBy.equals(other.resolvedBy))
			return false;
		if (rootCause == null) {
			if (other.rootCause != null)
				return false;
		} else if (!rootCause.equals(other.rootCause))
			return false;
		if (solution == null) {
			if (other.solution != null)
				return false;
		} else if (!solution.equals(other.solution))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Solution [id=" + id + ", bug=" + bug + ", solution=" + solution + ", resolvedBy=" + resolvedBy
				+ ", dateofSolved=" + dateofSolved + ", description=" + description + ", rootCause=" + rootCause
				+ ", correctiveness=" + correctiveness + ", projectName=" + projectName + ", designation=" + designation
				+ ", bugName=" + bugName + ", empName=" + empName + ", summary=" + summary + "]";
	}

}
