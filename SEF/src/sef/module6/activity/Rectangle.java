package sef.module6.activity;

public class Rectangle extends Shape {
		
	private double length;
	private double breadth;
		
	// default constructor
		public Rectangle(){
			System.out.println("I am a default Rectangle Constructor");
			System.out.println("Please provide values, f.i. Rectangle(5,6)" + " to calculate Area and Perimeter.");
		}
		
	// parameterized constructor
		
		public Rectangle(double length, double breadth){
			this.length = length;
			this.breadth = breadth;
		}
		
	// methods
		
		public double calculateArea(){
			return length*breadth;
		}
		
		public double calculatePerimeter(){
			return 2*(length+breadth);
		}
		

}
