package Ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
String userName;
String pwd;
double wallet;
static int loggedUser = -1;
//static String u
	public boolean checkCredential() {
	boolean b = false;
	Register ob = new Register();
	for(int i = 0 ; i < ob.userList.size();++i) {
		if(ob.userList.get(i).name.equals(userName) 
				  && ob.userList.get(i).password.equals(pwd)) {
			loggedUser = i;
			b = true;
		}
	}
	return b;
}
public void chooseModule() {
	Scanner sc = new Scanner(System.in);
	Home home = new Home();
	boolean bool = true;
	do {
		try {			
			System.out.println("enter 1 : Home page");
			System.out.println("enter 2 : view cart");
			System.out.println("enter 3 : wallet ");
			System.out.println("enter 4 : logout");
			int input = sc.nextInt();
			Cart cart = new Cart();
			switch(input) {
			case 1: home.homePage();
			        System.out.println();
			         System.out.println("enter 1 to continue and 0 to go back");
			        int value = sc.nextInt();
			        switch(value) {
			        case 1:cart.addToCart();
			           break;
			        case 0:chooseModule();
			        break;
			        }
//			         bool = false;
//			         chooseModule();
		             break;
			case 2:   cart.showCart();
		              bool = false;
				      chooseModule();
				      break; 
				      
			case 3:Wallet obj = new Wallet();
	           obj.wallet();
	        //  bool = false;
//		   chooseModule();
		   break;
		   
			case 4:Logout user = new Logout();
			       user.logout();
			       bool = false;
//			       chooseModule();
			       break;
		default:System.out.println("invalid input");
		}
		}
		catch(InputMismatchException e) {
			System.out.println("invalid input type");
			chooseModule();
		}
		
	}while(bool);
	
}
public void login() {
	System.out.println("..............Login................");
	System.out.println("Enter username ");
	Scanner sc = new Scanner(System.in);
	userName = sc.next();
	System.out.println("Enter password ");
	pwd = sc.next();
	if(checkCredential()) {
		System.out.println("login sucessful\n");
		chooseModule();
	}
	else {
		System.out.println("wrong username or password");
//		login();
		Register user = new Register();
		Register.userinput(user);
	}
			}
}
