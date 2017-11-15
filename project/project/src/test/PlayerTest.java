package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.*;

public class PlayerTest {
	//Constructor Tests
	 @Test
	 public void constructorTest_default() {
		 Player playerDefault = new Player("Default", 10, 1);
		 assertEquals("Player name should be 'Default'","Default",playerDefault.getName());
		 assertEquals("Player Health should be 10", 10, playerDefault.getHealth());
		 assertEquals("Player attack should be 1", 1, playerDefault.getAttack());
		 assertEquals("Player Level should  be 1", 1, playerDefault.getCurrentLevel());
		 assertEquals("Player CurrentExp should be 0", 0, playerDefault.getCurrentExp());
		 assertEquals("Player expToLvl should be 1", 1, playerDefault.getExpToLvl());
	 }
	 //Set Level Tests
	 @Test
	 public void setLevelTest_PositiveLevel() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setLevel(2);
		 assertEquals("Player level should be 2",2,p1.getCurrentLevel());
	 }
	 
	 @Test
	 public void setLevelTest_NegativeLevel() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setLevel(-1);
		 assertEquals("Player level should be 1",1,p1.getCurrentLevel());
	 }
	//Level Up Tests
	 @Test
	 public void levelUpTest() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setCurrentExp(1);
		 p1.checkExp();
		 assertEquals("Player current exp should be 1",1,p1.getCurrentExp());
		 assertEquals("Player level should be 2",2,p1.getCurrentLevel());
		 assertEquals("Player attack should be 2",2,p1.getAttack());
		 assertEquals("Player expToLvl should be 2",2,p1.getExpToLvl());
	 }
	 //Obtain Exp Tests
	 @Test
	 public void obtainExpTest_1Exp() {
		 Player p1 = new Player("Default", 10, 1);
		 Enemy e1 = new Enemy("E1",1,1,1); 
		 p1.obtainExp(e1);
		 assertEquals("Player current exp should be 1",1,p1.getCurrentExp());
	 }
	 
	 @Test
	 public void obtainExpTest_10Exp() {
		 Player p1 = new Player("Default", 10, 1);
		 Enemy e1 = new Enemy("E1",1,1,10); 
		 p1.obtainExp(e1);
		 assertEquals("Player current exp should be 10",10,p1.getCurrentExp());
	 }
	 //Pick Up Potion Tests
	 @Test
	 public void pickUpTest_SmallPotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(1);
		 assertEquals("Player should have 1 small potion",1,p1.getNumSmallPotions());
		 assertEquals("Player should have 0 medium potion",0,p1.getNumMediumPotions());
		 assertEquals("Player should have 0 large potion",0,p1.getNumLargePotions());
	 }
	 
	 @Test
	 public void pickUpTest_MediumPotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(2);
		 assertEquals("Player should have 0 small potion",0,p1.getNumSmallPotions());
		 assertEquals("Player should have 1 medium potion",1,p1.getNumMediumPotions());
		 assertEquals("Player should have 0 large potion",0,p1.getNumLargePotions());
	 }
	 
	 @Test
	 public void pickUpTest_LargePotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(3);
		 assertEquals("Player should have 0 small potion",0,p1.getNumSmallPotions());
		 assertEquals("Player should have 0 medium potion",0,p1.getNumMediumPotions());
		 assertEquals("Player should have 1 large potion",1,p1.getNumLargePotions());
	 }
	 //Pick up Weapon Tests
	 @Test
	 public void pickUpTest_Dagger() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(4);
		 assertEquals("Player weapon damage should be 1",1,p1.getWeaponDamage());
		 assertEquals("Player current weapon should be 'Rusty Dagger'","Rusty Dagger",p1.getCurrentWeapon());
	 }
	 
	 @Test
	 public void pickUpTest_Sword() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(5);
		 assertEquals("Player weapon damage should be 2",2,p1.getWeaponDamage());
		 assertEquals("Player current weapon should be 'Iron Longsword'","Iron Longsword",p1.getCurrentWeapon());
	 }
	 
	 @Test
	 public void pickUpTest_Excalibur() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(6);
		 assertEquals("Player weapon damage should be 3",3,p1.getWeaponDamage());
		 assertEquals("Player current weapon should be 'Excalibur'","Excalibur",p1.getCurrentWeapon());
	 }
	
}
