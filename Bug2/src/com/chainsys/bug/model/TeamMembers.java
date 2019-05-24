package com.chainsys.bug.model;

/**
 * TeamMembers class is used to add team members to particular team
 * @author durg2128
 *
 */
public class TeamMembers {

	private Team team;
	private Long member;
	private Long leader;
	private String membername;
	private String leadername;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Long getMember() {
		return member;
	}

	public void setMember(Long member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "TeamMembers [team=" + team + ", member=" + member + ", leader=" + leader + ", membername=" + membername
				+ ", leadername=" + leadername + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		result = prime * result + ((leadername == null) ? 0 : leadername.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((membername == null) ? 0 : membername.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
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
		TeamMembers other = (TeamMembers) obj;
		if (leader == null) {
			if (other.leader != null)
				return false;
		} else if (!leader.equals(other.leader))
			return false;
		if (leadername == null) {
			if (other.leadername != null)
				return false;
		} else if (!leadername.equals(other.leadername))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (membername == null) {
			if (other.membername != null)
				return false;
		} else if (!membername.equals(other.membername))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

	public Long getLeader() {
		return leader;
	}

	public void setLeader(Long leader) {
		this.leader = leader;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getLeadername() {
		return leadername;
	}

	public void setLeadername(String leadername) {
		this.leadername = leadername;
	}

}
