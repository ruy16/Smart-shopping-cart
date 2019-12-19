
import java.util.HashMap;

public class Cart{
	/* Require four Priority Queues to find mins
	 * 
	 */
	IndexMinPQ<CarP> priceByMpq;
	IndexMinPQ<CarM> mileageByMpq;
	IndexMinPQ<CarP> pricePQ;
	IndexMinPQ<CarM> mileagePQ;
	HashMap<String,Integer> map;
	HashMap<String,Integer> map2;
	//ArrayList<CarP> carsP;			//we need to provide a mapping of index to keys(car objects)
	//ArrayList<CarM> carsM;
	//Constructor.Builds two cars PQ with size 100
	public Cart() {
		pricePQ = new IndexMinPQ<CarP>(100);
		mileagePQ = new IndexMinPQ<CarM>(100);
		map = new HashMap<String,Integer>();//mapping of vin and index
	
	}
	//adds the same car object to two different PQ(CarP and CarM are the same! 
	//different comparable.
	public void add(int i,CarP car)
	{
		//carsP.add( car);
		pricePQ.insert(i, car);
		map.put(car.getVIN(), i);
	}
	
	public void add(int i,CarM car)
	{
		//carsM.add( car);
		mileagePQ.insert(i, car);
		//map2.put(car.getVIN(), i);
		//System.out.println(map2.containsKey(car.getVIN()));
	}
	
	//update price or mileage while keep pricePQ and MileagePQ in synch
	public void updatePrice(String vinN,int price)
	{
		pricePQ.keyOf(map.get(vinN)).setPrice(price);
		mileagePQ.keyOf(map.get(vinN)).setPrice(price);
	}
	
	public void updateMileage(String vinN,int mileage)
	{
		pricePQ.keyOf(map.get(vinN)).setMileage(mileage);
		mileagePQ.keyOf(map.get(vinN)).setMileage(mileage);
	}
	
	public void updateColor(String vinN,String color)
	{
		//System.out.println(mileagePQ.size());
		mileagePQ.keyOf(map.get(vinN)).setColor(color);
		pricePQ.keyOf(map.get(vinN)).setColor(color);
		
		
	}
	public void remove(String vinN)
	{
		
		mileagePQ.delete(map.get(vinN));//trick here, can't do price delete before mile delete
		pricePQ.delete(map.get(vinN));
		map.remove(vinN);
	}
	//retrieve the car with the lowest price
	public CarP findLowestPrice()
	{
		return pricePQ.minKey();
	}
	
	//retrieve the car with the lowest mileage
	public CarM findLowestMileage()
	{
		return mileagePQ.minKey();
	}
	
	//retrieve the car of specified make and model with the lowest price
	public CarP findLowestPriceByM(String make,String model)
	{
		priceByMpq = new IndexMinPQ<CarP>(100);
		int count = 0 ;//count
		
		for(int i:pricePQ)
		{
			if(pricePQ.keyOf(i).getMake().equals(make) && pricePQ.keyOf(i).getModel().equals(model))
				{
					priceByMpq.insert(count,pricePQ.keyOf(i));
					count+=1;
					//System.out.print(priceByMpq.keyOf(count));
				}
		}
		if(!priceByMpq.isEmpty())
		{
			return priceByMpq.minKey();
		}
		return null;
	}
	
	//retrieve the car of the specified make and model with the lowest mileage
	public CarM findLowestMileageByM(String make,String model)
	{
		mileageByMpq = new IndexMinPQ<CarM>(100);
		int count = 0;//count
		
		for(int i:mileagePQ)
		{
			if(mileagePQ.keyOf(i).getMake().equals(make) && mileagePQ.keyOf(i).getModel().equals(model))
				{
					mileageByMpq.insert(count,mileagePQ.keyOf(i));
					count+=1;
					//System.out.print(priceByMpq.keyOf(count));
				}
		}
		if(!mileageByMpq.isEmpty())
		{
			return mileageByMpq.minKey();
		}
		return null;
		
	}
	//helper method that prints out items in pricePQ and MileagePQ
	public void printInfo()
	{
		for(int i:pricePQ)
		{
			System.out.println(pricePQ.keyOf(i).toString());
		}
		System.out.println("\n");
		for(int i:mileagePQ)
		{
			System.out.println(mileagePQ.keyOf(i).toString());
			
		}
		System.out.println("\n");
		System.out.println(map);
		
	}
	
	public int getPSize()
	{
		return pricePQ.size();
	}
	public int getMSize()
	{
		return mileagePQ.size();
	}

}



