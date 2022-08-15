package graphs;

public class Task2A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in = new In("largeEWG.txt");
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
		
		// using Dijkstra Algorithm for finding the shortest path
		int s = 0;
		long startTime = System.currentTimeMillis();
		DijkstraSP shortestpath = new DijkstraSP(G, s);
	
		System.out.println("Implementing Dijkstra Algorithm\n");
		for (int t = 0; t < G.V(); t++) {
			if (shortestpath.hasPathTo(t)) {
				StdOut.printf("From %d to %d, Distance = %.2f  ", s, t, shortestpath.distTo(t));
				if (shortestpath.hasPathTo(t)) {
					for (DirectedEdge e : shortestpath.pathTo(t)) {
					}
				}
				StdOut.println();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("\nTotal CPU Time taken by Dijkstra Algorithm = " + (endTime - startTime) + " milliseconds");

	}

}
