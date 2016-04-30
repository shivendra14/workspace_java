class Display
{
 Display()
 {
  final String money[]={" 1-     1,000"," 2-     2,000"," 3-     3,000",
  " 4-     5,000"," 5-    10,000"," 6-    20,000"," 7-    40,000",
  " 8-    80,000"," 9-  1,60,000","10-  3,20,000","11-  6,40,000",
  "12- 12,50,000","13-  25 Lakh","14-  50 Lakh","15-  1 Crore"};
  System.out.println ("#######################################################################\n");
  System.out.println (">>>>>       Good Morning & Welcome to KAUN BANEGA CARORPATI       <<<<<");
  System.out.println (">>>>>             Sir let's tell you about the game               <<<<<");
  System.out.println (">>>>>       3 lifelines 1.)50-50, 2.)Flip, 3.)Audience Pole       <<<<<\n");
  System.out.println ("#######################################################################\n");
  for (int i=0;i<700000000;i++);
  int c=0,d=0;
  for (int j=1;j<=15;j++)
  {
   System.out.print("  $");
   for (int i=1;i<=8-c;i++)
   System.out.print(" ");
   System.out.print("$");
   for (int i=1;i<=c;i++)
   System.out.print(" ");
   if (c<7 && d==0)
   c++;
   else
   { c--; d=1; }
   if (j==1||j==15)
   System.out.print("\t$");
   else 
   System.out.print("\t $");
   for  (int i=1;i<8;i++)
   if (j==1||j==8||j==15)
   System.out.print(" $");
   else
   System.out.print("  ");
   System.out.print(" $\t$");
   for (int i=1;i<8;i++)
   if (j==1||j==15)
   System.out.print(" $");
   else
   System.out.print("  ");
   System.out.println("   "+money[15-j]);
  }
 }
}
//  ????????•????????????¶§??????????@?Ç?¢£¥?ƒª¿¬?é»?{§????q±C??????
              //  • ¶ § @ Ç ¢ £ ¥ ƒ ª ¬ » ±