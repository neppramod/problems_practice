package myprob;

public class NodeExample
{
	public static void main(String[] args) {
		Node node = new Node(3);
		node.appendToTail(7);
		node.appendToTail(9);
		node.appendToTail(2);
		
		node.printNode();
		node = node.delete(node, 9);
		node.printNode();
		node = node.delete(node,3);		
		node.printNode();
		node = node.delete(node,7);
		node = node.delete(node,2);
		node.printNode();
	}
}
