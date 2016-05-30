import java.util.Objects;

/**
 * City: City nodes
 */
public class City {
    private int index; // Index number of the city
    private String name;  // Name of the city

    public City(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    // Two cities are same if their name and indexes match
    public boolean equals(Object o) {
        City otherCity = (City) o;

        if (otherCity.getIndex() == index && otherCity.getName().equals(name))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }
}
