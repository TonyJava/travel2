package cn.itcast.domain;

public class OrderItem {

	private String id;
	private Product product;	//��ס�������������ı���
	private int quantity;	//��ס�������е�������˼���
	private double price;	//��¼����ܼ�
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
