package w01_introductionProblems;
import java.util.*;

public class LCM {
  private static long lcm(int a, int b) {
    //write your code here
    //return a * b;
	    return (long)a/gcd(a,b)*b;
  }
  private static int gcd(int a, int b) {
	    if (a>b)
	    {
	    	int temp=a;
	    	a=b;
	    	b=temp;
	    }
	    
	    if (a<=0)
	    	return b;

	    return gcd(a,b%a);
	  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
