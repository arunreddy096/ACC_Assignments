package Assignment4;

import java.util.ArrayList;
import java.util.List;

/***************************************************************
*
*  Compilation:  javac KMP.java
*  Execution:    java KMP pattern text
*
*  Reads in two strings, the pattern and the input text, and
*  searches for the pattern in the input text using the
*  KMP algorithm.
*
*  % java KMP abracadabra abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad 
*  pattern:               abracadabra          
*
*  % java KMP rab abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad 
*  pattern:         rab
*
*  % java KMP bcara abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad 
*  pattern:                                   bcara
*
*  % java KMP rabrabracad abacadabrabracabracadabrabrabracad 
*  text:    abacadabrabracabracadabrabrabracad
*  pattern:                        rabrabracad
*
*  % java KMP abacad abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad
*  pattern: abacad
*
***************************************************************/

public class KMP {
   private final int R;       // the radix
   private int[][] dfa;       // the KMP automoton

   private char[] pattern;    // either the character array for the pattern
   private String pat;        // or the pattern string

   // create the DFA from a String
   public KMP(String pat) {
       this.R = 256;
       this.pat = pat;

       // build DFA from pattern
       int M = pat.length();
       dfa = new int[R][M]; 
       dfa[pat.charAt(0)][0] = 1; 
       for (int X = 0, j = 1; j < M; j++) {
           for (int c = 0; c < R; c++) 
               dfa[c][j] = dfa[c][X];     // Copy mismatch cases. 
           dfa[pat.charAt(j)][j] = j+1;   // Set match case. 
           X = dfa[pat.charAt(j)][X];     // Update restart state. 
       } 
   } 

   // create the DFA from a character array over R-character alphabet
   public KMP(char[] pattern, int R) {
       this.R = R;
       this.pattern = new char[pattern.length];
       for (int j = 0; j < pattern.length; j++)
           this.pattern[j] = pattern[j];

       // build DFA from pattern
       int M = pattern.length;
       dfa = new int[R][M]; 
       dfa[pattern[0]][0] = 1; 
       for (int X = 0, j = 1; j < M; j++) {
           for (int c = 0; c < R; c++) 
               dfa[c][j] = dfa[c][X];     // Copy mismatch cases. 
           dfa[pattern[j]][j] = j+1;      // Set match case. 
           X = dfa[pattern[j]][X];        // Update restart state. 
       } 
   } 

   // return offset of first match; N if no match
   public int search(String txt) {

       // simulate operation of DFA on text
       int M = pat.length();
       int N = txt.length();
       int i, j;
       for (i = 0, j = 0; i < N && j < M; i++) {
           j = dfa[txt.charAt(i)][j];
       }
       if (j == M) return i - M;    // found
       return N;                    // not found
   }


   // return offset of first match; N if no match
   public int search(char[] text) {

       // simulate operation of DFA on text
       int M = pattern.length;
       int N = text.length;
       int i, j;
       for (i = 0, j = 0; i < N && j < M; i++) {
           j = dfa[text[i]][j];
       }
       if (j == M) return i - M;    // found
       return N;                    // not found
   }
   
	List<Integer> KMPSearch(String pat2, String txt) {
		int M = pat2.length();
		int N = txt.length();
		List<Integer> matchedIndexes = new ArrayList<>();

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int lps[] = new int[M];
		int j = 0; // index for pat[]

		// Preprocess the pattern (calculate lps[]
		// array)
		computeLPSArray(pat2, M, lps);

		int i = 0; // index for txt[]
		while (i < N) {
			if (pat2.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				// System.out.println("Found pattern " + "at index " + (i - j));
				matchedIndexes.add((i - j));
				j = lps[j - 1];
			}

			// mismatch after j matches
			else if (i < N && pat2.charAt(j) != txt.charAt(i)) {
				// Do not match lps[0..lps[j-1]] characters,
				// they will match anyway
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		if (matchedIndexes.size() == 0) {
			matchedIndexes.add(N);
		}
		return matchedIndexes;
	}

	void computeLPSArray(String pat, int M, int lps[]) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				} else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}


   // test client
   public static void main(String[] args) {
       //String pat = args[0];
       //String txt = args[1];
	   
       // There are two implmentations of search
	   // one is with String and the other is an array of chars
	   
	   String pat = "abracadabra";
       String txt = "abacadabrabracabracadabrabrabracad";
	   
       char[] pattern = pat.toCharArray();
       char[] text    = txt.toCharArray();

       KMP kmp1 = new KMP(pat);
       int offset1 = kmp1.search(txt);

       KMP kmp2 = new KMP(pattern, 256);
       int offset2 = kmp2.search(text);

       // print results
       StdOut.println("text:    " + txt);

       StdOut.print("pattern: ");
       for (int i = 0; i < offset1; i++)
           StdOut.print(" ");
       StdOut.println(pat + " at pos " + offset1);

       StdOut.print("pattern: ");
       for (int i = 0; i < offset2; i++)
           StdOut.print(" ");
       StdOut.println(pat + " at pos " + offset2);
   }
}
