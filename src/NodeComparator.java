import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
		public int compare(Node x,Node y)
		{
			return x.frequency - y.frequency;
		}

}
