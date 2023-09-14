import java.text.DecimalFormat;
import java.util.*;

public class Main {
	static Scanner console = new Scanner(System.in);
	static Customer[] data = new Customer[1];
	static List<Product> goods = new LinkedList<Product>();
	static Random rand = new Random();
	static char[] letters = "abcdefghijklmnopqrstuvwxyz123456789".toCharArray();
	static Order orderConfirm = new Order();

	public static void main(String[] args) {
		randomGoods();
		String tempOrder = "";
		double qty = 0;
		//Start program
		while(true) {
			
			try {
				//Initiating Products
			
				//Start
				
				System.out.print("\nWelcome to Online Retail!\n[1]Login | [2]Registration | [3]Admin | [4]Exit\nInput: ");
				int num = console.nextInt();
				
				if(num == 1) {
					System.out.print("Enter username: ");
					String username = console.next();
					
					//Accessing the stored object in the array
					if(data[0].verified(username)) {
						data[0].output();
						System.out.println("\n");
						System.out.print( "Product Name "+"\t"+ "Product Price"+ "\t"+"Product ID\t"+"Stocks/Quantity"+"\n");
						for(Product x : goods) {
							
							System.out.print( x.productName+"\t\t"+ x.productPrice+ "\t\t"+x.productId+"\t\t"+x.stockQuantity+"\n");
						
						}
						
						while(true) {
							try {
								System.out.print("[1]Add Product | [2]Confirm Order\nInput: ");
								int choice = console.nextInt();
							
								if(choice==1) {
								
									int counter = 0;
									System.out.print("Choose Product: ");
									String prod = console.next();
									
									
									for(Product info : goods) {
										
										if(info.productName.equalsIgnoreCase(prod)) {
											System.out.print("Qty: ");
											int  quantity = console.nextInt();
											
											//Order
											tempOrder += info.productName +"\t" + info.productId + "\t"+ "P " +(info.productPrice*quantity)+ ",";
											 qty += ( info.productPrice * quantity);
											
											info.stockQuantity -= quantity;
											prod = "";
											
											break;
											
										}
										else {
											counter++;
										}
										
										
								}
									if(counter==goods.size())
										System.out.println("Product Name doesn't exist!");
									
									counter = 0;
							
								
							}
							else if(choice == 2) {
								
								Main main = new Main();
								
								String[] orderArray = tempOrder.split(",");
								for(String x : orderArray)
									System.out.println(x);
								
								System.out.println("Total: " + qty);
								
								orderConfirm.addProductToOrder(main.orderId(), data[0].customerId, qty, orderArray);
								
								break;
							}
							else
								System.out.println("Invalid Input!");
							}catch(Exception e) {
								System.out.println("Invalid Input!");
								console.next();
							}
							
							System.out.println("\n");
							System.out.print( "Product Name "+"\t"+ "Product Price"+ "\t"+"Product ID\t"+"Stocks/Quantity"+"\n");
							for(Product x : goods) {
								
								System.out.print( x.productName+"\t\t"+ x.productPrice+ "\t\t"+x.productId+"\t\t"+x.stockQuantity+"\n");
							
							}
						}
						
						
					}else
						System.out.println("Invalid username");
						
					
						
				}
				else if(num == 2) {
					registration();
				}
				else if(num == 3) {
					
				}
				else if(num ==4) {
					break;
				}
			}catch(Exception e) {
				System.out.println("Error! Invalid input!");
				console.nextLine();
			}
			
		}

	}
	
	protected static void registration() {
	
		Main main = new Main();
		
		
	
			System.out.print("Registration!\nEnter Username: ");
			String username = console.next();
			System.out.print("Enter email: ");
			String email = console.next();
			System.out.print("Enter address: ");
			String address = console.next(); 
			
			
	
			Customer cus = new Customer(username,email,address,main.identification());
			//Stored in an array of objects
			data[0] = cus;
			
	
		
	
	}
	//Customer Identification
	protected String identification() {
		Random rand = new Random();
		String id = "cus-";
		char[] letters = "abcdefghijklmnopqrstuvwxyz123456789".toCharArray();
		
		for(int i = 0; i < 8; i++)
			id+= letters[rand.nextInt(letters.length-1)];
		
		return id;
		
	}
	
	//Product Object
	
	protected static void randomGoods() {
		Main main = new Main();
		
		String[] prodName = {"Can","Water","Meat","Banana","Apple","Spices","Egg"};
		
		
		
		for(int i = 0; i < prodName.length;i++) {
			DecimalFormat df = new DecimalFormat("#.##");
			double prodPrice = rand.nextDouble(100);
			int stock = rand.nextInt(100);
			
			
			
			Product product = new Product(main.prodId(),prodName[i],Double.parseDouble(df.format(prodPrice)),stock );
			goods.add(product);
		}
	}
	protected String prodId() {
		String id = "prod-";
		
		for(int i =0; i < 8; i++)
			id+= letters[rand.nextInt(letters.length)];
		
		return id;
		
	}
	protected String orderId() {
		String id = "order-";
		
		for(int i =0; i < 8; i++)
			id+= letters[rand.nextInt(letters.length)];
		
		return id;
		
	}

}
