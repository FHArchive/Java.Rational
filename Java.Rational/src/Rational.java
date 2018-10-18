/**
 * @date 18/10/2018
 * @author Kieran
 *
 */
public class Rational implements Comparable<Rational> {
	/**
	 * 
	 */
	private int num;
	private int denom;

	/**
	 * 
	 */
	public Rational() {
	}

	/**
	 * 
	 * @param num
	 * @param denom
	 */
	public Rational(int num, int denom) {
		setNum(num);
		try {
			setDenom(denom);
		} catch (DivideByZeroException e) {
			System.err.println("DivideByZeroException: " + toString() + "\n");
		}
	}

	/**
	 * This function sets the numerator
	 * 
	 * @param num
	 * @return [none]
	 */
	void setNum(int num) {
		this.num = num;
	}

	/**
	 * This function returns the numerator
	 * 
	 * @param [none]
	 * @return num
	 */
	int getNum() {
		return this.num;
	}

	/**
	 * This function sets the denominator and throws an exception if the
	 * denominator is set to 0. Also, if the denominator is negative, the
	 * fraction is multiplied by -1/-1
	 * 
	 * @param num
	 * @return [none]
	 */
	void setDenom(int denom) throws DivideByZeroException {
		if (denom == 0) {
			throw new DivideByZeroException();
		} else if (denom < 0) {
			this.denom = denom * -1;
			this.num = this.num * -1;
		} else {
			this.denom = denom;
		}
	}

	/**
	 * This function returns the denominator
	 * 
	 * @param [none]
	 * @return denom
	 */
	int getDenom() {
		return this.denom;
	}

	/**
	 * This function performs addition on the current Rational and another (rhs)
	 * and returns the result as a new Rational
	 * 
	 * @param rhs
	 * @return Rational
	 */
	public Rational add(Rational rhs) {
		return new Rational(num * rhs.denom + rhs.num * denom, denom * rhs.denom);
	}

	/**
	 * This function performs subtraction on the current Rational and another
	 * (this - rhs) and returns the result as a new Rational
	 * 
	 * @param rhs
	 * @return Rational
	 */
	public Rational subtract(Rational rhs) {
		return new Rational(num * rhs.denom - rhs.num * denom, denom * rhs.denom);
	}

	/**
	 * This function performs multiplication on the current Rational and another
	 * (rhs) and returns the result as a new Rational
	 * 
	 * @param rhs
	 * @return Rational
	 */
	public Rational multiply(Rational rhs) {
		return new Rational(num * rhs.num, denom * rhs.denom);
	}

	/**
	 * This function performs division on the current Rational and another
	 * (this/rhs) and returns the result as a new Rational
	 * 
	 * @param rhs
	 * @return Rational
	 */
	public Rational divide(Rational rhs) {
		return new Rational(num * rhs.denom, denom * rhs.num);
	}

	/**
	 * The toString is called when the Rational is printed. It is printed in the
	 * form num/denom
	 */
	public String toString() {
		return (num + "/" + denom);
	}

	/**
	 * The compareTo function returns -1 if this < rhs, 0 if this = rhs and 1 if
	 * this > rhs
	 * 
	 * @param rhs
	 * @return compare
	 */
	public int compareTo(Rational rhs) {
		double thisNum = (double) this.num;
		double rhsNum = (double) rhs.num;
		double thisVal = thisNum / this.denom;
		double rhsVal = rhsNum / rhs.denom;

		if (thisVal < rhsVal) {
			return -1;
		} else if (thisVal > rhsVal) {
			return 1;
		} else {
			return 0;
		}

	}

	/**
	 * gcd calculates the greatest common denominator for a fraction, for
	 * example 2/4 would return 2
	 * 
	 * @param num
	 * @param denom
	 * @return greatestCommonDenominator
	 */
	private int gcd(int num, int denom) {
		// Make positive
		if (num < 0) {
			num *= -1;
		}
		if (denom < 0) {
			denom *= -1;
		}

		if (num == denom) {
			return num;
		} else if (num > denom) {
			return gcd(num - denom, denom);
		} else {
			return gcd(denom - num, num);
		}

	}

	/**
	 * simplify uses gcd to return a update the reational with a simplified
	 * form, for example 2/4 would return 1/2
	 */
	public void simplify() {
		int gcd = gcd(this.num, this.denom);
		this.num /= gcd;
		this.denom /= gcd;
	}

	/**
	 * This functions tests that this and rhs are logically equal
	 * 
	 * @param rhs
	 * @return boolean-equals
	 */
	public boolean equals(Object rhs) {
		if (this == rhs) {
			return true;
		}
		if (!(rhs instanceof Rational)) {
			return false;
		}
		Rational r = (Rational) rhs;
		return num == r.num && denom == r.denom;
	}

	/**
	 * This function generates a hash code from the numerator and denominator so
	 * two logically equal Rationals will have the same hash
	 * 
	 * @return result
	 */
	public int hashCode() {
		int result = 17;
		result = 31 * result + num;
		result = 31 * result + denom;
		return result;
	}

}
