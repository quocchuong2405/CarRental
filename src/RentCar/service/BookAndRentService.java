package RentCar.service;

public interface BookAndRentService {
	void bookACar(int vehicleId, int customerId, String pickupDay, int duration);
	void signAContract(int vehicleId, int customerId, String pickupDay, 
			int duration, float cost, String payment_method,
			int garage_pickupId, int garage_returnId );
	void cancelBooking(int vehicleId, int customerId,  String pickupDay, int duration);
	boolean isAvailableDay(int vehicleId, String pickupDay, int duration);
}
