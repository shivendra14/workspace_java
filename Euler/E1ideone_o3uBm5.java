/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int multipleOfThree=3;
        int multipleOfFive=5;
        int i,j;
        int Max=1000;
        int sum=0;
        /*
        for (i=0;i<1000 && multipleOfThree<Max;i++)
        {
            for (j=0;j<1000 && multipleOfFive<Max;j++)
            {
                int multiple=multipleOfThree*multipleOfFive;
                if (multiple<Max)
                {
                    sum+=multiple;
                }
                multipleOfFive+=5;
            }
            multipleOfThree+=3;
            multipleOfFive=5;
            
        }
        */
        int divFive= (Max-1)/5;
        sum+=5*divFive*(divFive+1)/2;
        int divThree= (Max-1)/3;
        sum+=3*divThree*(divThree+1)/2;
        int divFif = (Max-1)/15;
        sum-=15*divFif*(divFif+1)/2;
        System.out.println(sum);
	}
}