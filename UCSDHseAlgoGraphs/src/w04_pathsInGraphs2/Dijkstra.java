package w04_pathsInGraphs2;
import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int result=-1;
        HashSet<Integer> visited = new HashSet<>();   
        HashMap<Integer,Integer> parent = new HashMap<>();
        HashMap<Integer,Integer> minDist = new HashMap<>();
        for(int i=0;i<adj.length;i++)
        	minDist.put(i,Integer.MAX_VALUE);
        
        Comparator<Integer> cmp=new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return minDist.get(o1)-minDist.get(o2);
			}
		};
        PriorityQueue<Integer> pq=new PriorityQueue<>(cmp);
        
        pq.add(s);
        minDist.put(s, 0);
        while (!pq.isEmpty())
        {
        	int curr=pq.poll();
        	if (!visited.contains(curr))
        	{
        		visited.add(curr);
        		if (curr==t) break;
        		ArrayList<Integer> neighbors=adj[curr];
        		ArrayList<Integer> nCost = cost[curr];
        		for (int index=0; index<neighbors.size(); index++ )
        		{
        			int n= neighbors.get(index);
        			if(visited.contains(n)) continue;
        			int nC=nCost.get(index);
        			       			
        			int newCost = minDist.get(curr) + nC;
        			if (minDist.get(n)> newCost)
        			{
        				minDist.put(n,newCost);
        				parent.put(n,curr);
        				pq.add(n);
        			}
        		}
        	}
        }
    	return minDist.get(t)==Integer.MAX_VALUE?-1 :minDist.get(t);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

