package RentCar.entity;

import java.util.Scanner;

public class Customer {
	protected int id;
	protected String email;
	protected String fullname;
	protected int phone;
	protected String address;
	protected Customer() {}
	public Customer(int id, String email, String fullname, int phone, String address) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
	}
	
	public Customer(int id, String email, String fullname, int phone) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.address = null;
	}
	
	public Customer(int id, String fullname, int phone) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phone = phone;
		this.address = null;
	}
	
	public Customer(int id, String fullname) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = null;
	}
	
	public void displayInfo() {
		System.out.println("Email: " + this.email);
		System.out.println("Fullname: " + this.fullname);
		System.out.println("Phone: " + this.phone);
		System.out.println("Address: " + this.address);
	}
	
	public void create() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Input customer id: ");
			int id_cus = scanner.nextInt();
			
			System.out.println("Input customer email: ");
			String email_cus = scanner.next();
			
			System.out.println("Input customer fullname: ");
			String fullname_cus = scanner.next();
			
			System.out.println("Input customer phone: ");
			int phone_cus = scanner.nextInt();
			
			System.out.println("Input customer address: ");
			String address_cus = scanner.next();
			
			this.id = id_cus;
			this.email = email_cus;
			this.fullname = fullname_cus;
			if (address_cus != null)
				this.address = address_cus;
		}
	}
	
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
