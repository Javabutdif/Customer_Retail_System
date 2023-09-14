
public class Customer extends User {
	
	protected String customerId = "";
	protected String address = "";
	
	Customer(){
		
	}
	Customer(String username,String email, String address,String id){
		this.email = email;
		this.userName = username;
		this.address = address;
		this.customerId = id;
	}
	
	public void placeOrder() {
		
	}
	public void viewOrderHistory() {
		
	}
	public boolean verified(String username) {
		return this.userName.compareTo(username) == 0 ? true : false;
	}
	public void output() {
		System.out.println("Customer ID: " + this.customerId+"\nAddress: " + this.address);
	}
}
