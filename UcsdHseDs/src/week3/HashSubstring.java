package week3;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    // for hash function
    private static int prime = 1000000007;
    private static int multiplier = 263;
    
    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences_nave(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();
        for (int i = 0; i + m <= n; ++i) {
	    boolean equal = true;
	    for (int j = 0; j < m; ++j) {
		if (s.charAt(j) != t.charAt(i + j)) {
		     equal = false;
 		    break;
		}
	    }
            if (equal)
                occurrences.add(i);
	}
        return occurrences;
    }

    private static List<Integer> getOccurrences(Data input) 
    {
    	List<Integer> occurrences = new ArrayList<Integer>();
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        
        if (m>n || n<1)  //pattern is bigger than text
        	return occurrences;
        
        long patternHash= hashFunc(s);
        long subStringHash = hashFunc( t.substring(0, m) ) ;
        
        for (int i = 0; i + m <= n; ++i) 
        {   
        	if(patternHash==subStringHash)
        	{
        		boolean equal = true;	 
        		for (int j = 0; j < m; ++j) 
        		{
        			if (s.charAt(j) != t.charAt(i + j)) 
        			{
        				equal = false;
        				break;
        			}
        		}
        		if (equal)
        			occurrences.add(i);
        	}
        	
        	if (i+m < n)
        	{
        		//nextHash 
        		subStringHash = rabinFingerprintRollingHash(subStringHash, m, t.charAt(i), t.charAt(i+m));
        	}
        }
        return occurrences;
    }
    
    private static long hashFunc(String s) {
        long hash = 0;
        for (int i = 0; i < s.length() ; i++)
            hash = ((hash * multiplier  % prime+ s.charAt(i)))%prime;
        return hash;
    }
    
    private static long rabinFingerprintRollingHash(long prevHash, int patternLength, char startChar, char endChar)
    {
    	long newHash=0;
    	//newHash = (long)(( (prevHash - startChar*Math.pow(multiplier, patternLength-1)% prime) *multiplier + endChar ) % prime) ;
    	
    	newHash = prevHash*multiplier %prime - (long)((startChar*Math.pow(multiplier, patternLength)  % prime - endChar) );
    	
    	newHash= (newHash +prime)%prime;
    	//System.out.print(startChar + ""+endChar+"\t");
    	//System.out.println(prevHash +"\t\t"+ newHash);
    	return newHash;
    }
    
    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

