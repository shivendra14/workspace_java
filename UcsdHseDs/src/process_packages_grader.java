import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class process_packages_grader {
    public static void main(String[] args) {
        try
        {
            System.out.println("TestSuite for processPackages:");
            String testFolder="tests_process_package/";
            for (int i=1;i<=22;i++)
            {
            	String testFile=Integer.toString(i);
            	if(i/10==0) testFile="0"+testFile;
            	
            	
            	Scanner scannerTestCase = new Scanner(new File(testFolder+testFile));
            	Scanner scannerSolution = new Scanner(new File(testFolder+testFile+".a"));

                int buffer_max_size = scannerTestCase.nextInt();
                int num_of_packets = scannerTestCase.nextInt();
                Buffer buffer = new Buffer(buffer_max_size);

                ArrayList<Request> requests = new ArrayList<>();
                while(scannerTestCase.hasNextInt()&& num_of_packets-- > 0)
                {
                	int arrival_time=scannerTestCase.nextInt();
                	int process_time=scannerTestCase.nextInt();
                	requests.add(new Request(arrival_time, process_time));
                }
                
                ArrayList<Response> responses = new ArrayList<>();
                boolean isTestPass = true;
                for (int k = 0; k < requests.size() && isTestPass; ++k) {
                    responses.add(buffer.Process(requests.get(k)));
                    int replyAns=scannerSolution.nextInt();
                    isTestPass=responses.get(k).start_time==replyAns;
                    //System.out.println("Processed: "+responses.get(k).start_time + "\tSolution: " + replyAns);
                }
                System.out.println("TestCase: "+ testFile + "\t"+ isTestPass);
                scannerTestCase.close();
                scannerSolution.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
