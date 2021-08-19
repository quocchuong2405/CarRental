package RenCar.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import RentCar.entity.Customer;
import RentCar.entity.Vehicle;
import RentCar.service.CarFleetService;

public class CarFleetSig implements CarFleetService{
	
	private static List<Vehicle> carFleet = new ArrayList<Vehicle>();
	
	private static CarFleetSig instance;
	
	private CarFleetSig() {}
	
	public static CarFleetSig getInstance() {
		if (instance == null) {
			instance = new CarFleetSig();
		}
		return instance;
	}
	
	
	@Override
	public List<Vehicle> findAll() {
		return carFleet;
	}
	
	@Override
	public Vehicle findById(int id) {
		for (Vehicle vehicle : carFleet) {
			if (vehicle.getId() == id) {
				return vehicle;
			}
		}
		return null;
	}
	
	@Override
	public void add(Vehicle vehicle) {
		carFleet.add(vehicle);
	}
	
	@Override
	public void update(Vehicle dto) {
		Vehicle vehicle = findById(dto.getId());
		if (vehicle != null) {
			vehicle = dto;
		}
	}
	
	@Override
	public void delete(int id) {
		Vehicle vehicle = findById(id);
		if (vehicle != null) {
			carFleet.remove(vehicle);
		}
		
	}
	
	public void listCarOfACustomer(Customer customer) {
		List<Vehicle> lv = CarFleetSig.getInstance().findAll();
		for (Vehicle v : lv) {
			if (v.getOwner() == customer) {
				System.out.println();
				v.displayInfo();
				System.out.println();
				System.out.println(" ------------------- ");
			}
		}
	}
	
	@Override
	public void display() {
		for (Vehicle v : carFleet) {
			System.out.println();
			v.displayInfo();
			System.out.println();
			System.out.println(" ------------------- ");
		}
		System.out.print("Total: " + carFleet.size());
	}

	@Override
	public void displayInJson() {
		ObjectWriter  mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PrintWriter file = null;
		try {
			file = new PrintWriter("CarFleet.json");
			for (Vehicle v : carFleet) {
				String json = mapper.writeValueAsString(v);
				file.println(json);  // to file
				System.out.println(json); // to console
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Convert Json error");
		}
		file.close();
	}

	@Override
	public Vehicle search(Vehicle vehicle) {
		for (Vehicle v : carFleet) {
			if (v.getCarname() == vehicle.getCarname() &&
				v.getBrand() == vehicle.getBrand() &&
				v.getSeat() == vehicle.getSeat() &&
				v.getColor() == vehicle.getColor())
			return v;
		}
		return null;
	}
	

}
