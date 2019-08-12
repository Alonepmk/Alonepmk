<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
.navbar-nav li {
	cursor: pointer;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<img src="resources/assets/images/icon_logo.png"
			style="width: 55x; height: 55px;">


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse navigation"
			id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="" id="menu1">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="" id="menu2">Contact
						Me</a></li>
				<li class="nav-item"><a class="nav-link" href="" id="menu3">About</a></li>
			</ul>
		</div>
		<div>
			<form class="form-inline" name="loginForm">
				<div class="form-group mt-sm-4">
					<label for="user_name" class="mr-sm-2 text-white"> Email:</label> <input
						class="form-control form-control-sm mr-sm-2" type="text"
						name="user_name" id="email"> <label for="password"
						class="mr-sm-2 text-white align-middle">Password:</label> <input
						class="form-control form-control-sm mr-sm-2" type="password"
						name="password" id="password"> <input value="Login"
						class="btn btn-primary btn-sm" type="button" id="login">
				</div>
			</form>
			<a href="" id="sign_up"
				class="col-sm-5 float-right text-info font-italic h7">Click here
				for signup..</a>


		</div>
	</nav>

	<script>
		$(document)
				.ready(
						function() {
							//For menu Item
							document.getElementById("menu1").href = urlDomain
									+ "index.html?mid=1";
							document.getElementById("menu2").href = urlDomain
									+ "index.html?mid=2";
							document.getElementById("menu3").href = urlDomain
									+ "index.html?mid=3";
							document.getElementById("sign_up").href = urlDomain
									+ "index.html?mid=4";

							//For LocalStorage Session Check
							var session = JSON.parse(localStorage
									.getItem("user")
									|| localStorage.getItem("admin"));
							if (session) {
								document.getElementById("email").value = session.email;
								document.getElementById("password").value = session.password;
							}

							//For Menu Item Page Select
							var mid = getParameterByName("mid") || 1;
							if (mid == 1) {
								$("#main_content").load(
										urlDomain + "mainContent.html");
								$(".navigation").siblings('li').removeClass(
										'active');
								$("#menu1").addClass('active');
							} else if (mid == 2) {
								$("#main_content").load(
										urlDomain + "contactUs.html");
								$(".navigation").siblings('li').removeClass(
										'active');
								$("#menu2").addClass('active');
							} else if (mid == 3) {
								$("#main_content").load(
										urlDomain + "about.html");
								$(".navigation").siblings('li').removeClass(
										'active');
								$("#menu3").addClass('active');
							} else {
								$("#main_content").load(
										urlDomain + "signUp.html");
								$(".navigation").siblings('li').removeClass(
										'active');
							}

							//For User Login
							$("#login")
									.click(
											function() {

												var account = {
													"id" : 1,
													"firstName" : "",
													"lastName" : "",
													"role" : "",
													"email" : $("#email").val(),
													"gender" : "",
													"city" : "",
													"country" : "",
													"password" : $("#password")
															.val(),
													"emailConfirmCode" : "",
													"confirmation" : "",

												};
												checkFirstTime(account);
											});
							
							//Is User Login FirstTime or Not
							function checkFirstTime(account){
								console.log(JSON.stringify(account));
								$.ajax({
									type : "POST",
									url : urlDomain
											+ "authentication/checkFirstTime",
									data : JSON
											.stringify(account),
									success : function(
											data) {
										console.log(data.status);
										if (data.status == 601) {
											var prompt_comfirm_code = prompt("Please enter your ConfirmCode");
											  if (prompt_comfirm_code != null) {
											    doLogin(data.account,prompt_comfirm_code);
											  }
											}else{
												doLogin(data.account,0);
											}
									},
									dataType : "json",
									contentType : "application/json"
								});
							}
							
							//for login
							function doLogin(account,code){
								$.ajax({
									type : "POST",
									url : urlDomain
											+ "authentication/login/"+code,
									data : JSON
											.stringify(account),
									success : function(
											data) {
										if (data.status == 200) {
											if (data.account.role == "adm") {
												localStorage
														.removeItem("user");
												localStorage
														.setItem(
																"admin",
																JSON
																		.stringify(data.account));
												window.location.href = urlDomain
														+ "admin/adminHome.html";

											} else if (data.account.role == "u") {
												localStorage
														.removeItem("admin");
												localStorage
														.setItem(
																"user",
																JSON
																		.stringify(data.account));
												window.location.href = urlDomain
														+ "user/userHome.html";
											} else {
												localStorage
														.removeItem("user");
												localStorage
														.removeItem("admin");
												alert("Something Went Wrong!!!");
												window.location
														.reload();
											}
										} else {
											localStorage
													.removeItem("user");
											localStorage
													.removeItem("admin");
											alert("Incorrect email and Password!!!");
											window.location
													.reload();
										}
									},
									dataType : "json",
									contentType : "application/json"
								});
							}

						});
	</script>
</body>
</html>