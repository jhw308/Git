<%@page import="ex01.ProductVO"%>
<%@page import="ex01.OrderBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="cartMgr" class="ex01.CartMgr"  scope="session" />
<jsp:useBean id="productDAO" class="ex01.ProductDAO" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 정보</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	<table style="width:100%"> 
		<tr style="font-weight:bold; font-size:80px; background-color:#EAEAEA; height:200px; text-align:left;">
			<td>&nbsp&nbsp장바구니</td>
		</tr>			
	</table>
	
	<table>
		<tr>
			<th>상품</th><th>가격</th><th>수량</th><th>소계</th><th>비고</th>
		</tr>
		<%
	
	int totalPrice = 0;		//총계 구하기위해
	Hashtable hcart = cartMgr.getCartList();
	if(hcart.size() == 0){
%>
	<tr><td colspan="5">주문 건수가 없습니다.</td></tr>
<%
	}else{
		Enumeration enu = hcart.keys();
		while(enu.hasMoreElements()){
			OrderBean orderBean = (OrderBean)hcart.get(enu.nextElement());
			ProductVO vo = productDAO.getProduct(orderBean.getp_id());
	
			int price = Integer.parseInt(vo.getp_unitprice());
			int quantity = Integer.parseInt(orderBean.getp_unitsinstock());
			int subTotal = price * quantity;		//소계
			
			totalPrice += subTotal;		//총계
			
%>

<tr>
	<td><%=vo.getp_name() %></td>
	<td><%=subTotal %></td>
	<form action="cartproc.jsp" method="get">
			<input type="hidden" name="flag">
			<input type="hidden" name="product_no" value="<%=vo.getp_id() %>">
	<td><input type="text" name="quantity" value="<%=quantity %>" size="5" style="text-align: center;"></td>
	<td>
		<input style="background-color: silver;" type="button" value="수정" onclick="cartUpdate(this.form)">	
		<input style="background-color: silver;" type="button" value="삭제" onclick="cartDelete(this.form)">	
	</td>
	</form>
	<td><a href="javascript:productDetail_guest('<%=vo.getp_id()%>')">상세보기</a></td>
</tr>


<% 
		}
		
		%>
		<tr>
		<td colspan="5">
			<br>
			<b>총 결제 금액 : <%=totalPrice %></b>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="orderproc.jsp">[ 주문하기 ]</a>
		</td>
	</tr>
	<%	
	}
	%>
</table>

<form action="productdetail_guest.jsp" name="detailFrm" >
	<input type="hidden" name="no">
</body>
</html>