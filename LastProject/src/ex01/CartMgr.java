package ex01;

import java.util.Hashtable;

public class CartMgr {

	private Hashtable hCart = new Hashtable<>();
	
	public void addCart(OrderBean obean) {
		String p_id = obean.getp_id();
		int p_unitsinstock = Integer.parseInt(obean.getp_unitsinstock());
		
		if(p_unitsinstock > 0) {
		//동일 상품에 대한 주문인 경우는 주문수량만 수정해서 카트에 담기
		 if(hCart.containsKey(p_id)) {
			 OrderBean imsi = (OrderBean)hCart.get(p_id);
			 p_unitsinstock += Integer.parseInt(imsi.getp_unitsinstock());
			 imsi.setp_unitsinstock(Integer.toString(p_unitsinstock));
			 hCart.put(p_id, imsi);
			 System.out.println("상품번호 : " + p_id + ", 주문수량:" + p_unitsinstock);
		 }else {
			 hCart.put(p_id, obean);
		 }
		}
	}
	
	public Hashtable getCartList() {
		return hCart;
	}
	
	public void updateCart(OrderBean obean) {
		String p_id = obean.getp_id();
		hCart.put(p_id, obean);
	}
	
	public void deleteCart(OrderBean obean) {
		String p_id = obean.getp_id();
		hCart.remove(p_id);
	}
	
}