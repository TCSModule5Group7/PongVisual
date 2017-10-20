package game.math;

public class NormalizedPosition {

	private double x, y;

	public NormalizedPosition(double x, double y) throws NotInRangeException {
		if (!setX(x)) {
			throw new NotInRangeException(x);
		}
		if (!setY(y)) {
			throw new NotInRangeException(y);
		}
	}

	public NormalizedPosition() {
		set(0, 0);
	}

	public double getX() {
		return x;
	}

	public boolean setX(double x) {
		if (isValid(x)) {
			this.x = x;
			return true;
		}
		return false;
	}

	public double getY() {
		return y;
	}

	public boolean setY(double y) {
		if (isValid(y)) {
			this.y = y;
			return true;
		}
		return false;
	}

	public boolean set(double x, double y) {
		return setX(x) && setY(y);
	}

	public boolean update(double dx, double dy) {
		return setX(x + dx) && setY(y + dy);
	}

	private boolean isValid(double n) {
		return 0 <= n && n <= 1;
	}

}
