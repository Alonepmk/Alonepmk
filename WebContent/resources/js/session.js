//Codes below are related to authenticate a session 

function checkSession(session){
	console.log(session);
	var storage = JSON.parse(localStorage.getItem("user")||localStorage.getItem("admin"));
	
	if(session == null){
		if(storage != null){
			if(storage.role == "adm"){
				window.alert("Access was Denied!!!");
				window.location.href = urlDomain + "admin/adminHome.html";
			}else{
				window.alert("Access was Denied!!!");
				window.location.href = urlDomain + "user/userHome.html";
			}
			
		}else{
			forceLogout();
		}
	}
	$.active = false;
	$('body').bind('click keypress', function() {
		$.active = true;
	});

	checkActivity(600000, 5000, 0);
}

function checkActivity(timeout, interval, elapsed) {
	
	if ($.active) {
		elapsed = 0;
		$.active = false;
		$.post(urlDomain + "session/active").done(function(data){
			if(data.status == 200){
				console.log("session still active");
			}else{
				console.log("session Time out");
				window.alert("session Time out");
				forceLogout();
			}
			
		}).fail(function(){
			window.alert("Session Time out!!!");
			forceLogout();
		});
	}
	if (elapsed < timeout) {
		elapsed += interval;
		setTimeout(function() {
			console.log("i'm doing");
			elapsed += interval;
			checkActivity(timeout, interval, elapsed);
		}, interval);
	} else {
		forceLogout();
	}
}