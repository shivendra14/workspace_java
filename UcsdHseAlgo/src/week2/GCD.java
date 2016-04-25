package week2;
import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
	/*
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }
    */
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

    System.out.println(gcd(a, b));
  }
}
