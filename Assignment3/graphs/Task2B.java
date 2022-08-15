package graphs;

public class Task2B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		In in = new In("largeEWG.txt");
		
		// using kruskal Algorithm for to find MST
		
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		KruskalMST mst = new KruskalMST(G);
		long startTime = System.currentTimeMillis();
		for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
		long endTime = System.currentTimeMillis();
		System.out.println("Finding MST of large weighted Graph\n");
		System.out.println(
				"CPU Time taken to compute the graph with of Kruskal Algorithm is  " + (endTime - startTime) + "ms");

	}

}
