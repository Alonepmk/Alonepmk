function forceLogout(){
	localStorage.removeItem("admin");
	localStorage.removeItem("user");
	window.location.href = urlDomain + "index.html";
	return;
}

function logout(){
	$.post(urlDomain+"session/logout").done(function(){
		localStorage.removeItem("admin");
		localStorage.removeItem("user");
		window.location.href = urlDomain + "index.html";
	}).fail(function(){
		window.alert("Something Wrong at the backend!!!");
	});
}