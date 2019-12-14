//상품처리
function productDetail(p_id){ //productdetail.jsp 참고
		document.detailFrm.p_id.value = p_id;
		document.detailFrm.submit();
	}

function ProductUpdate(p_id) { //productdetail.jsp 참고
	if(confirm("정말 수정하시겠습니까?")){
	document.updateForm.no.value = p_id;
	document.updateForm.submit();
	}
	
}


function ProductDelete(p_id) { // productdetail.jsp 참고
if (confirm("정말 삭제하시겠습니까?")) {
	document.delForm.no.value = p_id;
	document.delForm.submit();
}
}

//카트 처리용
function cartUpdate(form){
	form.flag.value = "update";
	form.submit();
}

function cartDelete(form){
	form.flag.value = "del";
	form.submit();
}

//관리자에서 주문 처리
function orderDetail(p_id){
document.detailFrm.no.value = no; //detailFrm.은 ordermanager.jsp에서 확인 가능
document.detailFrm.submit();
}

function orderUpdate(form){
document.detailFrm.flag.value = "update";
form.submit();
}

function orderDelete(form){
document.detailFrm.flag.value = "delete";
form.submit();
}