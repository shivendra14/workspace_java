import java.io.*;
class Process extends Lifelines  
{
 public byte Process(String options[])throws IOException
 {
  char input='\u0000'; byte flag=0;
  final String Lifelines[]={"50-50","Flip","Audience Pole"};
  for (int i=0;i<700000000;i++);
  System.out.println ("\nEnter your choice --->\n");
  while(flag==0)
  {
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   String n=br.readLine().toUpperCase();
   input = n.length()==1 ? n.charAt(0) :'\u0000';
   for (int i=0;i<100000000;i++);
   if ("123".indexOf(input)!=-1 && lifeline.indexOf(""+input)!=-1)
   { System.out.println ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
     System.out.println ("             You had already used "+Lifelines[input-49]+" life line    ");
     System.out.println ("                 Please enter any other choise !!!                     ");
     System.out.println ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
     continue; }
   else if (input=='1')
   { F_50(options); continue; }
   else if (input=='2')
   { Flip(options); new Options(options);
     flag=Process(options); }
   else if (input=='3')
   { A_Pole(options); continue; }
   else if (input=='Q')
   flag=1;
   else if ("ABCD".indexOf(input)>-1)
   {
     if (input==options[3].charAt(1))
     flag=3;
     else
     for(int i=0;i<3;i++)
     if (input==options[i].charAt(1))
     flag=2;
   }
   else
   { System.out.println ("?????????????????????????????????????????????????????????????????????¿¿");
     System.out.println ("?¿?   Please enter correct choise such as 'A' or 'B' or 'C' or 'D'  ?¿?");
     System.out.println ("?¿?      and for lifelines you must enter '1' or '2' or '3'         ?¿?");
     System.out.println ("?¿?            To quit the game in between enter 'Q'                ?¿?");
     System.out.println ("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿"); }
  }
  return flag;
 }
}