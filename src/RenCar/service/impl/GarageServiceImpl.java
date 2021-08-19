package RenCar.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import RentCar.entity.Garage;
import RentCar.entity.Vehicle;
import RentCar.service.GarageService;

public class GarageServiceImpl implements GarageService {
	
	private static List<Garage> listGarage = new ArrayList<Garage>();
	
	private static GarageServiceImpl instance;
	
	private GarageServiceImpl() {}
	
	public static GarageServiceImpl getInstance() {
		if (instance == null) {
			instance = new GarageServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<Garage> findAll() {
		return listGarage;
	}
	
	@Override
	public Garage findById(int id) {
		for (Garage garage : listGarage) {
			if (garage.getId() == id) {
				return garage;
			}
		}
		return null;
	}

	@Override
	public void add(Garage dto) {
		listGarage.add(dto);
	}

	@Override
	public void update(Garage dto) {
		Garage garage = findById(dto.getId());
		if (garage != null) {
			garage = dto;
		}
	}

	@Override
	public void delete(int id) {
		Garage garage = findById(id);
		if (garage != null) {
			listGarage.remove(garage);
		}
	}

	@Override
	public void display() {
		for (Garage garage : listGarage) {
			System.out.println();
			garage.displayInfo();
			System.out.println();
			System.out.println(" ------------------- ");
		}
		System.out.println("Total: " + listGarage.size());
	}

	@Override
	public void displayInJson() {
		ObjectWriter  mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PrintWriter file = null;
		try {
			file = new PrintWriter("Garage.txt");
			for (Garage g : listGarage) {
				String json = mapper.writeValueAsString(g);
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
