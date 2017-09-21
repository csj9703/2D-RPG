import static org.junit.Assert.*;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

public class ChangeTest {

	@Test
	public void test_Toonies_multiple_oddHunderdCents() {
		// Test setup
		int changeNeeded = 591;
		int expectedNumOfToonies = 2;

		//Run the test
		int actualNumOfToonies = Change.getNumOfToonies(changeNeeded);
		
		//Verify results

		assertEquals("Toonies test for " + changeNeeded + " change needed", expectedNumOfToonies, actualNumOfToonies);
	}
		
	@Test
	public void test_Toonies_multiple_evenHunderdCents() {
		// Test setup
		int changeNeeded = 1091;
		int expectedNumOfToonies = 5;

		//Run the test
		int actualNumOfToonies = Change.getNumOfToonies(changeNeeded);
		
		//Verify results

		assertEquals("Toonies test for " + changeNeeded + " change needed", expectedNumOfToonies, actualNumOfToonies);
	}
		
	@Test
	public void test_Toonies_one_3xx() {
		// Test setup
		int changeNeeded = 352;
		int expectedNumOfToonies = 1;

		//Run the test
		int actualNumOfToonies = Change.getNumOfToonies(changeNeeded);
		
		//Verify results

		assertEquals("Toonies test for " + changeNeeded + " change needed", expectedNumOfToonies, actualNumOfToonies);
	}
		
	@Test
	public void test_Toonies_one_2xx() {
		// Test setup
		int changeNeeded = 200;
		int expectedNumOfToonies = 1;

		//Run the test
		int actualNumOfToonies = Change.getNumOfToonies(changeNeeded);
		
		//Verify results

		assertEquals("Toonies test for " + changeNeeded + " change needed", expectedNumOfToonies, actualNumOfToonies);
	}
		
	@Test
	public void test_Toonies_zero_max() {
		// Test setup
		int changeNeeded = 199;
		int expectedNumOfToonies = 0;

		//Run the test
		int actualNumOfToonies = Change.getNumOfToonies(changeNeeded);
		
		//Verify results

		assertEquals("Toonies test for " + changeNeeded + " change needed", expectedNumOfToonies, actualNumOfToonies);
	}
		
		
	@Test
	public void test_Toonies_zero_min() {
		// Test setup
		int changeNeeded = 0;
		int expectedNumOfToonies = 0;

		//Run the test
		int actualNumOfToonies = Change.getNumOfToonies(changeNeeded);
		
		//Verify results

		assertEquals("Toonies test for " + changeNeeded + " change needed", expectedNumOfToonies, actualNumOfToonies);
	}
		
	@Test
	public void test_Loonies_one_3xx() {
		// Test setup
		int changeNeeded = 399;
		int expectedNumOfLoonies = 1;
		
		// run the test
		int actualNumOfLoonies = Change.getNumOfLoonies(changeNeeded);
		
		// verify the result
		assertEquals("Loonies test for " + changeNeeded + " change needed", expectedNumOfLoonies, actualNumOfLoonies);
	}

	@Test
	public void test_Loonies_one_1xx() {
		// Test setup
		int changeNeeded = 131;
		int expectedNumOfLoonies = 1;
		
		// run the test
		int actualNumOfLoonies = Change.getNumOfLoonies(changeNeeded);
		
		// verify the result
		assertEquals("Loonies test for " + changeNeeded + " change needed", expectedNumOfLoonies, actualNumOfLoonies);
	}

	@Test
	public void test_Loonies_zero_moreThan100() {
		// Test setup
		int changeNeeded = 660;
		int expectedNumOfLoonies = 0;
		
		// run the test
		int actualNumOfLoonies = Change.getNumOfLoonies(changeNeeded);
		
		// verify the result
		assertEquals("Loonies test for " + changeNeeded + " change needed", expectedNumOfLoonies, actualNumOfLoonies);
	}
	
	@Test
	public void test_Loonies_zero_lessThan100() {
		// Test setup
		int changeNeeded = 80;
		int expectedNumOfLoonies = 0;
		
		// run the test
		int actualNumOfLoonies = Change.getNumOfLoonies(changeNeeded);
		
		// verify the result
		assertEquals("Loonies test for " + changeNeeded + " change needed", expectedNumOfLoonies, actualNumOfLoonies);
	}

	@Test
	public void test_Quarters_three_greaterThan100() {
		// Test setup
		int changeNeeded = 191;
		int expectedNumOfQuarters = 3;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}

	@Test
	public void test_Quarters_three_lessThan100() {
		// Test setup
		int changeNeeded = 76;
		int expectedNumOfQuarters = 3;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}
	
	@Test
	public void test_Quarters_two_greaterThan100() {
		// Test setup
		int changeNeeded = 12451;
		int expectedNumOfQuarters = 2;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}

	@Test
	public void test_Quarters_two_lessThan100() {
		// Test setup
		int changeNeeded = 74;
		int expectedNumOfQuarters = 2;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}

	@Test
	public void test_Quarters_one_greaterThan100() {
		// Test setup
		int changeNeeded = 125;
		int expectedNumOfQuarters = 1;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}
	
	@Test
	public void test_Quarters_one_lessThan100() {
		// Test setup
		int changeNeeded = 42;
		int expectedNumOfQuarters = 1;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}
	
	@Test
	public void test_Quarters_zero_greaterThan100() {
		// Test setup
		int changeNeeded = 110;
		int expectedNumOfQuarters = 0;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}
	
	@Test
	public void test_Quarters_zero_lessThan100() {
		// Test setup
		int changeNeeded = 15;
		int expectedNumOfQuarters = 0;

		// run the test
		int actualNumOfQuarters = Change.getNumOfQuarters(changeNeeded);

		// verify the result
		assertEquals("Quarters test for " + changeNeeded + " change needed", expectedNumOfQuarters, actualNumOfQuarters);
	}


	@Test
	public void test_Dimes_two_moreThan25() {
		// Test setup
		int changeNeeded = 70;
		int expectedNumOfDimes = 2;
		
		// run the test
		int actualNumOfDimes = Change.getNumOfDimes(changeNeeded);
		
		// verify result
		assertEquals("Dimes test for " + changeNeeded + " change needed", expectedNumOfDimes, actualNumOfDimes);	
	}
		
	@Test
	public void test_Dimes_two_lessThan25() {
		// Test setup
		int changeNeeded = 24;
		int expectedNumOfDimes = 2;
		
		// run the test
		int actualNumOfDimes = Change.getNumOfDimes(changeNeeded);
		
		// verify result
		assertEquals("Dimes test for " + changeNeeded + " change needed", expectedNumOfDimes, actualNumOfDimes);	
	}
	
	@Test
	public void test_Dimes_one_moreThan25() {
		// Test setup
		int changeNeeded = 36;
		int expectedNumOfDimes = 1;
		
		// run the test
		int actualNumOfDimes = Change.getNumOfDimes(changeNeeded);
		
		// verify result
		assertEquals("Dimes test for " + changeNeeded + " change needed", expectedNumOfDimes, actualNumOfDimes);	
	}
			
	@Test
	public void test_Dimes_one_lessThan25() {
		// Test setup
		int changeNeeded = 14;
		int expectedNumOfDimes = 1;
		
		// run the test
		int actualNumOfDimes = Change.getNumOfDimes(changeNeeded);
		
		// verify result
		assertEquals("Dimes test for " + changeNeeded + " change needed", expectedNumOfDimes, actualNumOfDimes);	
	}
		
	@Test
	public void test_Dimes_zero_moreThan25() {
		// Test setup
		int changeNeeded = 55;
		int expectedNumOfDimes = 0;
		
		// run the test
		int actualNumOfDimes = Change.getNumOfDimes(changeNeeded);
		
		// verify result
		assertEquals("Dimes test for " + changeNeeded + " change needed", expectedNumOfDimes, actualNumOfDimes);	
	}
	
	@Test
	public void test_Dimes_zero_lessThan25() {
		// Test setup
		int changeNeeded = 0;
		int expectedNumOfDimes = 0;
		
		// run the test
		int actualNumOfDimes = Change.getNumOfDimes(changeNeeded);
		
		// verify result
		assertEquals("Dimes test for " + changeNeeded + " change needed", expectedNumOfDimes, actualNumOfDimes);	
	}
		
	@Test
	public void test_Nickels_one_moreThan10() {
		// Test setup
		int changeNeeded = 234;
		int expectedNumOfNickels = 1;

		// run the test
		int actualNumOfNickels = Change.getNumOfNickels(changeNeeded);

		// verify the result
		assertEquals("Nickels test for " + changeNeeded + " change needed", expectedNumOfNickels, actualNumOfNickels);

	}

	@Test
	public void test_Nickels_one_lessThan10() {
		// Test setup
		int changeNeeded = 8;
		int expectedNumOfNickels = 1;

		// run the test
		int actualNumOfNickels = Change.getNumOfNickels(changeNeeded);

		// verify the result
		assertEquals("Nickels test for " + changeNeeded + " change needed", expectedNumOfNickels, actualNumOfNickels);

	}
	
	@Test
	public void test_Nickels_zero_moreThan10() {
		// Test setup
		int changeNeeded = 125;
		int expectedNumOfNickels = 0;

		// run the test
		int actualNumOfNickels = Change.getNumOfNickels(changeNeeded);

		// verify the result
		assertEquals("Nickels test for " + changeNeeded + " change needed", expectedNumOfNickels, actualNumOfNickels);

	}

	@Test
	public void test_Nickels_zero_lessThan10() {
		// Test setup
		int changeNeeded = 3;
		int expectedNumOfNickels = 0;

		// run the test
		int actualNumOfNickels = Change.getNumOfNickels(changeNeeded);

		// verify the result
		assertEquals("Nickels test for " + changeNeeded + " change needed", expectedNumOfNickels, actualNumOfNickels);

	}

	@Test
	public void test_Pennies_four_moreThan5() {
		// Test setup
		int changeNeeded = 1234;
		int expectedNumOfPennies = 4;

		int actualNumOfPennies = Change.getNumOfPennies(changeNeeded);
		
		assertEquals("Pennies test for " + changeNeeded + " change needed", expectedNumOfPennies, actualNumOfPennies);
	}

	@Test
	public void test_Pennies_three_lessThan5() {
		// Test setup
		int changeNeeded = 3;
		int expectedNumOfPennies = 3;

		int actualNumOfPennies = Change.getNumOfPennies(changeNeeded);
		
		assertEquals("Pennies test for " + changeNeeded + " change needed", expectedNumOfPennies, actualNumOfPennies);
	}

	@Test
	public void test_Pennies_zero_noChangeNeeded() {
		// Test setup
		int changeNeeded = 0;
		int expectedNumOfPennies = 0;

		int actualNumOfPennies = Change.getNumOfPennies(changeNeeded);
		
		assertEquals("Pennies test for " + changeNeeded + " change needed", expectedNumOfPennies, actualNumOfPennies);
	}

	@Test
	public void test_Pennies_zero_comeChangeNeeded() {
		// Test setup
		int changeNeeded = 290;
		int expectedNumOfPennies = 0;

		int actualNumOfPennies = Change.getNumOfPennies(changeNeeded);
		
		assertEquals("Pennies test for " + changeNeeded + " change needed", expectedNumOfPennies, actualNumOfPennies);
	}

}
