package FileHandling;

import java.io.*;
import java.util.*;
class scanner
{
	scanner()
	{
		try
        {
         Scanner scan=new Scanner(new File("input.txt"));
         scan.useDelimiter("\n");
         int count=0,tokentype=0;
         String data="";
         while(scan.hasNext())
         {
             count++;
             data=scan.next();
             System.out.println(data+"\t\t"+scan.next());
             
         }
        scan.close();
        }
        catch (Exception e){System.out.println("Error");}
    }
}