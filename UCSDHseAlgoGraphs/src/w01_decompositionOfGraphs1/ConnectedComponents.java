package w01_decompositionOfGraphs1;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
	static ArrayList<Integer> visited = new ArrayList<>();
	
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        int numVertices= adj.length;
        for(int index=0; index<numVertices; index++)
        {
        	if (!visited.contains(index))
        	{	
        		dfsTraversal(adj, index);
        		result++;
        	}
        }
        return result;
    }

    private static void dfsTraversal(ArrayList<Integer>[] adj, int start)
    {
    	visited.add(start);
    	for (int n : adj[start])
    	{
    		if(!(visited.contains(n)))
    			dfsTraversal(adj,n);
    	}
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

