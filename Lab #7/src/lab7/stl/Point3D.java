package lab7.stl;

public class Point3D {
	
	// Instant variables
		private double x;
		private double y;
		private double z;

		// Initial constructor
		/**
		 * creates a 3D point
		 * @param a
		 * @param b
		 * @param c
		 */
		public Point3D(double a, double b, double c) {
			this.x = a;
			this.y = b;
			this.z = c;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		public double getZ() {
			return z;
		}

		// toString method
		/**
		 * convert the point into string
		 */
		public String toString() {

			return x + " " + y + " " + z;

		}

		// Calculate normal method
		/**
		 * Calculate the normal of the points 
		 * @param v1
		 * @param v2
		 * @param v3
		 * @return the normal
		 */
		public static Point3D calcNormal(Point3D v1, Point3D v2, Point3D v3) {
//			v1 = new Point3D(this.x, this.y, this.z);
//			v2 = new Point3D(this.x, this.y, this.z);
//			v3 = new Point3D(this.x, this.y, this.z);

			// First vector

			double a1 = v2.x - v1.x;
			double b1 = v2.y - v1.y;
			double c1 = v2.z - v1.z;

			// Second vector

			double a2 = v3.x - v1.x;
			double b2 = v3.y - v1.y;
			double c2 = v3.z - v1.z;
			
			//Product of vectors
			double c = a1 * b2 - b1 * a2;
			double a = b1 * c2 - c1 * b2;
			double b = c1 * a2 - a1 * c2;
			
			//magnitude
			
			double mag = Math.sqrt((a*a) + (b*b) + (c*c));

			// normal

			Point3D normal = new Point3D((a/mag), (b/mag), (c/mag));

			return normal;

		}
}
