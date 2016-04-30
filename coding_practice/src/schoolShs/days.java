package schoolShs;
import java.io.*;
class days
{
int y,n;
public void input()throws IOException
    {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       System.out.println("day no.  ");
       int d=Integer.parseInt(br.readLine());
       System.out.println("year   ");
       y=Integer.parseInt(br.readLine());
       System.out.println("day after(n<100) ");
       n=Integer.parseInt(br.readLine());
       if (n<1 || n>100 || d<1 ||d>366)
       {System.out.println("Wrong input"); System.exit(0);}
       System.out.print("INITIAL "); changed(d);
       System.out.print("FINAL "); changed(d+n);
    }
    private void changed(int d)
    {
       String month[]={"","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
       int arr[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
       
        
        int dd=0,mm=1,yy=y;
        int i=1;
        while(d>arr[i])
        {
            if (y%100==0)
            {
                if(y%400==0)
                arr[2]=29;
            }
            else if(y%4==0)
            arr[2]=29;
            
            d=d-arr[i];
            i++;
            mm++;
            if(mm==13)
            { mm=1; yy++; i=1;}
        }
        dd=d;
        String e="";
        switch(d)
        {
            case 1:
            case 21:
            case 31:e="st";break;
            case 2:
            case 22:e="nd";break;
            case 3:
            case 23:e="rd";break;
            default:e="th";break;
        }
            
        System.out.println("DATE-->\t"+dd+e+"\t"+month[mm]+"\t"+yy);
    }
}
