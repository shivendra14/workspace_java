package w02_greedy_algorithms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here 
        Items obj[] = new Items [values.length];
        for (int i=0; i<values.length;i++)
        {
        	obj[i]=new Items();
        	obj[i].value=values[i];
        	obj[i].weight=weights[i];
        	obj[i].vByw = 1.0*values[i]/weights[i];
        }
        Comparator<Items> comp =new Comparator<Items>() {
			@Override
			public int compare(Items arg0, Items arg1) {
				// TODO Auto-generated method stub
				return arg0.vByw<arg1.vByw?1:-1;
			}
		};
        Arrays.sort(obj, comp);
        /*for (int i=0; i<values.length;i++)
        {
        	System.out.print(obj[i].value +"\t");
        	System.out.print(obj[i].weight +"\t");
        	System.out.print(obj[i].vByw +"\n");
        }*/
        
        int i=0;
        while (capacity>0 && i< obj.length)
        {
        	if (obj[i].weight<= capacity)
        	{
        		value += obj[i].value;
        		capacity-=obj[i].weight;
        		i++;
        	}
        	else
        	{
        		value+= capacity * obj[i].vByw;
        		capacity=0;
        	}
        }
        value=(long)(value*10000)/10000.0; // for error < 10^-3
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 

class Items
{
	int weight;
	int value;
	double vByw;
}
