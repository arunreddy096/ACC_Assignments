package assignment;

import java.util.*;

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		long startTime, endTime;
		int n = 100;
		int keys = 100000;

		long mergeinput[] = new long[n];
		long Quick[] = new long[n];
		long Heap[] = new long[n];
		long DPQ[] = new long[n];

		// sorting 100,000 random keys for 100 times 
		for (int i = 0; i < n; i++) {
			long[] RandomNumber = random.longs(keys).toArray();
			Long[] mergeInput = new Long[keys];
			Long[] QuickInput = new Long[keys];
			Long[] HeapInput = new Long[keys];
			for (int j = 0; j < keys; j++) {
				mergeInput[j] = RandomNumber[j];
				QuickInput[j] = RandomNumber[j];
				HeapInput[j] = RandomNumber[j];
			}
			
			//merge sort time calculation
			startTime = System.currentTimeMillis();
			Sort.mergeinputSort(mergeInput);
			endTime = System.currentTimeMillis();
			mergeinput[i] = endTime - startTime;
			
			//quick sort time calculation
			startTime = System.currentTimeMillis();
			Sort.quicksort(QuickInput);
			endTime = System.currentTimeMillis();
			Quick[i] = endTime - startTime;
			
			// heap sort time calculation
			startTime = System.currentTimeMillis();
			Sort.heapsort(HeapInput);
			endTime = System.currentTimeMillis();
			Heap[i] = endTime - startTime;
			
			//dual pivot quicksort time calculation
			startTime = System.currentTimeMillis();
			Arrays.sort(RandomNumber);
			endTime = System.currentTimeMillis();
			DPQ[i] = endTime - startTime;

		}
		long[] AveragendTime = new long[4];
		long[] TotaltimeTaken = new long[4];
		for (int j = 0; j < 100; j++) {
			TotaltimeTaken[0] += mergeinput[j];
			TotaltimeTaken[1] += Quick[j];
			TotaltimeTaken[2] += Heap[j];
			TotaltimeTaken[3] += DPQ[j];
		}
		for (int k = 0; k < 4; k++) {
			AveragendTime[k] = TotaltimeTaken[k] / n;
		}

		System.out.println("Average Time in mergeinput Sort: " + AveragendTime[0] + " Milli Seconds");
		System.out.println("Average Time in Quick Sort: " + AveragendTime[1] + " Milli Seconds");
		System.out.println("Average Time in Heap Sort: " + AveragendTime[2] + " Milli Seconds");
		System.out.println("Average Time in Dual Pivot Quick Sort: " + AveragendTime[3] + " Milli Seconds");

	

	}

}
