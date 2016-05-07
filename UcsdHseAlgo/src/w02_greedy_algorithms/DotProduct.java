package w02_greedy_algorithms;
import java.lang.reflect.Array;
import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {
        //write your code here
    	Arrays.sort(a);
    	
    	Integer bnew[]=new Integer[b.length];
    	for(int i=0;i<b.length; i++) bnew[i]=b[i]; 
    	Arrays.sort(bnew, Collections.reverseOrder());
    	
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * bnew[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(minDotProduct(a, b));
    }
}

