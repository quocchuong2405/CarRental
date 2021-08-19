package RentCar.main;

import java.io.ObjectInputStream.GetField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.File;
import java.io.IOException;

import RenCar.service.impl.BookingServiceImpl;
import RenCar.service.impl.CarFleetSig;
import RenCar.service.impl.CarRentalManagement;
import RenCar.service.impl.CustomerServiceImpl;
import RenCar.service.impl.GarageServiceImpl;
import RenCar.service.impl.Vector2D;
import RentCar.DateSupportFunction.DateUtil;
import RentCar.entity.Booking;
import RentCar.entity.Customer;
import RentCar.entity.Driver;
import RentCar.entity.Garage;
import RentCar.entity.RentalContract;
import RentCar.entity.SUV;
import RentCar.entity.Trunk;
import RentCar.entity.Van;
import RentCar.entity.Vehicle;


public class main {

	public static void main(String[] args) {
		
		try {
			/* ----------------------- Initiation --------------*/
			Date current_day = new Date();
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

			Customer customer1 = new Customer(0, "Chuong");
			Customer customer2 = new Customer(1, "Huy");
			Customer customer3 = new Customer(2, "Ngan");
			Customer customer4 = new Customer(3, "emailfake@gmail.com", "Nguyen A", 911, "12 Thanh My");
			Customer customer5 = new Customer(4, "Hoang", 100331);
			Driver driver1 = new Driver(5,"Tan",66666);
			Driver driver2 = new Driver(6,"Tuyen","Male", 123123);
			Driver driver3 = new Driver(7,"Nguyet","Female", format.parse("24-05-2001"), 201712);
			Driver driver4 = new Driver(8,"Bill","Male", format.parse("19-05-2008"), 663322);
			Driver driver5 = new Driver(9, "driver5@gmail.com", "Anh", "Male", 122211, "14 Le Duan", format.parse("20-10-1998"), 445566, "123BCD");
				
			
			Trunk trunk1 = new Trunk(0, "Trunk1", "BMW", "Blue", 2, 100, 50);
			Trunk trunk2 = new Trunk(1, "Trunk2", "Toyota", "Red", 2, 105, 45, customer1);
			Trunk trunk3 = new Trunk(6, "Trunk3", "Ford", "Grey", 2, 15000, 100);
			SUV suv1 = new SUV(2, "Suv1", "Toyota", "Red", 4, 10300);
			SUV suv2 = new SUV(3, "Suv2", "Lamboghini", "Black", 4, 20100);
			SUV suv3 = new SUV(7, "Suv3", "Mercedes", "Yellow", 4, 2200, customer1);
			SUV suv4 = new SUV(8, "Suv4", "Toyota", "Blue", 4, 7777);
			Van van1 = new Van(4, "Van1", "Hyundai", "Brown", 2, 121212);
			Van van2 = new Van(5, "Van2", "Ford", "Green", 2, 3333);
			Van van3 = new Van(9, "Van3", "Yamaha", "Black", 2, 6666, customer1);
		
			
			Garage garage1 = new Garage(0, "268 LTK", "garage1", 48, customer1);
			Garage garage2 = new Garage(1, "123 Hoang Hoa Tham", "garage2", 12, driver5);
			Garage garage3 = new Garage(2, "177 ABC", "garage3", 32, customer3);
			Garage garage4 = new Garage(3, "20 ZZ", "garage4", 5, customer4);
			
			
			CustomerServiceImpl.getInstance().add(customer1);
			CustomerServiceImpl.getInstance().add(customer2);
			CustomerServiceImpl.getInstance().add(customer3);
			CustomerServiceImpl.getInstance().add(customer4);
			CustomerServiceImpl.getInstance().add(customer5);
			CustomerServiceImpl.getInstance().add(driver1);
			CustomerServiceImpl.getInstance().add(driver2);
			CustomerServiceImpl.getInstance().add(driver3);
			CustomerServiceImpl.getInstance().add(driver4);
			CustomerServiceImpl.getInstance().add(driver5);				
			
			CarFleetSig.getInstance().add(trunk1);
			CarFleetSig.getInstance().add(trunk2);
			CarFleetSig.getInstance().add(trunk3);
			CarFleetSig.getInstance().add(suv1);
			CarFleetSig.getInstance().add(suv2);
			CarFleetSig.getInstance().add(suv3);
			CarFleetSig.getInstance().add(suv4);
			CarFleetSig.getInstance().add(van1);		
			CarFleetSig.getInstance().add(van2);
			CarFleetSig.getInstance().add(van3);
			
			GarageServiceImpl.getInstance().add(garage1);
			GarageServiceImpl.getInstance().add(garage2);
			GarageServiceImpl.getInstance().add(garage3);
			GarageServiceImpl.getInstance().add(garage4);
			
			
			//BookingServiceImpl.getInstance().displayInJson();
			
			
			/*
			
			RentalContract contract1 = new RentalContract(0, trunk1, format.parse("05-04-2021"),  1, 1900, "credit card", garage1, garage2, driver1);
			RentalContract contract2 = new RentalContract(1, van1, format.parse("10-04-2021"), 2, 1900, "cash", garage2, garage4, customer2);
			RentalContract contract3 = new RentalContract(2, suv1, format.parse("01-03-2021"), 5, 1900, "cash", garage2, garage3, customer4);
			CarRentalManagement.getInstance().add(contract1);
			CarRentalManagement.getInstance().add(contract2);
			CarRentalManagement.getInstance().display();
			RentalContract contract4 = new RentalContract(3, suv3, format.parse("14-07-2021"),  2, 1900, "credit card", garage3, garage1, driver2);	
			RentalContract contract5 = new RentalContract(4, trunk3, format.parse("19-01-2021"), 35, 1900, "credit card", garage3, garage3, driver3);

			
			CarRentalManagement.getInstance().add(contract3);
			CarRentalManagement.getInstance().add(contract4);
			CarRentalManagement.getInstance().add(contract5);
			*/
			
			/*
			CarRentalManagement.getInstance().bookACar(1, 2, "14-07-2021", 3);  // Customer "2" can book the car "1" from "14-07-2021" to "17-07-2021"
			CarRentalManagement.getInstance().bookACar(1, 3, "18-07-2021", 2);	// Customer "3" can book the car "1" from "18-07-2021" to "19-07-2021"
			CarRentalManagement.getInstance().bookACar(1, 4, "15-07-2021", 1);  
			// Customer "2" can NOT book the car "1" from "15-07-2021" to "16-07-2021" because the car has been booked by customer "2"
			CarRentalManagement.getInstance().bookACar(1, 2, "10-07-2021", 10);  // Can NOT book with the same reason.
			CarRentalManagement.getInstance().bookACar(11, 2, "10-07-2021", 10);  // Can NOT book because we can not find the car with id "11" in CarFleetSig
			
			CarRentalManagement.getInstance().bookACar(2, 4, "25-05-2021", 3);  // booking successfully
			CarRentalManagement.getInstance().cancelBooking(2, 4, "25-05-2021", 3);  // cancel booking successfully
			//BookingServiceImpl.getInstance().display();
			
			System.out.println("\n\n\n---------------------------------------------------------\n\n\n");
			CarRentalManagement.getInstance().signAContract(1, 2, "14-07-2021", 3, 1500, "Cash", 2, 3);  // Can sign the contract
			CarRentalManagement.getInstance().signAContract(1, 3, "18-07-2021", 2, 1900, "Cash", 1, 2);  // Can sign the contract
			CarRentalManagement.getInstance().signAContract(1, 2, "15-07-2021", 3, 999, "Cash", 4, 5);   // Can NOT sign the contract because it has NOT been booked
			CarRentalManagement.getInstance().signAContract(1, 2, "14-07-2021", 3, 1500, "Cash", 2, 3);  // Can NOT sign the contract because it has been rent
			CarRentalManagement.getInstance().display(); */
			
			
			// Operator Overloading demo 
			/*
			Vector2D v1 = new Vector2D(13,4);
			Vector2D v2 = new Vector2D(3.5,6.3);
			
			System.out.println(v1);
			System.out.println(v2);
			
			Vector2D v3 = v1 + v2;
			Vector2D v4 = v1.add(v2);  // this is what the compiler actually do -> convert "+" to the .add() function.
			System.out.println("Operator Overloading: " + v3);
			System.out.println("Call by function: " + v4);
			*/
				
			
			//CarRentalManagement.getInstance().display();
			
			/*CarRentalManagement.getInstance().bookACar(0, 1, format.parse("06-04-2021"), 3);
			System.out.println(trunk1.getBookRentDate());
			
			CarRentalManagement.getInstance().bookACar(0, 1, format.parse("07-04-2021"), 3);
			System.out.println(trunk1.getBookRentDate());
			
			CarRentalManagement.getInstance().cancelBooking(0, 1);
			
			CarRentalManagement.getInstance().bookACar(0, 1, format.parse("07-04-2021"), 3);
			System.out.println(trunk1.getBookRentDate());
			*/

		    
			
			/* ---------------Input Date----------------- */ 
			/*
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Date ");

			String date = scanner.next();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date2=null;
			try {
			    date2 = dateFormat.parse(date); //Parsing the String
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			System.out.println(date2);
			
			date2 = DateUtil.addDays(date2, 1);
			System.out.println(date2);
			*/
			//System.out.println(trunk1.getFutureBookOrRent());

			
			
			
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}

}
