package RentCar.entity;

import java.util.Date;

public class Booking {
	private int id;
	private int idCar; 
	private int idCustomer; 
	private Date pickupDay; 
	private int duration;
	
	
	public Booking() {};
	
	public Booking(int id, int idCar, int idCustomer, Date pickupDay, int duration) {
		super();
		this.id = id;
		this.idCar = idCar;
		this.idCustomer = idCustomer;
		this.pickupDay = pickupDay;
		this.duration = duration;
	}
	
	
	public int getId() {
		return id;
	}
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Date getPickupDay() {
		return pickupDay;
	}
	public void setPickupDay(Date pickupDay) {
		this.pickupDay = pickupDay;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
