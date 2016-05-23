package w04_dynprog;
import java.util.Arrays;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
    	String num[]=exp.split("[+*-]");
    	String operator[]=exp.split("[0-9]+");

    	int n=num.length;
    	long min[][]=new long[n][n];
    	long max[][]=new long[n][n];
    	
    	//calculate expression from i th index to j th index
    	for (int s=0;s<n;s++)
    	{
    		for (int i=0;i<n-s;i++)
    		{
    			int j=i+s;
    			
    			if (i==j)
    				min[i][j]=max[i][j]=Long.parseLong(num[i]);
    			else
    			{
    				//int k=(i+j)/2;
    				max[i][j]=Long.MIN_VALUE;
    				min[i][j]=Long.MAX_VALUE;
    				for (int k=i;k<j;k++)
    				{
    					char op=(operator[k+ 1]).charAt(0);
    					if (op == '+') {
    						if (max[i][j] < max[i][k]+max[k+1][j])  max[i][j]=max[i][k]+max[k+1][j];
    						if (min[i][j] > min[i][k]+min[k+1][j])  min[i][j]=min[i][k]+min[k+1][j];
    					} else if (op == '-') {
    						if (max[i][j] < max[i][k]-min[k+1][j])  max[i][j]=max[i][k]-min[k+1][j];
    						if (min[i][j] > min[i][k]-max[k+1][j])  min[i][j]=min[i][k]-max[k+1][j];
    					} else if (op == '*') {
    						if (max[i][j] < max[i][k]*max[k+1][j])  max[i][j]=max[i][k]*max[k+1][j];
    						if (min[i][j] > min[i][k]*min[k+1][j])  min[i][j]=min[i][k]*min[k+1][j];
    					}
    				}

    			}
    		}
    	}
    	for (int i=0;i<n;i++)
    	System.out.println(Arrays.toString(max[i]));
//    	System.out.println(Arrays.toString(num));
//    	System.out.println(Arrays.toString(op));
      return max[0][n-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

