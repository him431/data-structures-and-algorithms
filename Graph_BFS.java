import java.util.LinkedList;

class Graph{
	int V;
	LinkedList<Integer> adj[];
	
	Graph(int V){
		this.V = V;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList();
	}

	public void addEdge(int i, int j) {
		adj[i].add(j);
	}

	public void BFS(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + "  ");
			for(Integer v : adj[u]) {
				if(!visited[v]) {
					visited[v]=true;
					queue.add(v);
				}
			}
		}
	}
}




public class Graph_BFS {
	public static void main(String args[]) 
    { 
        Graph g = new Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
    } 
}
