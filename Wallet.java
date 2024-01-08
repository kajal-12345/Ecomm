package Ecommerce;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Wallet {
//	private double wallet;
//	String name;
//	String password;
//	String email;
//	String ph_number;
//	 double wallet;

	 public void setWallet() {
		 Scanner sc = new Scanner(System.in);
		 try {
			 System.out.println("add amount to wallet: ");
			 double money = sc.nextDouble();
			 if(money > 0) {
				 Register.userList.get(Login.loggedUser).wallet+=money;
			 } 
		 }catch(InputMismatchException e) {
			 System.out.println("invalid input type, please enter appropriate amount");
			 setWallet();
		 }
		 
//		 Register.userList.get(1).wallet+=money;

	 }
	 public void getWallet() {
		 System.out.println(Register.userList.get(Login.loggedUser).wallet);		 	
	 }
	 public void wallet() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter 1 to add amount");
			System.out.println("enter 2 to view wallet");
			try {
				int value1 = sc.nextInt();
			       if(value1 == 1) {
			    	   setWallet();
			       }
			       else if(value1 == 2) {
			    	   getWallet();
			    	   
			       }
			       else {
			    	   System.out.println("invalid input");
			    	   wallet();
			       }
			}catch(InputMismatchException e) {
				System.out.println("invalid input type, please enter again");
				wallet();
			}
			       
			
	 }
	
}
