package w02_decompositionOfGraphs2;
import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {

	private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
		ArrayList<Integer> visited;
    	for (int index=0;index<adj.length;index++)
    	{
    		visited = new ArrayList<>();
    		if (reach(visited,adj,index,index) ==1) 
    		return 1;
    	}
        return 0;
    }
    	
    private static int reach(ArrayList<Integer> visited,ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
    	visited.add(x);    	
    	ArrayList<Integer> neighbors=adj[x];	
    	for (int n : neighbors)
    	{
    		if(!(visited.contains(n)))
    		{
    			if (reach(visited,adj,n,y) ==1 )
    			return 1;
    		}
    		else if (n==y)
    			return 1;
    	}
        return 0;
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
        }
        System.out.println(acyclic(adj));
    }
}

