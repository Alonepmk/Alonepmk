<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div #logout {
	position: absolute;
	top: 0;
	right: 0;
	border: solid 1px;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 10px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}
</style>
</head>
<body>
	<input type="button" class="button" id="logout" value="logout" />
	<script type="text/javascript">
		$(document).ready(function(){
			$("#logout").click(function(){
				var x = confirm("Are you sure to Logout?");
				if(x == true){
					logout();
				}
			});
			
		});
	</script>
</body>
</html>