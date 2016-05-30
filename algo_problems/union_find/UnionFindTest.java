public class UnionFindTest {
    public static void main(String[] args) {
        DisjointSet disJointSet = new DisjointSet();
        disJointSet.MakeSet(5);
        disJointSet.MakeSet(6);
        disJointSet.MakeSet(9);
        disJointSet.MakeSet(15);

        disJointSet.Union(5, 6);
        disJointSet.Union(9, 15);

        disJointSet.printNodeMap();
    }
}
