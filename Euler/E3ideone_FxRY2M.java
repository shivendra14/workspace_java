/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		long num=600851475143L;
		int i=3;int high=i;
		while (num!=1)
		{
		if (num%i==0)
		{
			high=i;
		while (num%i==0)
		num/=i;
		}
		i++;
		}
		System.out.println(high);
	}
}