package week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class check_brackets_grader {
    public static void main(String[] args) {
        try
        {
            System.out.println("TestSuite for check Brackets:");
            String testFolder="tests_check_brackets/";
            for (int i=1;i<=54;i++)
            {
            	String testFile=Integer.toString(i);
            	if(i/10==0) testFile="0"+testFile;
            BufferedReader br = new BufferedReader(new FileReader(testFolder+testFile));
            BufferedReader ans = new BufferedReader(new FileReader(testFolder+testFile+".a"));
            System.out.print(testFile+"\t");
            String line; String output;
            //PrintWriter out = new PrintWriter("grader_output/module2.part1.out", "utf-8");
            while ((line = br.readLine()) != null && (output = ans.readLine())!=null)
            {
                check_brackets doc = new check_brackets();
                
                int result = doc.faultPoint(line);
                System.out.print(result+"   ");
                System.out.print(output+"   ");
                if (result>=0)
                System.out.println(Integer.parseInt(output)==result);
                else
                System.out.println(output.equals("Success"));	
               // out.print(result);
            }
            //out.print("\n");
            //out.close();
            br.close();
            ans.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
