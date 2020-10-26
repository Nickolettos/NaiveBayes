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
		//parse differently depending on file type (.meta||.test||.train)
		//if(filename.substring(filename.valueOf('.')+1).equals(".train")) {
		try {
			scan= new Scanner(file);
			while(scan.hasNextLine()) {
				String line= scan.nextLine();
				System.out.println(line);//print to console for testing
				String[]items= line.split(",");
				classification= items[6];
				System.out.println("Classication: "+ classification);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		//}
		//else if (ends with .meta)
		//else if (ends with .train
		
	}
	
	
}
