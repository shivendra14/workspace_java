/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int i,j;
		int mul=1;
		int arr[]=new int [100];
		for (i=20;i>1;i--)
		{
			int k=i;
			for (j=2;j<=i/2;j++)
			{
				int count =0;
				while(k%j==0)
				{
				k/=j;
				count++;
				}
				if (arr[j]<count)
				arr[j]=count;
			}
			mul*=k;
		}
		
		for (i=0;i<20;i++)
		while(arr[i]-- >=2) mul*=i;
		System.out.println(mul);
	}
}