package Ecommerce;

public class Product {
int product_id;
String product_Name;
double price;
String color;
String size;
int quantity;
Product(int prod_id,String prod_name , double price , String color , String size,int quantity){
	this.product_id = prod_id;
	this.product_Name = prod_name;
	this.price = price;
	this.color = color;
	this.size = size;
	this.quantity = quantity;
}

}
