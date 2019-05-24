<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
input[type=text] {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 40px;
}

input[type=tel] {
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

.status {
	background-color: white;
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

textarea {
	border-radius: 10px;
	border: 2px solid #73AD21;
	padding: 10px;
	width: 200px;
	height: 100px;
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

.table
{
cellpadding="35";
background-color:white;


}
th, td {
  padding: 15px;
}

.name {
	color: black;
	font-size: 15px;
	font-weight: bold;
}
</style>
</head>
<body>






<form method="post" action="TeamServlet">
 <table align="center">
<tr>
<td align="left">Team Name:</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>
</td>
</tr>
<tr  align="center" colspan="1">

<td>

<button type=&nbsp;"submit" class="login100-form-btn" value="1" name="buttonn" >Add</button>

</td>
<td>

<button type=&nbsp;"submit" class="login100-form-btn" value="2" name="buttonn" >View</button>
</td>
</tr>
<tr><td>${status}</td></tr>
</table>



<div id="include"></div>




      
      <table class="table">
  <tr>
  <th scope="col">
  ID
  </th>
  <th >
  NAME
  </th>
  </tr>
      <c:forEach items="${teams}" var="teams">
    <tr>
    

            <td>${teams.id}</td>
       <td>${teams.name}</td>
      
    </tr>

        </c:forEach>
      
      </table>        


</form>



</body>
</html>