package lab7;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import lab7.curves.*;
import lab7.stl.*;

public class StlCurves {
	public static void main(String[] arg) {
		ArrayList <Curve> shapes = new ArrayList <Curve> ();
		CreateStlCurve crve = new CreateStlCurve();
		shapes.add(new ConeCurve());
		shapes.add(new MonkeySaddle());
		shapes.add(new HalfSphere(20));
		shapes.add(new Sphere(20));
		
		Scanner input = new Scanner (System.in);
		

		
		for(int i =0 ; i < shapes.size() ; i++) {
			
			System.out.println(i+1 + " " + shapes.get(i).getName());
			
		}

		
		System.out.print("\nWhich curve number do you want ? \n");
		int option = input.nextInt();
		input.close();
		
		if ( option > shapes.size() || option <= 0) {
			
			System.out.print("Invalid input");
			
		}else {
			
			Curve selectedCurve = shapes.get(option-1);
			
			crve.createMatrix(selectedCurve);
			
			Solid solid = crve.createSolid( shapes.get(option-1).getName() );

			String name = "c:\\temp\\" + shapes.get(option-1).getName() + ".stl";
			Path path = Paths.get(name);

			try {
				solid.toTextFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			System.out.print(name + " has been created");
			
		}


		
		

	}

}
