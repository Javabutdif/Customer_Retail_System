
public class Product {
	protected String productId = "";
	protected String productName = "";
	protected double productPrice = 0;
	protected int stockQuantity = 0;
	
	Product(){
		
	}
	Product(String prodId, String prodName, double prodPrice, int stockQ){
		this.productId = prodId;
		this.productName = prodName;
		this.productPrice = prodPrice;
		this.stockQuantity = stockQ;
	}
	
	public void updatePrice() {
		
	}
	public void updateStock() {
		
	}
}
