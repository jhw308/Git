package ex01;

import java.sql.Date; 
 
public class MemberVO { 
   private String id; 
   private String pwd; 
 
     
    public MemberVO() { 
       System.out.println("MemberVO 생성자 호출"); 
    } 

    public String getId() { return id; } 
    public void setId(String id) { this.id = id; } 
 
    public String getPwd() { return pwd; } 
    public void setPwd(String pwd) { this.pwd = pwd; } 
 } 