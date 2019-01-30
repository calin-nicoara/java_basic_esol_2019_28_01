package curs.shapes;

public class Rectangle extends Polygon{
	private int[] sides = new int[4];
	
	public Rectangle(int... sides) {
		super(4);
		
		if(sides.length < 4) {
			throw new NotEnoughSidesException("We need more sides!");
		}
		
		for(int i = 0; i < 4; i++) {
			this.sides[i] = sides[i];
		}
	}
	
	@Override
	public int getPerimiter() {
		return sides[0] + sides[1] + sides[2] + sides[3];
	}
}
