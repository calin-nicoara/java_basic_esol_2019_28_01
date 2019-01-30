package curs.shapes;

public abstract class Polygon {
	private int numberOfSides;
	
	public Polygon(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	
	public int getNumberOfSides() {
		return numberOfSides;
	}
	
	public abstract int getPerimiter();
}
