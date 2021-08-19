package RenCar.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import RentCar.entity.Customer;
import RentCar.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	private static List<Customer> listCustomer = new ArrayList<Customer>();
	
	private static CustomerServiceImpl instance;
	
	private CustomerServiceImpl() {}
	
	public static CustomerServiceImpl getInstance() {
		if (instance == null) {
			instance = new CustomerServiceImpl();
		}
		return instance;
	}
	
	
	public List<Customer> findAll() {
		return listCustomer;
	}

	@Override
	public Customer findById(int id) {
		for (Customer customer : listCustomer) {
			if (customer.getId() == id)
				return customer;
		}
		return null;
	}

	@Override
	public void add(Customer dto) {
		listCustomer.add(dto);
	}

	@Override
	public void update(Customer dto) {
		Customer customer =  findById(dto.getId());
		if (customer != null) {
			customer = dto;
		}
	}

	@Override
	public void delete(int id) {
		Customer customer = findById(id);
		if (customer != null) {
			listCustomer.remove(customer);
		}
	}

	@Override
	public void display() {
		for (Customer c : listCustomer) {
			System.out.println();
			c.displayInfo();
			System.out.println();
			System.out.println(" ------------------- ");
		}
		System.out.println("Total: " + listCustomer.size());
	}

	@Override
	public void displayInJson() {
		ObjectWriter  mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PrintWriter file = null;
		try {
			file = new PrintWriter("Customer.txt");
			for (Customer c : listCustomer) {
				String json = mapper.writeValueAsString(c);
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
