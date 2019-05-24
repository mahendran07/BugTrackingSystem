<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<style type="text/css">
input[type=text] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
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

input[type=text] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}
button {
	border-radius: 10px;
	border: 2px solid #ffffff;
	height: 55px;
	width: 130px;
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
font-size: 15px;
font-weight:bold;
}


</style>

<script type="text/javascript">

$(document).ready(
		function() {
			
			$.ajax({
						url : 'ViewTeamServlet',
						type : 'POST',
						success : function(responseText) {
							var value = JSON.parse(responseText);
							console.log(value);
							for ( var i=0;i<value.length;i++) {

								$('#second').append(
										"<option value="+value[i].id+">"
												+ value[i].name);

							}
						}

					});
		});
	</script>
</head>
<body>
<%@ include file="index.jsp"%>
<div class="name">
<form method="post" action="ProjectServlet">


		<table align="center">
			<tr>
				<td align="left">Project Name:</td>
				<td><input type="text" name="Projectname" pattern="[A-Za-z- ]{1,50}" required></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="left">Description:</td>
				<td><input type="text" name="description" pattern="[A-Za-z- ]{1,1000}" required></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="left">Start Date:</td>
				<td><input type="date" min="2019-05-23" name="StartDate"  required></td>
			</tr>
			<tr>
			<td align="left">End Date:</td>
				<td><input type="date" name="EndDate" required></td>
			</tr>
			<tr>
				<td align="left">AssignTo:</td>
				
				 
    
			<td><select name="team" id="second">
			<option value="-1">Select</option>
			</select></td>
			
			<tr>
				<td align="left">Client Name:</td>
				<td><input type="text" name="clientname" pattern="[A-Za-z-]{1,50}" required></td>
			</tr>
		
			<tr>
				<td align="left">Client Address:</td>
				<td><input type="text" name="clientaddress" required></td>
			</tr>
		
			<tr>
				<td align="left">Client Mobile</td>
				<td><input type="tel" name="clientmobile"  pattern="[6-9]{1}[0-9]{9}" required></td>
			</tr>
		<tr>
				<td align="left">Client Email</td>
				<td><input type="email" name="clientemail"  required></td>
			</tr>
			<tr>
			<td colspan="2"><button type="submit" name="addproject">ADD PROJECT</button> </td>
			<td>${status}</td></tr>
			</table>
			</form>
			
</div>
</body>
</html>