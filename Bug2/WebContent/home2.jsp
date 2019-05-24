<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>navbar example</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<style>
.navbar-default {
	background-color: grey;
	border-color: #d7b38c;
}
body
{
  background-image:url("bugging.jpeg");
  background-repeat: no-repeat;
  height:500px;
  width:100px;
   background-size: cover; 
  
}


/* .navbar-default .navbar-brand {
	color: #ffffff;
} */

/* .navbar-default .navbar-brand:hover, .navbar-default .navbar-brand:focus
	{
	color: grey;
} */

.navbar-default .navbar-text {
	color: grey;
}

.navbar-default .navbar-nav>li>a {
	color: white;
}

.navbar-default .navbar-nav>li>a:hover, .navbar-default .navbar-nav>li>a:focus
	{
	color: #ffffff;
}

.navbar-default .navbar-nav>li>.dropdown-menu {
	background-color: grey;
}

.navbar-default .navbar-nav>li>.dropdown-menu>li>a {
	color: #ffffff;
}

.navbar-default .navbar-nav>li>.dropdown-menu>li>a:hover,
	.navbar-default .navbar-nav>li>.dropdown-menu>li>a:focus {
	color: #ffffff;
	background-color: grey;
}

.navbar-default .navbar-nav>li>.dropdown-menu>li>.divider {
	background-color: grey;
}

.navbar-default .navbar-nav>.active>a, .navbar-default .navbar-nav>.active>a:hover,
	.navbar-default .navbar-nav>.active>a:focus {
	color: #ffffff;
	background-color: grey;
}

.navbar-default .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:hover,
	.navbar-default .navbar-nav>.open>a:focus {
	color: #ffffff;
	background-color: #d7b38c;
}

.navbar-default .navbar-toggle {
	border-color: #d7b38c;
}

.navbar-default .navbar-toggle:hover, .navbar-default .navbar-toggle:focus
	{
	background-color: #d7b38c;
}

.navbar-default .navbar-toggle .icon-bar {
	background-color: #ffffff;
}

.navbar-default .navbar-collapse, .navbar-default .navbar-form {
	border-color: #ffffff;
}

.navbar-default .navbar-link {
	color: #ffffff;
}

.navbar-default .navbar-link:hover {
	color: #ffffff;
}

@media ( max-width : 767px) {
	.navbar-default .navbar-nav .open .dropdown-menu>li>a {
		color: #ffffff;
	}
	.navbar-default .navbar-nav .open .dropdown-menu>li>a:hover,
		.navbar-default .navbar-nav .open .dropdown-menu>li>a:focus {
		color: #ffffff;
	}
	.navbar-default .navbar-nav .open .dropdown-menu>.active>a,
		.navbar-default .navbar-nav .open .dropdown-menu>.active>a:hover,
		.navbar-default .navbar-nav .open .dropdown-menu>.active>a:focus {
		color: #ffffff;
		background-color: #d7b38c;
	}
}
.container {
width: 136rem;
}
</style>
</head>
<body>
 <div class="container">
		<h1>Bug Tracking System</h1>
		<nav class="navbar navbar-default">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--   <a class="navbar-brand" href="#">Web</a> -->
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<!--   <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="https://www.jquery-az.com/php-tutorials/">PHP</a></li>
        <li><a href="https://www.jquery-az.com/jquery-tips/">jQuery</a></li>-->
				
					<li class="dropdown"><a
						href="https://www.jquery-az.com/bootstrap-tips-tutorials/"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">PROJECT<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="ViewProjectServlet">VIEW PROJECT</a></li>
							
						</ul></li>
					<li class="dropdown"><a
						href="https://www.jquery-az.com/bootstrap-tips-tutorials/"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">BUG <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="http://localhost:8082/Bug/Bug.jsp">RAISE
									BUG</a></li>
									<li><a
								href="ViewBugServlet">VIEW
									BUG</a></li>
						
						</ul></li>
					<li class="dropdown"><a
						href="https://www.jquery-az.com/bootstrap-tips-tutorials/"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">SOLUTION<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ViewSolutionServlet">VIEW SOLUTION</a></li>

						</ul></li>
								
					<li><a href="LogoutServlet"> 		<i class="fa fa-sign-out" style="font-size:14px; color:white;"></i>LOGOUT</a></li>
				</ul>
				<!--  <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Find topics">
        </div>
        <button type="submit" class="btn btn-info">Go</button>
        
      </form>-->

				<!--  <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">About <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="https://www.jquery-az.com/about-us/">Terms</a></li>
            <li><a href="https://www.jquery-az.com/contact/">Contact</a></li> 
          </ul>
        </li> 
      
    </div><!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
</body>
</html>

