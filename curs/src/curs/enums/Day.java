package curs.enums;

public enum Day {
	MONDAY(0) {
		@Override
		public int daysTillWeekend() {
			return 6;
		}
	}, 
	TUESDAY(1), 
	WEDNESDAY(2), 
	THURSDAY(3),
	FRIDAY(4), 
	SATURDAY(5),
	SUNDAY(6);
	
	final private int numberOfDay;
	Day(int numberOfDay) {
		this.numberOfDay = numberOfDay;
	}
	
	public int getNumberOfDay() {
		return this.numberOfDay;
	}
	
	public int daysTillWeekend() {
		return -1;
	};
}
