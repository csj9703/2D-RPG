import java.util.Scanner;
import java.io.*;

public class FilesExample {
	public static void usingScanner() {
		try {
			Scanner reader = new Scanner(new File("TextFilesExample.java"));
			while (reader.hasNext()) {
				String line = reader.nextLine();
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}
	
	public static void usingBufferedReader(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("TextFilesExample.java"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
	}
	
	public static void usingBufferedWriter() throws IOException {
		PrintWriter writer = new PrintWriter(
				new BufferedWriter(new FileWriter("Numbers.txt", true)));
		for (int counter = 0; counter < 10; counter+=3){
			// write counter to writer on it's own line.
			writer.println(counter);
		}
		writer.close();
	}
	
	public static void usingDataOutputStream() throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream("numbers.bin"));
		//out.writeInt(10);
		for (int counter = 1; counter <= 10; counter++){
			// write counter to writer on it's own line.
			out.writeInt(counter);
		}
		out.close();
		
	}
	
	public static void usingDataInputStream() throws IOException {
		DataInputStream in = new DataInputStream(new FileInputStream("numbers.bin"));
		int size = in.readInt();
		System.out.println("size: " + size);
		for (int counter = 0; counter < size; counter++){
			// write counter to writer on it's own line.
			int num = in.readInt();
			System.out.println(num);
		}
		in.close();
		
	}
	
	
	public static void main(String[] args) throws IOException {
		//usingScanner();
		//usingBufferedReader();
		//usingDataOutputStream();
		//usingDataInputStream();
	}
}