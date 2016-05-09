package w02_greedy_algorithms;
import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int i=1;
        while (n>0)
        {
        	if (2*i<n)
        	{
        		summands.add(i);
        		n-=i;
        		i++;
        	}
        	else
        	{
        		summands.add(n);
        		n=0;
        	}
        }
        
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

