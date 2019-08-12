<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alonepmk</title>
<style>
.fakeimg {
	height: 220px;
	background: #aaa;
}

body {
	overflow-x: hidden;
	font-family: "Times New Roman";
}

p {
	text-align: justify;
}

#footer {
	position: absolute;
	bottom : 0;
	width: 100%;
	margin-bottom: 0
}
#page-container {
  position: relative;
  min-height: 115vh;
}

</style>
<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<link rel='stylesheet'
	href='webjars/bootstrap/4.1.0/css/bootstrap.min.css'>
<script type="text/javascript" src="resources/js/domain.js"></script>
<script type="text/javascript" src="resources/js/network.js"></script>
</head>
<body>

	
		<div id="header_menu"></div>
	<div id="page-container">
		<div id="main_content"></div>
		<div id="footer_menu"></div>
	</div>

	<script>
		$(document).ready(function() {
			$("#header_menu").load(urlDomain + "header.html");
			$("#footer_menu").load(urlDomain + "footer.html");
		});
	</script>

</body>
</html>