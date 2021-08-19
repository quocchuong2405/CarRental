package RentCar.entity;

public class Garage {
	private int id;
	private String location;
	private String name;
	private int size;
	private Customer director;
	
	public Garage() {}
	public Garage(int id, String location, String name, int size, Customer director) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.size = size;
		this.director = director;
	}
	
	
	public void displayInfo() {
		System.out.println("Location: " + this.location);
		System.out.println("Name: " + this.name);
		System.out.println("Size: " + this.size);
		System.out.print("Director: " + this.director.getFullname());
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Customer getDirector() {
		return director;
	}
	public void setDirector(Customer director) {
		this.director = director;
	}
	public int getId() {
		return id;
	}
	
}
