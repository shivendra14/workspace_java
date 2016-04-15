import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;




public class tree_height_grader {
    public static void main(String[] args) {
        try
        {
            System.out.println("TestSuite for treeHeight:");
            String testFolder="tests_tree_height/";
            for (int i=1;i<=24;i++)
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
            	tree_height obj=new tree_height();
            	tree_height.TreeHeight tree= obj.new TreeHeight();
            	tree.n= Integer.parseInt(line);
            	line=br.readLine();
            	
            	tree.parent = new int[tree.n]; 
            	int count=0;
            	for (String num:line.split(" "))
            	{
            		tree.parent[count]=Integer.parseInt(num);
            		//System.out.print(tree.parent[count]+"  ");
            		count++;
            	}
    			System.out.println();
                
                int result = tree.computeHeight();
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
