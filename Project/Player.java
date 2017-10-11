/**
 * CPSC 233 Project.
 * @author Jason ShuJi Chen Team 6
 * Date last modified: Oct 11, 2017.
 */
public class Player {
	String name;
	int health;
	int attack;
	int numOfPot = 1;
	boolean hasSword = false;
	//Potion potion = new Potion();
	
	public Player(){
		health = 9;
		attack = 1;
	}
	/**
	 * Setter for Player name
	 * @param aName a name that user wishes to set.
	 */
	public void setName(String aName) {
		name = aName;
	}
	/**
	 * Getter for player health.
	 * @return player health.
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Getter for number of potion.
	 * @return number of potion.
	 */
	public int getNumOfPot() {
		return numOfPot;
	}
	/**
	 * Setter for play health
	 * @param aHealth a new health.
	 */
	public void setHealth(int aHealth) {
		health = aHealth;
	}
	/**
	 * Getter for player attack.
	 * @return attack value.
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * Uses potion.
	 * @param potNum the type of potion (in int)
	 */
	public void useItem() {
		if(numOfPot > 0 && health < 10) {
			restoreHp(2);
			numOfPot--;
		}
	}
	/**
	 * Player attack method use during battle
	 * @param attack player base attack value
	 * @param weaponDmg weapon damage
	 * @return total damage value.
	 */
	public int attack(int attack) {
		int damage = attack;
		return damage;
	}
	/**
	 * Player pick up method.
	 * @param item the item the player picked up.
	 */
	public void pickUp(String item) {
		int length = item.length();
		//Checks if the item has "Sword" in the name.
		if (item.charAt(length-5) == 'S'){
			System.out.println("Got a Sword!");
			hasSword = true;
		//Checks if the item has "Potion in the name.
		}else if(item.charAt(length-6) == 'P') {
			System.out.println("Got a Potion!");
			numOfPot ++;
		}
	}
	/**
	 * Restores the amount of hp based on the amount.
	 * @param amount amount of hp the player to restore.
	 */
	public void restoreHp(int amount)
    {
		health += amount;
		if(health > 10) {
			int excessHp = health - 10;
			health -= excessHp;
		}
    }
	
	public void equipSword(int swordDmg) {
		if(hasSword == true) {
			attack += swordDmg;
		}else {
			System.out.println("You don't have a Sword!");
		}
	}
	
}
