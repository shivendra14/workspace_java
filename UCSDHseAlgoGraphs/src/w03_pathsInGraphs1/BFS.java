package w03_pathsInGraphs1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
    	int result=-1;
    	HashSet<Integer> visited = new HashSet<>();
    	HashMap <Integer,Integer> parent = new HashMap<>();
    	Queue<Integer> qu= new LinkedList<>();
    	visited.add(s);
    	qu.add(s);
    	parent.put(s,-1);
    	while(!qu.isEmpty() && result==-1)
    	{
    		int curr=qu.poll();
    		ArrayList<Integer> neighbors=adj[curr];
    		for (int n: neighbors)
    		{
    			
    			if (!visited.contains(n))
    			{
    				visited.add(n);
    				parent.put(n,curr);
    				qu.add(n);
    				if (n==t) { result=0; break; }
    			}
    		}
    	}
    	if (result==0)
    		while ((t=parent.get(t))!=-1)
    			result++;
        return result;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

