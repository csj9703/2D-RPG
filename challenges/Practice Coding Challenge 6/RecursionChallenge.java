public class RecursionChallenge 
{	
	public static int countNumDigits(int number)
	{
		if (number < 10 && number > -10)
			return 1;
		else
			return 1 + countNumDigits(number/10);
	}
}