import java.util.HashMap;

public class DisjointSet {
    private HashMap<Integer, Node> nodeMap;

    public DisjointSet() {
        nodeMap = new HashMap<Integer, Node>();
    }

    public void MakeSet(int x) {
        nodeMap.put(x, new Node(x));
    }

    Node Find(int x) {
        Node node = null;

        if (nodeMap.containsKey(x))
            node = nodeMap.get(x);

        if (node != null)
            node = findRoot(node);

        return node;
    }

    Node findRoot(Node node) {
        if (node.parent == node)
            return node;
        else
            return findRoot(node.parent);
    }

    void Union(int x, int y) {
        Node xRoot = Find(x);
        Node yRoot = Find(y);

        if (xRoot != null && yRoot != null) {

            if (xRoot == yRoot)
                return;

            // x and y are not already in same set. Merge them.
            if (xRoot.rank < yRoot.rank)
                xRoot.parent = yRoot;
            else if (xRoot.rank > yRoot.rank)
                yRoot.parent = xRoot;
            else {
                yRoot.parent = xRoot;
                xRoot.rank = xRoot.rank + 1;
            }

        }
    }

    void printNode(Node node) {
        System.out.print(node.getX() + " ");

        if (node == node.parent)
            return;

        printNode(node.parent);
    }

    void printNodeMap() {

        for (int key : nodeMap.keySet()) {
            Node node = nodeMap.get(key);
            printNode(node);
            System.out.println();
        }

        System.out.println();
    }
}
