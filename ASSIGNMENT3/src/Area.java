import java.util.Scanner;
/**
 * 
 * Area class implement methods to calculate area of different shapes
 *
 */
public class Area {


	/**
	 * @param width   Width of Triangle
	 * @param height  Height of Triangle
	 * @return        Returns Area of Triangle
	 */
	public double areaTriangle( double width, double height){
		double constant = 0.5;
		double areaOfTriangle = constant * width * height;
		return areaOfTriangle;
	}
	
	/**
	 * @param width    Width of Rectangle
	 * @param height   Height of Rectangle
	 * @return         Returns Area of Rectangle
	 */
	public double areaRectangle( double width, double height){
		double areaOfRectangle = width * height;
		return areaOfRectangle;
	}
	
	
	/**
	 * @param width  width of Square
	 * @return  returns area of square
	 */
	public double areaSquare( double width){
		double areaOfSquare =  width * width;
		return areaOfSquare;
	}
	
	
	/**
	 * @param radius  radious of Circle 
	 * @return      Returns Area of Circle
	 */
	public double areaCircle( double radius){
		double constant = 3.14;
		double areaOfCircle = constant * radius * radius;
		return areaOfCircle;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Area areaObj = new Area();
		double width,height,radius;
		do {
			System.out.println("Enter your choice \n1.Calculate Area of Triangle\n2.Calculate Area of RectAngle\n3.Calculate Area of Square\n4.Calculate Area of Circle\n5.Exit");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			//Calculate Area of Triangle
			case 1:
				System.out.println("Enter width of Triangle");
				width = scan.nextDouble();
				System.out.println("Enter Height of Triangle");
				height = scan.nextDouble();
				System.out.println("Area of Triangle = "+(areaObj.areaTriangle(width, height)));
				break;
			// Calculate Area of Rectangle
			case 2:
				System.out.println("Enter width of RectAngle");
				width = scan.nextDouble();
				System.out.println("Enter Height of Rectangle");
				height = scan.nextDouble();
				System.out.println("Area of RectAngle = "+(areaObj.areaRectangle(width, height)));
				break;
            //Calculate Area of Square
			case 3:
				System.out.println("Enter width of Square");
				width = scan.nextDouble();
				System.out.println("Area of Square = "+(areaObj.areaSquare(width)));
				break;
			// Calculate Area of circle
			case 4:
				System.out.println("Enter Radius of Circle");
				radius = scan.nextDouble();
				System.out.println("Area of Triangle = "+(areaObj.areaCircle(radius)));
				break;

			case 5:
				System.exit(0);
			default:
				System.out.print("Wrong input");

			}
		} while (true);
		}
	
	
}
