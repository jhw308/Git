package ex01;

public class ProductBean { // 상품 주문 관련 
	private String p_id; 
	private String p_name;
	private int p_unitprice;
	private String p_description;
	private String p_category;
	private String p_manufacturer;
	private String p_unitsinstock;
	private String p_condition;
	private String p_filename;
	   
	 
	     
	    public ProductBean() { 
	       System.out.println("ProductBean 생성자 호출"); 
	    } 

	    public String getp_id() { return p_id; } 
	    public void setp_id(String p_id) { this.p_id = p_id; } 
	 
	    public String getp_name() { return p_name; } 
	    public void setp_name(String p_name) { this.p_name = p_name; } 
	 
	    public int getp_unitprice() { return p_unitprice; } 
	    public void setp_unitprice(int p_unitprice) { this.p_unitprice = p_unitprice; }

	    public String getp_description() { return p_description; } 
	    public void setp_description(String p_description) { this.p_description = p_description; }
	    
	    public String getp_category() { return p_category; } 
	    public void setp_category(String p_category) { this.p_category = p_category; }
	    
	    public String getp_manufacturer() { return p_manufacturer; } 
	    public void setp_manufacturer(String p_manufacturer) { this.p_manufacturer = p_manufacturer; }
	    
	    public String getp_unitsinstock() { return p_unitsinstock; } 
	    public void setp_unitsinstock(String p_unitsinstock) { this.p_unitsinstock = p_unitsinstock; }
	    
	    public String getp_condition() { return p_condition; } 
	    public void setp_condition(String p_condition) { this.p_condition = p_condition; }
	    
	    public String getp_filename() { return p_filename; } 
	    public void setp_filename(String p_filename) { this.p_filename = p_filename; }
}