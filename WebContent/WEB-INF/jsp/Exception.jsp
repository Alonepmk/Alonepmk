<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="../webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/domain.js"></script>
<script type="text/javascript" src="../resources/js/network.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center;">${msg}</h1>
	<h2 style="text-align:center;"><a id="link" href="">Click here to redirect!!!</a></h2>
	<script>
		$(document).ready(function(){
			//document.getElementById("link").href = urlDomain+"index.html";
			$("#link").attr("href", urlDomain+"index.html");
		});
	</script>
</body>
</html>