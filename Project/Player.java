/**
 * CPSC 233 Project.
 * @author Jason ShuJi Chen Team 6
 * Date last modified: Oct 10, 2017.
 */
public class Player {
	String name;
	int health;
	int attack;
	int numOfPot = 1;
	boolean hasSword = false;
	//Potion potion = new Potion();
	
	public Player(){
		health = 1;
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
	public void useItem(int potNum) {
		if(numOfPot > 0 && health < 10) {
			restoreTwo();
			
		}
	}
	/**
	 * Player attack method use during battle
	 * @param attack player base attack value
	 * @param weaponDmg weapon damage
	 * @return total damage value.
	 */
	public int attack(int attack, int weaponDmg) {
		int damage = 1;
		if (hasSword == true) {
			damage = attack + weaponDmg;
		}else {
			damage = attack;
		}
		return damage;
	}
	/**
	 * Player pick up method.
	 * @param item the item the player picked up.
	 */
	public void pickUp(String item) {
		char itemAsChar = item.charAt(0);
		if (!Character.isDigit(itemAsChar)){
			hasSword = true;
		}else {
			numOfPot ++;
		}
	}
	
	public void restoreTwo()
    {
    health += 2;
    }
	
	
}
