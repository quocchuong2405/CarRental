package RenCar.service.impl;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import RentCar.DateSupportFunction.DateUtil;
import RentCar.entity.Booking;
import RentCar.entity.Customer;
import RentCar.entity.Garage;
import RentCar.entity.RentalContract;
import RentCar.entity.Vehicle;
import RentCar.service.BookAndRentService;
import RentCar.service.ContractService;

public class CarRentalManagement  implements BookAndRentService, ContractService{
	private static List<RentalContract> rentalContractList = null;

	
	private static CarRentalManagement instance;
	
	private CarRentalManagement() {}
	
	public static CarRentalManagement getInstance() {
		if (instance == null) {
			instance = new CarRentalManagement();
			rentalContractList = new ArrayList<RentalContract>();
		}
		return instance;
	}
	
	@Override
	public List<RentalContract> findAll() {
		return rentalContractList;
	}
	
	@Override
	public RentalContract findById(int id) {
		for (RentalContract contract : rentalContractList) {
			if (contract.getId() == id) {
				return contract;
			}
		}
		return null;
	}

	@Override
	public void update(RentalContract dto) {
		RentalContract contract = findById(dto.getId());
		if (contract != null) {
			contract = dto;
		}
	}

	@Override
	public void delete(int id) {
		RentalContract contract = findById(id);
		if (contract != null) {
			rentalContractList.remove(contract);
		}	
	}

	@Override
	public void add(RentalContract contract) {
		rentalContractList.add(contract);
	}
	
	@Override
	public void display() {
		for (RentalContract contract : rentalContractList) {
			contract.displayContract();
		}
		System.out.println("Total: " + rentalContractList.size());
	}
	
	@Override
	public void displayInJson() {
		ObjectWriter  mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PrintWriter file = null;
		try {
			file = new PrintWriter("RentalContract.txt");
			for (RentalContract contract : rentalContractList) {
				String json = mapper.writeValueAsString(contract);
				System.out.println(json);
				file.println(json);
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Convert Json error");
		}
		file.close();
	}
	
	@Override
	public boolean isAvailableDay(int vehicleId, String pickupDay, int duration) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date pickupDay_;
		try {
			pickupDay_ = format.parse(pickupDay);
			List<Booking> listBooking = BookingServiceImpl.getInstance().findAll();
			for (Booking b : listBooking) {
				int vehicleId_ = b.getIdCar();
				if ( (vehicleId_ == vehicleId)  && 
					 ( pickupDay_.compareTo(b.getPickupDay()) >= 0 && pickupDay_.compareTo(DateUtil.addDays(b.getPickupDay(), b.getDuration())) <= 0) ||
					 ( pickupDay_.before(b.getPickupDay()) && DateUtil.addDays(pickupDay_, duration).after(b.getPickupDay()) &&
							 								  DateUtil.addDays(pickupDay_, duration).before(DateUtil.addDays(b.getPickupDay(), b.getDuration()))) ||
					 ( pickupDay_.compareTo(b.getPickupDay()) <= 0 && DateUtil.addDays(pickupDay_, duration).compareTo(DateUtil.addDays(b.getPickupDay(), b.getDuration())) >= 0) ) {
					
					return false;
				}
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public void bookACar(int vehicleId, int customerId, String pickupDay, int duration) { // book by Car ID & Customer ID
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date pickupDay_;
		try {
			pickupDay_ = format.parse(pickupDay);
			Vehicle vehicle = CarFleetSig.getInstance().findById(vehicleId); 
			Customer customer = CustomerServiceImpl.getInstance().findById(customerId);
			if ( (vehicle != null) &&  (customer != null) &&  
									   (BookingServiceImpl.getInstance().search(vehicleId, customerId, pickupDay, duration) == null)  &&
									   (isAvailableDay(vehicleId, pickupDay, duration))){
				
				Booking booking = new Booking(BookingServiceImpl.getInstance().getListSize(), vehicleId, customerId, pickupDay_, duration);
				BookingServiceImpl.getInstance().add(booking);
						System.out.println("Booking succesfully!!!");
			}
			else System.out.println("Can not find the car or the car has been rented.");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancelBooking(int vehicleId, int customerId,  String pickupDay, int duration) {
		Booking booking = BookingServiceImpl.getInstance().search(vehicleId, customerId, pickupDay, duration);
		try {
			if (booking != null) {
				BookingServiceImpl.getInstance().delete(booking);
				System.out.println("Cancel booking succesfully!!!");
			}
			else System.out.println("Cancel booking fail!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void signAContract(int vehicleId, int customerId, String pickupDay, int duration, float cost, String payment_method,
			int garage_pickupId, int garage_returnId ) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date pickupDay_;
			pickupDay_ = format.parse(pickupDay);
			Booking booking = BookingServiceImpl.getInstance().search(vehicleId, customerId, pickupDay, duration);
			Vehicle vehicle = CarFleetSig.getInstance().findById(vehicleId);
			Garage garage_pickup = GarageServiceImpl.getInstance().findById(garage_pickupId);
			Garage garage_return = GarageServiceImpl.getInstance().findById(garage_returnId);
			Customer customer = CustomerServiceImpl.getInstance().findById(customerId);
			if ((booking != null) && (vehicle != null) && (garage_pickup != null) && (garage_return != null)) {
				RentalContract contract = new RentalContract(rentalContractList.size(), vehicle, pickupDay_, duration, cost, payment_method, garage_pickup, garage_return, customer);
				this.add(contract);
				BookingServiceImpl.getInstance().delete(booking);
				vehicle.setAvailable(false);
				vehicle.setBookingCustomer(customer);
				vehicle.setBookRentDate(pickupDay_);
				
				System.out.println("Sign the contract succesfully!!!");
			}
			else System.out.println("Can not sign the contract!!!");
		}
		catch (Exception e) {
			System.out.println("Sign contract error!!!");
		}
	}




}
