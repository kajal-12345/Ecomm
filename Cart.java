package Ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cart {
//	String name;
//	String password;
//	String email;
//	String ph_number;
//	double wallet;
	public void addToCart() {
		Scanner sc = new Scanner(System.in);
		try {
			//			for(int i = 0 ; i<10 ; i++) {


			boolean reduceQty = true;
			do {
				System.out.println("enter product_id to add product to cart");
				int input = sc.nextInt();
				Product obj = Register.stock.get(input);
				if(obj.product_id == input) {
					System.out.println("enter quantity of slected product");
					int qty = sc.nextInt();

					if(obj.quantity >= qty && qty > 0)  
					{   
						//		int index = 0;
						boolean isAlreadyPresent = false;
						//	Product ob = Register.userList.get(Login.loggedUser).cart.get(index);

						for(Product x : Register.userList.get(Login.loggedUser).cart) {

							if(x.product_id == obj.product_id) {
//				                   Register.userList.get(Login.loggedUser).cart.get(index).quantity++;
//								Register.userList.get(Login.loggedUser).cart.get(index).price+=	Register.userList.get(Login.loggedUser).cart.get(index).price;							
								x.price *= qty;
								x.quantity +=qty;
								isAlreadyPresent = true;
							}

							//index++;
						}
						if(!isAlreadyPresent) {
							Register.userList.get(Login.loggedUser).cart.add(new Product(obj.product_id,obj.product_Name,obj.price*qty,obj.color,obj.size,qty));
							
						}

						Register.stock.get(input).quantity-=qty;
						System.out.println("added to cart");
						reduceQty = false;
					}
					else if(obj.quantity > 0 && obj.quantity < qty){
						System.out.println("reduce quantity");
						reduceQty = true;
					}
					else {
						System.out.println("something went wrong!!");
						reduceQty = true;
					}

				}
				else {
					System.out.println("invalid product id");
					reduceQty = true;
				}
				//						
			}while(reduceQty);

		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("invalid input");
			addToCart();
		}
		catch(InputMismatchException e) {
			System.out.println("invalid input!!");
					addToCart();
		}

	}
	public void showCart() {
		System.out.println("products added to cart\n");
		System.out.println("p_id  "+"  p_name "+" color "
				+"  price  "+" size  "+"  qty"); 

		//	System.out.println(Login.loggedUser);
		for(Product x : Register.userList.get(Login.loggedUser).cart) {
			//	System.out.println(x.product_Name);
			System.out.print(x.product_id+"  "+"     "+x.product_Name +"    "+x.color
					+"   "+x.price+"     "+x.size+"  "+x.quantity);
			System.out.println();

		}
		if(Register.userList.get(Login.loggedUser).cart.size()>0) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("enter 1 if you want to buy the product and 0 to go back");
				int buy = sc.nextInt();
				switch(buy) {
				case 1:
					double total = 0;
					for(Product product:Register.userList.get(Login.loggedUser).cart) {
						total += product.price;
					}

					if(Register.userList.get(Login.loggedUser).wallet >=total) {
						Register.userList.get(Login.loggedUser).wallet -=total;

						System.out.println("payment sucessful!");
						Register.userList.get(Login.loggedUser).cart.clear();

					}
					else {
						System.out.println("insufficient balance");
						System.out.println();
						System.out.println("please add money in the wallet");
						System.out.println();
						Wallet ob = new Wallet();
						ob.wallet();
					}

					break;
				case 0:Login ob = new Login();
				ob.chooseModule();
				break;
				default:System.out.println("invalid input!");
				}
			}catch(InputMismatchException e) {
				System.out.println("invalid input type!");
				Login ob = new Login();
				ob.chooseModule();
			}
		}
		else {
			System.out.println("cart is empty!");
			System.out.println();
		}
	}
}
