package test;
import static org.junit.Assert.*;
import org.junit.Test;

import game.Potion;
/*
 * This class contains the unit test for Potion.java
 */
public class PotionTest 
{
	/*
	 * Constructor Test default with default name and healing amounts entered
	 */
	@Test
	public void constructorTest() 
	{
		Potion pot1 = new Potion("Default", 10);
		assertEquals("Potion should be named 'Default'", "Default", pot1.getName());
		assertEquals("Potion should have healing amount 10", 10, pot1.getHealingAmount());
	}
	/*
	 * Testing the getHealingAmount method using default values for healing and name
	 */
	@Test
	public void test_getHealingAmount()
	{
		Potion pot1 = new Potion("Default", 5);
		assertEquals("Potion created with healing amount 5, should show this", 5, pot1.getHealingAmount());
    }
	/*
	 * Constructor Test with negative value as healing amount, this is not allowed
	 * for a normal functioning healing amount
	 */
	@Test
	public void test_constructor_NegativeHealing()
	{
		Potion pot1 = new Potion("Default", -10);
		assertEquals("Potion shouldn't show -10 as healing amount", 3, pot1.getHealingAmount());
	}
	/*
	 * Constructor Test with 0 for healing value, this is not allowed for a normal
	 * functioning healing amount
	 */
	@Test
	public void test_constructor_ZeroHealing()
	{
		Potion pot1 = new Potion("Default", 0);
		assertEquals("Potion shouldn't show 0 as healing amount", 3, pot1.getHealingAmount());
	}
	/*
	 * Testing to ensure the copy constructor properly copies the name
	 */
	@Test
	public void test_copy_constructor_name()
	{
		Potion pot1 = new Potion("Small Potion", 3);
		Potion pot2 = new Potion(pot1);
		assertEquals("Potion name should be the same", pot1.getName(), pot2.getName());
	}
	/*
	 * Testing to ensure the copy constructor properly copies the healing amount
	 */
	@Test
	public void test_copy_constructor_healingAmount()
	{
		Potion pot1 = new Potion("Small Potion", 3);
		Potion pot2 = new Potion(pot1);
		assertEquals("Potion healing amounts should be the same", pot1.getHealingAmount(), pot2.getHealingAmount());
	}
}