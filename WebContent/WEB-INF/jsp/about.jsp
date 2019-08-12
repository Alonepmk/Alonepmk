<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<div class="row">
		<h1>Welcome to my SpringMVC project</h1>
			<div class="col-sm-6">
				<h2>System Information</h2>
				<ul>
					<li>Web Server : Tomcat-9.0</li>
					<li>JDK : 12.0.1</li>
					<li>API : RestAPI</li>
					<li>Database : MySQL-8.1 + Mybatis-3.0.3</li>
					<li>Frontend : BootStrap 4 + JQuery</li>
					<li>Web Service : Amazon </li>
					<li>Server : Amazon Linux 2 AMI (HVM) | SSD Volume Type</li>
				</ul>
				<p class="text-secondary"><a id="about_signup_link" class="text-primary"
				href="">Signup</a> here for using or testing or learning together with me. It's absolutely free
				and so many benifit for you!!!</p>
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function(){
			document.getElementById("about_signup_link").href = urlDomain
			+ "index.html?mid=4";
		});
	</script>
</body>
</html>