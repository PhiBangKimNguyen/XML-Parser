package problemdomain;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuManager {
	private Scanner input = new Scanner(System.in);

	/**
	 * Constructor creating menu UI
	 * @throws FileNotFoundException
	 * 			if file not found.
	 */
	public MenuManager() throws FileNotFoundException {
		String choice;
		boolean loop = true;
		while(loop) {

			System.out.println("==========");
			System.out.println("XML Parser");
			System.out.println("1. Parse your own file");
			System.out.println("2. Parse a sample file");
			System.out.println("3. End Program");

				choice = input.nextLine();
				switch(choice) {
				case "1": 
					customFile();
					break;
				case "2": 
					sampleFile();
					break;
				case "3":
					loop = false;
					break;
				default: 
					System.out.println("Invalid option");
					break;
				}
			
		}
	}
	
	/**
	 * Method called when the user wants to parse their own file (JAR ONLY)
	 * @throws FileNotFoundException
	 * 			if file not found.
	 */
	public void customFile() throws FileNotFoundException {
		String file = "";

		System.out.print("Please enter XML file: ");
		file = input.nextLine();
		while(!file.contains(".xml")) {
			System.out.println("Invalid file format");
			file = input.nextLine();
		}
		try {
			new XMLParser(file);
			System.out.println("\nTry again?");
			input.nextLine();
		}
		catch (Exception e){
			System.out.println("\nFile Not Found.\n");
		}
	}
	
	
	/**
	 * Method called when the user wants a sample file
	 * @throws FileNotFoundException
	 * 				if file not found.
	 */
	public void sampleFile() throws FileNotFoundException {
		String file = "";
		System.out.print("Please enter the sample file you want (1 or 2): ");			
		file = input.nextLine();
		
		switch(file) {
			case "1":
				new XMLParser("/sample1.xml", true);
				break;
			case "2":
				new XMLParser("/sample2.xml", true);
				break;
			default: 
				System.out.println("Please enter either 1-2");
				
		}	
		System.out.println("\nTry again?");
		input.nextLine();			
	}
}