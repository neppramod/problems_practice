import java.util.*;

public class AirFlight
{
	static class Flight implements Comparable<Flight>
	{
		String name;
		boolean passenger;
		boolean big;

		public Flight(String n, boolean p, boolean b) { name = n; passenger = p; big = b; }

		public int compareTo(Flight f2)
		//public int compare(Object f1o, Object f2o)
		{
			//Flight f1 = (Flight) f1o;
			//Flight f2 = (Flight) f2o;
			Flight f1 = this;

			if (f2.passenger && !f1.passenger) {
				return 1;
			} else if (f1.passenger && ! f2.passenger) {
				return -1;
			} else if (f2.big && !f1.big) {
				return 1;
			} else if (f1.big && !f2.big) {
				return -1;
			} else {
				return 0;
			}
		}

		public String toString() { return name + ": " + (passenger ? " p, " : " c, ") + (big ? " b, " : " s, "); }

		public boolean equals(Flight f1, Flight f2)
		{
			if (f1.name.equals(f2.name) && f1.passenger == f2.passenger && f1.big == f2.big)
				return true;
			return false;
		}
	}

	public static void main(String[] args)
	{
		// name, passenger, big or name, cargo, small
		Flight f1 = new Flight("A", false, false); // cargo,small
		Flight f2 = new Flight("B", true, true); // cargo,small
		Flight f3 = new Flight("C", false, true); // cargo,small
		Flight f4 = new Flight("D", true, true); // cargo,small
		Flight f5 = new Flight("E", true, false); // cargo,small
		Flight f6 = new Flight("F", true, false); // cargo,small

		Queue<Flight> queue = new PriorityQueue<>();
		queue.add(f1);
		queue.add(f2);
		queue.add(f3);
		queue.add(f4);
		queue.add(f5);
		queue.add(f6);


		while (!queue.isEmpty()) {
			System.out.println(queue.poll());

		}
	}
}
