package view.console;

import java.util.Scanner;
import java.util.Vector;

import controller.manager.CarManager;
import model.Car;

class CarView extends View
{
	@Override
	void displayOptions() 
	{
			System.out.println("Manage Cars");
			System.out.println("=======================================");
			System.out.println("1. Add car");
			System.out.println("2. Update car");
			System.out.println("3. Delete car");			
			System.out.println("4. Display all cars");
			System.out.println("5. Display cars by maximum price");
			System.out.println("6. Display cars by minimum capacity");
			System.out.println("7. Display cars by transmission");
			System.out.println("8. Display cars by model");
			System.out.println("9. Back to main menu");	
	}
	
	@Override
	void processOption(Scanner scanner, int choice) 
	{
		if (choice == 1)
		{
			Car car = new Car();
			
			scanner.nextLine();
			System.out.println("PLease enter the car details");
			
			System.out.print("Plate no.: ");
			car.setPlateNo(scanner.nextLine());
			
			System.out.print("Model : ");
			car.setModel(scanner.nextLine());
			
			System.out.print("Price : RM ");
			car.setPrice(scanner.nextDouble());
			
			System.out.print("Capacity : ");
			car.setCapacity(scanner.nextInt());
			
			System.out.print("Auto : ");
			car.setAuto(scanner.nextBoolean());
			
			System.out.print("Usable : ");
			car.setUsable(scanner.nextBoolean());
			
			if (CarManager.addCar(car))
				System.out.println("Successfully added  a new car. ");
			else
				System.err.println("Unable to add a new car");
		}
		else if (choice == 2)
		{
			System.out.println("You've selected update car");
		}
		else if (choice == 3)
		{
			System.out.println("You've selected delete car");
		}
		else if (choice == 4)
		{	
			Vector<Car> cars = CarManager.getCars();
			
			for (Car car : cars)
				displayCar(car);
		}
		else if (choice == 5)
		{
		}
		else if (choice == 6)
		{
		}
		else if (choice == 7)
		{
		}
		else if (choice == 8)
		{
		}
		while (choice != 9);
	}
	
	private static void displayCar(Car car)
	{	
		System.out.println("Car ID: " + car.getCarID());
		System.out.println("Plate No: " + car.getPlateNo());
		System.out.println("Model: " + car.getModel());
		System.out.println("Price: RM " + car.getPrice());
		System.out.println("Capacity: " + car.getCapacity());
		System.out.println("Is Auto: " + car.isAuto());
		System.out.println("Is Usable: " + car.Usable());
		System.out.println("");
	}
	
}
	
