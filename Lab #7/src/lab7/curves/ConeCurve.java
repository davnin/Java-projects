package lab7.curves;

import static java.lang.Math.abs;

public class ConeCurve implements Curve {
	
	//methods
	public double getMinX () {
		return -10;
	}
	
	public double getMinY() {
		return -10;
	}
	
	public double getMaxX() {
		return 10;
	}
	
	public double getMaxY () {
		return 10;
	}
	public double getStepSize () {
		return 0.5;
	}
	
	public double getZ(double x, double y) {
		double z = abs(x) + abs(y);
		return z;
	}
	
	public  String getName() {
		return "ConeCurve";
	}

}
