import java.io.File;
import java.util.*;

/**
 * Tests the calculation of Shortest path cost problem using ShortestPath class.
 * The problem is designed to take input using the format (including variables like s, n, p, nr, cost and r) described in
 * http://www.spoj.com/problems/SHPATH/
 * Also throws RuntimeException if s, n and r are larger than specified maximum.
 */
public class ShortestPathTest {

    static final boolean PRINT_PATH = true;  // If true prints the minimum path
    static final boolean PRINT_DEBUG_MESSAGE = false; // If true prints all the city indexes and neighbors (DEBUG).
    static ArrayList<City> cities = new ArrayList<>(); // List of input cities
    static ArrayList<Path> paths = new ArrayList<>(); // List of edges (paths) between different cities

    // This method sets up the input and calculates shortest path using ShortestPath class. It is called from main (below)
    public static void test() {
        try {
            Scanner sc = new Scanner(new File("d.shpath.txt"));

            // Captures city index as key and (neighbor node, cost) as list
            HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> cityWithNeighborCosts =
                    new HashMap<>();

            // Separate arraylist to maintain index of cities, because HashMap does not maintain order
            ArrayList<String> cityNames = new ArrayList<>();

            System.out.println("Input:");

            System.out.println("Read from d.shpath.txt. Change the Scanner input to System.in to read from console");

            // Number of tests
            int s = sc.nextInt();
            if (s > 10)
                throw new RuntimeException(" Number of tests cannot be greater than 10");

            // Number of cities
            int n = sc.nextInt();
            if (n > 10000)
                throw new RuntimeException("Number of cities cannot be greater than 10000");

            // Enter data for each city
            for (int i = 0; i < n; i++) {

                // Escape remaining of the line
                sc.nextLine();

                String cityName = sc.nextLine();
                cityNames.add(cityName);

                // Number of neighbors
                int p = sc.nextInt();

                // Map of neighbor index and associated cost of the path to each city (cityName)
                ArrayList<HashMap<Integer, Integer>> neighborsWithCost = new ArrayList<>();


                // Add each neighbor with associated cost
                for (int j = 0; j < p; j++) {

                    // Neighbor
                    int nr = sc.nextInt();


                    // Important Note
                    // ==============
                    // ==============


                    // NOTE: I want to adjust the neighbor index, so that I can start from index 0,
                    // instead of index 1 as in question.
                    // However the user input will be from 1 (which I adjust in code)
                    // I will also start city index from 0 latter on.

                    nr = nr - 1;


                    // Cost of travelling to neighbor from current city
                    Integer cost = sc.nextInt();

                    HashMap<Integer, Integer> neighborWithCost = new HashMap<>();
                    neighborWithCost.put(nr, cost);
                    neighborsWithCost.add(neighborWithCost);
                }

                cityWithNeighborCosts.put(i, neighborsWithCost);
            }

            // Number of minimum paths to calculate
            int r = sc.nextInt();
            if (r > 100)
                throw new RuntimeException("Number of paths cannot be greater than 100");

            ArrayList<HashMap<String, String>> pathInputs = new ArrayList<>();

            // Add source destination pairs to pathInputs
            for (int i = 0; i < r; i++) {
                String source = sc.next();
                String destination = sc.next();

                HashMap<String, String> pair = new HashMap<>();
                pair.put(source, destination);
                pathInputs.add(pair);
            }


            // Format the data that we received from the user input and print cost

            // Lets create the city nodes first

            // Important Note
            // ==============
            //

            // Note: As specified above, while creating neighbors, I add city with index 0
            // as start. (Again, the user will input city starting from index 1)


            for (int i = 0; i < cityNames.size(); i++) {
                addCity(i, cityNames.get(i));
            }

            // Add paths
            for (Map.Entry<Integer, ArrayList<HashMap<Integer, Integer>>> cityWithNeighborCost : cityWithNeighborCosts.entrySet()) {
                Integer sourceCityIndex = cityWithNeighborCost.getKey();
                ArrayList<HashMap<Integer, Integer>> destinationCitiesWithCost = cityWithNeighborCosts.get(sourceCityIndex);

                for (HashMap<Integer, Integer> destinationCityWithCost : destinationCitiesWithCost) {
                    int destinationCityIndex = (Integer) destinationCityWithCost.keySet().toArray()[0];
                    int pathCost = destinationCityWithCost.get(destinationCityIndex);

                    // We got the index of connected nodes to city with index sourceCityIndex. Now we can add path
                    addPath(sourceCityIndex, destinationCityIndex, pathCost);
                }
            }


            System.out.println("\n"); // One more line
            // Output:
            System.out.println("Output:");

            // For DEBUG purpose only. Default: Set to false
            if (PRINT_DEBUG_MESSAGE)
                debugPrintCitiesAndNodes();


            for (HashMap<String, String> pathInput : pathInputs) {

                // Lets calculate the shortest path (minimum cost)

                ShortestPath shortestPath = new ShortestPath(cities, paths);

                String sourceCityName = (String) pathInput.keySet().toArray()[0];
                String destinationCityName = pathInput.get(sourceCityName);

                City sourceCity = findCityByName(sourceCityName);
                City destinationCity = findCityByName(destinationCityName);

                if (sourceCity == null || destinationCityName == null)
                    throw new RuntimeException("City object could not be found using city name");

                // Set the source city
                shortestPath.setSourceCity(sourceCity);

                // Calculate the minimum cost from source city to destination city
                shortestPath.setupMinimumCost(destinationCity);


                // Instead of showing just the minimum cost, I also want to show the minimum path from source to destination. (if PRINT_PATH is true). Default: Set to true
                List<City> minimumCostCities = shortestPath.getMinimumCostPath(destinationCity);

                if (PRINT_PATH) {
                    for (City city : minimumCostCities) {
                        System.out.print(city + " : ");
                    }
                }

                // Print minimum cost
                System.out.print(shortestPath.getSmallestCost(destinationCity) + "\n");


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Add a city to the list of cities
    private static void addCity(int index, String name) {
        cities.add(new City(index, name));
    }

    // Add route and cost between two cities
    private static void addPath(Integer sourceIndex, Integer destinationIndex, int cost) {
        Path path = new Path(cities.get(sourceIndex), cities.get(destinationIndex), cost);
        paths.add(path);
    }

    // Find city by city name
    private static City findCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName))
                return city;
        }

        return null;
    }

    // Just for debugging purpose: To see whether everything from input was set properly or not
    private static void debugPrintCitiesAndNodes() {
        for (City city : cities)
            System.out.print(city.getIndex() + ": " + city.getName() + ", ");

        for (Path path : paths)
            System.out.println(path.getSoureCity() + "-" + path.getDestinationCity() + " : " + path.getCost());


    }

    public static void main(String[] args) {

        // Test method gets the user input, creates list of city nodes and paths and calculates the shortest path cost.
        // To run the sample test in http://www.spoj.com/problems/SHPATH/,
        // Once the project runs and waits for input copy all the text between "Input:" and "Output:" (excluding those two lines)

        System.out.println("To run the sample test in http://www.spoj.com/problems/SHPATH/,");
        System.out.println("Once the project runs and waits for input copy all the text between \"Input:\" and \"Output:\" (excluding those two lines)");
        System.out.println("Also, I have printed the path. To omit printing the minimum path PRINT_PATH boolean variable can be set to false");
        System.out.println("====================");
        System.out.println("====================");

        test();
    }
}
