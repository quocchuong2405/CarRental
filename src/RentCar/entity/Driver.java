package RentCar.entity;

import java.util.Date;
import java.util.Scanner;

public class Driver extends Customer {
	private String gender;
	private Date dayOfBirth;
	private int license;
	private String postal_address;
	
	public Driver() {}
	public Driver(int id, String email, String fullname, String gender, int phone, String address, Date dayOfBirth, int license, String postal_address) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.license = license;
		this.postal_address = postal_address;
	}
	
	public Driver(int id, String fullname, String gender, Date dayOfBirth, int license) {
		super();
		this.fullname = fullname;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.license = license;
	}
	
	public Driver(int id, String fullname, String gender, int license) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.license = license;
	}
	
	public Driver(int id, String fullname, int license) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.license = license;
	}
	
	public void displayInfo() {
		System.out.println("Email: " + this.email);
		System.out.println("Fullname: " + this.fullname);
		System.out.println("Gender: " + this.gender);
		System.out.println("Day of birth: " + this.dayOfBirth);
		System.out.println("License: " + this.license);
		System.out.println("Phone: " + this.phone);
		System.out.println("Address: " + this.address);
		System.out.println("Postal_address: " + this.postal_address);
	}
	
	public void create() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Input driver id: ");
			int id_cus = scanner.nextInt();
			
			System.out.println("Input driver email: ");
			String email_cus = scanner.next();
			
			System.out.println("Input driver fullname: ");
			String fullname_cus = scanner.next();
			
			System.out.println("Input driver phone: ");
			int phone_cus = scanner.nextInt();
			
			System.out.println("Input driver address: ");
			String address_cus = scanner.next();
			
			System.out.println("Input driver gender: ");
			String gender_dri = scanner.next();
			
			//System.out.println("Input driver DayOfBirth: ");
			//Date dayOfBirth_dri
			
			System.out.println("Input driver license: ");
			int lisence_dri = scanner.nextInt();
			
			System.out.println("Input driver postal address: ");
			String postalAddress_dri = scanner.next();
			
			
			System.out.println(" ------------------- ");
			System.out.println();
			
			this.id = id_cus;
			if (email_cus != null)
				this.email = email_cus;
			if (fullname_cus != null)
				this.fullname = fullname_cus;
			if (address_cus != null)
				this.address = address_cus;
			if (gender_dri != null)
				this.gender = gender_dri;
			this.phone = phone_cus;
			this.license = lisence_dri;
			if (postalAddress_dri != null)
				this.postal_address = postalAddress_dri;
			
		}
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public int getLicense() {
		return license;
	}
	public void setLicense(int license) {
		this.license = license;
	}
	public String getPostal_address() {
		return postal_address;
	}
	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}

}
