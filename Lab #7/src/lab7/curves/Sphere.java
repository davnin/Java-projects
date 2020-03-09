package lab7.curves;

public class Sphere implements Curve{
	
	//instance variable
	private double radius;
	private double r2;
	
	//constructor
	
	public Sphere(double radius) {
		this.radius = radius;
		this.r2 = radius*radius;
	}
	
	
	
	public double getMinX () {
		return -radius;
	};

	public double getMinY() {
		return -radius;
	};
	
	public double getMaxX() {
		return radius;
	};
	
	public double getMaxY () {
		return radius;
	};
	
	public double getStepSize () {
		return 1;
	};
	
	public double getZ(double x, double y) {
		double z = 0;
		z = Math.sqrt(r2 - x * this.radius/2 - y * this.radius/2);
		//z = Math.sqrt(r2 - x * x - y * y);
		return z + this.radius/2;
	};
	
	public String getName() {
		return "My Curve " + this.radius;
	}

}
