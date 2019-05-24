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

body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.login100-form-btn {
  font-family: Ubuntu-Bold;
  font-size: 18px;
  color: #fff;
  line-height: 1.2;
  text-transform: uppercase;

  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  min-width: 160px;
  height: 42px;
  border-radius: 21px;

  background: #5CCB1B;
  background: -webkit-linear-gradient(left, #14690D, #5CCB1B, #72FC23);
  background: -o-linear-gradient(left, #14690D, #5CCB1B, #72FC23);
  background: -moz-linear-gradient(left, #14690D, #5CCB1B, #72FC23);
  background: linear-gradient(left, #14690D, #5CCB1B, #72FC23);
  position: relative;
  z-index: 1;

  -webkit-transition: all 0.4s;
  -o-transition: all 0.4s;
  -moz-transition: all 0.4s;
  transition: all 0.4s;
}
.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px 0px 80px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
.nav-side-menu {
  overflow: auto;
  font-family: verdana;
  font-size: 12px;
  font-weight: 200;
  background-color: #2e353d;
  position: fixed;
  top: 0px;
  width: 300px;
  height: 100%;
  color: #e1ffff;
}
.nav-side-menu .brand {
  background-color: #23282e;
  line-height: 50px;
  display: block;
  text-align: center;
  font-size: 14px;
}
.nav-side-menu .toggle-btn {
  display: none;
}
.nav-side-menu ul,
.nav-side-menu li {
  list-style: none;
  padding: 0px;
  margin: 0px;
  line-height: 35px;
  cursor: pointer;
  /*    
    .collapsed{
       .arrow:before{
                 font-family: FontAwesome;
                 content: "\f053";
                 display: inline-block;
                 padding-left:10px;
                 padding-right: 10px;
                 vertical-align: middle;
                 float:right;
            }
     }
*/
}
.nav-side-menu ul :not(collapsed) .arrow:before,
.nav-side-menu li :not(collapsed) .arrow:before {
  font-family: FontAwesome;
  content: "\f078";
  display: inline-block;
  padding-left: 10px;
  padding-right: 10px;
  vertical-align: middle;
  float: right;
}
.nav-side-menu ul .active,
.nav-side-menu li .active {
  border-left: 3px solid #d19b3d;
  background-color: #4f5b69;
}
.nav-side-menu ul .sub-menu li.active,
.nav-side-menu li .sub-menu li.active {
  color: #d19b3d;
}

.nav-side-menu ul .sub-menu li.active a,
.nav-side-menu li .sub-menu li.active a {
  color: #d19b3d;
}
.nav-side-menu ul .sub-menu li,
.nav-side-menu li .sub-menu li {
  background-color: #181c20;
  border: none;
  line-height: 28px;
  border-bottom: 1px solid #23282e;
  margin-left: 0px;
}
.nav-side-menu ul .sub-menu li:hover,
.nav-side-menu li .sub-menu li:hover {
  background-color: #020203;
}
.nav-side-menu ul .sub-menu li:before,
.nav-side-menu li .sub-menu li:before {
  font-family: Fontawesome;
  content: "\f105";
  display: inline-block;
  padding-left: 20px;
  padding-right: 10px;
  vertical-align: middle;
}
.nav-side-menu li {
  padding-left: 0px;
  border-left: 3px solid #2e353d;
  border-bottom: 1px solid #23282e;
}
.nav-side-menu li a {
  text-decoration: none;
  color: #e1ffff;
}
.nav-side-menu li a i {
  padding-left: 10px;
  width: 20px;
  padding-right: 20px;
}
.nav-side-menu li:hover {
  border-left: 3px solid #d19b3d;
  background-color: #4f5b69;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -o-transition: all 1s ease;
  -ms-transition: all 1s ease;
  transition: all 1s ease;
}
@media (max-width: 767px) {
  .nav-side-menu {
    position: relative;
    width: 100%;
    margin-bottom: 10px;
  }
  .nav-side-menu .toggle-btn {
    display: block;
    cursor: pointer;
    position: absolute;
    right: 10px;
    top: 10px;
    z-index: 10 !important;
    padding: 3px;
    background-color: #ffffff;
    color: #000;
    width: 40px;
    text-align: center;
  }
  .brand {
    text-align: left !important;
    font-size: 22px;
    padding-left: 20px;
    line-height: 50px !important;
  }
}
@media (min-width: 767px) {
  .nav-side-menu .menu-list .menu-content {
    display: block;
  }
}
body {
  margin: 0px;
  padding: 0px;
}

.nav-side-menu ul .sub-menu ul .sub-line li.active,
.nav-side-menu li .sub-menu li .sub-line li.active {
  color: #d19b3d;
}

.nav-side-menu ul .sub-menu li .sub-line li.active a,
.nav-side-menu li .sub-menu li .sub-line li.active a {
  color: #d19b3d;
}
.nav-side-menu ul .sub-menu li .sub-line li,
.nav-side-menu li .sub-menu li .sub-line li {
  background-color: #181c20;
  border: none;
  line-height: 28px;
  border-bottom: 1px solid #23282e;
  margin-left: 0px;
}
.nav-side-menu ul .sub-menu li .sub-line li:hover,
.nav-side-menu li .sub-menu li .sub-line li:hover {
  background-color: #020203;
}
.nav-side-menu ul .sub-menu li .sub-line li:before,
.nav-side-menu li .sub-menu li .sub-line li:before {
  font-family: FontAwesome;
  content: "\f105";
  display: inline-block;
  padding-left: 100px;
  padding-right: 10px;
  vertical-align: middle;
}

.nav-side-menu .sub-menu li {
  padding-left: 20px;
  border-left: 3px solid #2e353d;
  border-bottom: 1px solid #23282e;
}
.nav-side-menu .sub-menu li a {
  text-decoration: none;
  color: #e1ffff;
}
.sub-menu li a i {
  padding-left: 10px;
  width: 20px;
  padding-right: 20px;
}
.nav-side-menu li .sub-menu li:hover {
  border-left: 3px solid #d19b3d;
  background-color: #4f5b69;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -o-transition: all 1s ease;
  -ms-transition: all 1s ease;
  transition: all 1s ease;
}
@media (max-width: 767px) {
 .nav-side-menu .sub-menu {
    position: relative;
    width: 100%;
    margin-bottom: 10px;
  }
.nav-side-menu  .sub-menu .toggle-btn {
    display: block;
    cursor: pointer;
    position: absolute;
    right: 10px;
    top: 10px;
    z-index: 10 !important;
    padding: 3px;
    background-color: #ffffff;
    color: #000;
    width: 40px;
    text-align: center;
  }
  
  .sub-line ul .sub-press li.active,
.sub-line li .sub-press li.active {
  color: #d19b3d;
}

.sub-line ul .sub-press li.active a,
.sub-line li .sub-press li.active a {
  color: #d19b3d;
}
.sub-line ul .sub-press li,
.sub-line li .sub-press li {
  background-color: #181c20;
  border: none;
  line-height: 28px;
  border-bottom: 1px solid #23282e;
  margin-left: 0px;
}
.sub-line ul .sub-press li:hover,
.sub-line li .sub-press li:hover {
  background-color: #020203;
}
.sub-line ul .sub-press li:before,
.sub-line li .sub-press li:before {
  font-family: Arial;
  content: "\f105";
  display: inline-block;
  padding-left: 50px;
  padding-right: 10px;
  vertical-align: middle;
}

.sub-line li {
  padding-left: 20px;
  border-left: 3px solid #2e353d;
  border-bottom: 1px solid #23282e;
}
.sub-line li a {
  text-decoration: none;
  color: #e1ffff;
}
.sub-line li a i {
  padding-left: 50px;
  width: 20px;
  padding-right: 20px;
}
.sub-line li:hover {
  border-left: 3px solid #d19b3d;
  background-color: #4f5b69;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -o-transition: all 1s ease;
  -ms-transition: all 1s ease;
  transition: all 1s ease;
}
@media (max-width: 767px) {
  .sub-line {
    position: relative;
    width: 100%;
    margin-bottom: 10px;
  }
  .sub-line .toggle-btn {
    display: block;
    cursor: pointer;
    position: absolute;
    right: 10px;
    top: 10px;
    z-index: 10 !important;
    padding: 3px;
    background-color: #ffffff;
    color: #000;
    width: 40px;
    text-align: center;
  }

</style>

</head>
<body>



 <div class="navbar">
 
    <button> 
    <i class="fa fa-sign-out" aria-hidden="true"></i>Logout
    </button>
    
  </div> 

 
 

 <div class="nav-side-menu">
    <div class="brand">Bug Tracking</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <!--<li>
                  <a href="#">
                  <i class="fa fa-dashboard fa-lg"></i> Dashboard
                  </a>
                </li>  -->

                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                  <a href="#"><i class="fa fa-group"></i> Team <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products">
                    <li class="active"><a href="http://localhost:8082/Bug/team.jsp">Add Team</a></li>
   
                    <li><a href="#">Allocate Team Members</a></li>
                    <li><a href="#">View Members</a></li>
                </ul>


                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class='fa fa-group'></i> Project <span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <li>Add Project</li>
                  <li>View Project</li>
              
                </ul>


                <li data-toggle="collapse" data-target="#new" class="collapsed">
                  <a href="#"><i class="fa fa-group"></i>Bug<span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="new">
                  <li>View Bug</li>
                  <li>View Solution</li>
                </ul>


        <!--         <li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> 
                  </a>
                  </li>

                 <li data-toggle="collapse" data-target="#new" class="collapsed">
                  <a href="#"><i class="fa fa-car fa-lg"></i> Logout <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="new">
                  <li>Sensorkonfiguration</li>
                  <li>Betriebsarten</li>
                </ul>--> 

            </ul>
     </div>
</div>


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
{$status}
</td>
<td>

<button type=&nbsp;"submit" class="login100-form-btn" value="2" name="buttonn" >View</button>
</td>
</tr>
</table>



<div id="include"></div>




      
      <table border="1" align="center">
  <tr>
  <td>
  ID
  </td>
  <td>
  NAME
  </td>
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