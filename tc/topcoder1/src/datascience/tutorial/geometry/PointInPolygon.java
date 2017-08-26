package datascience.tutorial.geometry;

import tc.lib.Maths;

public class PointInPolygon {
    public static void main(String[] args) {
        String[] vertices = {"1 0", "2 0", "2 1", "3 1", "3 0", "4 0", "4 -1", "5 -1", "5 0",
                "6 0", "6 2", "0 2", "0 3", "-1 3", "-1 4", "0 4", "0 6", "1 6",
                "1 7", "0 7", "0 8", "-2 8", "-2 2", "-8 2", "-8 0", "-7 0",
                "-7 -1", "-6 -1", "-6 0", "-4 0", "-4 1", "-3 1", "-3 0",
                "-2 0", "-2 -6", "0 -6", "0 -5", "1 -5", "1 -4", "0 -4",
                "0 -3", "-1 -3", "-1 -2", "0 -2", "0 -1", "1 -1"};
        int x = 0, y = 0;
        System.out.println(new PointInPolygon().testPoint(vertices, x, y));

    }

    String testPoint(String[] vertices, int testPointX, int testPointY) {
        int N = vertices.length;
        int count = 0;

        int x2 = (int) (Math.random() * 1000 + 1000);
        int y2 = (int) (Math.random() * 1000 + 1000);
        int[] randomPoint = {x2, y2};

        for (int i = 0; i < N; i++) {
            int[] vertexi = getPoint(vertices[i]);
            int[] vertexip1 = getPoint(vertices[(i + 1) % N]);
            int[] testPoint = {testPointX, testPointY};

            int linePointDistance = Maths.linePointDistance(vertexi, vertexip1, testPoint, true);

            if (linePointDistance == 0) {
                return "BOUNDARY";
            }


            int[] segmentIntersection = Maths.linelineintersection(vertexi, vertexip1, testPoint, randomPoint, true);
            if (segmentIntersection[0] != Integer.MIN_VALUE && segmentIntersection[1] != Integer.MIN_VALUE)
                count++;
        }

        if (count % 2 == 0) return "EXTERIOR";
        else return "INTERIOR";
    }

    private int[] getPoint(String vertex) {
        int[] point = new int[2];
        String[] ps = vertex.split(" ");
        point[0] = Integer.parseInt(ps[0]);
        point[1] = Integer.parseInt(ps[1]);

        return point;
    }
}
