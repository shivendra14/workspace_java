package w04_dynprog;
import java.util.*;

public class Knapsack {
	
    static int greedyWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;
    }

    /* Print the optimal weight that can be carried in a knapsack of capacity W*/
    
    static int optimalWeight(int W, int[] w) {
        //write you code here
    	int capacityTable[][]=new int[w.length+1][W+1];
        //return optimalWightHelper(W,w,capacityTable);
    	for (int item=0;item<=w.length;item++)
    	{
    		for (int backPack=0;backPack<=W;backPack++)
    		{
    			if(item==0 || backPack==0)
    				capacityTable[item][backPack]=0;
    			
    			else if(w[item-1]<=backPack)
    			{
    				int keep     = w[item-1] + capacityTable[item-1][backPack-w[item-1]];
    				int dontKeep =             capacityTable[item-1][backPack];
    				capacityTable[item][backPack] =Integer.max(keep, dontKeep);
    			}
    			else
    			{
    				capacityTable[item][backPack]=capacityTable[item-1][backPack];
    			}
    		}
    	}
    	return capacityTable[w.length][W];
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

