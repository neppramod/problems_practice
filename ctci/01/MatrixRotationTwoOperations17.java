public class MatrixRotationTwoOperations17
{
    public static void rotate(int[][] array)
    {
        translate(array);
        mirror(array);
    }

    static void translate(int[][] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array[0].length; j++) {
                int tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }
    }

    static void print(int[][] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void mirror(int[][] array)
    {
        for (int j = 0; j < array[0].length / 2; j++) {
            for (int i = 0; i < array.length; i++) {
                int tmp = array[i][j];
                array[i][j] = array[i][array[0].length - 1 - j];
                array[i][array[0].length - 1 - j] = tmp;
            }
        }
    }

    static void mirrordown(int[][] array)
    {
        for (int i = 0; i < array.length / 2; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int tmp = array[i][j];
                array[i][j] = array[array.length - 1 - i][j];
                array[array.length - 1 - i][j] = tmp;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] array = {{5,7,3,7,3},
                         {6,3,7,4,2},
                         {7,4,2,7,5},
                         {1,0,3,6,8},
                         {7,2,3,5,7}};
        print(array);
        System.out.println();
        translate(array);
        print(array);
        System.out.println();
        mirrordown(array);        
        print(array);
    }

    
}
