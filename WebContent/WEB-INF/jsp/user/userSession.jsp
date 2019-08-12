<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
		$(document).ready(function(){
			var session = localStorage.getItem("user");
			checkSession(session);			
		});
	</script>
</body>
</html>