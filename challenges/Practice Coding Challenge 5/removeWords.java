import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class removeWords 
{
	public static int removeFirstWord(String input, String output) throws FileNotFoundException, EmptyFileException
	{
		boolean fileIsEmpty = false;
		try 
		{
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(output, false)));
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line;
			while ((line = reader.readLine()) != null)
			{
				fileIsEmpty = true;
				String[] list = line.split(" ");
				
				for (int i = 1; i < list.length; i++)
				{
					writer.print(list[i] + " ");
				}
				writer.println();
			}
			reader.close();
			writer.close();
		} 
		catch (IOException ioe) 
		{
			return -1;
		}
		if (fileIsEmpty)
		{
			throw new EmptyFileException();
		}
		return 0;
	}
	
	public static int sumNumbers(String input) 
	{
		DataInputStream in;
		int total = 0;
		try 
		{
			in = new DataInputStream(new FileInputStream(input));
			for (int counter = 0; counter < 10; counter++)
			{
				total += in.readInt();
			}
			in.close();
		}
		catch (IOException e) 
		{
			return 1;
		}
		return total;
	}
}