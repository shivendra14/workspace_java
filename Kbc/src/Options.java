class Options  
{
 public Options(String options[])
 {
  StringBuffer s=new StringBuffer(4);
  char c='A'-1;
  while (c!='D')
  {
   byte a=(byte)(Math.random()*4);
   if(s.indexOf(Byte.toString(a))==-1)
   {
    System.out.print(" "+ ++c +": ");
    for (int i=0;i<800000000;i++);
    for (int i=0;i<4;i++)
    if (a==i)
    {
     System.out.println (options[i]);
     options[i]=" "+c+": "+options[i]; break;
    }
    s.append(a);
   }
  }
 }
}