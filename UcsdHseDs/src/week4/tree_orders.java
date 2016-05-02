package week4;
import java.util.*;
import java.io.*;

public class tree_orders {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
	
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeOrders {
		int n;
		long [] key;
		int[] left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new long[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Long> inOrder() {
			ArrayList<Long> result = new ArrayList<Long>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			inorder_Helper(result,0);
                        
			return result;
		}
		private void inorder_Helper(ArrayList<Long> result, int index)
		{
			if (index<key.length && index>-1)
			{
				inorder_Helper(result, left[index]);
				result.add(key[index]);
				inorder_Helper(result, right[index]);
			}
		}

		List<Long> preOrder() {
			ArrayList<Long> result = new ArrayList<>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			preOrder_Helper(result,0);
                        
			return result;
		}
		private void preOrder_Helper(ArrayList<Long> result, int index)
		{
			if (index<key.length && index>-1)
			{
				result.add(key[index]);
				preOrder_Helper(result, left[index]);
				preOrder_Helper(result, right[index]);
			}
		}

		List<Long> postOrder() {
			ArrayList<Long> result = new ArrayList<>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			postOrder_Helper(result,0);            
			return result;
		}
		
		private void postOrder_Helper(ArrayList<Long> result, int index)
		{
			if (index<key.length && index>-1)
			{
				postOrder_Helper(result, left[index]);
				postOrder_Helper(result, right[index]);
				result.add(key[index]);
			}
		}
	}
	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Long> x) {
		for (Long a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
