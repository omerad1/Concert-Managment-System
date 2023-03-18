
public class LinkedList {
	/**
	 * constructor
	 */
	
	public Node head;
	int size;
	public Node tail;
	public LinkedList(){
		/**
		 * Constructor
		 */
		this.head = null;
		this.size = 0;
		this.tail = null;
		
		
	}
	public Node getHead() {
		/**
		 * return the head of the linked list
		 */
		return this.head;
		
	}
	public int getSize() {
		/**
		 * returns the size of the linked list 
		 */
		return this.size;
	}
	public int search(String key) {
		/**
		 * searching for a key in the linked list, if found return 1 else reuturn 0 
		 */
		Node pointer = this.head;
		while(pointer != null) {
			String a = pointer.id;
			if (pointer.id.equals(key)){
				return 1;
			}
			pointer = pointer.getNext();}
		
		return 0;
			
			
		}
	public int countsteps(String key) {
		/**
		 * counting the steps until found/not found key
		 */
		Node pointer = this.head;
		int steps = 0;
		while(pointer != null) {
			if (pointer.id.equals(key)){
				steps++;
				return steps;
			}
			pointer = pointer.getNext();
			steps ++;
			}
		steps ++;
		return steps;
	}
	public void add(String [] person) {
		/**
		 * adds new node to the end of the list
		 */
		Node p = new Node(person);
		if (this.size == 0) {
			this.head = p;
			this.tail = p;
		}
		else {
			this.tail.setNext(p);
			this.tail = p;
			
		}
		this.size ++;
		}
	public void delete(Node key) {
		/**
		 * delete elements from the linked list - found by key
		 */
		Node pointer = this.head;
		if(this.head == null) {
			return;
		}
		if(this.head.id.equals(key.id)) {
			this.head = this.head.getNext();
			this.size --;
		}
		else {
		while(pointer.getNext() != null) {
			if (pointer.getNext().id.equals(key.id)){
				this.size --;
				pointer.setNext(pointer.getNext().getNext());	
			}
			if (pointer.getNext() == null) {
				break;
			}
			pointer = pointer.getNext();}
		
		}
	}
	public int popmax() {
		/**
		 * pops the max element from the linked list
		 */
		Node dummy = this.head;
		Node max = this.head;

		while (dummy != null) {
			if (max.compareTo(dummy) == -1) {
				max = dummy;
				
			}
			dummy = dummy.getNext();
		}
		delete(max);
		return Integer.valueOf(max.id);
		
	}
	}



