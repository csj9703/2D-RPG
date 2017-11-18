package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class EnemyTest
{
  @Test
  public void test_setName()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setName("Slime");
    assertEquals("Enemy name should be \'Slime\'", "Slime", e1.getName());
  }

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

  @Test
  public void test_setAttack_InvalidNegative()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setAttack(-1);
    assertEquals("Negative value passed as enemy attack, should be default value 1", 1, e1.getAttack());
  }

  @Test
  public void test_setAttack_InvalidZero()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setAttack(0);
    assertEquals("Zero passed as enemy attack, should be default value 1", 1, e1.getAttack());
  }

  @Test
  public void test_setAttack_Valid()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setAttack(5);
    assertEquals("Enemy attack should be 5", 5, e1.getAttack());
  }

  @Test
  public void test_isAlive_HealthZero()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(0);
    boolean dead = !e1.isAlive();
    assertEquals("Enemy health is 0, so should be dead",dead);
  }

  @Test
  public void test_isAlive_HealthNegative()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(-1);
    boolean dead = !e1.isAlive();
    assertEquals("Enemy health is -1, so should be dead",dead);
  }

  @Test
  public void test_isAlive_Alive()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    e1.setHealth(5);
    assertEquals("Enemy health is 5, so should be alive",e1.isAlive());
  }

  @Test
  public void test_getExperience_ValidValue()
  {
    Enemy e1 = new Enemy("Monster", 10,10,10);
    int experience = e1.getExperience();
    assertEquals("Enemy created with experience passed in as 10, so should return 10", 10, e1.getExperience());
  }

  @Test
  public void test_getExperience_InvalidValue()
  {
    Enemy e1 = new Enemy("Monster", 10,-1,10);
    int experience = e1.getExperience();
    assertEquals("Enemy experience cannot be negative, experience should be 0", 0, e1.getExperience());
  }

  @Test
  public void test_constructor_Name()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy with name 'Monster' created","Monster",e1.getName());
  }

  @Test
  public void test_constructor_NegativeHealth()
  {
    Enemy e1 = new Enemy("Monster",-10,10,10);
    assertEquals("Enemy with -10 passed as health value, which is allowed",-10,e1.getHealth());
  }

  @Test
  public void test_constructor_ZeroHealth()
  {
    Enemy e1 = new Enemy("Monster",0,10,10);
    assertEquals("Enemy with 0 passed as health value, which is allowed",0,e1.getHealth());
  }

  @Test
  public void test_constructor_NegativeHealth()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy with 10 passed as health value, so expecting that value",10,e1.getHealth());
  }

  @Test
  public void test_constructor_InvalidNegativeAttackValue()
  {
    Enemy e1 = new Enemy("Monster",10,-10,10);
    assertEquals("Enemy created with -10 as attack value, but expected default value of 0",0,e1.getAttack());
  }

  @Test
  public void test_constructor_ValidAttackValue()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy created with 10 as attack value",10,e1.getAttack());
  }

  @Test
  public void test_constructor_InvalidNegativeExperience()
  {
    Enemy e1 = new Enemy("Monster",10,10,-10);
    assertEquals("Enemy created with -10 as experience value, but expected default value of 0",0,e1.getExperience());
  }

  @Test
  public void test_constructor_ValidExperience()
  {
    Enemy e1 = new Enemy("Monster",10,10,10);
    assertEquals("Enemy created with 10 as experience value",10,e1.getExperience());
  }

  @Test
  public void test_attack_Default()
  {
    Enemy e1 = new Enemy("Monster",10,5,10);
    Player p1 = new Player("Hero",10,5,10);
    e1.attack(p1,e1);
    assertEquals("Player with 10 health attacked by Enemy with 5 attack, Player health should decrease after enemy attacks", 5, p1.getHealth());
  }

  @Test
  public void test_getDamage()
  {
    Enemy e1 = new Enemy("Monster",10,5,10);
    Player p1 = new Player("Hero",10,5,10);
    e1.attack(p1,e1);
    assertEquals("Enemy had attack value of 5 when attacking Player, so should return 5 as damage", 5, e1.getDamage());
  }
}
