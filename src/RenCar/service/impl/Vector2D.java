package RenCar.service.impl;

import RentCar.service.OperatorOverloading;

public class Vector2D implements OperatorOverloading<Vector2D> {
	
	private double x, y;
	
	public Vector2D(double d, double e) {
		this.x = d;
		this.y = e;
	}
	
	public double length() {
		double l2 = this.x * this.x + this.y * this.y;
		return Math.sqrt(l2);
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	public Vector2D add(Vector2D t) {
		return new Vector2D(this.x + t.x, this.y + t.y);
	}

	@Override
	public Vector2D add(double t) {
		return new Vector2D(x + t, y + t);
	}

	@Override
	public Vector2D add(int t) {
		return new Vector2D(x + t, y + t);
	}

	@Override
	public Vector2D addRev(Vector2D t) {
		return new Vector2D(t.x + x, t.y + y);
	}

	@Override
	public Vector2D addRev(double t) {
		return new Vector2D(t + x, t + y);
	}

	@Override
	public Vector2D addRev(int t) {
		return new Vector2D(t + x, t + y);
	}

	@Override
	public Vector2D subtract(Vector2D t) {
		return null;
	}

	@Override
	public Vector2D subtract(double t) {
		return new Vector2D(this.x - t, this.y - t);
	}

	@Override
	public Vector2D subtract(int t) {
		return new Vector2D(this.x - t, this.y - t);
	}

	@Override
	public Vector2D subtractRev(Vector2D t) {
		return new Vector2D(t.x - this.x, t.y - this.y);
	}

	@Override
	public Vector2D subtractRev(double t) {
		return new Vector2D(t - this.x, t - this.y);
	}

	@Override
	public Vector2D subtractRev(int t) {
		return new Vector2D(t - this.x, t - this.y);
	}
	
	@Override
	public Vector2D multiply(Vector2D t) {
		return new Vector2D(this.x * t.x, this.y * t.y);
	}
	
	/*
	 * float Vector3D::operator*(Vector3D other){
    		return this->x*other.x + this->y*other.y + this->z*other.z;
		}
	 * 
	 */
	@Override
	public Vector2D multiplyRev(Vector2D t) {
		return new Vector2D(t.x * this.x, t.y * this.y);
	}
	
	@Override
	public Vector2D divide(double t) {
		return new Vector2D(this.x / t, this.y / t);
	}

	@Override
	public Vector2D divide(int t) {
		return new Vector2D(this.x / t, this.y / t);
	}

	@Override
	public Vector2D negate() {
		return new Vector2D(0 - this.x, 0 - this.y);
	}

	public boolean compareTo(Vector2D t) {
		return true;
	}
	

}
