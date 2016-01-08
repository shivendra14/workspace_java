/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class euler1{

long sum=0;
     public static void main(String []args){
euler1 obj=new euler1();
     obj.sumFibonacci(1,2);
System.out.println(obj.sum);
     }
     
     
     public void sumFibonacci(int a, int b)
     {
     if (b>4000000)
     return;
     if (b%2==0)
     sum+=b;
     sumFibonacci(b,a+b);
     }
}
     