package w04_dynprog;
import java.util.*;

public class LCS3 {
	private static int max (int... a)
	{
		int max=Integer.MIN_VALUE;
		for (int i:a)   if(max<i) max=i;
		return max;
	}

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
    	
    	int arr[][][]=new int [a.length+1][b.length+1][c.length+1];
  	  
  	  for (int i=0;i<c.length;i++)
  		  arr[0][0][i+1]=0;
  	  for (int i=0;i<b.length;i++)
  		  arr[0][i+1][0]=0;
   	  for (int i=0;i<a.length;i++)
		  arr[i+1][0][0]=0;
   	  
  	  for (int i=1;i<arr.length;i++)
  	  {
  		  int ai=a[i-1];
  		  for (int j=1;j<arr[0].length;j++)
  		  {
  			int bj=b[j-1];
  			  for (int k=1;k<arr[0][0].length;k++)
  			  {
  				int ck=c[k-1];
    			  int inserti	=arr[i-1][j][k];
    			  int insertj	=arr[i][j-1][k];
    			  int insertk	=arr[i][j][k-1];
    			  
    			  int deletei	=arr[i][j-1][k-1];
    			  int deletej	=arr[i-1][j][k-1];
    			  int deletek	=arr[i-1][j-1][k];
    			  
    			  int mismatch	=arr[i-1][j-1][k-1];
    			  int match		=arr[i-1][j-1][k-1]+1;
    			  if (ai==bj && bj==ck)
				  {
    				  arr[i][j][k]=max(inserti, insertj, insertk, deletei, deletej, deletek, match);
				  }
    			  else if (ai==bj)
    			  {
    				  arr[i][j][k]=max(insertk, deletei, deletej, deletek, mismatch);
    			  }
    			  else if (ai==ck)
    			  {
    				  arr[i][j][k]=max(insertj, deletei, deletej, deletek, mismatch);
    			  }
    			  else if (bj==ck)
    			  {
    				  arr[i][j][k]=max(inserti, deletei, deletej, deletek, mismatch);
    			  }
    			  else
    			  {
    				  arr[i][j][k]=max(inserti, insertj, insertk, deletei, deletej, deletek,  mismatch);
    			  }	
  			  } 			  
  		  }
  	  }
  	  //for (int i=0;i<s.length()+1;i++)
  		//  System.out.println(Arrays.toString(arr[i]));
      return arr[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

