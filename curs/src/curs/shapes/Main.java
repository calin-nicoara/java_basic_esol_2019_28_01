package curs.shapes;

public class Main {

	public static void main(String[] args) {
		Polygon triangle = new Triangle(1, 4, 5);
		Triangle triangle2 = new Triangle(1, 4, 9);
	
		
		System.out.println(triangle.getPerimiter());
		
		Polygon square = new Rectangle(4, 4, 4, 4);
		System.out.println(square.getPerimiter());
		
		new Rectangle(2, 3, 4);
	}

}
