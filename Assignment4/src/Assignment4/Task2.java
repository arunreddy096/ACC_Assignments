package Assignment4;

import java.util.StringTokenizer;

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TST<Integer> ternarysearchtrie = new TST<Integer>();
		//Read the file protein.txt
    	In file1 = new In("src/Protein.txt");
    	String text = file1.readAll(); 
    	//String Tokenizer to extract words from protein.txt
    	StringTokenizer stringTokenizer = new StringTokenizer(text, " (),.;\n\t");
    	int i = 0;
    	//extracting words from protein.txt
    	while(stringTokenizer.hasMoreTokens())
    	{	
    		
    		String s = stringTokenizer.nextToken();
    		ternarysearchtrie.put(s, i);
    		i++;
    	}
    	
		String searchKeys[] = {"protein","complex","PPI","prediction","studied","interaction","network","complex"};
		
		// print occurance of each word
		for(int j=0; j<searchKeys.length; j++)
    	{
			System.out.println(" Occurence of the word " +searchKeys[j]+ " : " +ternarysearchtrie.get(searchKeys[j]));
			
    	}

	}

}
