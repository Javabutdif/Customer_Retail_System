
public class Order {
	protected String orderId = "";
	protected String customerId = "";
	protected double totalAmount = 0;
	protected String[] products;
	protected String date = "09/14/23";
	
	public void calculateTotalAmount(double price, int qty) {
		totalAmount += price* qty;
	}
	public void addProductToOrder(String orderId, String customerId,double totalAmount, String[] products) {
		
	}
	public void confirmOrder() {
		
	}

}
