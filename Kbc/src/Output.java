class Output
{
 public Output(String options[],byte flag,byte ques_no)
 {
  final String money[]={"0","1,000","2,000","3,000","5,000","10,000","20,000","40,000",
  "80,000","1,60,000","3,20,000","6,40,000","12,50,000","25 Lakh","50 Lakh","1 Crore"};
  for (int i=0;i<1000000000;i++);
  if (flag==1)
  {
   System.out.println("    K.B.C. khelnae ke liye shukriya");
   System.out.println("    Sahi jawab tha"+options[3]);
   System.out.println("    Aur aap jeetate hain sirf "+money[ques_no-1]+" rupye");
   System.exit(0);
  }
  if (flag==2)
  {
   System.out.print ("ªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªª\n");
   System.out.println ("\tAufsos!!! Galat jawab, sahi jawab hai"+options[3]);
   if (ques_no<=5) 
   System.out.println ("\t        Aur aap jeetate hain 0 rupye");
   else if (ques_no<=10)
   System.out.println ("\t        Aur aap jeetate hain 10,000 rupye");
   else
   System.out.println ("\t        Aur aap jeetate hain 3,20,000 rupye");
   System.out.println ("ªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªªª");
   System.exit(0);
  }
  else if(flag==3)
  if(ques_no==15)
  for (int i=0;i<=20;i++)
  System.out.println ("           Congratulations!!!!!!! you became a \"CARORPATI\"");
  else
  { System.out.println ("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n");
    System.out.println ("           Sahi jawab, aur aapka agla sawal hai yeh -->\n"); 
    System.out.println ("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n");
  }
 }
}