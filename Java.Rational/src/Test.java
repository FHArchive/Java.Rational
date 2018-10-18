/**
 * @date 18/10/2018
 * @author Kieran
 *
 */
public class Test {

	public static void main(String[] args) {
		/*
		 * Initialise Rationals
		 * 
		 * r1 = 1/2, r2 = 3/4, r3 = 1/-2, r4 = 1/0, r5 = 1/2
		 */
		System.out.println("Initialising Rationals");
		Rational r1 = new Rational(1, 2);
		Rational r2 = new Rational(3, 4);
		Rational r3 = new Rational(1, -2);
		Rational r5 = new Rational(1, 2);
		Rational r6 = new Rational(10, 12);
		Rational ans = new Rational();

		/*
		 * Output the values of each rational
		 */
		System.out.println("\nThe values of each rational are:");
		System.out.println("r1: (1, 2): 1/2 = " + r1);
		System.out.println("r2: (3, 4): 3/4 = " + r2);
		System.out.println("r3: (1, -2): 1/-2 = " + r3);
		System.out.println("r5: (1, 2): 1/2 = " + r5);
		System.out.println("r6: (10, 12): 10/12 = " + r6);

		/*
		 * Output if r1 is equal to itself and print the hash code of r1
		 */
		boolean result = r1.equals(r1);
		System.out.println("\nr1 is equal to itself? " + result);
		System.out.println("The hashcode of r1 is: " + r1.hashCode());

		/*
		 * Calculate and output the results of various functions on rationals r1
		 * and r2
		 */
		System.out.println("\nThe results of various functions on rationals r1 and r2:");
		ans = r1.add(r2);
		System.out.println(r1 + " + " + r2 + " = " + ans);
		System.out.print("Simplify " + ans + " = ");
		ans.simplify();
		System.out.println(ans);
		ans = r1.subtract(r2);
		System.out.println(r1 + " - " + r2 + " = " + ans);
		ans = r1.multiply(r2);
		System.out.println(r1 + " * " + r2 + " = " + ans);
		ans = r1.divide(r2);
		System.out.println(r1 + " / " + r2 + " = " + ans);

		/*
		 * Calculate and output the results of addition on rationals r3
		 * and r1
		 */
		System.out.println("\nThe result of r3 add r1:");
		ans = r3.add(r1);
		System.out.println(r3 + " + " + r1 + " = " + ans);
		
		/*
		 * Simplify and output the results of r6
		 */
		System.out.print("Simplify " + r6 + " = ");
		r6.simplify();
		System.out.println(r6);

		System.out.println("\n");

	}

}
