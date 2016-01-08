/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n=100;
		long squareOfSum=(n*(n+1)/2) * (n*(n+1)/2);
		long sumOfSquare= n*(n+1)*(2*n+1)/6;
		System.out.println(squareOfSum-sumOfSquare);
	}
}