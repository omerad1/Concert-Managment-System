import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Concert {
	/**
	 * constructor
	 */
	
	public static LinkedList getFromFile(String FileName) {
		/**
		 * create linked list from the people in the file
		 */
		LinkedList crowd = new LinkedList(); // the linkedlist that going to be returned
		try {
			File file = new File(FileName);
			Scanner s1 = new Scanner(file);
			while(s1.hasNextLine()) {
				String[] person = s1.nextLine().split(",");
				crowd.add(person);
			}
			s1.close();

		} catch (FileNotFoundException e) {
			System.out.println("file not found !");
	}
		return crowd;
	}
	public static HashClosed registerCrowd(String file_path) {
		/**
		 * the function gets an file with list of people and returns hash closed with the
		 *  people that has been registered
		 * 
		 */
		LinkedList scanned = getFromFile(file_path);
		int size = scanned.getSize(); // the amount of people that going to be registered
		HashClosed hash = new HashClosed(size);
		Node pointer = scanned.getHead(); // pointer to head
		while (pointer != null) {
			String [] person = pointer.getData();
			pointer = pointer.getNext();
			hash.insert(person);

		}
		return hash;
	}
	public static void sort_concert(int []arr) {
		/**
		 * sort function for sorting the ids
		 */
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
	}
	}
	public static int[] reception(String file_path, HashClosed registered) {
		/**
		 * the function gets list of people from the file and hash table with all the registered people, 
		 * it checks for every people from the file if he registered, if he is the function will add him to the seated 
		 * list. if there is free spots left the people will be seated in the free spots by their tickets value order
		 */
		int sz; //will be the size of the id array of pre seated people
		int free_spots = 0;
		LinkedList waitinglist = getFromFile(file_path);// linked list of the arrived people
		int n = registered.gettotalsize(); // total people that has been registered before 
		int i = waitinglist.getSize(); // amount of people that arrived
		if(i<n) { // if there is not enough people to fill the hall
			sz = i;
		}
		else {
			sz =n;
		}
		int [] seated = new int [sz]; 
		for (int h=0;h<seated.length; h++) {
			seated[h] = 0;
			
		}
		LinkedList n_regis = new LinkedList(); // new linked list for all the people that came but haven't done pre registration
		Node pointer = waitinglist.getHead();
		int a = 0;
		for(int j=0;j<i;j++) { // for loop that checks if person is registered or not
								// if he is it will add him to the sited list, else it will add him to not registered list
			if(a == seated.length) {
				break;
			}
			if(pointer != null) {
				String [] key = pointer.getData();
				pointer = pointer.getNext();
			if (registered.search(key)[0] == 1) { // the person arrived and he is registered
				seated[a] = Integer.valueOf(key[0]);
				a++;
			}
			else {
				n_regis.add(key);	
			}
			}
		}
		while(a<sz) {
			if(n_regis.getSize()> 0) {
				seated[a] = n_regis.popmax();
				a++;}
			else {
				break;
			}
		}
		sort_concert(seated);
		return seated;
		
	}
	
	public static int reception_AverageSteps(String file_path, HashClosed registered) {
		/**
		 * Return average steps of searching in HashClosed
		 */
		
		LinkedList arrived = getFromFile(file_path); // create linked list from the file 
		int total_steps = 0; // the counter of steps 
		Node dummy = arrived.getHead();
		while (dummy != null) { // while loop for counting total steps in searching from registered people in the file 
			total_steps = total_steps + (registered.search(dummy.getData())[1]);
			dummy = dummy.getNext();
		}
		if(arrived.getSize() == 0) {
			return 0;
		}
		return Math.floorDiv(total_steps,arrived.getSize()); 
		
	}
	
	
	
	public static int[] seatingArrangement(int[] sortedCrowed, HashClosed registered, int functionNum) {
		/**
		 * this function creates list with statistics about the seating arrangement,
		 *  it saves the stats in variabels and returns them in list
		 */
		int size = registered.gettotalsize(); // the size of the concert hall
		int Sa = 0; // first N/2 
		int Sb = 0;	// first 3N/4
		int Sc = 0;	// first N - sqrt(N)
		int Sd = 0;	// last sqrt(N)
		int steps;
		int n = sortedCrowed.length;
		HashOpen open = new HashOpen(size);
		for(int i=0;i< sortedCrowed.length;i++) {
			steps = open.insert(sortedCrowed[i], functionNum);
			if (i+1<= Math.floorDiv(n,2)){
				Sa += steps;
			}
			if (i+1<= Math.floorDiv((3*n),4)){
				Sb += steps;
			}
			if (i+1<= n-(int)(Math.floor(Math.sqrt(n)))){
				Sc += steps;
			}
			if (i+1> n-(int)Math.floor(Math.sqrt(n))){
				Sd += steps;
			}
			steps = 0;
		}
		int [] res = {Sa,Sb,Sc,Sd};
		return res;
		
	}

	
	}
