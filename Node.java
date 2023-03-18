
public class Node implements Comparable<Node> {
	/**
	 * Node that represents person in the audience list
	 *
	 */
	String id;
	String first_name;
	String last_name;
	String ticket_type;
	private Node next;
	public Node(String [] person) {
		/**
		 * constructor
		 */

		this.id = person[0];
		this.first_name = person[1];
		this.last_name = person[2];
		this.ticket_type = person[3];
		this.next = null;
		
	}
	public void setNext(Node p) {
		this.next = p; 
	}
	public Node getNext() {
		/**
		 * returns the next node 
		 */
		return this.next;
	}
	public String [] getData() {
		/**
		 * returns the person's data as strings array
		 */
		String [] data  = {this.id,this.first_name,this.last_name,this.ticket_type};
		return data;
	}

	public int compareTo(Node other) {
		/**
		 * Comparator between nodes by ticket type
		 * this function gets other node in order to compare to him, there is list with the ticket types when 
		 * the list in the first index is the lowest rank of ticket and the last index is the highest. it use the indices 
		 * to compare with one has more valuable ticket
		 */
		String [] types = {"OUTER_RING","INNER_RING","GOLDEN_RING","VIP"};
		int a=0;
		int b=0;
		for(int i=0;i< types.length;i++) {
			if (this.ticket_type.equals(types[i])) {
				a = i;
			}
			if (other.ticket_type.equals(types[i])) {
				b = i;
			}
		
		}
		if (a>b) { 

			return 1;	
		}
		if (a<b) {
			return -1;	
		}
		return 0;
	}
}
