package RentCar.service;

import RentCar.entity.Vehicle;

public interface CarFleetService extends GenericService<Vehicle> {
	Vehicle search(Vehicle vehicle);
}
