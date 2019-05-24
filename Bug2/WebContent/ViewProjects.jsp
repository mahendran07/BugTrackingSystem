<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
.display {
color: black;
font-size: 15px;
padding-left:600px;
}
		
</style>

</head>
<body>
	<%@ include file="home2.jsp"%>
	<div class="display">
			
				
<table class="table" align="center">
	<tr>
	<th scope="col">PROJECT NAME</th>
	<th scope="col">DESCRIPTION</th>
	<th scope="col">START DATE</th>
	<th scope="col">END DATE</th>
	<th scope="col">CLIENT NAME</th>
	<th scope="col">CLIENT MOBILE</th>
	<th scope="col">CLIENT EMAIL</th>
	<th scope="col">TEAM NAME</th>
	<th></th>
	</tr>
		<c:forEach items="${projectList}" var="projectList">

<tr>
			
				
					<td>${projectList.name}</td>
					<td>${projectList.description}</td>
					<td>${projectList.startDate}</td>
					<td>${projectList.endDate}</td>
					<td>${projectList.client_name}</td>
					<td>${projectList.client_mobile}</td>
					<td>${projectList.client_email}</td>
				<td>${projectList.team.name}</td>
				</tr></c:forEach>
				
	</table></div>
</body>
</html>