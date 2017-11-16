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
	 //Player is alive Test
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
	 //Set Name Tests
	 @Test
	 public void setNameTest() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setName("New");
		 assertEquals("Player name should be 'New'","New",p1.getName());
	 }
	 //Set Health Tests
	 @Test
	 public void setHealthTest_Positive() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setHealth(20);
		 assertEquals("Player health should be 20",20,p1.getHealth());
	 }
	 
	 public void setHealthTest_Negative() {
		 Player p1 = new Player("Default", 10, 1);
		 p1.setHealth(-1);
		 assertEquals("Player health should be 10",10,p1.getHealth());
	 }
	 //Set Attack Tests
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
	 //Set Exp to Lvl Tests
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
	 //Set Current Exp Tests
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
	//Use Potion Tests
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
	 //Potion over max health limit tests
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
	 //Using potion with invalid amount Tests
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
	 //Item amount after used Test
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
	 //Attack Tests
 	 @Test
 	 public void attackTest_AttackEnemy() {
 		 boolean isLess = false;
		 Player p1 = new Player("Default", 10, 1);
		 int e1Health = 10;
		 Enemy e1 = new Enemy("E1",e1Health,1,1); 
		 p1.attack(p1, e1);
		 if(e1Health<e1.getHealth()) {
			 isLess = true;
		 }
		 assertEquals("Enemy health should decrease.",isLess,e1Health<e1.getHealth());
 	 }
 	 
}
