package driver;
import java.io.FileNotFoundException;

import problemdomain.MenuManager;

/**
 * XML Parser program allowing users to interact with XML file and check for any errors. 
 * @author Phi N
 */

public class appDriver {
	public static void main(String args[]) {
		try {
			new MenuManager();
		} catch (FileNotFoundException e) {
			System.out.print("File Not Found");
		}
		
	}
}
