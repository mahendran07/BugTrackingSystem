<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.card {
	margin-left: 50%;
	background-color: #D3D3D3
}
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
	
			

						
<div class="name">

						<table class="table" align="center">



							<tr>
							<th scope="col">Project Name</th>
							<th scope="col">Bug name</th>
								<th scope="col">Solution ID</th>
							<th scope="col">Solved By</th>
							<th scope="col">Date of Solved</th>
							<th scope="col">Root Cause</th>
							<th scope="col">Correctiveness</th>
							<th scope="col">Summary</th>
								</tr>
									<c:forEach items="${solutionList}" var="solutionList">
		<tr><td>${solutionList.projectName }</td>
								<td>${solutionList.bugName}&nbsp;&nbsp;</td>
								
						
								<td>${solutionList.id}&nbsp;&nbsp;</td>
							
								<td>${solutionList.empName}-&nbsp;${solutionList.designation}&nbsp;</td>
							
								
								
								<td>${solutionList.dateofSolved}&nbsp;&nbsp;</td>
							
								<td>${solutionList.rootcause}&nbsp;&nbsp;</td>
						
								<td>${solutionList.correctiveness}</td>
					
							
								<td>${solutionList.summary}&nbsp;&nbsp;</td>
							</tr>

</c:forEach>


						</table>
					</div></div>
				
</body>
</html>