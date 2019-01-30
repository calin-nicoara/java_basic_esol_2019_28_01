package curs.shapes;

public class Triangle extends Polygon{
	private int[] sides;
	
	public Triangle(int... sides) {
		super(3);
		this.sides = new int[3];
		
		for(int i = 0; i < 3; i++) {
			this.sides[i] = sides[i];
		}
	}
	
	@Override
	public int getPerimiter() {
		return sides[0] + sides[1] + sides[2];
	}
}
