
public class HashClosed {
	final public  int array_size;
	final public LinkedList array [];
	public HashClosed(int m) {
		/**
		 * constructor - initiate new hash table
		 */
		
		if (0<m && m<3) {
			array_size = 1;
			array = new LinkedList [array_size];
			array[0] = new LinkedList();
		}
		else {
			array_size = Math.floorDiv(m,3); // creates the table size
			array = new LinkedList[array_size]; 
			for(int i =0 ; i< array_size;i++) {
				array[i] = new LinkedList();
		}
			
		}
	}
	
	public void insert(String [] person) {
		/**
		 * inserting person to the hash table
		 */
		int k = Integer.valueOf(person[0]);
		int index = k%array_size;
		array[index].add(person);
	}
	
	public int[] getNodesSize() {
		/**
		 * returns the size of the nodes in the array
		 */
		int[] sizes = new int[array_size];// array in size n/3
		for(int i = 0; i<sizes.length && i<array.length ; i++) {
			int temp = array[i].getSize();
			sizes[i] =temp;

		}

		return sizes;
	}
	public int[] search(String[] person) {
		/**
		 * using 2 helper functions from class LinkedList to find out if the person is in the linked list
		 * and counting how much steps it takes to find him
		 */
		int[] found_steps = {0,0};
		int k = Integer.valueOf(person[0]);
		int index = k%array_size;
		found_steps[0] = array[index].search(person[0]);
		found_steps[1] = array[index].countsteps(person[0]);
		return found_steps;
		
	}
	
	public int getSize() {
		/**
		 * returns the size of the hash table
		 */
		return array_size;
	}
	
	public int gettotalsize() {
		/**
		 * returns the total size of the hash table
		 */
		int total = 0;
		int [] s = getNodesSize();
		for(int i=0 ; i<s.length;i++) {
			total += s[i];
		}
		return total;
	}
}
