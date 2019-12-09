package ex01;

import java.sql.Connection; 
import java.sql.Date; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List; 
 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.sql.DataSource; 
 
 
 public class MemberDAO { 
    private Connection con; 
    private PreparedStatement pstmt; 
    private DataSource dataFactory; 
    private ResultSet rs;
 
 
    public MemberDAO() { 
       try { 
          Context ctx = new InitialContext(); 
          Context envContext = (Context) ctx.lookup("java:/comp/env"); 
          dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); 
       } catch (Exception e) { 
          e.printStackTrace(); 
       } 
    } 
 
 
    public List<MemberVO> listMembers() { 
       List<MemberVO> list = new ArrayList<MemberVO>(); 
       try { 
          // connDB(); 
          Connection con = dataFactory.getConnection(); 
          String query = "select * from member"; 
          System.out.println("prepareStatememt: " + query); 
          pstmt = con.prepareStatement(query); 
          rs = pstmt.executeQuery(); 
         while (rs.next()) { 
             String id = rs.getString("id"); 
             String pwd = rs.getString("pwd"); 
             MemberVO vo = new MemberVO(); 
             vo.setId(id); 
             vo.setPwd(pwd); 
             list.add(vo);
          } 
          rs.close(); 
          pstmt.close(); 
          con.close(); 
       } catch (Exception e) { 
          e.printStackTrace(); 
       } 
       return list; 
    } 
 
 
    public void addMember(MemberVO memberVO) { 
       try { 
          Connection con = dataFactory.getConnection(); 
          String id = memberVO.getId(); 
          String pwd = memberVO.getPwd();
          
          String query = "insert into member"; 
          query += " (id,pwd)"; 
          query += " values(?,?)"; 
          System.out.println("prepareStatememt: " + query); 
          pstmt = con.prepareStatement(query); 
          pstmt.setString(1, id); 
          pstmt.setString(2, pwd); 
          pstmt.executeUpdate(); 
          pstmt.close(); 
      } catch (Exception e) { 
          e.printStackTrace(); 
       } 
    } 
    
	public boolean loginCheck(String id, String pwd) {
		boolean b = false;
		try {
			Connection con = dataFactory.getConnection();
			String sql = "select * from member where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			b = rs.next();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return b;
	}
 } 