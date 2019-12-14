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
		<tr style="font-weight:bold; font-size:80px; background-color:#EAEAEA; height:200px; text-align:left;">
			<td>&nbsp&nbsp상품 정보</td>
		</tr>			
	</table>
<form action="cartproc.jsp">
	<table style="width: 100%">
		<tr style="font-size:25px;"><td style="padding:35px; padding-bottom:0px;"><%=vo.getp_name() %></td></tr>
		<tr><td style="padding-left: 35px; padding-bottom: 15px;">제품 스펙 : <%=vo.getp_description() %></td></tr>
		<tr><td style="padding-left: 35px; padding-bottom: 15px;"><b>상품 코드 : </b><%=vo.getp_id() %></td></tr>
		<tr><td style="padding-left: 35px; padding-bottom: 15px;"><b>제조사 : </b><%=vo.getp_manufacturer() %></td></tr>
		<tr><td style="padding-left: 35px; padding-bottom: 15px;"><b>분류 : </b><%=vo.getp_category() %></td></tr>
		<tr><td style="padding-left: 35px; padding-bottom: 15px;"><b>재고수 : </b><%=vo.getp_unitsinstock() %></td></tr>
		<tr style="font-size:20px;"><td style="padding-left: 35px; padding-bottom: 15px;"><b><%=vo.getp_unitprice() %>원</td></tr>
		
		<tr>
			<td colspan="3" style="text-align:center;">
			<input type="button" value="상품 주문" style="background-color: red;">			
			<input type="submit" value="장바구니"	style="background-color: yellow;">
			<input type="hidden" name="product_no" value="<%=vo.getp_id()%>">
			<input type="button" value="상품 목록" onclick="history.back()">
			</td> 
		</tr>
	</table>
</form>
</body>
</html>