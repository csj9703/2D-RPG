/*
 * This class is used to recursively count the 
 * number of vowels in a string
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since November 28, 2017
 */
public class Vowels 
{
	public static int numOfVowels(String aString) 
	{
		int vowelCount = 0;
		if (aString.length() == 0) 
		{
			return 0;
		}
		else if (aString.charAt(0) == 'a' || aString.charAt(0) == 'A' || aString.charAt(0) == 'e' || aString.charAt(0) == 'E'|| 
				 aString.charAt(0) == 'i' || aString.charAt(0) == 'I' || aString.charAt(0) == 'o' || aString.charAt(0) == 'O'|| 
				 aString.charAt(0) == 'u' || aString.charAt(0) == 'U') 
		{
			vowelCount++;
		}
		return vowelCount + numOfVowels(aString.substring(1));
	}
}