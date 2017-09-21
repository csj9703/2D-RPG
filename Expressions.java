/**
 *  Practice Coding Challenge 1
 */

public class Expressions 
{
    /**
	 * This method accepts a double and returns its floor value
	 * @param The double to be calculated
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
	 * @return degrees celcius as a double
	 */

	//method 2
	public static double conversion(double num)
	{
		return (((num - 32)*5)/9);
	}
	

    /**
	 * This method checks wether the passed double will be rounded
	 * @param The double being checked
	 * @return True when rounds up, false otherwise
	 */

	//method 3
	public static boolean willRoundUp(double num)
	{
		long wholePart = (long) num;
		double decimalPart = num - wholePart;
		return !(decimalPart < 0.5);
	}
	
    /**
	 * This method sums the digits of passed integer
	 * @param The integer being summed
	 * @return The sum of digits of the integer
	 */

	//method 4
	public static int addDigits(int num)
	{

        // Gets last five digits
        num %= 100000;
        
        return (num / 10000)        // first digit
		     + (num / 1000) % 10    // second digit
		     + (num / 100) % 10     // third digit
		     + (num / 10) % 10      // fourth digit
		     + (num / 1) % 10;      // fifth digit		
	}
}
