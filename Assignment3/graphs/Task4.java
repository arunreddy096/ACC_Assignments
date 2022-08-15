package graphs;

public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymbolGraph sg = new SymbolGraph("movies.txt", "/");
		Graph G = sg.G();
		String artist1, artist2, charac3;
//		String string1[] = new String[1000];
//		String string2[] = new String[1000];
		artist1 = "DiCaprio, Leonardo";// StdIn.readLine();
		System.out.print("\nSearching movies for the actor : " + artist1 + "\n");
		if (sg.contains(artist1)) {
			int s1 = sg.index(artist1);
			for (int v1 : G.adj(s1)) {
				StdOut.println("   " + sg.name(v1));
			}
		} else {
			StdOut.println("input does not contain the actor " + artist1 + "'\n");
		}
		artist2 = "Roberts, Julia (I)";
		System.out.println("\nSearching movies for the actor : " + artist2 + "\n");
		if (sg.contains(artist2)) {
			int s1 = sg.index(artist2);
			for (int v1 : G.adj(s1)) {
				StdOut.println("   " + sg.name(v1));
			}
		} else {
			StdOut.println("input does not contain " + artist2 + "'\n");
		}

		charac3 = "Grant, Hugh (I)";
		System.out.println("\nSearching movies for the actor : " + charac3 + "\n");
		if (sg.contains(charac3)) {
			int s1 = sg.index(charac3);
			for (int v1 : G.adj(s1)) {
				StdOut.println("   " + sg.name(v1));
			}
		} else {
			StdOut.println("input does not contain " + charac3 + "'\n");
		}
		System.out.println("\nSearching common movies for both actors ");
		System.out.print(artist2);
		System.out.print(" And " + charac3);
		if (sg.contains(artist2)) {
			int s = sg.index(artist2);
			for (int v : G.adj(s)) {
				String sp = sg.name(v);
				if (sg.contains(sp)) {
					int s1 = sg.index(sp);
					for (int v1 : G.adj(s1)) {
						String sp1 = sg.name(v1);
						if (sp1.equals(charac3)) {
							StdOut.println(" is " + sp);
						}
					}
				}
			}
		}

	}

}
