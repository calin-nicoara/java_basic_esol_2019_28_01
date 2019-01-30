package curs.collection;


public class Box<T> {
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T newValue) {
		value = newValue;
	}
}
