package week2;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigit(int n) {
    	
    	if (n<=1) return n;
    	
    	int fNminus2=0;
    	int fNminus1=1;
    	for (int i=2;i<=n;i++)
    	{
    		int fN=(fNminus1+fNminus2)%10;
    		fNminus2=fNminus1;
    		fNminus1=fN;
    	}
        return fNminus1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

