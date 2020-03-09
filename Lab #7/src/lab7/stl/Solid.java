package lab7.stl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;




/**
 * Lab #6
 * 
 * @author David Nindorera 
 * nind0002@algonquinlive.com
 * 
 */
public class Solid {

	// Instance variables
	private String name;
	private ArrayList<Facet> facets = new ArrayList<Facet>();

	// Constructors
	public Solid() {
		this.name = "";

		// this.currentSize=0;
	}

	public Solid(String n) { // Initialize
		this.name = n;
	}

	// Methods

	public boolean addFacet(Facet a) {

		this.facets.add(a);

		return true;

	}

	/**
	 * 
	 * @param vertex
	 * @return true if facet is correctly arguments are more than 3 and false 
	 */
	public boolean addFacet(Point3D... vertex) {

		// the 3 vertexes for the facet and and if there less than 2 vertexes return
		// false
		if (vertex.length >= 3) {
			for (int i = 0; i < vertex.length - 2; i++) {
				Point3D p1 = vertex[0];
				Point3D p2 = vertex[i + 1];
				Point3D p3 = vertex[i + 2];
				Facet fac = new Facet(p1, p2, p3);
				facets.add(fac);
			}
			return true;
		} else {
			return false;
		}

		// if(vertex.length < 3 ) {
		// return false;
		// }else
		// for(Point3D i : vertex) {

		// for(int i = 0 ; i < vertex.length; i ++) {

		// facets.add(vertex[i]);

		// return true;

	}

	public void toTextFile(Path path) throws IOException {
		// ArrayList<String> content = new ArrayList<>();
		// content.add(toString());
		// Files.write(path, content, Charset.forName("UTF-8"));
		Files.write(path, toString().getBytes());
	}

	public String toString() {
		String msg = "solid " + name +"\n";

		for (Facet i : facets) {

			msg+=i;
		}
		msg += "endsolid " + name;
		return msg;
	}

}
