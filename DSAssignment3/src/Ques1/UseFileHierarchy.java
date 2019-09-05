package Ques1;

import java.util.InputMismatchException;
import java.util.Scanner;
/* This is the application class. This class uses component classes and is used to run Virtual
 * Command Prompt.
 */
public class UseFileHierarchy {

	public static void main(String[] args) {
		
		// Scanner object for user input.
		Scanner sc = new Scanner(System.in);
		
		// Tree object for using its functionality.
		Tree cmd = new Tree();

		String command;
		do {
			try {
				cmd.showCurrentDirectory();
				command = sc.nextLine();
				String subCommand[] = command.split(" ");
				switch (subCommand[0]) {
				case "mkdir":
					cmd.makeDirectory(subCommand[1]);
					break;
					
				case "cd":
					cmd.changeDirectory(subCommand[1]);
					break;

				case "bk":
					cmd.changeDirectory("cd..");
					break;

				case "find":
					System.out.println(cmd.find(subCommand[1], cmd.currentDirectory));
					break;
				
				case "tree":
					cmd.tree();
					break;
				
				case "ls":
					cmd.printList(cmd.currentDirectory);
					break;
				
				case "exit":
					System.exit(0);
				
				default:
					System.out.println("Invalid command");
				}
			} catch (InputMismatchException e) {

				System.out.println("Warning : Type Mismatch!! Try Again");
				System.out.println("-------------------------------------------------------------------------------");
				sc.nextLine();
			}
		} while (true);
	}
}