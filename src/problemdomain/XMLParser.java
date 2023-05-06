package problemdomain;
import utility.*;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * Parsing the given file
 *
 */
public class XMLParser {
	private static InputStream file;
	private static File externalFile;
	private Scanner readFile;
	private MyStack<String> stack = new MyStack<>();
	private MyQueue<String> errorQueue = new MyQueue<>();
	private MyQueue<String> extraQueue = new MyQueue<>();
	
	/**
	 * Constructor 
	 * @param filePath 
	 * 			name of the file 
	 * @param external
	 * 			enable the use of InputStream
	 * @throws FileNotFoundException
	 * 			if file not found.
	 */
	public XMLParser(String filePath, boolean external) throws FileNotFoundException {
		file = getClass().getResourceAsStream(filePath);
		readFile = new Scanner(file);
		System.out.println();
		parseFile();
	}
	
	/**
	 * Constructor  
	 * read a file in the JAR directory using the File class.
	 * @param filePath
	 * 			name of the file 
	 * @throws FileNotFoundException
	 * 			if file not found
	 */
	public XMLParser(String filePath) throws FileNotFoundException {
		externalFile = new File(filePath);
		readFile = new Scanner(externalFile);
		System.out.println();
		parseFile();
		
	}
	
	/**
	 * Scan file
	 */
	public void parseFile() {
		int lineCount = 0;
		while(readFile.hasNext()) {
			lineCount++;
			parseLine(readFile.nextLine(), lineCount);
		}
		errorVerify();
	}
	
	/**
	 * This method Verify any incorrectness
	 */
	public void errorVerify() {
		int errorCount = 0;
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) 
				errorQueue.enqueue(stack.pop());
		}
		while(!errorQueue.isEmpty() || !extraQueue.isEmpty()) {
			errorCount++;
			if(errorQueue.isEmpty() && !extraQueue.isEmpty()) 
				System.out.println("Error with " + extraQueue.dequeue());
			
			else if(!errorQueue.isEmpty() && extraQueue.isEmpty()) 
				System.out.println("Error with " + errorQueue.dequeue());
			
			else if (!errorQueue.isEmpty() && !extraQueue.isEmpty()) {
				if(errorQueue.peek().equals(extraQueue.peek())){
					extraQueue.dequeue();
					errorQueue.dequeue();
				}
				else 
					System.out.println("Error with " + errorQueue.dequeue());
				
			}
		}
		if(errorCount == 0) 
			System.out.println("No Errors Found");
	}
	
	/**
	 * Parses each tag
	 * @param line
	 * @param lineCount
	 */
	public void parseLine(String line, int lineCount) {
		String tagName = "null";
		String tag = "null";
		line = line.trim();
		while(line.contains(">") && line.contains("<")) {
			tag = line.substring(line.indexOf('<'), line.indexOf('>')+1);
			line = line.substring(line.indexOf('>') + 1);
			if(!(tag.contains("?") || tag.contains("/>"))) {
				if(!tag.contains(" ")) 
					tagName = tag.substring(tag.indexOf('<') + 1, tag.indexOf('>'));				
				else 
					tagName = tag.substring(tag.indexOf('<') + 1, tag.indexOf(' '));				
				if(!tagName.contains("/")) 
					stack.push(tagName);				
				else {
						tagName = tagName.substring(tag.indexOf('/'));
						if(!stack.isEmpty() && tagName.equals(stack.peek())) 
							stack.pop();						
						else if(!errorQueue.isEmpty() && tagName.equals(errorQueue.peek())) 
							errorQueue.dequeue();						
						else if(stack.isEmpty()) 
							errorQueue.enqueue(tagName);						
						else {
							if(!stack.isEmpty()) {
								if(stack.search(tagName) > 0) 
									for(int i = 0; i<stack.search(tagName);i++) 
										errorQueue.enqueue(stack.pop());																	 
								else 
									extraQueue.enqueue(tagName);							
							}
						}
				}
			} 
		}
	}
}
