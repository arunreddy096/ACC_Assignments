package graphs;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		In in = new In("mediumDG.txt");
        Digraph G = new Digraph(in);
        
        // Depth first search order for mediumDG
        DepthFirstOrder MediumDFS = new DepthFirstOrder(G);
        System.out.println("   v  pre post");
        System.out.println("--------------");
        for (int i = 0; i < G.V(); i++) {
        	System.out.printf("%4d %4d %4d\n", i, MediumDFS.pre(i), MediumDFS.post(i));
        }
        
        //mediumDG graph pre order and calculating cpu time
        long startTime = System.currentTimeMillis();
        StdOut.print("Pre order -  ");
        for (int i : MediumDFS.pre()) {
        	System.out.print(i + " ");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nThe total CPU Time For PreOrder = " + (endTime - startTime) + "ms");
        System.out.println();
        startTime = 0;
		endTime = 0;
		startTime = System.currentTimeMillis();
		 
		//mediumDG graph post order and calculating cpu time
        StdOut.print("Post order - ");
        for (int i : MediumDFS.post()) {
        	System.out.print(i + " ");
        }
        endTime = System.currentTimeMillis();
        System.out.println();

        System.out.println("\nThe total CPU Time For PostOrder = " + (endTime - startTime) + "ms");




	}

}
