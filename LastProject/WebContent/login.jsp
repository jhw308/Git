<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("idKey"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>

<script type="text/javascript">
	window.onload = function(){
		var btn = document.getElementById("btnLogin");
		if(btn){
			btn.addEventListener("click", funcLogin, false);
		}
	}
	
	function funcLogin(){
		if(loginForm.id.value == ""){
	          alert("아이디를 입력해주세요.");
	          loginForm.id.focus();
	     }else{
	    	 if(loginForm.pwd.value == ""){
	          alert("비밀번호를 입력해주세요");
	          loginForm.pwd.focus();
	          
	     	}else{
	     		loginForm.action ="Loginproc.jsp";
	     		loginForm.method="post";
	     		loginForm.submit();
	     	}    
	     }
	}
</script>
</head>
<body>
	<form name="loginForm">
		<table style="width:100%">
			<tr style="text-align:center">
				<td>Id: <input type="text" name="id" value=""> 
				PW: <input type="password" name="pwd" value=""> 
				<input type="button" value="login" id="btnLogin"></td>
		</table>
	</form>
</body>
</html>