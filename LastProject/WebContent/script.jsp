<script>
function idCheck(){
    if(regForm.id.value === ""){
         alert("아이디를 입력해주세요.");
         regForm.id.focus();
    }else{
         url = "idcheck.jsp?id=" + frmLogin.id.value;
         window.open(url, "","width=300,height=150,left=150,top=150");
    }
}
function inputCheck(){
    if(frmLogin.id.value == ""){
         alert("아이디를 입력해주세요.");
         regForm.id.focus();
         return;
    }
    if(frmLogin.passwd.value !== frmLogin.repasswd.value){
         alert("비밀번호가 다릅니다. 다시입력해주세요!");
         regForm.passwd.focus();
         return;
    }

</script>