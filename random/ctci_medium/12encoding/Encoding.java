import java.util*;

public class Encoding
{
    pubic static void main(String[] args)
    {
        HashMap<String, Integer> mapping = getMapping();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            encode(sc.nextLine(), mapping);
        }
    }

    private static void encode(String line, HashMap<String, Integer> mapping)
    {
        String[] parts = line.split(" ");


    }

    private static HashMap<String, Integer> getMapping()
    {
        HashMap<String, Integer> mapping = new HashMap<>();
        mapping.add("family", 1);
        mapping.add("person", 2);
        mapping.add("firstName", 3);
        mapping.add("lastName", 4);
        mapping.add("state", 5);
        return mapping;
    }

}
