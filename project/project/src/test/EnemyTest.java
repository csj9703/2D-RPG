package test;

import static org.junit.Assert.*;
import game.*;
import org.junit.Test;
/*
 * This class contains the unit test for Enemy.java
 */
public class EnemyTest
{
  /*
   * Tests the setName method inherited from the GameObject class. Should return "Slime" after then name is changed from 
   * Monster to Slime. 	
   */
  @Test
  public void test_setName_Slime()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setName("Slime");
    assertEquals("Enemy name should be \'Slime\'", "Slime", e1.getName());
  }
  /*
   * The series of tests for the setHealth method inherited from the Character class. Any integer values should be 
   * accepted as the new health, and therefore should return that value which was set as using the method.   
   */
  @Test
  public void test_setHealth_Positive()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(1);
    assertEquals("Enemy health should be 1", 1, e1.getHealth());
  }

  @Test
  public void test_setHealth_Negative()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(-1);
    assertEquals("Enemy health should be -1", -1, e1.getHealth());
  }

  @Test
  public void test_setHealth_Zero()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(0);
    assertEquals("Enemy health should be 0", 0, e1.getHealth());
  }
  /*
   * Testing the setAttack method inherited from the Character class. Negative integer values or zero is not accepted as 
   * a valid attack value, so is expecting the default value of 1. Any positive integer values are accepted as a valid
   * attack value. 
   */
  @Test
  public void test_setAttack_InvalidNegative()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setAttack(-1);
    assertEquals("Negative value passed as enemy attack, should be the value 1", 1, e1.getAttack());
  }

  @Test
  public void test_setAttack_InvalidZero()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setAttack(0);
    assertEquals("Zero passed as enemy attack, should be the default value 1", 1, e1.getAttack());
  }

  @Test
  public void test_setAttack_Valid()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setAttack(5);
    assertEquals("Enemy attack should be 5", 5, e1.getAttack());
  }
  
  /*
   * Testing the inherited isAlive method from the Character class. Negative or Zero health indicates that the enemy is
   * dead, and should return false. Positive health should return true. 
   */
  @Test
  public void test_isAlive_HealthZero()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(0);
    assertEquals("Enemy health is 0, so should be dead",false,e1.isAlive());
  }

  @Test
  public void test_isAlive_HealthNegative()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(-1);
    assertEquals("Enemy health is -1, so should be dead",false,e1.isAlive());
  }

  @Test
  public void test_isAlive_HealthPositive()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(5);
    assertEquals("Enemy health is 5, so should be alive",true,e1.isAlive());
  }
  /*
   * Testing the getExperience method from Enemy class. The method should return the correct enemy experience values,
   * which cannot be zero or negative. In this case, the getter method should return 1 as a default value. 
   */
  @Test
  public void test_getExperience_ValidPositiveValue()
  {
    Enemy e1 = new Enemy("Monster", 10,10,10);
    assertEquals("Enemy created with experience passed in as 10, so should return 10", 10, e1.getExperience());
  }
  
  @Test
  public void test_getExperience_ValidZeroValue()
  {
    Enemy e1 = new Enemy("Monster", 10,10,0);
    assertEquals("Enemy created with experience passed in as 0, should return default value of 1", 1, e1.getExperience());
  }

  @Test
  public void test_getExperience_InvalidValue()
  {
    Enemy e1 = new Enemy("Monster", 10,10,-1);
    assertEquals("Enemy experience cannot be negative, experience should be 1", 1, e1.getExperience());
  }
  /*
   * Testing the constructor of the Enemy class, more specifically whether the constructor can correctly assign 
   * instance variables when valid and invalid values are passed into the argument. The invalid and valid values are 
   * same as the setter methods for each instance variable, and should handle the passing of an invalid value just like
   * the setter methods.
   */
  @Test
  public void test_constructor_Name()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy with name \'Monster\' created","Monster",e1.getName());
  }

  @Test
  public void test_constructor_NegativeHealth()
  {
    Enemy e1 = new Enemy("Monster",-10,10,10);
    assertEquals("Enemy with -10 passed as health value, expecting value of -10",-10,e1.getHealth()); //
  }

  @Test
  public void test_constructor_ZeroHealth()
  {
    Enemy e1 = new Enemy("Monster",0,10,10);
    assertEquals("Enemy with 0 passed as health value, expecting value of 0",0,e1.getHealth()); //
  }

  @Test
  public void test_constructor_ValidPositiveHealth()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy health should be 10",10,e1.getHealth());
  }

  @Test
  public void test_constructor_InvalidNegativeAttackValue()
  {
    Enemy e1 = new Enemy("Monster",10,-10,10);
    assertEquals("Enemy created with -10 as attack value, but expecting default value of 1",1,e1.getAttack());
  }

  @Test
  public void test_constructor_ValidAttackValue()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy attack should be 10",10,e1.getAttack()); 
  }

  @Test
  public void test_constructor_InvalidNegativeExperience()
  {
    Enemy e1 = new Enemy("Monster",10,10,-10);
    assertEquals("Enemy created with -10 as experience value, but expected default value of 1",1,e1.getExperience());
  }

  @Test
  public void test_constructor_ValidExperience()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy created with 10 as experience value",10,e1.getExperience());
  }
  /*
   * Testing the overridden attack method from the Enemy class. If the constructor for the class, the setHealth method
   * and the attack method is written correctly, it should return the player's health as 5.   
   */
  @Test
  public void test_attack_Default()
  {
    Enemy e1 = new Enemy("Monster",10,5,10);
    Player p1 = new Player("Hero",10,5);
    e1.attack(p1);
    assertEquals("Player with 10 health attacked by Enemy with 5 attack, Player health should decrease after enemy attacks", 5, p1.getHealth());
  }
  /*
   * Testing the getDamage method from the Enemy class for the correct damage value after the attack method is called.    
   */
  @Test
  public void test_getDamage()
  {
    Enemy e1 = new Enemy("Monster",10,5,10);
    Player p1 = new Player("Hero",10,5);
    e1.attack(p1);
    assertEquals("Enemy had attack value of 5 when attacking Player, so should return 5 as damage", 5, e1.getDamage());
  }
}