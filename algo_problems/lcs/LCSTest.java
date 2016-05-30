import java.io.File;
import java.util.Scanner;

public class LCSTest {
    String[][] b;
    int[][] c;

    public LCSTest() {

    }

    public static char[] createArrayFromStringIndex1(String str) {
        char outputChars[] = new char[str.length() + 1];
        char strChars[] = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            outputChars[i + 1] = strChars[i];
        }

        return outputChars;
    }

    public static void lcsPrinter(String str1, String str2) {
        System.out.println("==========================");
        System.out.println("Str1: " + str1);
        System.out.println("Str2: " + str2);
        ;


        LCSTest lcsExample = new LCSTest();
        char[] str1_1_indexedChars = LCSTest.createArrayFromStringIndex1(str1);
        char[] str2_1_indexedChars = LCSTest.createArrayFromStringIndex1(str2);


        lcsExample.lcsLength(str1_1_indexedChars, str2_1_indexedChars);
        lcsExample.printb();
        lcsExample.printc();
        lcsExample.printLCS(str1_1_indexedChars, str1_1_indexedChars.length - 1, str2_1_indexedChars.length - 1);
        System.out.println("\n==========================");
    }

    public static void main(String[] args) {
        /*
        lcsPrinter("abacabaca", "bacbacbacbac");
        lcsPrinter("abacabac", "bacbacbacbac");
        lcsPrinter("abacaba", "bacbacbacbac");
        lcsPrinter("abacabac", "bacbacbacba");
        */
        try {
            Scanner sc = new Scanner(new File("c.lcsinput.txt"));

            while (sc.hasNext()) {
                String a = sc.next();
                String b = sc.next();
                lcsPrinter(a, b);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void lcsLength(char[] X, char[] Y) {

        int m = X.length;
        int n = Y.length;


        b = new String[m][n];
        c = new int[m][n];

        for (int i = 0; i < m; i++)
            b[i][0] = "";
        for (int j = 0; j < n; j++)
            b[0][j] = "";

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X[i] == Y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "d";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "↑";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "←";
                }
            }
        }
    }

    public void printLCS(char[] X, int i, int j) {
        if (i == 0 || j == 0)
            return;

        if (b[i][j].equals("d")) {
            printLCS(X, i - 1, j - 1);
            System.out.print(X[i]);
        } else if (b[i][j].equals("↑"))
            printLCS(X, i - 1, j);
        else
            printLCS(X, i, j - 1);
    }


    public void printc() {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++)
                System.out.print(c[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void printb() {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

}
