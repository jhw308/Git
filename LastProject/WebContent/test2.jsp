<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
<script type="text/javascript">
	function funcLogin(){
		if(loginFrom.id.value == ""){
	          alert("아이디를 입력해주세요.");
	          loginForm.id.focus();
	     }else{
	    	 if(loginForm.pwd.value == ""){
	          alert("비밀번호를 입력해주세요");
	          loginForm.pwd.focus();
	          
	     	}else{
	          loginForm.action ="loginproc.jsp";
	          loginForm.method="post";
	          loginForm.submit();
	     	}    
	     }
	}
</script>
</head>
<body>
	<form name="loginFrom">
		<table style="width:100%">
			<tr style="text-align:center">
				<td>Id: <input type="text" name="id" value=""> 
				PW: <input type="password" name="pwd" value=""> 
				<input type="button" value="login" onclick="funcLogin();"></td>
		</table>
	</form>
</body>
</html>