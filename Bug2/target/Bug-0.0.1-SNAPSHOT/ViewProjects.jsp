<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style>

.card
{

margin-left:50%;
background-color:white;
}
		
		
</style>

</head>
<body>
	<%@ include file="home2.jsp"%>
	<div class="display">
		<c:forEach items="${projectList}" var="projectList">
		<div class="col-md-9 mb-4">
			<div class="card">
				<div class="card-body">

					<h5 class="card-title" align="center" style="font-weight: bold">${projectList.name}</h5>
				

					<table class="card-text">

						<tr>
						<tr>
							<td>Description</td>
							
							<td>:</td>
							<td>${projectList.description}&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>Start Date</td>
							<td>:</td>
							<td>${projectList.startDate}&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>End Date</td>
							<td>:</td>
							<td>${projectList.endDate}&nbsp;&nbsp;</td>
						</tr>

<tr>
							<td>Client Name</td>
							<td>:</td>
							<td>${projectList.client_name}&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>Client Address</td>
							<td>:</td>
							<td colspan="2">${projectList.client_address}&nbsp;&nbsp;</td>
						</tr>
	<tr>
							<td>Client Mobile</td>
							<td>:</td>
							<td colspan="2">${projectList.client_mobile}&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>Client Email</td>
							<td>:</td>
							<td colspan="2">${projectList.client_email}&nbsp;&nbsp;</td>
						</tr>
<tr>
							<td>TeamName</td>
							<td>:</td>
			<td colspan="2">${projectList.team.name}&nbsp;&nbsp;</td>
						</tr>

					</table>
				</div>
			</div>
		</div>
		</c:forEach>
		</div>
</body>
</html>