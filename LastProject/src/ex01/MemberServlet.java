package ex01;


import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Date; 
import java.sql.Timestamp; 
import java.util.ArrayList; 
import java.util.List; 
 
 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;   
 
@WebServlet("/member3")
 public class MemberServlet extends HttpServlet { 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
       doHandle(request, response); 
    } 
 
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
       doHandle(request, response); 
    } 
 
 
    private void doHandle(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException { 
       request.setCharacterEncoding("utf-8"); 
       response.setContentType("text/html;charset=utf-8"); 
       MemberDAO dao=new MemberDAO(); 
       PrintWriter out=response.getWriter(); 
       String command=request.getParameter("command");
       
       if(command != null && command.equals("addMember")){ 
        String id=request.getParameter("id"); 
        String pwd=request.getParameter("pwd"); 
        MemberVO vo=new MemberVO(); 
        vo.setId(id); 
        vo.setPwd(pwd); 
        dao.addMember(vo); 
       }
        List list=dao.listMembers(); 
      out.print("<html><body>"); 
      out.print("<table border=1><tr align='center' bgcolor='lightgreen'>"); 
      out.print("<td>아이디</td><td>비밀번호</td></tr>"); 
      
      for (int i=0; i<list.size();i++){ 
        MemberVO memberVO=(MemberVO) list.get(i); 
        String id=memberVO.getId(); 
        String pwd = memberVO.getPwd(); 
        out.print("<tr><td>"+id+"</td><td>" 
                           +pwd+"</td><td></tr>"); 
      } 
      out.print("</table></body></html>"); 
    } 
 } 