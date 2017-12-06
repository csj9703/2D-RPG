package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.*;

public class PlayerTest {
	/*
	 * This test the player constructor, player stats name, health, attack, level, 
	 * currentExp, and expToLvl should be "Default",1,1,0,and 1 correspondingly.
	 */
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
	 /*
	  * Series of tests for the isAlive method, should return false when player health is 0
	  * or below, true otherwise.
	  */
	 @Test
	 public void isAliveTest_Alive() {
		 boolean alive = true;
		 Player p1 = new Player("Default", 1, 1);
		 assertEquals("Player should be alive, thus returning True", alive, p1.isAlive());
	 }
	 
	 @Test
	 public void isAliveTest_Dead() {
		 boolean alive = false;
		 Player p1 = new Player("Default", 1, 1);
		 p1.setHealth(0);
		 assertEquals("Player should be dead, thus returning False", alive, p1.isAlive());
	 }
	 /*
	  * This tests the setName method, String should be the same as what it sets to.
	  */
	 @Test
	 public void setNameTest() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setName("New");
		 assertEquals("Player name should be 'New'","New",p1.getName());
	 }
	 /*
	  * These 2 tests are for the setHealth method, health should be the same as to what
	  * passed into the parameter, including negative values.
	  */
	 @Test
	 public void setHealthTest_Positive() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setHealth(20);
		 assertEquals("Player health should be 20",20,p1.getHealth());
	 }
	 
	 public void setHealthTest_Negative() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setHealth(-1);
		 assertEquals("Player health should be -1",-1,p1.getHealth());
	 }
	 /*
	  * These two tests are for setAttack method, attack should be the same as to what
	  * passed into the parameter, except negative values.
	  */
	 @Test
	 public void setAttackTest_Positive() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setAttack(2);
		 assertEquals("Player attack should be 2",2,p1.getAttack());
	 }
	 
	 public void setAttackTest_Negative() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setAttack(-1);
		 assertEquals("Player attack should be 1",1,p1.getAttack());
	 }
	 /*
	  * These two tests are for setLevel method, Level should be the same as to what
	  * passed into the parameter, except negative values.
	  */
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
	 /*
	  * These 2 tests is for setExpToLvl method, experience to level should be the same as to what
	  * passed into the parameter, except negative values.
	  */
	 @Test
	 public void setExpToLvlTest_Positive() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setExpToLvl(2);
		 assertEquals("Player exp to lvl should be 2",2,p1.getExpToLvl());
	 }
	 
	 @Test public void setExpToLvlTest_Negative() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setExpToLvl(-1);
		 assertEquals("Player exp to lvl should be 1",1,p1.getExpToLvl());
	 }
	 /*
	  * These 2 tests is for setCurrentExp method, current experience to level should be the same as to what
	  * passed into the parameter, except negative values.
	  */
	 @Test
	 public void setCurrentExpTest_Positive() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setCurrentExp(2);
		 assertEquals("Player current exp should be 2",2,p1.getCurrentExp());
	 }
	 
	 @Test
	 public void setCurrentExpTest_Negative() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setCurrentExp(-1);
		 assertEquals("Player current exp should be 0",0,p1.getCurrentExp());
	 }
	/*
	 * This is for testing levelUp method, player should increase level if they have the required experience,
	 * and the player stats should also increase as well. 
	 */
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
	 /*
	  * These 2 test is for obtainExp method, player should obtain experience accordingly.
	  */
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
	 /*
	  * Series of tests for pickUp, potion count should increase accordingly,
	  * i.e picking up a small potion should only increase the potion count for
	  * small potions, while the amount of medium/large potion should remain as
	  * their original value.
	  */
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
	 /*
	  * Series of tests for pickUp method, player should pickup correspoding weapon,
	  * should return the proper weapon name and weapon stats
	  */
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
		 assertEquals("Player current weapon should be 'Blessed Excalibur'","Blessed Excalibur",p1.getCurrentWeapon());
	 }
	/*
	 * Series of tests for useItem method, player health should increase accordingly to the potion's
	 * restoration values.
	 */
	 @Test
	 public void useItemTest_SmallPotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(1);
		 p1.useItem(1);
		 assertEquals("Player health should be 13", 13, p1.getHealth());
	 }
	 
	 @Test
	 public void useItemTest_MediumPotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(2);
		 p1.useItem(2);
		 assertEquals("Player health should be 15", 15, p1.getHealth());
	 }
	 
	 @Test
	 public void useItemTest_LargePotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(3);
		 p1.useItem(3);
		 assertEquals("Player health should be 17", 17, p1.getHealth());
	 }
	 /*
	  * Series of tests for useItem method, these test to see if using the potion will go over the
	  * maximum health limit of the player (20).
	  */
	 @Test
	 public void useItemTest_SmallPotion_OverMaxHealth() {
		 Player p1 = new Player("Default", 19, 1);
		 p1.pickUp(1);
		 p1.useItem(1);
		 assertEquals("Player health should be 20", 20, p1.getHealth());
	 }
	 
	 @Test
	 public void useItemTest_MediumPotion_OverMaxHealth() {
		 Player p1 = new Player("Default", 19, 1);
		 p1.pickUp(2);
		 p1.useItem(2);
		 assertEquals("Player health should be 20", 20, p1.getHealth());
	 }
	 
	 @Test
	 public void useItemTest_LargePotion_OverMaxHealth() {
		 Player p1 = new Player("Default", 19, 1);
		 p1.pickUp(3);
		 p1.useItem(3);
		 assertEquals("Player health should be 20", 20, p1.getHealth());
	 }
	 /*
	  * Series of test for useItem, player shouldn't be able to use potions when there are
	  * 0 potion count.
	  */
	 @Test
	 public void useItemTest_SmallPotion_NoPotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.useItem(1);
		 assertEquals("Player health should be 10", 10, p1.getHealth());
	 }
	 
	 @Test
	 public void useItemTest_MediumPotion_NoPotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.useItem(2);
		 assertEquals("Player health should be 10", 10, p1.getHealth());
	 }
	 
	 @Test
	 public void useItemTest_LargePotion_NoPotion() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.useItem(3);
		 assertEquals("Player health should be 10", 10, p1.getHealth());
	 }
	 /*
	  * Series of test for useItem, potion count should decrease after usage.
	  */
	 @Test
	 public void useItemTest_SmallPotion_ItemUsed() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(1);
		 p1.useItem(1);
		 assertEquals("numSmallPotions should be 0", 0, p1.getNumSmallPotions());
	 }
	 
	 @Test
	 public void useItemTest_MediumPotion_ItemUsed() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(2);
		 p1.useItem(2);
		 assertEquals("numMediumPotions should be 0", 0, p1.getNumMediumPotions());
	 }
	 
	 @Test
	 public void useItemTest_LargePotion_ItemUsed() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.pickUp(3);
		 p1.useItem(3);
		 assertEquals("numLargePotions should be 0", 0, p1.getNumLargePotions());
	 }
	 /*
	  * This tests the attack method, enemy health should decrease based on player's attack
	  * values.
	  */
 	 @Test
 	 public void attackTest_AttackEnemy() {
 		 boolean isLess = false;
		 Player p1 = new Player("Default", 10, 1);
		 int e1Health = 10;
		 Enemy e1 = new Enemy("E1",e1Health,1,1); 
		 p1.attack(e1);
		 if(e1Health<e1.getHealth()) {
			 isLess = true;
		 }
		 assertEquals("Enemy health should decrease.",isLess,e1Health<e1.getHealth());
 	 }
}