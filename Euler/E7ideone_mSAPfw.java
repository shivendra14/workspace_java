/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int Max=10001;
		int arr[]=new int [Max];
		int count=0;
		int i,j;
		for (i=2;i<1000000 && count<Max; i++)
		{
			if (checkPrime(i,count,arr))
			{
				//System.out.println(i);
				arr[count++]=i;
			}
			
		}
		System.out.println(arr[Max-1]);
	}
	
	public static boolean checkPrime(int num, int count, int arr[])
	{
		int i;
		int j=0;
		while (j<count)
		{
			if (num%arr[j++] ==0)
			return false;
		}
		for(i=arr[count]; i*i<=num; i++)
		{
			if (i!=0 && i!=1 && num%i==0)
			return false;
		}
		return true;
	}
}