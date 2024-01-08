package Ecommerce;

import java.util.ArrayList;

public class User  {
String name;
String password;
String email;
String ph_number;
 double wallet;
   ArrayList<Product> cart = new ArrayList<Product>();
User(String name,String password,String email,String ph_number,double wallet,ArrayList<Product> cart){
	this.name = name;
	this.password = password;
	this.ph_number =  ph_number;
	this.email = email;
	this.wallet = wallet;
	this.cart = cart;
}

}
