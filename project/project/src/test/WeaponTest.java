package test;
import static org.junit.Assert.*;
import org.junit.Test;

import game.Weapon;

public class WeaponTest 
{
	
	/*
	 * Constructor Test using default values for name and weapon damage variables
	 */
	@Test
	public void constructorTest() 
	{
		Weapon wep1 = new Weapon("Default", 3);
		assertEquals("Weapon should be named 'Default'","Default",wep1.getName());
		assertEquals("Weapon should have weapon damage 3",3,wep1.getWeaponDamage());
	}
	
	/*
	 * Testing the getWeaponDamage method, with default name and weapon damage values
	 */
	@Test
	public void test_getWeaponDamage()
  {
    Weapon wep1 = new Weapon("Default", 1);
    assertEquals("Weapon created with weapon damage 1, should show this", 1, wep1.getWeaponDamage());
  }
  
	/*
	 * Constructor Test with negative damage entered, negative damage for weapon 
	 * is not allowed in normal weapon implementation
	 */
	@Test
	public void test_constructor_NegativeDamage()
  {
    Weapon wep1 = new Weapon("Default", -1);
    assertEquals("Weapon shouldn't show -1 as weapon damage",1,wep1.getWeaponDamage());
  }
  
  /*
   * Constructor Test with no damage, this is not allowed for a normal functioning weapon
   */
	@Test
	public void test_constructor_ZeroDamage()
  {
    Weapon wep1 = new Weapon("Default", 0);
    assertEquals("Weapon shouldn't show 0 as weapon damage",1,wep1.getWeaponDamage());
  }
}