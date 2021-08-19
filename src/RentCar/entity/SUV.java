package RentCar.entity;

public class SUV extends Vehicle {
	
	public SUV() {
		this.seat = 7;
		this.distance = 0;
		this.brand = null;
		this.color = null;
	}
	
	public SUV(int distance) {
		this.distance = distance;
	}
	
	public SUV(int id, String carname, String brand, String color, int seat, int distance) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
	}
	
	public SUV(int id, String carname, String brand, String color, int seat, int distance, Customer owner) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
		this.owner = owner;
	}
	
	public SUV(int id, String carname, String brand, String color, int seat, int distance, int oil_change_times, 
			int minor_times,int major_times,int fluid_change_times,int overhault_times,int adjustment_times,
			int replacent_times) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
		this.oil_change_times = oil_change_times;
		this.minor_times = minor_times;
		this.major_times = major_times;
		this.overhault_times = overhault_times;
		this.adjustment_times = adjustment_times;
		this.replacent_times = replacent_times;
	}
	
	public SUV(int id, String carname, String brand, String color, int seat, int distance, int oil_change_times, 
			int minor_times,int major_times,int fluid_change_times,int overhault_times,int adjustment_times,
			int replacent_times, Customer owner) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
		this.oil_change_times = oil_change_times;
		this.minor_times = minor_times;
		this.major_times = major_times;
		this.overhault_times = overhault_times;
		this.adjustment_times = adjustment_times;
		this.replacent_times = replacent_times;
		this.owner = owner;
	}
	
	@Override
	public void serviceEngine() {
		if (distance / 200000 > this.oil_change_times  && distance != 0){
            this.oil_change_times += 1;
            this.major_times += 1;
            this.minor_times += 1;
        }
	}


	@Override
	public void serviceTransmission() {
		if (distance / 1500 > this.fluid_change_times && distance != 0) {
			this.fluid_change_times += 1;
			this.overhault_times += 1;
			this.minor_times += 1;
		}
		
	}


	@Override
	public void serviceTires() {
		if (distance / 10000 > this.adjustment_times && distance != 0) {
			this.adjustment_times += 1;
			this.replacent_times += 1;
		}
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public void displayInfo() {
		System.out.println("Carname: " + this.carname);
		System.out.println("Brand: " + this.brand);
		System.out.println("Color: " + this.color);
		System.out.println("Seat: " + this.seat);
		System.out.println("Distance: " + this.distance);
		System.out.println("Oil_change_times: " + this.oil_change_times); 
		System.out.println("Minor_times: " + this.minor_times);
		System.out.println("Major_times: " + this.major_times);
		System.out.println("Overhault_times: " + this.overhault_times);
		System.out.println("Adjustment_times: " + this.adjustment_times);
		System.out.println("Replacent_times: " + this.replacent_times);
		System.out.println("Available: " + this.available);
	}
	
}
