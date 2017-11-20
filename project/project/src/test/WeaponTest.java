package test;
import static org.junit.Assert.*;
import org.junit.Test;

import game.Weapon;

public class WeaponTest 
{
	
	//Constructor Test default name and damage
	@Test
	public void constructorTest() 
	{
		Weapon wep1 = new Weapon("Default", 3);
		assertEquals("Weapon should be named 'Default'","Default",wep1.getName());
		assertEquals("Weapon should have weapon damage 3",3,wep1.getWeaponDamage());
	}
	
	//getWeaponDamage test
	@Test
	public void test_getWeaponDamage()
  {
    Weapon wep1 = new Weapon("Default", 1);
    assertEquals("Weapon created with weapon damage 1, should show this", 1, wep1.getWeaponDamage());
  }
  
	//Constructor Test with negative damage, 
	//this is allowed but wouldn't be used unless implementing an enemy-healing weapon
	@Test
	public void test_constructor_NegativeDamage()
  {
    Weapon wep1 = new Weapon("Default", -1);
    assertEquals("Weapon shouldn't show -1 as weapon damage",1,wep1.getWeaponDamage());
  }
  
  //Constructor Test with no damage, allowed for a broken weapon perhaps
	@Test
	public void test_constructor_ZeroDamage()
  {
    Weapon wep1 = new Weapon("Default", 0);
    assertEquals("Weapon shouldn't show 0 as weapon damage",1,wep1.getWeaponDamage());
  }
}