package game.math;

public class NotInRangeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private double val;
	
	public NotInRangeException(double value) {
		val = value;
	}
	
	@Override
	public String toString() {
		return "Value MUST be between 0 and 1: " + val;
	}

}
