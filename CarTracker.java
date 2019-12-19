import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class CarTracker{
	public static void main (String[] args) throws FileNotFoundException
	{
		int UserOption;
		String VIN ;
		String make ;
		String model ;
		int price ;
		int mileage;
		String color;
		Scanner inputReader = new Scanner(System.in);
		/*initialize the cart with input file*/
		Cart shoppingCart = new Cart();//make a cart object
		ArrayList<CarP> carsP = new ArrayList<CarP>();//stores cars objects locally
		ArrayList<CarM> carsM = new ArrayList<CarM>();
		String[] results;
		File txt = new File("cars.txt");
		Scanner fileReader = new Scanner(txt); 
		results = fileReader.nextLine().split(":");
		while(fileReader.hasNextLine())
		{
			
			results = fileReader.nextLine().split(":");
			carsP.add(new CarP(results[0],results[1],results[2],Integer.parseInt(results[3]),Integer.parseInt(results[4]),results[5]));
			carsM.add(new CarM(results[0],results[1],results[2],Integer.parseInt(results[3]),Integer.parseInt(results[4]),results[5]));
		
		}
		fileReader.close();
		
		for(int i=0;i<carsP.size();i++)
		{
			shoppingCart.add(i, carsP.get(i));
			shoppingCart.add(i, carsM.get(i));
		}
		
		//shoppingCart.printInfo();//used for testing
		
		//Prompt user for options//
		System.out.println("Enter 1 to add a car\n");
		System.out.println("Enter 2 to update a car\n");
		System.out.println("Enter 3 to remove a specific car from consideration\n");
		System.out.println("Enter 4 to retrieve the lowest price car\n" );
		System.out.println("Enter 5 to retrieve the lowest mileage car\n" );
		System.out.println("Enter 6 to retrieve the lowest price car by make and model\n");
		System.out.println("Enter 7 to retrieve the lowest mileage car by make and model\n");
		
		
		while(inputReader.hasNext())
		{
			UserOption = inputReader.nextInt();
			if(UserOption == 1)
			{
				System.out.println("Enter the car's unique VIN number");
				VIN = inputReader.next();
				System.out.println("Enter the car's make");
				make = inputReader.next();
				System.out.println("Enter the car's model");
				model = inputReader.next();
				System.out.println("Enter the price(in dollars)");
				price = inputReader.nextInt();
				System.out.println("Enter the mileage of the car");
				mileage = inputReader.nextInt();
				System.out.println("Enter the color of the car");
				color = inputReader.next();
				shoppingCart.add(shoppingCart.getPSize(), new CarP(VIN,make,model,price,mileage,color));
				shoppingCart.add(shoppingCart.getMSize(), new CarM(VIN,make,model,price,mileage,color));
				//shoppingCart.printInfo();
			}
			if(UserOption == 2)
			{
				System.out.println("Enter the VIN number of the car you want to update");
				VIN = inputReader.next();
				System.out.println("Enter 1 if you would like to update the price");
				
				System.out.println("Enter 2 if you would like to update the mileage");
				
				System.out.println("Enter 3 if you would like to update the color");
				int changeOption = inputReader.nextInt();
				if(changeOption == 1) {
					System.out.println("Enter your new price");
					shoppingCart.updatePrice(VIN,inputReader.nextInt());
				}
				if(changeOption == 2) {
					System.out.println("Enter your new mileage");
					shoppingCart.updateMileage(VIN,inputReader.nextInt());
				}
				if(changeOption == 3) {
					System.out.println("Enter your new color");
					( shoppingCart).updateColor(VIN,inputReader.next());
				}
				//shoppingCart.printInfo();
			}
			if(UserOption == 3)
			{
				System.out.println("Enter the VIN number of the car you want to remove");
				VIN = inputReader.next();
				shoppingCart.remove(VIN);
				//shoppingCart.printInfo();
			}
			if(UserOption == 4)
			{
				System.out.println("The lowest price car is: ");
				System.out.println(shoppingCart.findLowestPrice());
			}
			if(UserOption == 5)
			{
				System.out.println("The lowest mileage car is: ");
				System.out.println(shoppingCart.findLowestMileage());
			}
			if(UserOption == 6)//return the car with lowest price by make and model
			{
				System.out.println("Enter the make of the car that you are looking");
				make = inputReader.next();
				System.out.println("Enter the model of the car");
				model = inputReader.next();
				System.out.println("The lowest price for "+ make+" "+model+" : "+shoppingCart.findLowestPriceByM(make, model));
				
			}
			if(UserOption == 7)//return the car with lowest price by make and model
			{
				System.out.println("Enter the make of the car that you are looking");
				make = inputReader.next();
				System.out.println("Enter the model of the car");
				model = inputReader.next();
				System.out.println("The lowest mileage for "+ make+" "+model+" : "+shoppingCart.findLowestMileageByM(make, model));
			}
		
		System.out.println("\nEnter 1 to add a car\n");
		System.out.println("Enter 2 to update a car\n");
		System.out.println("Enter 3 to remove a specific car from consideration\n");
		System.out.println("Enter 4 to retrieve the lowest price car\n" );
		System.out.println("Enter 5 to retrieve the lowest mileage car\n" );
		System.out.println("Enter 6 to retrieve the lowest price car by make and model\n");
		System.out.println("Enter 7 to retrieve the lowest mileage car by make and model\n");
		
	}
}
}
