import java.util.*;

/**
 * Calculates shortest/cheapest path between cities (based on cost) using Dijkstra algorithm
 */
public class ShortestPath {
    // This is the max cost defined by the question.
    private final Integer MAX_ALLOWED_COST = 200000;
    private ArrayList<City> cities; // List of all the cities
    private ArrayList<Path> paths;  // List of all the paths
    private Set<City> markedCities; // Cities that have destination cleared
    private Set<City> unmarkedCities; // Cities that can now be visited, but have not been completely cleared (source, destination)
    private HashMap<City, City> parents; // Route to parent
    private HashMap<City, Integer> costs; // Updated minimum cost of each node after all visits. Keeps on updating after newer minimum cost is calculated
    private City sourceCity;  // City from where to search the minimum path (cost)
    private City destinationCity; // City to which to find the minimum path

    // This class gets city list and their paths externally
    public ShortestPath(ArrayList<City> cities, ArrayList<Path> paths) {
        this.cities = cities;
        this.paths = paths;
        markedCities = new HashSet<City>();
        unmarkedCities = new HashSet<City>();
        parents = new HashMap<City, City>();
        costs = new HashMap<City, Integer>();
    }

    public void setSourceCity(City sourceCity) {
        this.sourceCity = sourceCity;
    }

    // Calculates minimum cost from source to the destination
    // Source has to be set in setSource before executing this.
    public void setupMinimumCost(City destinationCity) {
        this.destinationCity = destinationCity;

        if (this.sourceCity == null)
            throw new RuntimeException("Source is still null. Please fix that");

        // We know cost of going from current city to current city is 0
        costs.put(sourceCity, 0);

        // Unless we clear out all the destination from a city, it remains in unmarked
        unmarkedCities.add(sourceCity);

        // Until we clear all the destinations
        while (unmarkedCities.size() > 0) {
            // Get the city with least cost from all the unmarked cities list
            City city = getMinimumCostCity(unmarkedCities);

            // Add it to visited/marked Cities
            markedCities.add(city);

            // Remove it from unmarked
            unmarkedCities.remove(city);

            // Calculate minimum costs using this city.
            calculateMinimumCost(city);
        }
    }

    // Calculate minimum cost
    private void calculateMinimumCost(City city) {
        // Get all the neighboring cities to this city
        List<City> neighboringCities = getNeighboringCities(city);

        for (City neighboringCity : neighboringCities) {

            int neighborCost = getSmallestCost(city) + getRelatedPathCost(city, neighboringCity);

            if (getSmallestCost(neighboringCity) > neighborCost) {
                // Update new cost
                costs.put(neighboringCity, neighborCost);

                // Specify parent of neighbor
                parents.put(neighboringCity, city);

                // Add neighbor to unmarked
                unmarkedCities.add(neighboringCity);

            }
        }
    }

    // Get the cost between two directly linked cities.
    // It does not calculate cost between cities that are not directly linked.
    private int getRelatedPathCost(City city1, City city2) {
        for (Path path : paths) {
            if (path.getSoureCity() == city1 && path.getDestinationCity() == city2)
                return path.getCost();
        }

        throw new RuntimeException("May be the cities are not directly linked");
    }

    // Returns neighboring cities to a city
    private List<City> getNeighboringCities(City city) {
        List<City> cities = new ArrayList<>();

        // Using all the paths, find and add cities that are linked to this city that are not marked
        for (Path path : paths) {
            if (path.getSoureCity() == city && !markedCities.contains(path.getDestinationCity()))
                cities.add(path.getDestinationCity());
        }
        return cities;
    }

    // Returns the city with least cost from all the unmarked cities list
    private City getMinimumCostCity(Set<City> cities) {

        // Lets start with first
        City minimumCostCity = cities.iterator().next();

        // If we override equals and hashCode of City, we can identify city objects uniquely, thus remove it
        cities.remove(minimumCostCity);

        // Examine other cities and determine which has the minimum cost
        for (City city : cities) {
            if (getSmallestCost(city) < getSmallestCost(minimumCostCity))
                minimumCostCity = city;
        }

        return minimumCostCity;
    }

    // Returns the current minimum cost assigned (calculated) to a city (from source)
    public int getSmallestCost(City city) {
        // Costs always keeps the updated minimum cost
        Integer cost = costs.get(city);

        // If no cost have been assigned yet, we set it to maximum allowed cost
        if (cost == null) {
            cost = MAX_ALLOWED_COST;
        }

        return cost;
    }

    // Returns the minimum cost path from source to destination (city)
    public List<City> getMinimumCostPath(City city) {
        ArrayList<City> cities = new ArrayList<>();
        City start = city;

        if (parents.get(start) == null)
            return null;

        cities.add(start);

        while (parents.get(start) != null) {
            start = parents.get(start);
            cities.add(start);
        }

        // Since we traversed from back, we want to reverse the list to show from source to destination
        // We will make a shadow copy of the list to do that.
        List<City> clonedList = (List<City>) cities.clone();
        Collections.reverse(clonedList);

        return clonedList;
    }
}
