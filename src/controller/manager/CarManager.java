package controller.manager;

import java.util.Vector;

import model.Car;

public class CarManager
{
	//List, Set and Map
	//ArrayList and Vector
	private static Vector<Car> cars = new Vector<>();

	public static boolean addCar(Car car)
	{
		return cars.add(car);
	}
	
	public static int updateCar(Car car)
	{
		/*int index = -1;
	
		for (int i = 0; i < cars.length; i++)
		{
			Car temp = cars[i];

			if (temp != null && temp.getCarID() == car.getCarID())
			{
				cars[i] = car;
				index = i;

				break;
			}
		}
		
		return index;*/
		
		return -1;
	}

	public static boolean deleteCar(int carID)
	{
		Car car = null;
		
		for (Car c : cars)
		{
			if (c.getUniqueID() == carID)
			{
				car = c;
				break;
			}
		}
		
		return cars.remove(car);
	}
	
	public static Vector<Car> getCars()
	{
		return new Vector<>(cars);
	}
	
	public static Vector<Car> getCars(double maxPrice)
	{
		Vector<Car> temp = new Vector<>();
		
		for (Car car : cars)
			if (car.getPrice() <= maxPrice)
				temp.add(car);
		
		return temp;
	}
	
	public static Vector<Car> getCars(int minCapacity)
	{
		Vector<Car> temp = new Vector<>();
		
		for (Car car : cars)
			if (car.getCapacity() <= minCapacity)
				temp.add(car);
		
		return temp;
	}
	
	public static Vector<Car> getCars(boolean auto)
	{
		Vector<Car> temp = new Vector<>();
		
		for (Car car : cars)
			if (car.isAuto() == auto)
				temp.add(car);
		
		return temp;
	}
	
	public static Vector<Car> getCars(String model)
	{
		Vector<Car> temp = new Vector<>();
		
		for (Car car : cars)
			if (car.getModel().toLowerCase().contains(model.toLowerCase())	)
				temp.add(car);
		
		return temp;
	}
}