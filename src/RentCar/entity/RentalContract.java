package RentCar.entity;

import java.util.Date;

import RentCar.DateSupportFunction.DateUtil;

public class RentalContract {
	private int id;
	private Vehicle vehicle;
	private Date pickupDay;
	private Date returnDay;
	private int duration;
	private float cost;
	private String payment_method;
	private Garage garage_pickup;
	private Garage garage_return;
	private Customer customer;
	
	public RentalContract() {}

	public RentalContract(int id, Vehicle vehicle, Date pickupDay, int duration, float cost,
			String payment_method, Garage garage_pickup, Garage garage_return, Customer customer) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.vehicle.setAvailable(false);
		this.pickupDay = pickupDay;
		this.duration = duration;
		this.cost = cost;
		this.payment_method = payment_method;
		this.garage_pickup = garage_pickup;
		this.garage_return = garage_return;
		this.customer = customer;
		this.returnDay = DateUtil.addDays(this.pickupDay, this.duration);
	}
	
	public void displayContract() {
		System.out.println("Vehicle: " + this.vehicle.getCarname());
		System.out.println("Pickup Day: " + this.pickupDay);
		System.out.println("Return Day: " + this.returnDay);
		System.out.println("Duration: " + this.duration + " days");
		System.out.println("Cost: " + this.cost);
		System.out.println("Payment Method: " + this.payment_method);
		System.out.println("Garage pickup: " + this.garage_pickup.getName());
		System.out.println("Garage return: " + this.garage_return.getName());
		System.out.println("Customer: " + this.customer.getFullname());
		System.out.println("");
		System.out.println(" --------------------- ");
		System.out.println("");
	}
	public int getId() {
		return id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getPickupDay() {
		return pickupDay;
	}

	public void setPickupDay(Date pickupDay) {
		this.pickupDay = pickupDay;
	}

	public Date getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public Garage getGarage_pickup() {
		return garage_pickup;
	}

	public void setGarage_pickup(Garage garage_pickup) {
		this.garage_pickup = garage_pickup;
	}

	public Garage getGarage_return() {
		return garage_return;
	}

	public void setGarage_return(Garage garage_return) {
		this.garage_return = garage_return;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}