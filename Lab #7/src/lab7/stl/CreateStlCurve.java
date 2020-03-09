package lab7.stl;

import java.util.ArrayList;
import java.util.List;

import lab7.curves.*;

/**
 * Application to create a text STL file for a Cone curve
 * 
 * @author Howard Rosenblum rosenbh@algonquincollege.com
 * @version 1.0
 */
public class CreateStlCurve {
	private List<List<Point3D>> list = new ArrayList<>();

	/**
	 * 
	 * @param curve
	 */

	public void createMatrix(Curve curve) {

		double ss = curve.getStepSize();
		double minX = curve.getMinX();
		double minY = curve.getMinY();
		double maxX = curve.getMaxX();
		double maxY = curve.getMaxY();

		int xSize = (int) ((maxX - minX) / ss) + 1;
		int ySize = (int) ((maxY - minY) / ss) + 1;
		list = new ArrayList<List<Point3D>>(ySize);

		double xValue, yValue = 0;
		for (int y = 0; y < ySize; y++) {
			List<Point3D> row = new ArrayList<Point3D>();
			list.add(row);
			xValue = 0;
			for (int x = 0; x < xSize; x++) {
				row.add(new Point3D(xValue, yValue, curve.getZ(xValue + minX, yValue + minY)));
				xValue += ss;
			}
			yValue += ss;
		}
	}

	/**
	 * Create Solid based on values in matrix using the addFacet method 
	 * 
	 * @param name Name of the solid
	 * @return Generated solid
	 */
	public Solid createSolid(String name) {

		Solid solid = new Solid(name);

		int height = list.size() - 1;
		int width = list.get(0).size() - 1;

		// Create curve
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				// solid.addFacet(new Point3D (10,10,20));
				// as viewed from above
				solid.addFacet(list.get(h).get(w), // bottom left
						list.get(h).get(w + 1), // bottom right
						list.get(h + 1).get(w + 1), // top right
						list.get(h + 1).get(w)); // top left
			}
		}

		// Create bottom edge

		for (int w = 0; w < width; w++) {
			solid.addFacet(new Point3D(list.get(0).get(w).getX(), 0, 0), // base bottom left
					new Point3D(list.get(0).get(w + 1).getX(), 0, 0), // base bottom right
					list.get(0).get(w + 1), // top right
					list.get(0).get(w) // top left
			// new Point3D(10, 10, 20)
			);
		}

		// Create top edge

		for (int w = 0; w < width; w++) {
			solid.addFacet(new Point3D(list.get(height).get(w + 1).getX(), list.get(height).get(w + 1).getY(), 0), // top
																													// left
					new Point3D(list.get(height).get(w).getX(), list.get(height).get(w).getY(), 0), // top right
					list.get(height).get(w), // top right
					list.get(height).get(w + 1) // top left
			// new Point3D(10, 10, 20)
			);
		}

		// Create left edge

		for (int w = 0; w < height; w++) {
			solid.addFacet(new Point3D(list.get(w).get(0).getX(), list.get(w).get(0).getY(), 0), // base bottom left
					new Point3D(list.get(w + 1).get(0).getX(), list.get(w + 1).get(0).getY(), 0), // base top left
					list.get(w + 1).get(0), // top left of the curve
					list.get(w).get(0) // bottom left of the curve
			// new Point3D(10, 10, 20)
			);
		}

		// Create right edge

		for (int w = 0; w < height; w++) {
			solid.addFacet(new Point3D(list.get(w).get(width).getX(), 0, 0), // bottom rigth
					new Point3D(list.get(w + 1).get(width).getX(), list.get(height).get(width).getY(), 0), // top right
					// new Point3D(10, 10, 20)
					list.get(w + 1).get(width), // bottom right
					list.get(w).get(width) // top right

			);
		}

		// Create base

		solid.addFacet(new Point3D(list.get(0).get(0).getX(), list.get(0).get(0).getY(), 0), // bottom left
				new Point3D(list.get(0).get(width).getX(), list.get(0).get(width).getY(), 0), // top left
				new Point3D(list.get(height).get(width).getX(), list.get(height).get(width).getY(), 0), // top right
				new Point3D(list.get(height).get(0).getX(), list.get(height).get(0).getY(), 0) // bottom right

		);

		return solid;

	}

	/**
	 * Print the points to the console
	 */

	public void printMatrix() {
		for (List<Point3D> row : list) {
			for (Point3D value : row)
				System.out.print("(" + value + ") ");
			System.out.println();
		}
	}

}
