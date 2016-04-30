package FileHandling;
import java.io.*;
class stringFile
{
String name="";
public static void main (String args[])throws IOException
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    stringFile obj=new stringFile();
    String names[] = new String[3];
    for (int i=0;i<3;i++)
    {
        System.out.println("Enter a name");
        names[i]= br.readLine();
    }
    obj.write(names);
    obj.read();
}

public void write(String names[])
{
    try
    {
        FileWriter fw=new FileWriter("src/FileHandling/names.txt",true);//remove true to over-write the file
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pr=new PrintWriter(bw);
        for (String name: names)
            pr.println(name);
        pr.close();
    }
    catch(IOException e)
    {
        System.err.println(e);
    }
}


public void read()
{
    try
    {
        FileReader fr=new FileReader("src/FileHandling/names.txt");
        BufferedReader br=new BufferedReader(fr);
        while((name=br.readLine())!=null)
        {
            System.out.println(name);
        }
        br.close();
    }
    catch(IOException e)
    {
        System.err.println(e);
    }
}
}
