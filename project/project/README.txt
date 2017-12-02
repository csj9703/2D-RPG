Compile & Run Instructions

===============================================================================
To run the GUI version:
-------------------------------------------------------------------------------
Linux:
	in ../project/project> javac -d bin -cp bin src/launcher/Main.java
	in ../project/project> java -cp .:bin:/*.class launcher.Main 
-------------------------------------------------------------------------------
Windows:
	in ../project/project> javac -d bin -cp bin src\launcher\Main.java
	in ../project/project> java -cp .;bin;\*.class launcher.Main 
===============================================================================
To run the Textversion:
-------------------------------------------------------------------------------
Linux:
	in ../project/project> javac -d bin -cp bin src/launcher/TextMain.java
	in ../project/project> java -cp .:bin:/*.class launcher.TextMain
-------------------------------------------------------------------------------
Windows:
	in ../project/project> javac -d bin -cp bin src\launcher\TextMain.java
	in ../project/project> java -cp .;bin;\*.class launcher.TextMain 
-------------------------------------------------------------------------------

Testing Instructions
===============================================================================
Test Class Names:

	GameObject.java 	- GameObjectTest
	Character.java  	- CharacterTest
	Player.java     	- PlayerTest
	Enemy.java 		- EnemyTest
	Potion.java 		- PotionTest
	Weapon.java 		- WeaponTest
	Spawner.java 		- SpawnerTest

-------------------------------------------------------------------------------
Linux:
	in ../project/project> javac -d bin -cp bin src/launcher/Main.java

	*****Replace "TestClasses" with the corresponding test classes*****
	in ../project/project> java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar;bin org.junit.runner.JUnitCore test.TestClasses  
	
-------------------------------------------------------------------------------
Windows:
	in ../project/project> javac -d bin -cp bin src\launcher\Main.java

	*****Replace "TestClasses" with the corresponding test classes*****
	in ../project/project> java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar:bin org.junit.runner.JUnitCore test.TestClasses
	