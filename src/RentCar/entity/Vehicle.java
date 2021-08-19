package RentCar.entity;

import java.util.Date;

public abstract class Vehicle {
	protected int id;
	protected int distance;
	protected String carname;
	protected String brand;
	protected String color;
	protected int seat;
	
	
	protected int oil_change_times = 0;
	protected int minor_times = 0;
	protected int major_times = 0;
	protected int fluid_change_times = 0;
	protected int overhault_times = 0;
	protected int adjustment_times = 0;
	protected int replacent_times = 0;
	
	// for booking and renting
	protected boolean available = true;
	protected Customer owner = null;
	protected Date bookRentDate = null; 
	protected int duration = 0;
	protected Customer bookingCustomer = null;
	
	public Vehicle() {
		this.carname = null;
		this.brand = null;
		this.color = null;
		this.seat = 4;
		this.oil_change_times = 0;
		this.minor_times = 0;
		this.major_times = 0;
		this.fluid_change_times = 0;
		this.overhault_times = 0;
		this.adjustment_times = 0;
		this.replacent_times = 0;
	}
	
	public abstract void serviceEngine();
	public abstract void serviceTransmission();
	public abstract void serviceTires();
	public abstract void displayInfo();

	public int getId() {
		return id;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public int getOil_change_times() {
		return oil_change_times;
	}

	public void setOil_change_times(int oil_change_times) {
		this.oil_change_times = oil_change_times;
	}

	public int getMinor_times() {
		return minor_times;
	}

	public void setMinor_times(int minor_times) {
		this.minor_times = minor_times;
	}

	public int getMajor_times() {
		return major_times;
	}

	public void setMajor_times(int major_times) {
		this.major_times = major_times;
	}

	public int getFluid_change_times() {
		return fluid_change_times;
	}

	public void setFluid_change_times(int fluid_change_times) {
		this.fluid_change_times = fluid_change_times;
	}

	public int getOverhault_times() {
		return overhault_times;
	}

	public void setOverhault_times(int overhault_times) {
		this.overhault_times = overhault_times;
	}

	public int getAdjustment_times() {
		return adjustment_times;
	}

	public void setAdjustment_times(int adjustment_times) {
		this.adjustment_times = adjustment_times;
	}

	public int getReplacent_times() {
		return replacent_times;
	}

	public void setReplacent_times(int replacent_times) {
		this.replacent_times = replacent_times;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Date getBookRentDate() {
		return bookRentDate;
	}

	public void setBookRentDate(Date bookRentDate) {
		this.bookRentDate = bookRentDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Customer getBookingCustomer() {
		return bookingCustomer;
	}

	public void setBookingCustomer(Customer bookingCustomer) {
		this.bookingCustomer = bookingCustomer;
	}
	
	
	
	
	/*
	public Vehicle(int id, String carname, String brand, String color, int seat) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = seat;
	}
	
	public Vehicle(int id, String carname, String brand, String color) {
		super();
		this.id = id;
		this.carname = carname;
		this.brand = brand;
		this.color = color;
		this.seat = null;
	}
	
	*/
}
