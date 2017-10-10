public class Main 
{
	public static void play()
	{
		boolean gameWon = false;
		Map stage1 = new Map();
		
		while (!(gameWon))
		{
			stage1.displayMenu();
			stage1.displayMaze();
			stage1.move();
		}
	}

	public static void main(String[] args)
	{
		play();
	}
}