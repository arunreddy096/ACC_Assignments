package Assignment;
import java.util.*;

public class Task1And2 {
	
	// generating random strings of length 10
	public static String generaterandomstring() {
		String string = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String outputString="";
	    Random random = new Random();
	    StringBuilder stringBuild = new StringBuilder();
	    	for(int i = 0; i < 10; i++) 
		      {
		      int index = random.nextInt(string.length());
		      stringBuild.append(string.charAt(index));
		      }
	    	outputString=stringBuild.toString();

	    return outputString;
	 
	}
	
	//inserting random string into hash table
	public static HashMap<Integer, String> avginsertiontime(int n,HashMap<Integer, String> hashtable) {
		long totalTimeTaken=0;
	 
	    for(int i=1; i<=n; i++) {
	    	String out=generaterandomstring();
	    	long start = System.nanoTime();
		    hashtable.put(i, out);	
		    long end = System.nanoTime();
		    long Time=end-start;
		    totalTimeTaken+=Time;       
	    }
	    System.out.println("average insertion compute time " + (totalTimeTaken/n)+" nanoseconds");
	    return hashtable;

	}
	
	//searching a random string from hashtable and deleting it
	public static Map<Integer, String> avgsearchtime(int n,HashMap<Integer, String> hashtable) {
		long totalTimeTaken=0;
		for(int i=0;i<n;i++) {
			String out=generaterandomstring();	
			long start = System.nanoTime();
		    boolean value = hashtable.containsValue(out);
		    long end = System.nanoTime();
		    long Time=end-start;
		    totalTimeTaken+=Time;
		    if(value==true)
	    	{
	    	    System.out.println("yes");
	    		hashtable.values().remove(out);
	    	}	
		}

	    System.out.println("average search compute time " + (totalTimeTaken/n)+" nanoseconds");
	    return hashtable;
	}
	
	
	
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		HashMap<Integer, String> ht = new HashMap<>();
		
		//@SuppressWarnings("resource")
		System.out.print("enter a number: ");
		Scanner Obj = new Scanner(System.in);
		int n = Obj.nextInt();
		avginsertiontime(n,ht);
		avgsearchtime(n,ht);
		System.out.print(ht);
}
	
	
}
