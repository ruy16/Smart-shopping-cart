//A class that uses mileage as its comparable field.Creates a car object
public class CarM implements Comparable<CarM>{
	String  VIN;
	String  make;
	String  model;
	int	price;
	int	mileage;
	String	color;
	
	public CarM(String vinNumber,String make,String model,int price,int mileage,String color)
	{
		this.VIN = vinNumber;
		this.make = make;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.color = color;
	}
	//getters
	public String getVIN()	{return VIN;}
	
	public String getMake() {return make;}
	
	public String getModel() {return model;}
	
	public int getPrice() {return price;}
	
	public int getMileage() {return mileage;}
	
	public String getColor() {return color;}
	//setters
	public void setVIN(String vin) {this.VIN = vin;}
	
	public void setMake(String make) {this.make = make;}
	
	public void setModel(String model) {this.model = model;}
	
	public void setPrice(int price) {this.price = price;}
	
	public void setMileage(int mileage) {this.mileage = mileage;}
	
	public void setColor(String color) {this.color = color;}
	
	//Comparator for two cars by their mileages,returns -1 if the car's price is lower than c
	//1 if the price is higher, 0 if they are the same
	@Override
	public int compareTo(CarM c)
	{
		if(this.getMileage() < c.getMileage())
		{return -1;}
		if(this.getMileage() > c.getMileage())
		{return 1;}
		else
			return 0;
	}

	public String toString()
	{
		return(VIN + " "+make+" "+model+" "+price+" "+mileage+" "+ color);
	}
	
}
