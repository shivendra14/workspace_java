package w04_dynprog;
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> greedy_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int optimalLength[]=new int[n+1];
        optimalLength[0]=optimalLength[1]=0;
       
        for (int i=2;i<=n;i++)
        {
        	int len = Integer.MAX_VALUE;
        	len = i%3==0 && len>optimalLength[i/3]? optimalLength[i/3]:len;
        	len = i%2==0 && len>optimalLength[i/2]? optimalLength[i/2]:len;
        	len = i>=1    && len>optimalLength[i-1]? optimalLength[i-1]:len;
        	optimalLength[i]=len+1;
        }
        
        while (n>=1)
        {
        	sequence.add(n);
        	if (n%3 ==0  && optimalLength[n/3]+1 == optimalLength[n])
        		n=n/3;
        	else if (n%2 ==0  && optimalLength[n/2]+1 == optimalLength[n])
        		n=n/2;
        	else if (n>1 && optimalLength[n-1]+1 == optimalLength[n])
        		n=n-1;
        	else if (n==1)
        		n=n-1;
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

