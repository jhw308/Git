<%@page import="ex01.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberDAO" class="ex01.MemberDAO"/>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	boolean b = memberDAO.loginCheck(id, pwd);
	
	if(b){
		session.setAttribute("idKey", id);
		response.sendRedirect("loginsuc.jsp");
	}else{
		response.sendRedirect("loginfail.jsp");
	}
%>