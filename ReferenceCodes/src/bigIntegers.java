import java.math.*;
import java.io.*;
class bigIntegers
{
public static void main(String args[])throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
for(int i=0;i<t;i++)
{
String tw=br.readLine();
String mw=br.readLine();
if(tw.length()>9)
{
BigInteger TW = new BigInteger(tw);
BigInteger MW = new BigInteger(mw);
BigInteger result = TW.remainder(MW);
TW= TW.subtract(result);
BigInteger resdiv= TW.divide(MW);
System.out.println(result+" "+resdiv);
}
else
{
long tww=Long.parseLong(tw);
long mww=Long.parseLong(mw);
System.out.println(tww%mww+" "+(long)(tww/mww));
}
}
}
}