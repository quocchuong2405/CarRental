package RenCar.service.impl;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import RentCar.entity.Booking;
import RentCar.service.BookingService;

public class BookingServiceImpl implements BookingService{
	private static List<Booking> listBooking = new ArrayList<Booking>();
	
	private static BookingServiceImpl instance;
	
	private BookingServiceImpl() {}
	
	public static BookingServiceImpl getInstance() {
		if (instance == null) {
			instance = new BookingServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<Booking> findAll() {
		return listBooking;
	}
	
	@Override
	public Booking findById(int id) {
		for (Booking booking : listBooking ) {
			if (booking.getId() == id) {
				return booking;
			}
		}
		return null; 
	}
	
	public int getListSize() {
		return listBooking.size();
	}
	
	@Override
	public void add(Booking dto) {
		listBooking.add(dto);
	}

	@Override
	public void update(Booking dto) {
		Booking booking = findById(dto.getId());
		if (booking != null) {
			booking = dto;
		}
		
	}

	@Override
	public void delete(int id) {
		Booking booking = findById(id);
		if (booking != null) {
			listBooking.remove(booking);
		}
	}
	
	@Override
	public void delete(Booking booking) {
		if (booking != null) {
			listBooking.remove(booking);
		}
	}
	
	@Override
	public Booking search(int carId, int cusId) {
		for (Booking booking : listBooking) {
			if (booking.getIdCar() == carId && booking.getIdCustomer() == cusId) {
				return booking;
			}
		}
		return null;
	}
	
	@Override
	public Booking search(int carId, int cusId, String pickupDay) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date pickupDay_ = format.parse(pickupDay);
			for (Booking booking : listBooking) {
				if (booking.getIdCar() == carId && 
					booking.getIdCustomer() == cusId &&
					booking.getPickupDay().equals(pickupDay_)) {
						
					return booking;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Booking search(int carId, int cusId, String pickupDay, int duration) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date pickupDay_ = format.parse(pickupDay);
			for (Booking booking : listBooking) {
				if (booking.getIdCar() == carId && 
					booking.getIdCustomer() == cusId &&
					booking.getPickupDay().equals(pickupDay_) &&
					booking.getDuration() == duration) {
						
					return booking;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public void display() {
		for (Booking booking : listBooking) {
			System.out.println();
			
			System.out.println("Car name: " + CarFleetSig.getInstance().findById(booking.getIdCar()).getCarname());
			System.out.println("Customer name: " + CustomerServiceImpl.getInstance().findById(booking.getIdCustomer()).getFullname());
			System.out.println("PickupDay: " + booking.getPickupDay());
			System.out.println("Duration: " + booking.getDuration());
			System.out.println();
			System.out.println(" ------------------- ");
		}
		System.out.println("Total: " + listBooking.size());
	}

	@Override
	public void displayInJson() {
		ObjectWriter  mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PrintWriter file = null;
		try {
			file = new PrintWriter("Booking.txt");
			for (Booking b : listBooking) {
				String json = mapper.writeValueAsString(b);
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

}
