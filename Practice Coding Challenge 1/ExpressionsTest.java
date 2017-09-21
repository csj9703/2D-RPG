import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExpressionsTest {
	String filename = "Expressions.java";

	private boolean containsImportStatement() {
		boolean containsImport = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !containsImport) {
				if (line.matches("import+\\s.*")) {
					containsImport = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return containsImport;
	}
	
	/**
	Checks if the specified library is used anywhere in the code tested.  It checks
	for the word exactly.  If there is a variable name that contains the library name,
	this will result in a false positive.
	*/
	private boolean usesLibrary(String libraryName) {
		boolean usesLibrary = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesLibrary) {
				if (line.contains(libraryName)) {
					usesLibrary = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return usesLibrary;	
	}
	
	/**
		Checks if the coding construct is used in the class we're testing.  It expects the 
		construct to be preceded and followed by white space or parenthesis.
	*/
	private boolean usesConstruct(String constructName) {
		boolean usesConstruct = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesConstruct) {
				if (line.matches(".*\\s+if+[\\s+,(].*")) {
					usesConstruct = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return usesConstruct;	
	}
		
	@Test
	public void test_floor_3_5() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		long expected = 3;
		long actual = Expressions.floor(3.5);
		
		assertEquals("Floor of 3.5", expected, actual);
	}
	
	@Test
	public void test_floor_0_01() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		long expected = 0;
		long actual = Expressions.floor(0.01);
		
		assertEquals("Floor of 0.01", expected, actual);
	}
	
	@Test
	public void test_conversion_32() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		double expected = 0;
		double actual = Expressions.conversion(32.0);
		
		assertEquals("Converting from 32 F", expected, actual, 0.0001);
	}
	
	@Test
	public void test_conversion_0() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		double expected = -17.77778;
		double actual = Expressions.conversion(0.0);
		
		assertEquals("Converting from 0 F", expected, actual, 0.0001);
	}
	
	@Test
	public void test_conversion_96() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		double expected = 35.55556;
		double actual = Expressions.conversion(96.0);
		
		assertEquals("Converting from 96 F", expected, actual, 0.0001);
	}
	
	@Test
	public void test_conversion_69_8() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		double expected = 21.0;
		double actual = Expressions.conversion(69.8);
		
		assertEquals("Converting from 69.8 F", expected, actual, 0.0001);
	}
	
	@Test
	public void test_conversion_minus20() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		double expected = -28.8889;
		double actual = Expressions.conversion(-20.0);
		
		assertEquals("Converting from -20.0 F", expected, actual, 0.0001);
	}
	
	@Test
	public void test_willRoundUp_0() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		boolean expected = false;
		boolean actual = Expressions.willRoundUp(0.0);
		
		assertEquals("0.0 does not round up", expected, actual);
	}
	
	@Test
	public void test_willRoundUp_0_5() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		boolean expected = true;
		boolean actual = Expressions.willRoundUp(0.5);
		
		assertEquals("Testing 0.5", expected, actual);
	}
	
	@Test
	public void test_willRoundUp_0_4999999() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		boolean expected = false;
		boolean actual = Expressions.willRoundUp(0.4999999);
		
		assertEquals("testing 0.4999999", expected, actual);
	}
	
	@Test
	public void test_willRoundUp_1_0() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		boolean expected = false;
		boolean actual = Expressions.willRoundUp(1.0);
		
		assertEquals("testing 1.0", expected, actual);
	}
	
	@Test
	public void test_willRoundUp_23_674() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		boolean expected = true;
		boolean actual = Expressions.willRoundUp(23.674);
		
		assertEquals("testing 23.674", expected, actual);
	}
	
	@Test
	public void test_addDigits_12345() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 15;
		int actual = Expressions.addDigits(12345);
		
		assertEquals("testing 12345", expected, actual);
	}
	
	@Test
	public void test_addDigits_00000() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 0;
		int actual = Expressions.addDigits(0);
		
		assertEquals("testing 00000", expected, actual);
	}

	@Test
	public void test_addDigits_98765() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 35;
		int actual = Expressions.addDigits(98765);
		
		assertEquals("testing 98765", expected, actual);
	}
	
	@Test
	public void test_addDigits_10000() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 1;
		int actual = Expressions.addDigits(10000);
		
		assertEquals("testing 98765", expected, actual);
	}

	@Test
	public void test_addDigits_911111() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 5;
		int actual = Expressions.addDigits(911111);
		
		assertEquals("testing 911111 (note six digits)", expected, actual);
	}


}
