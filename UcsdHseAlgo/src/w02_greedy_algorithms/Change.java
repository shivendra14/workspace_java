package w02_greedy_algorithms;
import java.util.Scanner;

public class Change {
    private static int getChange(int n) {
        //write your code here
    	int denom[]={10,5,1};
    	int coins=0;
    	for (int i=0;i<denom.length;i++)
    	{
    		coins += n/denom[i];
    		n=n%denom[i];
    	}
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}

