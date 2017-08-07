import java.util.*;
public class Maths
{
    public static boolean[] seive(int n)
    {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        int m = (int)Math.sqrt(n);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= m; i++) {
            if (prime[i]) {
                for (int j = i * i; j <=n; j+=i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    // greatest number that evenly divides both a and b
    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }

    // lowest multiple common to both numbers
    public static int lcm(int a, int b)
    {
        return b * a / gcd(a,b);
    }

    public static class Point
    {
        int x, y;
        public Point(int x1, int y1) { x = x1; y = y1;}
        public int getX() { return x; }
        public int getY() { return y; }
        public void setX(int x1) { x = x1; }
        public void setY(int y1) { y = y1; }
        boolean isGreaterThan(Point p) { if (p != null) { return x > p.getX() && y > p.getY(); } return false;}
    }

    public static class Rectangle
    {
        Point ll1, tr1;
        public Rectangle(Point ll11, Point tr11) { ll1 = ll11; tr1 = tr11;}
        public Point getLL1() { return ll1; }
        public Point getTR1() { return tr1; }
        public void setLL1(Point ll11) { ll1 = ll11; }
        public void setTR1(Point tr11) { tr1 = tr11; }
    }

    public static Rectangle intersection(Point LL1, Point TR1, Point LL2, Point TR2)
    {
        Point intll1 = new Point(Math.max(LL1.x, LL2.x), Math.max(LL1.y, LL2.y));
        Point inttr1 = new Point(Math.min(TR1.x, TR2.x), Math.min(TR1.y, TR2.y));

        if (intll1 != null && inttr1 != null && !intll1.isGreaterThan(inttr1))
            return new Rectangle(intll1, inttr1);

        return null;

    }

    // Area of polygon
    // A = B/2 + I - 1
    // B = no. of lattice points on boundary
    // I = no. of lattice in interior of polygon

    // Polygonnet
    // V - E + F = 2
    // V = no. of vertices, E = no. of edges, F = no. of faces (outside is also considered)

    // Bases
    // Integer.parseInt("" + n, b);
    // Integer.toBinaryString(n);
    // Integer.toOctalString(n);
    // Integer.toHexString(n);


    public static int[] multiplyFractions(int[] a, int[] b)
    {
        int[] c = {a[0] * b[0], a[1] * b[1]};
        return c;
    }

    public static int[] addFractions(int[] a, int[] b)
    {
        int denom = lcm(a[1], b[1]);
        int[] c = {denom/a[1] * a[0] + denom/b[1] * b[0], denom};
        return c;
    }

    public void reduceFraction(int[] a)
    {
        int b = gcd(a[0], a[1]);
        a[0] /= b;
        a[1] /= b;
    }

    // (a + ib) * (c + id) = (ac - bd) + i (ad + bc)
    public int[] multiplyComplex(int[] m, int[] n)
    {
        int[] prod = {m[0] * n[0] - m[1] * n[1], m[0] * n[1] + m[1] * n[0]};
        return prod;
    }

    // AB.BC = x1*x2 + y1*y2
    public static int dot(int[] A, int[] B, int[] C)
    {
        int[] AB = {B[0] - A[0], B[1] - A[1]};
        int[] BC = {C[0] - B[0], C[1] - B[1]};

        return AB[0] * BC[0] + AB[1] * BC[1];
    }

    // AB * AC = x1 * y2 - x2 * y1
    public static int cross(int[] A, int[] B, int[] C)
    {
        int[] AB = {B[0] - A[0], B[1] - A[1]};
        int[] AC = {C[0] - A[0], C[1] - A[1]};
        return AB[0] * AC[1] - AC[0] * AB[1];
    }

    // sqrt(x*x + y*y)
    public static int distance(int[] A, int[] B)
    {
        int[] AB = {B[0] - A[0], B[1] - A[1]};
        return (int)Math.sqrt(AB[0] * AB[0] + AB[1] * AB[1]);
    }

    // Line-Point distance

    // Area = 1/2*AB*b
    // Area = 1/2*ABxAC
    public static int linePointDistance(int[] A, int[] B, int[] C, boolean isSegment)
    {
        if (isSegment) {
            int d = dot(A,B,C);
            if (d > 0) return distance(B,C);
            d = dot(B,A,C);
            if (d > 0) return distance(A,C);
        }

        return cross(A, B, C) / distance(A, B);
    }

    // triangulate the polygon into p[0], p[i], p[i+1]
    public static int polygonarea(int[][] p)
    {
        int area = 0;
        int N = p.length;

        for (int i = 1; i + 1 < N; i++) {
            int x1 = p[i][0] - p[0][0];
            int y1 = p[i][1] - p[0][1];
            int x2 = p[i+1][0] - p[0][0];
            int y2 = p[i+1][1] - p[0][1];

            int cross = x1 * y2 - x2 * y1;
            area += cross;
        }

        return area/2;
    }

    // Ax + By = C
    // find A, B, C

    // A(x1-x2) = B(y2-y1)
    // A = y2-y1
    // B = x1-x2
    // C = Ax1 + By1
    public static int[] linecoefficients(int[] p1, int[] p2)
    {
        int[] coefficients = new int[3];
        coefficients[0] = p2[1] - p1[1];
        coefficients[1] = p1[0] - p2[0];
        coefficients[2] = coefficients[0] * p1[0] + coefficients[1] * p1[1];
        return coefficients;
    }

    // A1x + B1y = C1
    // A2x + B2y = C2
    // Find point of intersection

    // A1B2x + B1B2y = B2C1
    // A2B1x + B1B2y = B1C2
    // x = (B2C1 - B1C2) / A1B2 - A2B1
    // denom (0) = parallel lines
    // A1A2x +  A2B1y = A2C1
    // A1A2x + A1B2y = A1C2
    // y = A1C2 - A2C1 / A1B2 - A2B1
    public static int[] linelineintersection(int[] L1, int[] L2)
    {
        int[] points = new int[2];
        int denom = L1[0] * L2[1] - L2[0] * L1[1];


        if (denom == 0) {
            points[0] = Integer.MIN_VALUE;
            points[1] = Integer.MIN_VALUE;
            return points;
        }

        points[0] = (L2[1 * L1[2] - L1[1] * L2[2]]) / denom;
        points[1] = (L1[0] * L2[2] - L2[0] * L1[2]) / denom;
        return points;
    }

    // make sure point is in the line segment
    public static boolean ispointinlinesegments(int[] P, int[] L1, int[] L2)
    {
        boolean xchecked = (Math.min(L1[0], L2[0]) <= P[0]) && (P[0] <= Math.max(L1[0], L2[0]));
        boolean ychecked = (Math.min(L1[1], L2[1]) <= P[1]) && (P[1] <= Math.max(L1[1], L2[1]));

        return xchecked && ychecked;
    }

    // center of circle from 3 points that line in circumference
    // describe XY,YZ in Ax + By = C (or could use 2 points formula)
    // find mid point of XY,YZ
    // line perpendicular to Ax + By = C is -Bx + Ay = D
    // To find D, find mid point of X and Y and plug
    // Intersection of perpendiculars line from mind points of XY and YZ
    // is center
    // Distance from radius to one of the points is radius
    public static int[] circlecenter(int[] X, int[] Y, int[] Z)
    {
        int[] XY = linecoefficients(X, Y);
        int[] YZ = linecoefficients(Y, Z);

        int[] XYDash = {(-1) * XY[1], XY[0], 0};
        int[] YZDash = {(-1) * YZ[1], YZ[0], 0};

        int[] MXY = {(X[0] + Y[0])/2, (X[1] + Y[1])/2};
        int[] MYZ = {(Y[0] + Z[0])/2, (Y[1] + Z[1])/2};

        XYDash[2] = XYDash[0] * MXY[0] + XYDash[1] * MXY[1];
        YZDash[2] = YZDash[0] * MYZ[0] + YZDash[1] * MYZ[1];

        return linelineintersection(XYDash, YZDash);
    }

    // reflection of X into line L, find XDash
    public static int[] reflection(int[] L, int[] X)
    {
        int[] LPerpendicular = {(-1) *L[1], L[0], 0};
        LPerpendicular[2] = (-1) * L[1] * X[0] + L[0] * X[1];

        int[] Y = linelineintersection(L, LPerpendicular);

        int[] XDash = {2 * Y[0] - X[0], 2 * Y[1] - X[1]};
        return XDash;
    }

    // rotation of point
    // [cos -sin]
    // [sin cos]
    public static int[] rotate(int[] X, int degrees)
    {
        int x = X[0];
        int y = X[1];
        int radian = (int)Math.toRadians(degrees);
        int[] XDash = new int[2];
        XDash[0] = (int)(x * Math.cos(radian) - y * Math.sin(radian));
        XDash[1] = (int)(x * Math.sin(radian) + y * Math.cos(radian));

        return XDash;
    }
}