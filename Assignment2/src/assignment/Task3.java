package assignment;

import java.util.*;


public class Task3 {
	

		private static final String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		private static Random random = new Random();

		// generating a random string of given length
	private static String genarateRandomString(int stringLen) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < stringLen; i++) {
				int randompos = random.nextInt(randomString.length());
				result.append(randomString.charAt(randompos));
			}
			return result.toString();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s=genarateRandomString(4);
		//System.out.println(s);
		long startTime,endTime;
		 long MergeTime,HeapTime,quickTime,radixTime,DPQTime;
		 long MergeTotalTime,HeapTotalTime,QucikTotalTime,RadixTotalTime,DPQTotalTime;
			String[] mergeinput = new String[100000];
			String[] quicksortinput = new String[100000];
			String[] heapsortinput = new String[100000];
			String[] DPQinput = new String[100000];
			String[] radixsortinput = new String[100000];
		 int[] stringlength= {4,6,8,10};
		MergeTotalTime=HeapTotalTime=QucikTotalTime=RadixTotalTime=DPQTotalTime=0;
		MergeTime=HeapTime=quickTime=0;
		for(int k=0;k<stringlength.length;k++)
		 {
			for(int i=0;i<100000;i++)
			{
				String randstring=genarateRandomString(stringlength[k]);
				mergeinput[i]=randstring;
				quicksortinput[i]=randstring;
				heapsortinput[i]=randstring;
				DPQinput[i]=randstring;
				radixsortinput[i]=randstring;
			}
		 
			for(int j=1;j<=10;j++)
	        {
			  
			  
				//merge sort time calculation
			  startTime = System.currentTimeMillis();
		      Sort.mergeinputSort(mergeinput);
	          endTime = System.currentTimeMillis();
	          MergeTime =(endTime - startTime);
	    
	            MergeTotalTime+=MergeTime;
	       
	            //quick sort time calculation
	         startTime = System.currentTimeMillis();
	       Sort.quicksort(quicksortinput);
           endTime = System.currentTimeMillis();
           quickTime =(endTime - startTime);
      
           QucikTotalTime+=quickTime;
	       
           // heap sort time calculation
           startTime = System.currentTimeMillis();
	       Sort.heapsort(heapsortinput);
           endTime = System.currentTimeMillis();
           HeapTime =(endTime - startTime);
         
           HeapTotalTime+=HeapTime;
           
           //dual pivot quicksort time calculation
            startTime = System.currentTimeMillis();
	        Arrays.sort(DPQinput);
            endTime = System.currentTimeMillis();
            DPQTime =(endTime - startTime);
        
            DPQTotalTime+=DPQTime;
	       
            // radix sort time calculation
           startTime = System.currentTimeMillis();
	       RadixSort.radixSortA(radixsortinput,stringlength[k]);
           endTime = System.currentTimeMillis();
           radixTime =(endTime - startTime);
   
           RadixTotalTime+=radixTime;
           
         
	 
	 }
		 
		        
		        System.out.println("Average Time taken to sort randomstrings of length "+stringlength[k]+" using merge sort = "+ (MergeTotalTime/10)+" milliseconds");
		        System.out.println("Average Time taken to sort randomstrings of length "+stringlength[k]+" using Heap sort = "+ (HeapTotalTime/10)+" milliseconds");
		        System.out.println("Average Time taken to sort randomstrings of length "+stringlength[k]+" using Quick sort = "+ (QucikTotalTime/10)+" milliseconds");
		        System.out.println("Average Time taken to sort randomstrings of length "+stringlength[k]+" using Dual pivot sort = "+ (DPQTotalTime/10)+" milliseconds");
		        System.out.println("Average Time taken to sort randomstrings of length "+stringlength[k]+" using radix sort = "+ (RadixTotalTime/10)+" milliseconds\n");
		     
		        
	}
	}

}
