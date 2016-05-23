import java.util.*;

public class GNode
{
	public int data;
	public List<GNode> neighbors;
	public boolean visited;
	public GNode(int data) { this.data = data; }
}
