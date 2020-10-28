import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NB {
	
	public static Scanner scan;
	public static String classification;

	private MetaData metaData;
	private Data trainingData;
	private Data testData;
	
	public NB() {
		
		
	}
	
	public void parse(String filename) {
		File file= new File(filename);

		//parse differently depending on file type (.meta||.test||.train)
		try {
			scan= new Scanner(file);

			switch(getFileExtension(filename)){
				case "meta":
					this.metaData = populateMetaData(filename);
					break;
				case "train":
					this.trainingData = populateData(filename);
					break;
				case "test":
					this.testData = populateData(filename);
					break;
				default:
					throw new FileNotFoundException("File Extension Not Supported");
			}

//			while(scan.hasNextLine()) {
//				String line= scan.nextLine();
//				System.out.println(line);//print to console for testing
//				String[]items= line.split(",");
//				classification= items[6];
//				System.out.println("Classication: "+ classification);
//			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	private String getFileExtension(String fileName){
		return fileName.substring(fileName.indexOf(".") + 1);
	}

	private MetaData populateMetaData(String fileName){
		List<Attributes> attributes = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();
			while(line != null){
				//Get name of attribute
				String name = line.substring(0, line.indexOf(":"));

				String[] lst = line.substring(line.indexOf(":") + 1).split(",");
				attributes.add(new Attributes(name, lst));

				line = reader.readLine();
			}

			Attributes classification = attributes.remove(attributes.size() - 1);
			return new MetaData((ArrayList<Attributes>)attributes, classification);
		}
		catch (FileNotFoundException e){
			System.out.println("Error Populating Meta Data");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Data populateData(String fileName){
		List<List<String>> d = new ArrayList<>();

		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();
			while(line != null){
				d.add((Arrays.asList(line.split(","))));

				line = reader.readLine();
			}

			return new Data(d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
}
