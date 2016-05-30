import java.util.*;

public class City implements Comparator
{
	String name;
	int cost;
	City[] neighbors;
	boolean visited;
	
	public City(String name) 
	{
		this.name = name;
		cost = Integer.MAX_VALUE;
	}
	
	public int compare(Object o1, Object o2)
	{
		City c1 = (City) o1;
		City c2 = (City) o2;
		return c1.cost - c2.cost;
	}
}
