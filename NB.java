import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NB {
	
	public static Scanner scan;
	public static String classification;
	
	public NB() {
		
		
	}
	public static void parse(String filename) {
		File file= new File(filename);
		try {
			scan= new Scanner(file);
			while(scan.hasNextLine()) {
				String line= scan.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
}
