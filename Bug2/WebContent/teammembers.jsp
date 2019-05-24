<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 

	 
	  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
text-align: center;
padding-top: 230px;
font-size: 15px;
}

form {
display: inline-block;
}
</style>
<script>



$(document).ready(function() {
	
	$.ajax({
		url : 'TeamServlet',
		type: 'POST'
		
		}
		);
});
</script>



</head>
<body>
<h1>Team</h1>
<form method="post" action="LoginServlet">
<table align="center">
<tr>
<td align="left">Team:</td>

<td>  <select name="team">
		  
		
		  
          
                 
                       <option value="appconnect1">appconnect1</option>
                          <option value="appconnect2">appconnect2</option>
                             <option value="appconnect3">appconnect3</option>
                  
                </select> </td>

</tr>

<tr>
<td align="left">Team Leader:</td>

<td><select name="leader" id=secondcombo>

		<option value="-1">Select
		</option>
		<option value="pooja">Pooja
		</option>
		<option value="anitha">Anitha
		</option>
		<option value="durga">Durga
		</option>
			</select>

</td>
</tr>

<tr>
<td align="left">Team Member:</td>
<td><select name="member" id=thirdcombo>

	<option value="-1">Select
		</option>
		<option value="pooja">Pooja
		</option>
		<option value="anitha">Anitha
		</option>
		<option value="durga">Durga
		</option>
			</select>

</td>
</tr>



<tr>
<td>

<button type="submit">Add</button>
</td>
</tr>
</table>
</form>



</body>
</html>