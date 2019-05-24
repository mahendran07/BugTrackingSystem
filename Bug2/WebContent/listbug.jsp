<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.table
{
cellpadding="35";
background-color:white;


}
th, td {
  padding: 15px;
}

</style>
</head>
<body>
<%@ include file="home2.jsp"%>
	<h3>Bugs</h3>
	<table class="table">
	<tr>
	<th scope="col">BUG NAME</th>
	<th scope="col">PROJECT NAME</th>
	<th scope="col">RAISED DATE</th>
	<th scope="col">DESCRIPTION</th>
	<th scope="col">TYPE</th>
	<th scope="col">PRIORITY</th>
	<th scope="col">RAISED BY</th>
	<th scope="col">STATUS</th>
	<th></th>
	</tr>	

			<c:forEach items="${bugList}" var="bugList" >
				<tr>
					<td>${bugList.name}</td>
					<td>${bugList.project.name}</td>
					<td>${bugList.raisedDate}</td>
					<td>${bugList.description}</td>
					<td>${bugList.type}</td>
					<td>${bugList.priority}</td>
					<td>${bugList.teamMembers.member}</td>
				<td>${bugList.status}</td>
				
					
				</tr>
				
			</c:forEach>
		
		
	</table>
	
</body>
</html>