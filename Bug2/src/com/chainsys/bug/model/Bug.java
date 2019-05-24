package com.chainsys.bug.model;

import java.time.LocalDate;

/**
 * Bug class is used to raise the bug by the tester to the project.
 * @author durg2128
 *
 */
public class Bug {
	private Long id;
	private String name;
	private LocalDate raisedDate;
	private String description;
	private String type;
	private String priority;
	private String status;
	private Project project;
	private Long raisedby;
	private String raisedbyname;
	private Long raisedTo;
	private String projectname;

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRaisedTo() {
		return raisedTo;
	}

	public void setRaisedTo(Long raisedTo) {
		this.raisedTo = raisedTo;
	}

	public String getRaisedbyname() {
		return raisedbyname;
	}

	public void setRaisedbyname(String raisedbyname) {
		this.raisedbyname = raisedbyname;
	}

	TeamMembers teamMembers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(LocalDate raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getRaisedby() {
		return raisedby;
	}

	public void setRaisedby(Long raisedby) {
		this.raisedby = raisedby;
	}

	public TeamMembers getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(TeamMembers teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((projectname == null) ? 0 : projectname.hashCode());
		result = prime * result + ((raisedDate == null) ? 0 : raisedDate.hashCode());
		result = prime * result + ((raisedTo == null) ? 0 : raisedTo.hashCode());
		result = prime * result + ((raisedby == null) ? 0 : raisedby.hashCode());
		result = prime * result + ((raisedbyname == null) ? 0 : raisedbyname.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((teamMembers == null) ? 0 : teamMembers.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Bug other = (Bug) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (projectname == null) {
			if (other.projectname != null)
				return false;
		} else if (!projectname.equals(other.projectname))
			return false;
		if (raisedDate == null) {
			if (other.raisedDate != null)
				return false;
		} else if (!raisedDate.equals(other.raisedDate))
			return false;
		if (raisedTo == null) {
			if (other.raisedTo != null)
				return false;
		} else if (!raisedTo.equals(other.raisedTo))
			return false;
		if (raisedby == null) {
			if (other.raisedby != null)
				return false;
		} else if (!raisedby.equals(other.raisedby))
			return false;
		if (raisedbyname == null) {
			if (other.raisedbyname != null)
				return false;
		} else if (!raisedbyname.equals(other.raisedbyname))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (teamMembers == null) {
			if (other.teamMembers != null)
				return false;
		} else if (!teamMembers.equals(other.teamMembers))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bug [id=" + id + ", name=" + name + ", raisedDate=" + raisedDate + ", description=" + description
				+ ", type=" + type + ", priority=" + priority + ", status=" + status + ", project=" + project
				+ ", raisedby=" + raisedby + ", raisedbyname=" + raisedbyname + ", raisedTo=" + raisedTo
				+ ", projectname=" + projectname + ", teamMembers=" + teamMembers + "]";
	}
}