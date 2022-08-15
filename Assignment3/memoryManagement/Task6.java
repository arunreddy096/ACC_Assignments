package memoryManagement;

import java.io.*;

public class Task6 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		long startTime = 0, endTime = 0;
		PrintStream p = System.out;
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("B-tree.dat")), true));
		startTime = System.currentTimeMillis();
		In Data = new In("Chip-seq-reads-1M.dat");
		String lines[] = Data.readAllLines();
		//creating a B- tree
		BTree<String, String> st = new BTree<String, String>();
		for (int i = 0; i < lines.length; i++) {
			st.put(lines[i], "1");
		}
		StdOut.println(st); // write output data in file B-tree.dat
		endTime = System.currentTimeMillis();
		System.setOut(p);
		System.out.println("Total Time for B-Tree is:" + (endTime - startTime));

	}

}
