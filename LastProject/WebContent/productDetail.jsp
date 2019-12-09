<%@page import="ex01.ProductVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productDAO" class="ex01.ProductDAO" />

<%
	String p_id = request.getParameter("p_id");
	ProductVO vo = productDAO.getProduct(p_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	<table style="width:100%"> 
		<tr style="font-weight:bold; font-size:80px; background-color:#EAEAEA; height:300px; text-align:left;">
			<td>&nbsp&nbsp상품 정보</td>
		</tr>			
	</table>
	<table style="width: 100%">
		<tr><td><%=vo.getp_name() %></td></tr>
		<tr><td><%=vo.getp_id() %></td></tr>
		<tr><td><%=vo.getp_manufacturer() %></td></tr>
		<tr><td><%=vo.getp_category() %></td></tr>
		<tr><td><%=vo.getp_unitsinstock() %></td></tr>
		<tr><td><%=vo.getp_unitprice() %></td></tr>
	</table>
</body>
</html>