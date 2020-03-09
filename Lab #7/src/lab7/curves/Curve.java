package lab7.curves;

public interface Curve {
	//methods
	public double getMinX ();

	public double getMinY();
	
	public double getMaxX();
	
	public double getMaxY ();
	
	public double getStepSize ();
	
	public double getZ(double x, double y);
	
	public String getName();

}
