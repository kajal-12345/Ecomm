package Ecommerce;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Register {
	protected	String userName;
	protected String password;
	private   String email_id; 
	private String phone_number;
	double wallet;
	
	   static ArrayList<User> userList = new ArrayList<User>();
	 static ArrayList<Product> stock = new ArrayList<Product>();

	public void setuserName() {
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		this.userName = username;
	}
	
	public   boolean isValidPassword() {
		String password = this.password;
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(password);
		boolean matchfound = matcher.find();
		return matchfound;
	}
	
	public  boolean isValidEmail() {
		String Email = this.email_id;
		String regex ="^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
//				"^[A-Z0-9._%+-]+@[A-Z.-]+\\.[A-Z]{2,6}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(Email);
		boolean matchfound = matcher.find();
		return matchfound;
	}
	
	public static boolean isValidPh(String phone_number) {
		String regex = "\\d{10}";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(phone_number);
		boolean matchfound = matcher.find();
		return matchfound;
	}
	public void setPassword() {	
		 Scanner sc = new Scanner(System.in);
		 String password = sc.next();
		this.password = password;		
	}
	public static void setCredential(Register obj) {
		System.out.println("Enter UserName");
		obj.setuserName();
//		set password
		boolean b = true;
		do {
			System.out.println("Enter Password");
			obj.setPassword();
			if(obj.isValidPassword()) {
				b = false;
			}
			else {
				System.out.println("weak password!,Enter again");
			}
		}while(b);
		
//	set	email
		boolean b1 = true;
		Scanner sc = new Scanner(System.in);
      do {
			System.out.println("Enter email-id ");
			obj.email_id = sc.next();
			if(obj.isValidEmail()) {
				b1 = false;
			}
			else {
				System.out.println("invalid email format!!,enter again");
			}
		}while(b1);
//        set phone number
      boolean b2 = true;
		do {
			System.out.println("Enter phone number ");
			obj.phone_number = sc.next();
			if(isValidPh(obj.phone_number) && obj.phone_number.length()==10) {
				b2 = false;
			}
			else {
				System.out.println("invalid phone number");
			}
		}while(b2);
	}
	public static void userinput(Register ob) {
		Scanner sc = new Scanner(System.in);
		boolean bool = true;
		do {
			try {
				System.out.println("Enter 1 if you want to register and Enter 2 for login");
				int val = sc.nextInt();
				switch(val) {
				case 1:  setCredential(ob);
					        ob.addUser();
					        Login obj = new Login();
					        obj.chooseModule();
				            bool = false;
				      break;
				case 2:	Login user = new Login();
					   user.login();
					   bool = false;
					   break;
				default:System.out.println("invalid input!!");
				         userinput(ob);
				}
			}
			catch(InputMismatchException e){
				System.out.println("invalid input type ,please enter again");
		        userinput(ob);
			}
			
		}while(bool);

	}   
	public static void createUser() {
//		Register ob = new Register();
		userList.add(new User("kajal","Kajal@123","kajal@gmail.com","9823456773",0,new ArrayList<Product>()));
		userList.add(new User("sejal","Sejal@123","sejal@gmail.com","9823456773",0,new ArrayList<Product>()));

			Register ob1 = new Register();
			Register.userinput(ob1);
					
	}
        public  void addUser() {
        	User user = new User(userName,password,email_id,phone_number,wallet,new ArrayList<Product>());
            userList.add(++Login.loggedUser, user);;
//            Login.loggedUser++;
//            System.out.println(Login.loggedUser);
            System.out.println("account created successfully");
        }
//	    public static void getCredential() {   	
//	    	 for(User x : userList) {
//					System.out.println(x.name);
//					System.out.println(x.password);
//					System.out.println(x.email);
//					System.out.println(x.ph_number);
//				}
//    }
	    public static void main(String[] args) {
	    	
			
			     Product p1 = new Product(0,"kurti",500,"red  ","M ",12);
				 stock.add(p1);			
				 Product p2 = new Product(1,"shirt",400,"black","s ",10);
				 stock.add(p2);
				 Product p3 = new Product(2,"pant ",600,"grey ","26",5);
				 stock.add(p3);
				 Product p4 = new Product(3,"shirt",400,"black","s ",8);
				 stock.add(p4);
				 
				 createUser();
//				  getCredential();

	    
	    }
	
}
