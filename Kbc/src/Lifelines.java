class Lifelines  
{
 static StringBuffer lifeline=new StringBuffer(3);
 public void F_50(String options[])
 {
  lifeline.append(1);
  for (int i=0;i<1000000000;i++);
  System.out.println (".......................................................................");
  System.out.println ("                 The remaining \"50-50\" options are --->");
  System.out.println (".......................................................................\n");
  for (int i=0;i<2000000000;i++);
  byte a=(byte)(Math.random()*3);
  for (int i=0;i<3;i++)
   if (a==i)
    if(options[a].charAt(1)<options[3].charAt(1))
    System.out.println (options[a]+"\n"+options[3]);
    else
    System.out.println (options[3]+"\n"+options[a]);
  for (int i=0;i<700000000;i++);
  System.out.println ("\nEnter your choice --->\n");
 }
 public void Flip(String options[])
 {
  for (int i=0;i<1000000000;i++);
  System.out.println (".......................................................................");
  System.out.println ("                  Your new \"flip\" question is --->");
  System.out.println (".......................................................................\n");
  for (int i=0;i<1000000000;i++);
  System.out.println ("ƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒ\n");
  System.out.println ("FLIP- Who was the eldest son of Kunti acording to Hindu mythology ?\n");
  System.out.println ("ƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒƒ\n");
  options[0]="Bhima";options[1]="Yudhishtir";options[2]="Arjun";options[3]="Karna";
  lifeline.append(2);
 }
 public void A_Pole(String options[])
 {
  for (int i=0;i<1000000000;i++);
  System.out.println (".......................................................................");
  System.out.println ("                 The \"audience\" recommendations are -->");
  System.out.println (".......................................................................\n");  
  String a=Double.toString(Math.random());
  byte c=Byte.parseByte(a.substring(a.length()-2));
  for (int i=0;i<1000000000;i++);
  switch (options[3].charAt(1))
  { case 'A':System.out.println ("A: "+c+"%\nB: "+(100-c-(100-c)/2-(100-c)/4)+"%\nC: "+(100-c)/2+"%\nD: "+(100-c)/4+"%");
             break;
    case 'B':System.out.println ("A: "+(100-c-(100-c)/2-(100-c)/4)+"%\nB: "+c+"%\nC: "+(100-c)/2+"%\nD: "+(100-c)/4+"%");
             break;
    case 'C':System.out.println ("A: "+(100-c)/2+"%\nB: "+(100-c-(100-c)/2-(100-c)/4)+"%\nC: "+c+"%\nD: "+(100-c)/4+"%");
             break;
    case 'D':System.out.println ("A: "+(100-c)/4+"%\nB: "+(100-c)/2+"%\nC: "+(100-c-(100-c)/2-(100-c)/4)+"%\nD: "+c+"%");
  }
  for (int i=0;i<700000000;i++);
  System.out.println ("\nEnter your choice --->\n");
  lifeline.append(3);
 }
}