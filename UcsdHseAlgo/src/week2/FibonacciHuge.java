package week2;
import java.util.*;

public class FibonacciHuge {
	
	static ArrayList<Long> fib;
    private static long getFibonacciHuge(long n, long m) {
        //write your code here
    	// Fn mod m is periodic with p
    	fib=new ArrayList<>();
    	long p=getPisanoPeriod(m);
    	//System.out.println(m+"\t"+p);
    	long eqivalentN = n%p;
    	long hugeFib= fib.get((int) eqivalentN);
        return hugeFib;
    }
    
    private static long getPisanoPeriod(long m)
    {
    	fib.add(0L);
    	fib.add(1L);
    	
    	long count=0;
    	long back=fib.get(0);
    	
    	for (int i=2;;i++)
    	{
    		fib.add( (fib.get(i-1)+fib.get(i-2))%m );
    		long fibN=fib.get(i);
    		if (fibN==back)
    			count++;
    		else 
    			count=0;
    		
    		back=fib.get((int)count);
    		
    		if (count == (i+1) - count) //count is a complete period: such that  2*count is the iterator 
    			break;
    	}
    	
    	return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

