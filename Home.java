package Ecommerce;

public class Home {
	public void homePage() {
	System.out.println("Home page");
	System.out.println();
	System.out.println("p_id  "+"  p_name "+" color "
            +"  price  "+" size  "+"  quantity "); 
	   	for(Product x:Register.stock) {
	   		
		System.out.print(x.product_id+"  "+"     "+x.product_Name +"    "+x.color
                +"   "+x.price+"     "+x.size+"     "+x.quantity);
		System.out.println();

	}
	
	
}
}
