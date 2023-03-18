
public class HashOpen {
	int size;
	int elements;
	int [] table;
	public HashOpen(int m){
		/**
		 * constructor
		 */
		this.elements = 0;
		this.table = new int[m]; // the table of values
		this.size = m;
		for (int i =0 ; i<m ;i ++) { // initiates the table
			this.table[i] = -1;
		}
	}
	public int h1(int k) {
		/**
		 * taking an given integer k as id and return the modulo of it with m
		 */
		int seat = k%this.size;
		return seat;
		
	}
	
	public int reverse(int k) {
		/**
		 * taking an given integer and reverse its chars order
		 */
		String s = String.valueOf(k);
		String res = "";
		for(int i = s.length()-1;i>=0;i--) {
			res += s.charAt(i);
		}
		return Integer.valueOf(res);
		
	}
	
	public int h2(int k) {
		/**
		 * taking an given integer k as id, reverse it and return the modulo of it with m
		 */
		int r_k = reverse(k);
		int res = r_k%this.size;
		return res;
}
	
	public int insert(int id, int hashFunc) {
		/**
		 * the function receives id as key to insert and integer - 1 or 2, if it gets 1 we will use h1 and if it will get 2 we will use h2
		 * the function will count how many steps it took to insert the person 
		 */
		int steps =0 ; // counter of the steps 
		int f;
		int more = 1; // the addition or submission to f
		if (hashFunc == 1) {
			f = h1(id);
		}
		else {
			f= h2(id);
		}
		while(this.table[f] != -1){ // while loop that checks if the table[f] has free spot, if there is we will insert the id and return the number
						// of steps that took to find the free spot
			if(f+more < this.table.length) {
				steps++;
				if (this.table[f+more] == -1){
					f= f+more;
					this.table[f] = id;
					this.elements ++;
					return steps;}}
			if(f-more >= 0) {
				steps++;
				if(this.table[f-more] == -1) {
					f= f-more;
					this.table[f] = id;// updating the spot
					this.elements ++;
					return steps;}}
			more++;
			}
		this.table[f] = id;
		this.elements ++; 
		return steps; // will return 0 if there is free spot at the index we have got from the hash function
		
	}
	public int getNumberElements() {
		/**
		 * return the field elements that keeps how much elements are in the table
		 */
		return this.elements;
	}
	public int getSize() {
		/**
		 *returns table size
		 */
		return this.size;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
