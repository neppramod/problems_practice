public class RecursiveMultiply
{
    static int multiply(int x, int y)
    {
	if (x == 0 || y == 0)
	    return 0;

	boolean negative = x < 0 || y < 0;

	int xval = Math.abs(x);
	int yval = Math.abs(y);

	int product = xval + multiply(xval, yval-1);
	if (negative)
	    return 0 - product;
	else
	    return product;
    }

    static int multiplyByHalf(int smaller, int bigger)
    {
	if (smaller == 0)
	    return 0;
	if (smaller == 1)
	    return bigger;

	int s = smaller >> 1;
	int side1 = multiplyByHalf(s, bigger);
	int side2 = side1;

	if (smaller % 2 == 1) {
	    side2 = multiplyByHalf(smaller - s, bigger);
	}

	return side1 + side2;
    }

    public static void main(String[] args)
    {
	System.out.println(multiply(5000, 3000));
	System.out.println(multiplyByHalf(5000, 3000));
    }
}
