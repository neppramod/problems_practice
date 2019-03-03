import java.util.*;
import java.lang.*;

class HMRO
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for (int t = 0; t < s; t++) {
            int p = sc.nextInt();
            String[][] parr = new String[p][2];
            for (int i = 0; i < p; i++) {
                parr[i][0] = sc.next();
                parr[i][1] = sc.next();
            }

            int z = sc.nextInt();
            String[][] zarr = new String[z][2];
            for (int i = 0; i < z; i++) {
                zarr[i][0] = sc.next();
                zarr[i][1] = sc.next();
            }
            HashMap<String, String> zarrmap = reformatMRO(zarr);

            int peas = sc.nextInt();
            String[] peasarr = new String[peas];
            for (int i = 0; i < peas; i++) {
                peasarr[i] = sc.next();
            }

            HashMap<String, String> parrmap = reformat(parr, zarrmap);

            for (int i = 0; i < peas; i++) {
                System.out.println(peasarr[i] + " " + parrmap.get(peasarr[i]));
            }
        }

    }

    static HashMap<String, String> reformatMRO(String[][] zarr)
    {
        HashMap<String, String> map = new HashMap<>();
        for (int i = zarr.length-1; i>=0; i--) {
            String value = map.get(zarr[i][1]);
            map.put(zarr[i][0], value == null ? zarr[i][1] : value);
        }

        return map;
    }

    static HashMap<String, String> convertToMap(String[][] parr)
    {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < parr.length; i++) {
            map.put(parr[i][0], parr[i][1]);
        }
        return map;
    }

    static HashMap<String, String> reformat(String[][] parr, HashMap<String,String> zarrmap)
    {
        int M = parr.length;
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String value = zarrmap.get(parr[i][1]);
            if (value != null) {
                map.put(parr[i][0], value);
            } else {
                map.put(parr[i][0], parr[i][1]);
            }
        }

        return map;
    }
}
