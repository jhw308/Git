package ex01;

import java.util.Hashtable;

public class CartMgr {

	private Hashtable hCart = new Hashtable<>();
	
	public void addCart(OrderBean obean) {
		String p_id = obean.getp_id();
		int p_unitsinstock = Integer.parseInt(obean.getp_unitsinstock());
		
		if(p_unitsinstock > 0) {
		//���� ��ǰ�� ���� �ֹ��� ���� �ֹ������� �����ؼ� īƮ�� ���
		 if(hCart.containsKey(p_id)) {
			 OrderBean imsi = (OrderBean)hCart.get(p_id);
			 p_unitsinstock += Integer.parseInt(imsi.getp_unitsinstock());
			 imsi.setp_unitsinstock(Integer.toString(p_unitsinstock));
			 hCart.put(p_id, imsi);
			 System.out.println("��ǰ��ȣ : " + p_id + ", �ֹ�����:" + p_unitsinstock);
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