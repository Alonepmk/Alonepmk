<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table {
	border-collapse: collapse;
	table-layout: fixed;
	width: 2350px
}

table td .left {
	width: 2150px;
	border: word-wrap:break-word;
}
table td .right{
	align : left;
}
#txt_area{
	width: 80%;
	height : 100px;
}
.comment {
	position: absolute;
	bottom : 80px;
	width: 100%;
	margin-bottom: 10;
}
.div_show_comment{
	overflow-y: scroll;
	overflow-x : hidden;
	height : 500px;
}
</style>
</head>
<body>
	<h1>Real Time Comment</h1>
	<div class="container-fluid div_show_comment">
		<table class="mt-4" id="show_data">
			<tr>
				<th>Comments</th>
				<th>User</th>
			</tr>
		</table>
	</div>
	<br>
	<div class="container-fluid comment">
		<input style="display : none;" type="text" id="last_num"/>
		<textarea id="txt_area"></textarea>
		<br>
		<button class="btn-primary" id="btn_submit">Comment</button>
	</div>
	<script>
		$(document).ready(
				function() {
					 scrollTable();
					var dataSource;
					$.ajax({
						url : urlDomain + "comment/getAllComment",
						type : 'GET',
						dataType : 'json',
						async : false,
						success : function(data) {
							dataSource = data;
						}
					});
					var table = $('#show_data');
					appendDataToTable(dataSource,table);
					$("#last_num").val(dataSource[dataSource.length-1].id);
					
				 	function updateCommentBox() {
					    $.ajax({
					            type: 'GET',
					            url:  urlDomain + "comment/getLatestData/"+$("#last_num").val(),
					            dataType: 'json',
					            success: function (data) {
					            	if(data.length > 0 ){
					            		console.log(data);
					            	  $("#last_num").val(data[data.length-1].id);
					                  appendDataToTable(data,table);
					                  scrollTable();
					            	}
					            },
					            complete: function (data) {
					                    setTimeout(updateCommentBox, 2000);
					            }
					    });
					}
					setTimeout(updateCommentBox, 2000); 
					

				});
		function appendDataToTable(source,table){
			$.each(source, function() {
				table.append($('<tr></tr>').append(
						$('<td class="left"></td>').text(this.comment),
						$('<td class="right"></td>').text(
								this.firstName)));
			});
		}
		
		function scrollTable(){
			$('.div_show_comment').animate({
		        scrollTop: $('.div_show_comment')[0].scrollHeight}, 2000);//this one is for scrolling the div to bottom
		 
		}
		
		$("#btn_submit").click(function() {
			var txt_data = $.trim($("#txt_area").val());
			if(txt_data === ""){
				window.alert("Hey are you trying to submit an empty string");	
			}else{
			postAComment(txt_data);
			}
		});
		
		function postAComment(data){
			$.ajax({
				url : urlDomain + "comment/postAComment/"+JSON.parse(localStorage.user).email+"/"+data,
				type : 'POST',
				dataType : 'json',
				async : false,
				complete: function (data) {
					$("#txt_area").val("");
	            }
			});
		}
		
		
		
	</script>
</body>
</html>