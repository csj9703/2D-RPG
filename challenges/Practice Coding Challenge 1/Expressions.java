/*
 *  Practice Coding Challenge 1
 */

public class Expressions 
{
    /**
	 * This method accepts a number and returns its floor value
	 * @param num The double to be calculated
	 * @return The floor value as a long
	 */

	//method 1
	public static long floor(double num)
	{
		return (long)num; 
	}


    /**
	 * This method converts fahrenheit to celcius
	 * @param The fahrenheit value as a double to be converted
	 * @return Degrees celcius as a double
	 */

	//method 2
	public static double conversion(double num)
	{
		return ((num - 32)*5)/9;
	}
	

    /**
	 * This method checks whether the passed number will be rounded up
	 * @param The double being checked
	 * @return True when rounds up, false otherwise
	 */

	//method 3
	public static boolean willRoundUp(double num)
	{
		return !(num - (long) num < 0.5);
	}
	
    /**
	 * This method sums the last five digits of an integer
	 * @param The integer being summed
	 * @return The sum of digits of the integer
	 */

	//method 4
	public static int addDigits(int num)
	{
        num %= 100000;         // gets last five digits
        return (num / 10000)   // first digit
		+ (num / 1000) % 10    // second digit
		+ (num / 100) % 10     // third digit
		+ (num / 10) % 10      // fourth digit
		+ (num / 1) % 10;      // fifth digit		
	}
}
