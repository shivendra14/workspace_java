package schoolShs;
import java.io.*;
class spiral
{
 public static void main(String args[])throws IOException
 {
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 int n=Integer.parseInt(br.readLine());
 int p=0,q=0,a,b=1,e=1;
 int arr[][]=new int[n][n];
 a=n/2;
 p=a;
 if(n%2==0)
 q=a-1;
 else 
 q=a;  
 arr[p][q]=1;
 for(int i=1;i<n;i++)
 {
  for(int s=1;s<=i;s++)
  {
   b++;
   q+=e;
   arr[p][q]=b;
  }
  e=-e;
  for(int r=1;r<=i;r++)
  {
   b++;
   p+=e;
   arr[p][q]=b;
  }

  if(i==n-1)
  {for(int s=1;s<=i;s++)
   {
    b++;
    q+=e;
    arr[p][q]=b;
  }}}
  for(int i=0;i<n;i++)
  { for(int s=0;s<n;s++)
    System.out.print(arr[i][s]+"\t");
  System.out.println();}
  }
 }