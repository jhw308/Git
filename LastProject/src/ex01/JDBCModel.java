package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import ex01.Employee;

public class JDBCModel {
    // ��� ��ü ��ȸ�� �޼ҵ�
    public void testJDBC() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        // ctrl + shift + O �� ������ import �ؾ��ϴ� �׸��� ����.
         
        // 1. �ش� ������ ���̽��� ���� ���̺귯�� ��� �۾�
        // Class.forName("Ŭ������"); // ClassNotFoundException ó���� �ؾ� ��
        try {
            Class.forName("oracle.jdbc.OracleDriver");
             
            // 2.�����ͺ��̽��� ������  // SQLException ó���� �ؾ��Ѵ�.
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "JSP", "tiger");
             
            System.out.println(conn);
             
            // 3. ������ �ۼ� �� DB���� ������ �����Ű�� ����� ������ ��
            String query = "SELECT * FROM member";
             
            stmt = conn.createStatement();
             
            rset = stmt.executeQuery(query);
             
            while (rset.next()) {
                System.out.println( rset.getString("id") + ", " + rset.getString("pwd") );
                 
            }
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 4. DB�� ���õ� ��ü�� �ݵ�� close �ؾ� ��
                rset.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         
    }
 
}
