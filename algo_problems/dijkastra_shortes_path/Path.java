/**
 * Path between two cities
 */
public class Path {
    private City soureCity;         // Path from
    private City destinationCity;   // Path to
    private int cost;               // Transportation cost from sourceCity to destinationCity

    public Path(City sourceCity, City destinationCity, int cost) {
        this.soureCity = sourceCity;
        this.destinationCity = destinationCity;
        this.cost = cost;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public City getSoureCity() {
        return soureCity;
    }

    public int getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return soureCity + " - " + destinationCity;
    }


}
