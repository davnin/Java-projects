package lab7.curves;

public class Cone implements Curve {
	
	//Instance Variables
	
	private double radius;
	private double u;
	
	//Constructors
	public Cone() {
		this.radius = 20;
		this.u = 10;
	}
	
	public Cone(double r, double i ) {
		
		this.radius = r;
		this.u = i;
		
	}
	
	//methodes
	
	public double getMinX () {
		double x = ((20 - this.u)/20)*this.radius*Math.cos(45);
		
		return -x;
	}

	public double getMinY() {
		
		double y = ((20 - this.u)/20)*this.radius*Math.sin(45);
		
		return -y;
	}
	
	public double getMaxX() {
		
		double x = ((20 - this.u)/20)*this.radius*Math.cos(45);
		
		return x;
	}
	
	public double getMaxY () {
		
		double y = ((20 - this.u)/20)*this.radius*Math.sin(45);
		
		return y;
	}
	
	public double getStepSize () {
		
		return 1;
	}
	
	public double getZ(double x, double y) {
		double c = this.radius/20;
		
		double z = Math.sqrt((x*x + y*y)/c*c) + 20;
		
		return z;
	}
	
	public String getName() {
		return "Cone";
	}
	
	

}
