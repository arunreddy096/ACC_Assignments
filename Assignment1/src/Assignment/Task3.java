package Assignment;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task3 {
	//method for generating random string
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
	
	// method for insertion of cuckoo, quadratic and separate chaining hashtables
	public static void avginsertiontime(){
		long startTime, endTime;
		long totalTimeTaken=0;
		
		// cuckoo hash table insertion
		for (int i = 1; i <= 20; i++) {
			
			double n = Math.pow(2, i);
			startTime = System.nanoTime();
			for ( n = 0; n < Math.pow(2, i); n++) {
				CuckooHashTable<String> cuckooHashTable = new CuckooHashTable<>(new StringHashFamily(10), 2000);
				cuckooHashTable.insert(generaterandomstring());
				
			}
			endTime = System.nanoTime();
			totalTimeTaken=(endTime-startTime);
			System.out.println("\nAvg Time for insertion " + (int) Math.pow(2, i)
			+ " in CuckooHashTable  is " + totalTimeTaken/n);
			
			// Quadratic probing hash table insertion
			startTime = System.nanoTime();
			for (n = 0; n < Math.pow(2, i); n++) {
				QuadraticProbingHashTable<String> quadraticHashTable = new QuadraticProbingHashTable<>();
				quadraticHashTable.insert(generaterandomstring());
				
			}
			endTime = System.nanoTime();
			totalTimeTaken=(endTime-startTime);
			System.out.println("Avg Time for insertion " + (int) Math.pow(2, i)
			+ " in QuadraticHashTable  is " + totalTimeTaken/n);
			
			// separate hash table insertion
			startTime = System.nanoTime();
			for ( n = 0; n < Math.pow(2, i); n++) {
				SeparateChainingHashTable<String> separateChainHashTable = new SeparateChainingHashTable<>();
				separateChainHashTable.insert(generaterandomstring());
				
			}
			endTime = System.nanoTime();
			totalTimeTaken=(endTime-startTime);
			System.out.println("Avg Time for insertion " + (int) Math.pow(2, i)
			+ " in SeparateHashTable  is " + totalTimeTaken/n);
		}
		
	}
	
	// method for search and deletion of cuckoo, quadratic and separate chaining hashtables
	public static void avgsearchtime() {
		long startTime = 0, endTime = 0;
		long totalTimeTaken=0;
		
		
		
		CuckooHashTable<String> cuckooHashTable = new CuckooHashTable<>(new StringHashFamily(10), 2000);
		QuadraticProbingHashTable<String> quadraticHashTable = new QuadraticProbingHashTable<>();
		SeparateChainingHashTable<String> separateChainHashTable = new SeparateChainingHashTable<>();
		
		for (int i = 1; i <= 20; i++) {
		for (int n = 0; n < Math.pow(2, i); n++) {
			cuckooHashTable.insert(generaterandomstring());
			quadraticHashTable.insert(generaterandomstring());
			separateChainHashTable.insert(generaterandomstring());
		}
		}
		
			
		for (int i = 1; i <= 20; i++) {
			double n = Math.pow(2, i);
			
			// Cuckoo Hash Table search and Deletion
			startTime = System.nanoTime();
		for (n = 0; n < Math.pow(2, i); n++) {
			String out=generaterandomstring();	
			boolean value = cuckooHashTable.contains(out);
		    endTime = System.nanoTime();	
		    if(value==true)
	    	{
	    	    
	    	    cuckooHashTable.remove(out);
	    	}	
		}
		totalTimeTaken=(endTime-startTime);
		System.out.println("\n average search compute time for "+ (int) Math.pow(2, i)+ " cuckoo hash table " + (totalTimeTaken/n));
		
		
		// quadraticHashTable search and Deletion
		
			startTime = System.nanoTime();
		for (n = 0; n < Math.pow(2, i); n++) {
			String out=generaterandomstring();	
			boolean value = quadraticHashTable.contains(out);
		    endTime = System.nanoTime();	
		    if(value==true)
	    	{
	    	    
	    	    quadraticHashTable.remove(out);
	    	}	
		}
		totalTimeTaken=(endTime-startTime);
		System.out.println("average search compute time for "+ (int) Math.pow(2, i)+ " quadraticHashTable " + (totalTimeTaken/n));

		
		// quadraticHashTable search and Deletion
		
					startTime = System.nanoTime();
				for (n = 0; n < Math.pow(2, i); n++) {
					String out=generaterandomstring();	
					boolean value = separateChainHashTable.contains(out);
				    endTime = System.nanoTime();	
				    if(value==true)
			    	{
			    	    
			    	    separateChainHashTable.remove(out);
			    	}	
				}
				totalTimeTaken=(endTime-startTime);
				System.out.println("average search compute time for "+ (int) Math.pow(2, i)+ " separateChainHashTable " + (totalTimeTaken/n));
				}
	    
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		avginsertiontime();
		avgsearchtime();
			
			
	
	}
	
}
