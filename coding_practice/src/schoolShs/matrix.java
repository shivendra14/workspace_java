package schoolShs;
import java.io.*;
class matrix
{
 int arr[][]=new int[10][10];
 int n,m;
 public void input()throws IOException
 { 
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter the no. of rows & columns");
  n=Integer.parseInt(br.readLine());
  m=Integer.parseInt(br.readLine());
  System.out.println("Enter the elements");
  for(int i=0;i<n;i++)
   for(int j=0;j<m;j++)
    arr[i][j]=Integer.parseInt(br.readLine());
 }
 public void showMatrix()
 {
  System.out.println("RESULTANT MATRIX IS");
  for(int i=0;i<n;i++)
  {
   for(int j=0;j<m;j++)
   System.out.print(arr[i][j]+"\t");
  System.out.println();
  }
 }
 public void findProduct(matrix a,matrix b)
 {
  if(a.m==b.n)
   for(int i=0;i<n;i++)
    for(int j=0;j<m;j++)
     for(int k=0;k<a.m;k++)
     arr[i][j]+=a.arr[i][k]*b.arr[k][j];
  else
  {
   System.out.println("MATRIX MULTIPLICATION NOT POSSIBLE");
   System.exit(0);
  }
 }
 public static void main(String args[])throws IOException
 {
 matrix a1=new matrix();a1.input();
 matrix a2=new matrix();a2.input();
 matrix a3=new matrix(); a3.n=a1.n; a3.m=a2.m;
 a3.findProduct(a1,a2);
 a3.showMatrix();
 }
}