package FileHandling;

import java.io.*;
class byteFile
{
   static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   public static void main(String args[])throws IOException
   {
      String name="";
      int mark=0;
      
      // write in a file
      try
      {
        FileOutputStream fw=new FileOutputStream("src/FileHandling/marks.txt");
        DataOutputStream fout=new DataOutputStream(fw); 
        
        for (int i=0;i<3;i++)
        {
          System.out.println("Enter name");
          name=br.readLine();
          fout.writeUTF(name);
          System.out.println("Enter marks");
          mark=Integer.parseInt(br.readLine());
          fout.writeInt(mark);
      }
      fout.close();
      fw.close();
     }
     catch(Exception e)
     {
        System.out.println("File open error");
     }  
       
     //read the file 
     try
     {
      FileInputStream fr=new FileInputStream("src/FileHandling/marks.txt");
      DataInputStream fin=new DataInputStream(fr);
      System.out.println("Output-->");
      boolean eof = false;
      while(!eof)
      {
         name=fin.readUTF();
         mark=fin.readInt();
         System.out.println("Name "+name+"\nMarks "+mark);
      }
      eof = true;
     }
     catch(EOFException e)
     {
     } 
   }
}