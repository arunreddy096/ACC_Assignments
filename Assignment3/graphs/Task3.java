package graphs;

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		SymbolGraph sg = new SymbolGraph("movies.txt", "/");
		Graph G = sg.G();
		CC cc = new CC(G);
		int M = cc.count();
		StdOut.println(M + " components");
		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
		for (int i = 0; i < M; i++) {
			components[i] = new Queue<Integer>();
		}
		for (int v = 0; v < G.V(); v++) {
			components[cc.id(v)].enqueue(v);
		}
		for (int i = 0; i < M; i++) {
			for (int v : components[i]) {
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Total CPU Time = " + (endTime - startTime) + "ms");

	}

}
