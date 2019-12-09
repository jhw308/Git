package ex01;

import ex01.JDBCModel;
import ex01.Employee;

public class TestMain {
 
    public static void main(String[] args) {
        JDBCModel model = new JDBCModel();
         
        //전체 조회
        model.testJDBC();
         
    }
 
}
