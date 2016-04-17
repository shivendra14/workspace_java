import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Anagram
{

 public NodeString main(String input)
 {
     String gen="",name="";
     input=generic(input);
     int word_length=input.length();
     NodeString perm=new NodeString();
     NodeString list=perm;
     perm.next=null;
     try
    {
        FileReader fr=new FileReader("data/dict.txt");
        BufferedReader br=new BufferedReader(fr);
        while((name=br.readLine())!=null)
        {
            int len=name.length();
            if (len!=word_length) 
            continue;
            
            gen=generic(name);
            if(gen.equals(input))
            {
                NodeString temp=new NodeString();
                temp.a=name;
                temp.next=null;
                list.next=temp;
                list=list.next;
            }
        }
        br.close();
    }
    catch(IOException e)
     {}
     return perm.next;
 }
 
 public String generic(String a)
 {
     int len=a.length();
     char arr[]=new char[len];   
     for(int i=0;i<len;i++)
     arr[i]=a.charAt(i);
     
     for(int i=0;i<len;i++)
         for(int j=0;j<len-1-i;j++)
             if(arr[j]>arr[j+1])
             {
                 char tem=arr[j];
                 arr[j]=arr[j+1];
                 arr[j+1]=tem;
             }
     a="";
     for(int i=0;i<len;i++)
     a+=arr[i];
     return a;
 }
}