<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script src="../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<link rel='stylesheet' href='../webjars/bootstrap/4.1.0/css/bootstrap.min.css'>
<script type="text/javascript" src="../resources/js/domain.js"></script>
<script type="text/javascript" src="../resources/js/session.js"></script>
<script type="text/javascript" src="../resources/js/logout.js"></script>
<title>Admin Home</title>
</head>
<body>
	<div id="session"></div>
	<div id="content" class="flexbox contentBody">
		<div id="menu"></div>
		<div id="page"></div>
		<div id="logout"></div>
	</div>
	<script>
		$(document).ready(function() {
			$("#session" ).load( "adminSession.html" );
			$("#menu").load("adminMenu.html");
			$("#page").load("../shareView/homePage.html");
			$("#logout").load("../shareView/logout.html");
		});
		
	</script>

</body>
</html>