<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="resources/plugin/country_picker/js/countrypicker.js"></script>
</head>
<body>

	<div class="row justify-content-center" style="margin-top: 100px;">
		<div class="col-md-6">
			<div class="card">
				<header class="card-header">
					<a href="" class="float-right btn btn-outline-primary mt-1">Log
						in</a>
					<h4 class="card-title mt-2">Sign up</h4>
				</header>
				<article class="card-body">
					<form class="needs-validation"  onsubmit="signup()">
						<div class="form-row">
							<div class="col form-group">
								<label>First name </label> <input type="text"
									class="form-control" id="first_name" placeholder="" required>
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Last name</label> <input id="last_name" type="text"
									class="form-control" placeholder=" " required>
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row end.// -->
						<div class="form-group">
							<label>Email address</label> <input type="email"
								id="email_signup" class="form-control" placeholder="" required> 
								<small
								class="form-text text-muted">We'll never share your
								email with anyone else.</small>
						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<label class="form-check form-check-inline"> <input
								class="form-check-input gender" type="radio" name="gender"
								value="1" checked> <span class="form-check-label"> Male </span>
							</label> <label class="form-check form-check-inline"> <input
								class="form-check-input gender" type="radio" name="gender"
								value="2"> <span class="form-check-label"> Female</span>
							</label>
						</div>
						<!-- form-group end.// -->
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>City</label> <input id="city" type="text"
									class="form-control" required>
							</div>
							<!-- form-group end.// -->
							<div class="form-group col-md-6">
								<label>Country</label> <select
									class="selectpicker countrypicker form-control"
									data-default="Australia" data-flag="true" id="select_box" required></select>
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row.// -->
						<div class="form-group">
							<label>Create password</label> <input class="form-control"
								type="password" id="password_input" required>
						</div>
						<p id="error" class="text-danger"></p>
						<div class="form-group">
							<label>Confirm password</label> <input class="form-control"
								type="password" id="repassword_input" required>
							<div class="invalid-feedback">Must Fill!!!</div>
						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<button type="button" id="signUp_btn"
								class="btn btn-primary btn-block">Register</button>
						</div>
						<!-- form-group// -->
						<small class="text-muted">By clicking the 'Sign Up'
							button, you confirm that you accept our <br> Terms of use
							and Privacy Policy.
						</small>
					</form>
				</article>
				<!-- card-body end .// -->
				<div class="border-top card-body text-center">
					Have an account? <a href="">Log In</a>
				</div>
			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->

	</div>
	<!-- row.//-->


	<br>
	<br>
	<!--container end.//-->
	<script>
		$(document).ready(function() {
			var isSubmit = false;
			//check password match or not
			$('#repassword_input').keyup(function(e) {
				//get values 
				var pass = $('#password_input').val();
				var confpass = $(this).val();

				//check the strings
				if (pass == confpass) {
					//if both are same remove the error and allow to submit
					$('#error').text('');
					isSubmit = true;
				} else {
					//if not matching show error and not allow to submit
					$('#error').text('Password not matching');
					isSubmit = false;
				}
			});

			$("#signUp_btn").click(function() {
				if (isSubmit) {
					$("#signUp_btn").attr("disabled", true);
					var account = {
						"id" : 1,
						"firstName" : $("#first_name").val(),
						"lastName" : $("#last_name").val(),
						"role" : "u",
						"email" : $("#email_signup").val(),
						"gender" : $("input[name='gender']:checked").val(),
						"city" : $("#city").val(),
						"country" : $("#select_box").val(),
						"password" : $("#password_input").val(),
						"emailConfirmCode" : "",
						"confirmation" : "",
					};
					if(account.email == ""){
						window.alert("Email cannot be null");
					}
					else if(account.password == ""){
						window.alert("Password cannot be null");
					}
					else if(account.firstName == ""){
						window.alert("First Name cannot be null")
					}
					else if(account.lastName == ""){
						window.alert("Last Name cannot be null");
					}
					
					doSignUp(account);

				} else {
					window.alert("Password MisMatch!!!");
				}

			});
			
			function doSignUp(account){
				$.ajax({
					type : "POST",
					url : urlDomain
							+ "authentication/signup",
					data : JSON
							.stringify(account),
					success : function(data) {
						$("#signUp_btn").attr("disabled", false);
						if(data.status == 200){
							window.alert("Confirmation Code is Sent to your Email");
							localStorage.setItem("user", JSON.stringify(data.account));
							window.location.href = urlDomain + "index.html";
						}else if(data.status == 405){
							window.alert(data.message);
						}else{
							window.alert("still have bugs");
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