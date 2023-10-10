package crackingCoding6thEdition.Ch_09_Scalability_and_Memory_Limits.Q9_05_Cache;

public class Node {
	public Node prev;
	public Node next;
	public String[] results;
	public String query;

	public Node(String q, String[] res) {
		results = res;
		query = q;
	}
}
