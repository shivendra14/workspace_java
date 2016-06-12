package w02_decompositionOfGraphs2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Toposort {
    private static LinkedList<Integer> toposort(ArrayList<Integer>[] adj) {
        HashSet<Integer> used = new HashSet<>();
        LinkedList<Integer> order = new LinkedList<Integer>();
        //write your code here
        for (int s=0;s<adj.length && used.size()!=adj.length;s++)
        if(!used.contains(s))
        dfs(adj,used,order,s);

        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, HashSet<Integer> used, LinkedList<Integer> order, int s) {
      //write your code here
    	used.add(s);
    	for(int n: adj[s])
    	{
    		if(!used.contains(n))
    			dfs(adj,used,order,n);
    	}
    	order.add(0,s); //add at beginning to get top-to-bottom topologies
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
        LinkedList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

