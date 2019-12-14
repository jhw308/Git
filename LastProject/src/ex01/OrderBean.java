package ex01;

public class OrderBean { // 상품 주문 관련 
	   private String p_id; 
	   private String p_name;
	   private int p_unitprice;
	   private String p_unitsinstock;
	   private String p_filename;
	   
	public OrderBean() { 
	       System.out.println("OrderBean 생성자 호출"); 
	    } 

	    public String getp_id() { return p_id; } 
	    public void setp_id(String p_id) { this.p_id = p_id; } 
	 
	    public String getp_name() { return p_name; } 
	    public void setp_name(String p_name) { this.p_name = p_name; } 
	 
	    public int getp_unitprice() { return p_unitprice; } 
	    public void setp_unitprice(int p_unitprice) { this.p_unitprice = p_unitprice; }
	    
	    public String getp_unitsinstock() { return p_unitsinstock; } 
	    public void setp_unitsinstock(String p_unitsinstock) { this.p_unitsinstock = p_unitsinstock; }
	    
	    public String getp_filename() { return p_filename; } 
	    public void setp_filename(String p_filename) { this.p_filename = p_filename; }
}
