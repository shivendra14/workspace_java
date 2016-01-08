/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		boolean arr[]=new boolean [2000000];
		long sum=0;
		for (int i=2;i<2000000;i++)
		{
			if(!arr[i]) sum+=i;
			else continue;
			for (int  j=i; j<2000000; j+=i)
			arr[j]=true;
		}
		System.out.println(sum);
	}
}