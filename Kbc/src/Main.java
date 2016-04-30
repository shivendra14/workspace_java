import java.io.*;
class Main  
{
 public static void main(String args[])throws IOException
 {
  new Display(); byte limit=0;
  String options[]=new String[4];
  StringBuffer s=new StringBuffer(41);
  s.append(" "); byte ques_no=1;
  while(ques_no<=15)
  {
   limit=(byte)(Math.random()*19);
   if(s.indexOf(" "+limit+" ")==-1)
   {
    s.append(limit+" ");
    new Questions(options,ques_no,limit);
    new Options(options);
    byte flag=new Process().Process(options);
    new Output(options,flag,ques_no);
    ques_no++;
   }
  }
 }
}