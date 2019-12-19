/* modified PriorityQueue that is indexable*/
import java.util.*;
public class MyPriorityQueue<E> extends PriorityQueue {
	private indirectHeap<String> heap ;
	public MyPriorityQueue() {} //constrctor
	
	public static void main(String[] args)//testing
	{
		
	}
	/*public boolean add(E e) 
	{
		
		return false;
		
	}*/	 



private class indirectHeap<E>
{
	int[] map;
	int[] inverse;
	public indirectHeap(){}
	
}

}