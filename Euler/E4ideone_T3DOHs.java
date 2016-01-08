/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int pal[]=new int[1000];
		int i,j,k=0;
		for(i=999;i>0;i--)
		{
			for (j=i;j>0;j--)
			{
				if(checkPalindrome(i*j))
				{
					pal[k++]=i*j;
					break;
				}
			}
		}
		int max=-1;
		for (i=0;i<k;i++)
		if (max<pal[i]) max=pal[i];
		System.out.println(max);
	}
	public static boolean checkPalindrome(int a)
	{
		int b=a, c=0;
		while (a!=0)
		{
		   int d=a%10;
		   a=a/10;
		   c=c*10+d;
		}
		return b==c;
	}
}
