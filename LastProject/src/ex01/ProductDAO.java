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
 
 
 public class ProductDAO { 
    private Connection con; 
    private PreparedStatement pstmt; 
    private DataSource dataFactory; 
    private ResultSet rs;
 
 
    public ProductDAO() { 
       try { 
          Context ctx = new InitialContext(); 
          Context envContext = (Context) ctx.lookup("java:/comp/env"); 
          dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); 
       } catch (Exception e) { 
          e.printStackTrace(); 
       } 
    } 
 
 
    public List<ProductVO> listMembers() { 
       List<ProductVO> list = new ArrayList<ProductVO>(); 
       try { 
          // connDB(); 
          Connection con = dataFactory.getConnection(); 
          String query = "select * from product"; 
          System.out.println("prepareStatememt: " + query); 
          pstmt = con.prepareStatement(query); 
          rs = pstmt.executeQuery(); 
         while (rs.next()) { 
        	 ProductVO vo = new ProductVO(); 
             String p_id = rs.getString("p_id"); 
             String p_name = rs.getString("p_name");
             int p_unitprice = rs.getInt("p_unitprice");
             String p_description = rs.getString("p_description");
             String p_category = rs.getString("p_category");
             String p_manufacturer = rs.getString("p_manufacturer");
             String p_unitsinstock = rs.getString("p_unitsinstock");
             String p_condition = rs.getString("p_condition");
             String p_filename = rs.getString("p_filename");
             
             vo.setp_id(p_id); 
             vo.setp_name(p_name);
             vo.setp_unitprice(p_unitprice);
             vo.setp_description(p_description);
             vo.setp_category(p_category);
             vo.setp_manufacturer(p_manufacturer);
             vo.setp_unitsinstock(p_unitsinstock);
             vo.setp_condition(p_condition);
             vo.setp_filename(p_filename);
             list.add(vo);
          }  
       } catch (Exception e) { 
          e.printStackTrace(); 
       }finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
       }
       return list; 
    } 
 
    public ProductVO getProduct(String p_id) {
    	ProductVO vo = new ProductVO();
    	try {
    		con = dataFactory.getConnection();
    		String sql = "select * from product where p_id=?";
    		pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, p_id);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			vo = new ProductVO();
    			vo.setp_id(rs.getString("p_id"));
    			vo.setp_name(rs.getString("p_name"));
    			vo.setp_unitprice(rs.getInt("p_unitprice"));
    			vo.setp_description(rs.getString("p_description"));
    			vo.setp_category(rs.getString("p_category"));
    			vo.setp_manufacturer(rs.getString("p_manufacturer"));
    			vo.setp_unitsinstock(rs.getString("p_unitsinstock"));
    			vo.setp_condition(rs.getString("p_condition"));
    			vo.setp_filename(rs.getString("p_filename"));
    		}
    	} catch (Exception e) {
			System.out.println("getProduct err:" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return vo;
    }
    
 
    public void addProduct(ProductVO productVO) { 
       try { 
          Connection con = dataFactory.getConnection(); 
          String p_id = productVO.getp_id(); 
          String p_name = productVO.getp_name();
          int p_unitprice = productVO.getp_unitprice();
          String p_description = productVO.getp_description();
          String p_category = productVO.getp_category();
          String p_manufacturer = productVO.getp_manufacturer();
          String p_unitsinstock = productVO.getp_unitsinstock();
          String p_condition = productVO.getp_condition();
          String p_filename = productVO.getp_filename();
          
          String query = "insert into product"; 
          query += " (p_id,p_name,p_unitprice,p_description,p_category,p_manufacturer,p_unitsinstock,p_condition,p_filename)"; 
          query += " values(?,?,?,?,?,?,?,?,?)"; 
          System.out.println("prepareStatememt: " + query); 
          pstmt = con.prepareStatement(query); 
          pstmt.setString(1, p_id); 
          pstmt.setString(2, p_name);
          pstmt.setInt(3, p_unitprice);
          pstmt.setString(4, p_description);
          pstmt.setString(5, p_category);
          pstmt.setString(6, p_manufacturer);
          pstmt.setString(7, p_unitsinstock);
          pstmt.setString(8, p_condition);
          pstmt.setString(9, p_filename);
          pstmt.executeUpdate(); 
          pstmt.close(); 
      } catch (Exception e) { 
          e.printStackTrace(); 
       } 
    } 
    

 } 