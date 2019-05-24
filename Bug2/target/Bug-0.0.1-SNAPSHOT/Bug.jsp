<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
}


</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				
				$.ajax({
							url : 'FindProjectSerlvet',
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
		

				
	$("#second").change(
			
			function() {
				$('#first').empty();
				$.ajax({
					type : 'POST',
					url : 'TeamMemberServlet',
					data : {
						second : $("#second").val()
					},
					success : function(data) {
						var x = JSON.parse(data);
						console.log(x);

					/* 	$('#first').append('<option value="">Select</option>'); */

						for(var i=0;i<x.length;i++)
							{
								$('#first').append(
										'<option value='+x[i].member+'>' + x[i].membername
												+ '</option>');
						}

					}

				});

			}); 	});
</script>

</head>
<body>
<%@ include file="home2.jsp"%>
<div class="name">
	<form method="post" action="BugServlet">
		<table align="center">
			<tr>
				<td align="left">Bug Name:</td>
				<td><input type="text" name="Bugname" required></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="left">Project Name:</td>
				<td align="left"><select name="second" id="second">
						<option value="-1">Select</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="left">RaisedDate:</td>
				<td align="left"><input type="date" name="RaisedDate" required></td>
			</tr>
			<tr>
				<td></td>
			</tr>
	
			<tr>
				<td align="left">Description:</td>
				<td><input type="text" name="Description" required></td>
			</tr>
			<tr>
				<td></td>
			</tr>
	
			<tr>
				<td align="left">Bug Type:</td>
				<td align="left"><select name="Bugtype">
						<option value="warning">Warning</option>
						<option value="major">Major</option>
						<option value="crictical">crictical</option>

				</select></td>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="left">Bug Priority:</td>
				<td align="left"><select name="Bugpriority">
						<option value="low">Low</option>
						<option value="medium">Medium</option>
						<option value="high">High</option>

				</select></td>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="left">Raised To:</td>
				<td align="left"><select name="first" id="first">
						<option value=>Select</option>
				</select></td>
			</tr>
			<tr>
				<td>
					<button type=&nbsp;"submit">Add</button>${status}
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>