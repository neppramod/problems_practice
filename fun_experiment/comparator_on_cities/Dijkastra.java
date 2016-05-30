import java.util.*;

public class Dijkastra
{
	static class City implements Comparable
	{
		String name;
		int cost;
		boolean visited;
		ArrayList<City> adjacent;
		City parent;
		
		public City(String name)
		{
			this.name = name;
			cost = Integer.MAX_VALUE;
			adjacent = new ArrayList<>();
		}
		
		public int compareTo (Object o2)
		{			
			City c2 = (City) o2;
			return this.cost - c2.cost;
		}
		
		
		public boolean equals(City c)
		{
			return this.name.equals(c.name);
		}
		
		
		public String toString()
		{
			return name;
		}	
		
	}
	
	static class Path
	{
		City c1;
		City c2;
		
		public Path(City c1, City c2) { this.c1 = c1; this.c2 = c2;}
		
		boolean equals(Path p)
		{
			return this.c1 == p.c1 && this.c2 == p.c2;
			
		}
		
		public String toString() 
		{
			return c1.name + " - " + c2.name;
		}
	}
	
	static void printParent(City node)
	{
		if (node == null)
			return;
		System.out.print(node.name + " : ");
		printParent(node.parent);
	}
	
	int getCost(City s, City d, HashMap<Path, Integer> pathCosts)
	{
		int cost = 0;
		//Path p = new Path(s, d);
		//System.out.println(pathCosts);
		
		/*
		if (pathCosts.get(p) != null) {
			cost = pathCosts.get(p);
		} else {
			cost = Integer.MAX_VALUE;
		}
		*/
		
		// Cannot search using equality, need to use a hacky method
		for (Path p1 : pathCosts.keySet()) {
			if (p1.c1.equals(s) && p1.c2.equals(d)) {
				cost = pathCosts.get(p1);
				break;
			}
		}
		
		return cost;
	}
	
	void dijkastra(City source, HashMap<Path, Integer> pathCosts)
	{
		if (source == null)
			return;
			
		source.cost = 0;
		Queue<City> queue = new PriorityQueue<>();
		queue.add(source);
		
		while (!queue.isEmpty()) {
			City s = queue.poll();
			s.visited = true;
			
			for (City n : s.adjacent) {
				if (!n.visited) {					
					
					int newCost = s.cost + getCost(s, n, pathCosts);
					if (newCost < n.cost) {
						n.cost = newCost;
					}					
					
					n.parent = s;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		City one = new City("gdansk");
		City two = new City("bydgoszcz");
		City three = new City("torun");
		City four = new City("warszawa");
		
		ArrayList<City> allCities = new ArrayList<>();
		allCities.add(one);
		allCities.add(two);
		allCities.add(three);
		allCities.add(four);
		
		HashMap<Path, Integer> pathCosts = new HashMap<>();
		pathCosts.put(new Path(one,two), 1);
		pathCosts.put(new Path(one,three), 3);
		
		one.adjacent.add(two);
		one.adjacent.add(three);
		
		
		pathCosts.put(new Path(two, one), 1);
		pathCosts.put(new Path(two, three), 1);		
		pathCosts.put(new Path(two, four), 4);		
		
		two.adjacent.add(one);
		two.adjacent.add(three);
		two.adjacent.add(four);
		
		pathCosts.put(new Path(three, one), 3);
		pathCosts.put(new Path(three, two), 1);
		pathCosts.put(new Path(three, four), 1);
		
		three.adjacent.add(one);
		three.adjacent.add(two);
		three.adjacent.add(four);
		
		pathCosts.put(new Path(four, two), 4);
		pathCosts.put(new Path(four, three), 1);
		
		four.adjacent.add(two);
		four.adjacent.add(three);
		
		Dijkastra d = new Dijkastra();
		d.dijkastra(one, pathCosts);		

		
		for (City city : allCities) {			
			printParent(city);
			System.out.println(" : " + city.cost);
		}
		
		
	}
	
}
