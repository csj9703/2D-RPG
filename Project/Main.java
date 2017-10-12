package project;

public class Main 
{
	public static void play() 
	{
		Map stage1 = new Map();
		
		while (stage1.maze[0][18] != "X")
		{
			stage1.displayMaze();
			stage1.displayMenu();
			stage1.move();
		}
		System.out.println("Congratulations! You Win!");
	}

	public static void main(String[] args) 
	{
		play();
	}
}