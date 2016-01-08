/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// abc= 1000c(500-c)  for a,b,c natural no.s a<b<c
		// ab = 1000(500-c)
		// c^2 > 1000(500-c)  && c<500
		// 366<c<500  
		//for such c, a and b should be natural no.
		
		double a,b;
		int c;
		for (c=367;c<500;c++)
		{
			int prod=1000*(500-c);
			int sum=1000-c;
			double root= Math.sqrt (sum*sum-4*prod);
			if (Math.ceil(root)==root)
			{
				a= (sum+root)/2;
				b= (sum-root)/2;
				System.out.println("a="+a+" b="+b+" c="+c+" abc="+(int)(a*b*c));
			}
			
		}
		
		
	}
}