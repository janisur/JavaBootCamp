package sef.module6.activity;

public class AbstractionActivity {

	public static void main(String[] args) {
		
		Rectangle Rectangle = new Rectangle(5,6);
		Rectangle Square = new Rectangle(5,5);
		
		Rectangle.setColor("Blue");
		Square.setColor("Red");
		
		System.out.println("---------------------------");
		System.out.println("");
		
		System.out.println("Square Color       : " +Square.getColor());
		System.out.println("Square Area        : " +Square.calculateArea());
		System.out.println("Square Perimeter   : " +Square.calculatePerimeter());
		
		System.out.println("");
		
		System.out.println("---------------------------");
		
		System.out.println("");
		
		System.out.println("Rectangle Color    : " +Rectangle.getColor());
		System.out.println("Rectangle Area     : " +Rectangle.calculateArea());
		System.out.println("Rectangle Perimeter: " +Rectangle.calculatePerimeter());
		
		System.out.println("");
		
		System.out.println("---------------------------");

		
	}

}
