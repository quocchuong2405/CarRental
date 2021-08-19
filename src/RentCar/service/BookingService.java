package RentCar.service;

import RentCar.entity.Booking;

public interface BookingService extends GenericService<Booking> {
	Booking search(int carId, int cusId);
	Booking search(int carId, int cusId, String pickupDay);
	Booking search(int carId, int cusId, String pickupDay, int duration);
	void delete(Booking booking);
}
