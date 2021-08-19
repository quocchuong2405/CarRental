package RentCar.service;

public interface OperatorOverloading<T> {
	// addition
	T add(T t);    // this + t
	T add(double t); // t + this
	T add(int t);
	T addRev(T t); 
	T addRev(double t);
	T addRev(int t);
	
	// subtraction
	T subtract(T t);
	T subtract(double t);
	T subtract(int t);
	T subtractRev(T t);
	T subtractRev(double t);
	T subtractRev(int t);
	
	// division
//	T divide(T t);
	T divide(double t);
	T divide(int t);
//	T divideRev(T t);
//	T divideRev(float t);
//	T divideRev(int t);
	
	// multiply
	T multiply(T t);
	T multiplyRev(T t);
	
	// negate
	T negate();  
	
}
