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



.card
{

margin-left:50%;
background-color:#D3D3D3
}
		
		
</style>

</head>

<body>
	<%@ include file="home2.jsp"%>
	<div class="display">
		<c:forEach items="${solutionList}" var="solutionList">
		<div class="col-md-9 mb-4">
			<div class="card">
				<div class="card-body">

					<h5 class="card-title" align="center" style="font-weight: bold">${solutionList.projectName}</h5>
				

					<table class="card-text">

						
						
						<tr>
							<td>Bug name</td>
							
							<td>:</td>
							<td>${solutionList.bugName}&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>Solution ID</td>
							
							<td>:</td>
							<td>${solutionList.id}&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>Solved By</td>
							
							<td>:</td>
							<td>${solutionList.empName}-&nbsp;${solutionList.designation}&nbsp;</td>
						</tr>
						<tr>
							<td>Date of Solved</td>
							<td>:</td>
							<td>${solutionList.dateofSolved}&nbsp;&nbsp;</td>
						</tr>

<tr>
							<td>Root Cause</td>
							<td>:</td>
							<td>${solutionList.rootcause}&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>Correctiveness</td>
							<td>:</td>
							<td colspan="2">${solutionList.correctiveness}&nbsp;&nbsp;</td>
						</tr>
	<tr>
							<td>Summary</td>
							<td>:</td>
							<td colspan="2">${solutionList.summary}&nbsp;&nbsp;</td>
						</tr>
					



					</table>
				</div>
			</div>
		</div>
		</c:forEach>
		</div>
</body>
</body>
</html>