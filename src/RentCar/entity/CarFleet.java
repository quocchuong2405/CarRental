package RentCar.entity;

import java.util.ArrayList;
import java.util.List;

public class CarFleet {
	private List<Vehicle> carFleet = new ArrayList<Vehicle>();
	
	public void add(Vehicle vehicle) {
		carFleet.add(vehicle);
	}
	/*
	public void add(Trunk vehicle) {
		carFleet.add(vehicle);
		//System.out.println("add ok");
	}
	public void add(Van vehicle) {
		carFleet.add(vehicle);
	}
	public void add(SUV vehicle) {
		carFleet.add(vehicle);
	}*/
	
	public void displayCarFleet() {
		for (Object v : carFleet) {
			System.out.println(v);
		}
	}
}
