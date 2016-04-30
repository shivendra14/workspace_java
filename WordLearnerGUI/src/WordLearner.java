import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


class WordLearner
{
 int arr[];
 WordLearner()
 {
     try
        {
         int count=0; String data="",prev="";;
         FileReader fr=new FileReader("data/WordList.txt");
         BufferedReader br=new BufferedReader(fr);
         while((data=br.readLine()) != null)
         {
             data=data.trim();
             prev=data;
             count++;
        }
        count--;
        arr=new int[count/3 +1];
        for (int i=1;i<=count/3;i++)
        arr[i]=0;
        char pos='\u0000';  int i=0; String temp="";        
        while(i<prev.length())
        {
            pos=prev.charAt(i);    i++;
            if(pos!=',' || pos!='.')
            temp+=pos;
            else
            {
                int p=Integer.parseInt(temp);
                arr[p]++;
                temp="";
            }
        }
        arr[0]=count/3;
        br.close();
    }
        catch (IOException e){}
 
 
     
    }
    
    public Combo main()
    {
        
        int rand=0;
     int size0=0, size1=0, size2=0;
     for(int i=1;i<= arr[0]; i++)
     {
         if(arr[i]==0)
         size0++;
         else if(arr[i]==1)
         size1++;
         else
         size2++;
     }
     Combo data=new Combo();         
     try
     {

     if(size1==0 && size2==0)
     rand=(int)Math.ceil(size0*Math.random());
     else
     rand=(int)Math.floor((size0-size1-size2+1)*Math.random());
     if(rand==0)
     {
      if(size2==0)
      rand=(int)Math.ceil(size1*Math.random());
      else
      rand=(int)Math.floor((size1-size2+1)*Math.random());
      
      if(rand==0)
      {
        rand=(int)Math.ceil(size2*Math.random());
        data=wordfetch(rand,2);
      }
      else
      data=wordfetch(rand,1);
     }
     else
     data=wordfetch(rand,0);

    }
    catch (Exception e) {}
         return data;    
 }
    
    public Combo wordfetch(int line, int status)throws Exception
    {
        Combo obj=new Combo();
        FileReader fr=new FileReader("data/WordList.txt");
        BufferedReader br=new BufferedReader(fr);
        int count=0;
        for(int i=1;i<=arr[0];i++)
        {
            if(arr[i]==status)
            {
                count++;
                if(count==line)
                {
                    obj.word=br.readLine();
                    obj.meaning=br.readLine();
                    obj.line=i;
                    break;
                }
                else
                {
                 br.readLine();  br.readLine();  br.readLine();
                }
            }
            else
            {
                br.readLine();  br.readLine();  br.readLine();
            }
        
        }
        br.close();
         return obj;
 }
}