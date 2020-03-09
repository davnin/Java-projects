package lab7.stl;

/**
 * Lab #3
 * @author David Nindorera 
 * nind0002@algonquinlive.com
 */
public class Facet {
	
	// Instance variables

	Point3D normal;
	Point3D v1;
	Point3D v2;
	Point3D v3;

	// Facet counstructor
	/**
	 * constructor that creates a facet
	 * @param v1
	 * @param v2
	 * @param v3
	 */
	public Facet(Point3D v1, Point3D v2, Point3D v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;

		normal = Point3D.calcNormal(v1,v2,v3);
		
		//normal = calcNormal(v1, v2, v3) + calcNormal(v1, v2, v3) + p1.calcNormal(v1, v2, v3));

		
	}
	 
	// toString method
	/**
	 * convert information to string
	 * @return the information
	 */
	public String toString() {
		String msg = "facet normal " + normal +" \n" + "  " + "outer loop" + "\n" +"   " + "vertex "+this.v1+
				"\n" +"   " + "vertex " +  this.v2 + "\n" +"   " + "vertex " + this.v3 + "\n" +" " + " endloop" + "\n endfacet \n";

		return msg;


	}
}