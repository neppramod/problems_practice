public class Node {
    public Node parent;
    public int rank;
    private int x;

    public Node(int x) {
        this.x = x;
        this.parent = this;
        this.rank = 0;
    }

    public int getX() {
        return x;
    }
}
