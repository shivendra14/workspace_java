package FileHandling;
import java.io.*;
class stream
{
	stream()
	{
		try
        {
         FileReader fr=new FileReader("input.txt");
         StreamTokenizer inputStream=new StreamTokenizer(fr);
         int count=0,tokentype=0;
         String data="";
         while(tokentype!=StreamTokenizer.TT_EOF)
         {
             count++;
             tokentype=inputStream.nextToken();
             data=inputStream.sval;
             // int t=(int)inputStream.nval;
             System.out.println(data +"   "+count);
             
         }
        }
        catch (IOException e){}
    }
}