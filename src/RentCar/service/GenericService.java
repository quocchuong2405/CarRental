package RentCar.service;

import java.util.List;

public interface GenericService<T>{
	List<T> findAll();
	T findById(int id);
	void add(T dto);
	void update(T dto);
	void delete(int id);
	void display();
	void displayInJson();
}
