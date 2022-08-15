package memoryManagement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task5 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long startTime = 0, endTime = 0;

		startTime = System.currentTimeMillis();
		In Data = new In("Chip-seq-reads-1M.dat");// read the Chip-seq-reads-1M.dat file
		String line[] = Data.readAllLines(); // Write the content of the file to an array

		String file1[] = new String[line.length / 4];// Array for file 1
		// file 1
		// write data in file A.dat 
		FileWriter fileWriter1 = new FileWriter("A.dat");

		for (int i = 0; i < line.length / 4; i++) {
			fileWriter1.write(line[i] + "\n");
			file1[i] = line[i];
		}
		fileWriter1.close();
		// sorting the file and saving it in AS.dat
		Arrays.sort(file1);// Sort data written in A.dat

		FileWriter fw1S = new FileWriter("AS.dat");
		for (int i = 0; i < line.length / 4; i++) {
			fw1S.write(file1[i] + "\n");
		}
		fw1S.close();

		// file 2
		String file2[] = new String[line.length / 4]; // Array for file 2
		// write data in file B.dat
		FileWriter fileWriter2 = new FileWriter("B.dat");
		int k = line.length / 4;
		for (int i = line.length / 4; i < line.length / 2; i++) {
			fileWriter2.write(line[i] + "\n");
			file2[i - k] = line[i];
		}

		fileWriter2.close();
		// sorting the file and saving it in BS.dat
		Arrays.sort(file2);
		FileWriter fw2S = new FileWriter("BS.dat");
		for (int i = 0; i < line.length / 4; i++) {
			fw2S.write(file2[i] + "\n");
		}
		fw2S.close();

		// file 3
		String file3[] = new String[line.length / 4];// Array for file 3
		// write data in file C.dat
		FileWriter fileWriter3 = new FileWriter("C.dat");
		int k1 = line.length / 2;
		for (int i = line.length / 2; i < 3 * (line.length / 4); i++) {
			fileWriter3.write(line[i] + "\n");
			file3[i - k1] = line[i];
		}

		fileWriter3.close();
		// sorting the file and saving it in CS.dat
		Arrays.sort(file3);
		FileWriter fw3S = new FileWriter("CS.dat");
		for (int i = 0; i < line.length / 4; i++) {
			fw3S.write(file3[i] + "\n");
		}
		fw3S.close();

		// file 4
		String file4[] = new String[line.length / 4]; // Array for file 4
		// write data in file D.dat
		FileWriter fileWriter4 = new FileWriter("D.dat");
		int k2 = 3 * (line.length / 4);
		for (int i = 3 * (line.length / 4); i < line.length; i++) {
			fileWriter4.write(line[i] + "\n");
			file4[i - k2] = line[i];
		}

		fileWriter4.close();
		// sorting the file and saving it in DS.dat
		Arrays.sort(file4);
		FileWriter fw4S = new FileWriter("DS.dat");
		for (int i = 0; i < line.length / 4; i++) {
			fw4S.write(file4[i] + "\n");
		}
		fw4S.close();

		String[] sortedfiles = { "AS.dat", "BS.dat", "CS.dat", "DS.dat" };
		int N = sortedfiles.length;
		In[] files = new In[N];
		for (int i = 0; i < N; i++)
			files[i] = new In(sortedfiles[i]);
		merge(files);
		endTime = System.currentTimeMillis();
		System.out.println("Total Time:" + (endTime - startTime));


	}

	private static void merge(In[] files)throws IOException {
		// TODO Auto-generated method stub
		int N = files.length;
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
		for (int i = 0; i < N; i++)
			if (!files[i].isEmpty())
				pq.insert(i, files[i].readString());

		// Extract, store minimum and read next from its stream.
		FileWriter wr = new FileWriter("Chip-seq-reads-1M-sorted.dat");
		while (!pq.isEmpty()) {
			// finding the minimum value and store in a file
			String sr = pq.minKey();
			wr.write(sr + "\n");
			int i = pq.delMin();
			if (!files[i].isEmpty())
				pq.insert(i, files[i].readString());
		}
		StdOut.println();
		wr.close();
		
		
	}

}
