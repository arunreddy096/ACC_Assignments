package Assignment4;

import java.util.List;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In f = new In("src/HardDisk.txt");
		String text = new String();
		long startTime=0, endTime=0;
		while (f.hasNextLine()) {
			text += f.readLine();
		}
		String[] keys = { "hard", "disk", "hard disk", "hard drive", "hard dist", "xltpru" };

		System.out.println("BruteForceMatch");
		startTime = System.nanoTime();
		for (int y = 0; y < 100; y++) {
			for (int i = 0; i < keys.length; i++) {
				if (y == 0)
					System.out.println("Pattern:" + keys[i]);
				List<Integer> matchedIndexes = BruteForceMatch.bruteForceStringMatcher(text, keys[i]);
				int index = 0;
				for (Integer matchedIndex : matchedIndexes) {
					if (y == 0)
						System.out.print(matchedIndex + " ");
					index++;
					if (index % 20 == 0) {
						if (y == 0)
							System.out.println();
					}
				}
				if (y == 0)
					System.out.println();
			}
		}
		endTime = System.nanoTime();
		
		System.out.println("Average CPU time taken by Brute Force is:" + (endTime - startTime) / 100 + " Nano seconds");
		System.out.println();
		startTime=0; endTime=0;
		System.out.println("BoyerMoore");
		startTime = System.nanoTime();
		for (int y = 0; y < 100; y++) {
			for (int i = 0; i < keys.length; i++) {
				if (y == 0)
					System.out.println("Pattern:" + keys[i]);
				char txt[] = text.toCharArray();
				char pat1[] = keys[i].toCharArray();
				List<Integer> matchedIndexes = BoyerMoore.BoyerMooreSearch(txt, pat1);
				int index = 0;
				for (Integer matchedIndex : matchedIndexes) {
					if (y == 0)
						System.out.print(matchedIndex + " ");
					index++;
					if (index % 20 == 0) {
						if (y == 0)
							System.out.println();
					}
				}
				if (y == 0)
					System.out.println();
			}
		}
		endTime = System.nanoTime();
		System.out.println("Average CPU time taken by Boyer Moore is:" + (endTime - startTime) / 100 + " Nano seconds");

		System.out.println();
		startTime=0; endTime=0;
		System.out.println("KMP");
		KMP kmp = new KMP(text);
		startTime = System.nanoTime();
		for (int y = 0; y < 100; y++) {
			for (int i = 0; i < keys.length; i++) {
				if (y == 0)
					System.out.println("Pattern:" + keys[i]);
				List<Integer> matchedIndexes = kmp.KMPSearch(keys[i], text);
				int index = 0;
				for (Integer matchedIndex : matchedIndexes) {
					if (y == 0)
						System.out.print(matchedIndex + " ");
					index++;
					if (index % 20 == 0) {
						if (y == 0)
							System.out.println();
					}
				}
				if (y == 0)
					System.out.println();
			}
		}
		endTime = System.nanoTime();
		System.out.println("Average CPU time taken by KMP is:" + (endTime - startTime) / 100 + " Nano seconds");

	
	
	}

}
