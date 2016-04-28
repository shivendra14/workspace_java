import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaurabhXML 
{
    public String[] findAns(String line)
    {
        String outArr[];
        String inpArr[]=line.split(" ");
        
        outArr = new String[2* inpArr.length];
        
        for (int i=0;i <inpArr.length;i++)
        {
        	String num= inpArr[i].substring(2); //remove 0x
        	if (num.length()==1)                //converting inputs of form 0xA to 0x0A
        		num="0"+num;
        	
        	String right=num.charAt(1)+"2";
        	String left =num.charAt(0)+"a";
        	
        	outArr[2*i]   = "<byte>0x"+right+"</byte>";
        	outArr[2*i+1] = "<byte>0x"+left +"</byte>";
        }
        return outArr;
    }
}

	
	


