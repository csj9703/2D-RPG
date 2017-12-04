package test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import game.Character;

public class CharacterTest {
	private class Temp extends Character{
		public Temp(String name, int health, int attack) {
			super(name,health,attack);
		}
		public void attack(Character character) {
		}
	}
	
	private boolean isAbstractAndContainsAbstractMethod(){
		boolean classAbstract = false;
		boolean containsAbstractMethod = false;
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/game/Character.java"));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("public abstract class Character")){
					classAbstract = true;
				} else if (line.contains("public abstract void attack")){
					containsAbstractMethod = true;
				}
				line = in.readLine();
				in.close();
			}
		} catch (FileNotFoundException e) {
			classAbstract = false;
		} catch (IOException e) {
			classAbstract =  false;
		}
		return classAbstract && containsAbstractMethod;
	}
	//Constructor Tests
	@Test
	public void constructorTest_Default() {
		assertTrue("Character should be declared abstract and contain abstract attack method", isAbstractAndContainsAbstractMethod());
		Character chr = new Temp("Default",10,1);
		assertEquals("Character Name should be 'Default'","Default",chr.getName());
		assertEquals("Character health should be 10",10,chr.getHealth());
		assertEquals("Character attack should be 1",1,chr.getAttack());
	}
	//Set name Tests
	@Test
	public void setNameTest_String() {
		assertTrue("Character should be declared abstract and contain abstract attack method", isAbstractAndContainsAbstractMethod());
		Character chr = new Temp("Default",10,1);
		chr.setName("New");
		assertEquals("Character name should be 'New'","New",chr.getName());
	}
	//Set Health Tests
	@Test
	public void setHealthTest_Postive() {
		assertTrue("Character should be declared abstract and contain abstract attack method", isAbstractAndContainsAbstractMethod());
		Character chr = new Temp("Default",10,1);
		chr.setHealth(20);
		assertEquals("Character health should be 20",20,chr.getHealth());
	}
	
	@Test
	public void setHealthTest_Negative() {
		assertTrue("Character should be declared abstract and contain abstract attack method", isAbstractAndContainsAbstractMethod());
		Character chr = new Temp("Default",10,1);
		chr.setHealth(-1);
		assertEquals("Character health should be -1",-1,chr.getHealth());
	}
	//Set Attack Tests
	@Test
	public void setAttackTest_Positive() {
		assertTrue("Character should be declared abstract and contain abstract attack method", isAbstractAndContainsAbstractMethod());
		Character chr = new Temp("Default",10,1);
		chr.setAttack(2);
		assertEquals("Character attack should be 2",2,chr.getAttack());
	}
	
	@Test
	public void setAttackTest_Negative() {
		assertTrue("Character should be declared abstract and contain abstract attack method", isAbstractAndContainsAbstractMethod());
		Character chr = new Temp("Default",10,1);
		chr.setHealth(-1);
		assertEquals("Character attack should be 1",1,chr.getAttack());
	}
}
