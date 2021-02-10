package view.console;

import java.util.Scanner;

abstract class View 
{
	abstract void displayOptions();
	
	int selectOptions(Scanner scanner, int maximum) 
	{
		int choice;
		
		do
		{
				choice = 0;
				
				while(choice < 1 || choice > maximum)
				{
					System.out.print("Please enter an option: ");
					choice = scanner.nextInt();
					
					if (choice < 1 || choice > maximum)
						System.out.println("Invalid input, please try again. ");
				}
			processOption(scanner, choice);
		}
		while (choice != maximum);		
		
		return choice;
	}
	
	
	abstract void processOption(Scanner scanner, int choice);
}