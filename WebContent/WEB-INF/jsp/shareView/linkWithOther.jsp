<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div class="right-panel" id="right-panel"><h1>Link With other page</h1></div>
	<div></div>
	<table id="example" class="table table-striped table-bordered" style="width:80%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>City</th>
                <th>Country</th>
                <th>Gender</th>
            </tr>
        </thead>

    </table>
	<script>
		$(document).ready(function(){
			$('#example').DataTable( {
		        	ajax: {
		                url: urlDomain + '/account/getAllUserAccount',
		                dataSrc: ''
		            },
		            columns: [
		            	{ data : "fullName" },
		            	{ data : "email" },
		            	{ data : "city" },
		            	{ data : "country" },
		            	{ data : "fullName" }
		            ]
		    } );
		});
	</script>
</body>
</html>