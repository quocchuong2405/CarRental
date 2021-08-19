package RentCar.entity;

public class Trunk extends Vehicle {
	private int carry;
	
	
	public Trunk(int distance) {
		this.distance = distance;
	}
	
	public Trunk(int distance, int carry) {
		super();
		this.distance = distance;
		this.carry = carry;
	}
	
	public Trunk(int id, String carname, String brand, String color, int seat, int distance, int carry) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
		this.carry = carry;	
	}
	
	public Trunk(int id, String carname, String brand, String color, int seat, int distance, int carry, Customer owner) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
		this.carry = carry;	
		this.owner = owner;
	}
	
	public Trunk(int id, String carname, String brand, String color, int seat, int distance, int carry, int oil_change_times, int minor_times,int major_times,int fluid_change_times,int overhault_times,int adjustment_times,int replacent_times) {
		super();
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
		this.carry = carry;	
		this.oil_change_times = oil_change_times;
		this.minor_times = minor_times;
		this.major_times = major_times;
		this.overhault_times = overhault_times;
		this.adjustment_times = adjustment_times;
		this.replacent_times = replacent_times;
	}
	
	public Trunk(int id, String carname, String brand, String color, int seat, int distance, 
			int carry, int oil_change_times, int minor_times,int major_times,int fluid_change_times,
			int overhault_times,int adjustment_times,int replacent_times, Customer owner) {
		super();
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
		this.distance = distance;
		this.carry = carry;	
		this.owner = owner;
		this.oil_change_times = oil_change_times;
		this.minor_times = minor_times;
		this.major_times = major_times;
		this.overhault_times = overhault_times;
		this.adjustment_times = adjustment_times;
		this.replacent_times = replacent_times;
	}
	
	public Trunk(){
		super();
        this.color = null;
        this.seat = 2;
        this.brand = null;
        this.distance = 0;
        this.carry = 200;
    }

	@Override
	public void serviceEngine() {
		if (distance / 30000 > this.oil_change_times && distance != 0){
            this.oil_change_times += 1;
            this.major_times += 1;
            this.minor_times += 1;
        }
	}


	@Override
	public void serviceTransmission() {
		if (distance / 1000 > this.fluid_change_times && distance != 0) {
			this.fluid_change_times += 1;
			this.overhault_times += 1;
			this.minor_times += 1;
		}
		
	}


	@Override
	public void serviceTires() {
		if (distance / 5000 > this.adjustment_times && distance != 0) {
			this.adjustment_times += 1;
			this.replacent_times += 1;
		}
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Carname: " + this.carname);
		System.out.println("Brand: " + this.brand);
		System.out.println("Color: " + this.color);
		System.out.println("Seat: " + this.seat);
		System.out.println("Distance: " + this.distance);
		System.out.println("Carry: " + this.carry);
		System.out.println("Oil_change_times: " + this.oil_change_times); 
		System.out.println("Minor_times: " + this.minor_times);
		System.out.println("Major_times: " + this.major_times);
		System.out.println("Overhault_times: " + this.overhault_times);
		System.out.println("Adjustment_times: " + this.adjustment_times);
		System.out.println("Replacent_times: " + this.replacent_times);
		System.out.println("Available: " + this.available);
	}
	
	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public int getCarry() {
		return carry;
	}


	public void setCarry(int carry) {
		this.carry = carry;
	}
	
}
