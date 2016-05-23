package w04_dynprog;
import java.util.*;

class EditDistance {

  private static int min(int a,int b,int c)
  {
	return Integer.min(Integer.min(a, b), c);
  }
  public static int EditDistance(String s, String t) {
    //write your code here
	  int arr[][]=new int [s.length()+1][t.length()+1];
	  
	  for (int i=0;i<t.length();i++)
		  arr[0][i+1]=i+1;
	  for (int i=0;i<s.length();i++)
		  arr[i+1][0]=i+1;
	  
	  for (int i=1;i<arr.length;i++)
	  {
		  char si=s.charAt(i-1);
		  for (int j=1;j<arr[0].length;j++)
		  {
			  char tj=t.charAt(j-1);
			  int insert	=arr[i-1][j]+1;
			  int delete	=arr[i][j-1]+1;
			  int mismatch	=arr[i-1][j-1]+1;
			  int match 	=arr[i-1][j-1];
			  if (si!=tj)
				  arr[i][j]=min(insert, delete,mismatch);				  
			  else
				  arr[i][j]=min(insert, delete,match);				  
			  
		  }
	  }
	  //for (int i=0;i<s.length()+1;i++)
		//  System.out.println(Arrays.toString(arr[i]));
    return arr[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
