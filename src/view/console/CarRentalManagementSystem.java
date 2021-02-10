package view.console;

import java.util.Scanner;

public class CarRentalManagementSystem extends View
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		CarRentalManagementSystem crms = new CarRentalManagementSystem();
		
		crms.displayOptions();
		crms.selectOptions(scanner, 4);
		scanner.close();
	}
	
	@Override
	void displayOptions() 
	{
		System.out.println("Welcome to Car Rental Management System");
		System.out.println("=======================================");
		System.out.println("1. Manage cars");
		System.out.println("2. Manage customers");
		System.out.println("3. Manage rentals");			
		System.out.println("4. Exit");
	
	}

	@Override
	void processOption(Scanner scanner, int choice) 
	{
		if (choice == 1)
		{
			CarView cv = new CarView();
			
			cv.displayOptions();
			cv.selectOptions(scanner, 9);
			displayOptions();
		}
		else if (choice == 2)
		{
			System.out.println("You've selected manage customers ");
		}
		else if (choice == 3)
		{
			System.out.println("You've selected manage rentals ");
		}
	}
}
