<%@page import="ex01.ProductVO" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productDAO" class="ex01.ProductDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록 표시하기</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	<table style="width:100%"> 
		<tr style="font-weight:bold; font-size:80px; background-color:#EAEAEA; height:300px; text-align:left;">
			<td>&nbsp&nbsp상품목록</td>
		</tr>			
	</table>
	<table>
		<tr style=" font-weight:normal; text-align:center;">
			<%
			List<ProductVO> list = productDAO.listMembers();
			
			for(ProductVO p:list){
			%>
				<td style="width: 320px;height: 65px; border-color:white;" >
				<%=p.getp_name() %><br>
				<%=p.getp_description() %><br>
				<%=p.getp_unitprice() %><br>
				<a href="javascript:productDetail('<%=p.getp_id()%>')">상품정보</a>
				</td>
			<%
			}
			%>
		</tr>
	</table>
</body>
</html>