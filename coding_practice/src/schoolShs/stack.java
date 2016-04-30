package schoolShs;
import java.io.*;
class stack
{
char stk[]=new char[100];
int capacity;
int top;
public stack(int a)
{
capacity=a;
top=-1;
}
public void pushData(char val)
{
if(top<capacity-1)
 {
  top++;
  stk[top]=val;
 }
 else
  System.out.println("STACK OVERFLOW!!Element cannot be pushed");
}
public char removeData()
{
if(top>-1)
 {
     --top;
     return stk[top+1];
 }
 else
 {
     System.out.println("STACK UNDERFLOW!!");
     char q='9';
     return q;
  }
}
public void showStag()
{
 if(capacity!=0)
 for(int i=0;i<=top;i++)
 {
     System.out.println(stk[i]);
 }
 else
  System.out.println("STACK UNDERFLOW");
}
public static void main()throws IOException
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Enter capacity -->");
 int n=Integer.parseInt(br.readLine());
 stack obj=new stack(n);
 char ch;
 while(true)
 {
     System.out.println("MENU");
     System.out.println("R-REMOVE\nP-PUSH DATA\nD-DISPLAY \nQ-QUIT");
     String v=br.readLine();
     ch=v.charAt(0);
     ch=Character.toUpperCase(ch);
     System.out.println();

     switch(ch)
     {
         case'R':obj.removeData();
          break;
         case 'P':System.out.println("Enter the char.");
          String v2=br.readLine();
          char va=v2.charAt(0);
          obj.pushData(va);
          break;
         case 'D':obj.showStag();
          break;
         case 'Q':System.exit(0);
          break;
         default:System.out.println("WRONG CHOICE!!!");
          System.exit(0);
     }
  }
}}