<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script src="../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<link rel='stylesheet'
	href='../webjars/bootstrap/4.1.0/css/bootstrap.min.css'>
<script type="text/javascript" src="../resources/js/domain.js"></script>
<script type="text/javascript" src="../resources/js/logout.js"></script>
<script type="text/javascript" src="../resources/js/session.js"></script>
<link rel="stylesheet" href="../DataTables/datatables.min.css">
<script type="text/javascript" src="../DataTables/datatables.min.js"></script>

<link rel="stylesheet" href="../resources/assets/css/style.css">
<title>Link With Other</title>
</head>
<body>
	<div id="session"></div>
	<div class="d-flex" id="wrapper">
		<div id="userMenu"></div>
		<div id="page-content-wrapper">
			<div id="header"></div>
			<div id="content"></div>

		</div>

	</div>
	<script>
		$(document).ready(function() {
			$("#session").load("userSession.html");
			$("#userMenu").load("userMenu.html");
			$("#header").load("userHeader.html");
			$("#content").load("../shareView/linkWithOther.html");
		});
	</script>
</body>
</html>