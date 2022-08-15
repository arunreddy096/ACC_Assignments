package assignment;

import java.util.Random;

public class Task5 {

	private static final String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz";
	private static Random random = new Random();
	
	
	// Generating a random string of given length
	private static String genarateRandomword(int stringLen) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < stringLen; i++) {
			int randompos = random.nextInt(randomString.length());
			result.append(randomString.charAt(randompos));
		}
		return result.toString();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	     int[] stringLength= {10,20,50,100};
	     
	     
		 for(int i=0;i<stringLength.length;i++)
		 {
			 long startTime,endTime;
		     long TimeTaken=0;
		     long totalTime=0;
		     
		     // generating two random words of length 10, 20, 50, 100
			 String randomWord1=genarateRandomword(stringLength[i]);
			 String randomWord2=genarateRandomword(stringLength[i]);
		 
			 //calculating time for distance between all words
	     for(int j=0;j<1000;j++)
	     {

	    	 
	    	startTime=System.nanoTime();
	    	Sequences.editDistance(randomWord1, randomWord2);
	    	endTime=System.nanoTime();
	    	 TimeTaken=endTime-startTime;
	    	 totalTime+=TimeTaken;
	    	
	     }
	 	System.out.println("Average time taken for 1,000 pairs of random words of lengths  " + stringLength[i] + " : "+ totalTime / 1000 + " nanoseconds");
	
	 }
	 }
		 
	 
	 


	
	 
	 
	 

	

}
