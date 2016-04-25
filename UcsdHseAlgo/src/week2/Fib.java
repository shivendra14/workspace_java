package week2;
import java.util.ArrayList;
import java.util.Scanner;

public class Fib {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    long fNminus2=0;
	long fNminus1=1;
    
    for (int i=2;i<=n;i++)
    {
		long fN=(fNminus1+fNminus2);
		fNminus2=fNminus1;
		fNminus1=fN;
	}
    return fNminus1;
    //return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
