<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
<title>Insert title here</title>
<style type="text/css">
input[type=text] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}

label {
	font-weight: normal !important;
}

input[type=email] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}

input[type=password] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}

input[type=number] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}
textarea
{
border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height:100px;

}
select {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}

input[type=date] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}

button {
	border-radius: 10px;
	border: 2px solid #ffffff;
	height: 40px;
	width: 120px;
	font-weight: bold;
	background-color: #73AD21;
}

::placeholder {
	opacity: 0.4;
}

table {
	border-collapse: separate;
	border-spacing: 0 5px;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	width: 200px;
}

.name {
color: black;
font-size: 20px;
padding-left:600px;
}

</style>
<!-- <script>
$(document).ready(
		function() {
			
			$.ajax({
						url : 'FindBugServlet',
						type : 'POST',
						success : function(responseText) {
							var value = JSON.parse(responseText);
							console.log(value);
							for ( var i=0;i<value.length;i++) {

								$('#bugid').append(
										"<option value="+value[i].id+">"
												+ value[i].name);

							}
						}

					});
	
		});




</script> -->

</head>


<body>
<%@ include file="home1.jsp"%>
<div class="name">
<form method="post" action="SolutionServlet">
		<table style="background-color: white;">
			<tr><td>
			Select Bug</td>
				<td>	<select name="bugid" id="bugid">
		<option value="-1">Select
		</option>
		<option value="${solution.bug.id}">${solution.bug.name}</option>
			</select></td>
			</tr>
			<tr><td>
			Solved Date
			</td>
				<td><input type="date" name="solveddate" 
					></td>
			</tr>
			<tr>
			<tr><td>
			
			Root Cause</td>
			
			<td><input type="text" name="rootcause"></td>
				</tr>
			<tr><td>
			Correctiveness</td>
				<td><input type="text" name="correctiveness" 
					></td>
			</tr>
			<tr><td>
			Summary</td>
			<td><textarea rows="5" cols="25" name="summary"></textarea></td></td></tr>
			<tr>
				<td colspan="2"><button type="submit">ADD</button></td>
			
			</tr>
			<tr>
			<td colspan="2">${status}
			</td>
			</tr>
		</table>
		</form>

</div>
</body>
</html>