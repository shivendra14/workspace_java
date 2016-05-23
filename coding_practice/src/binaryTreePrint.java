import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class binaryTree
{
	Node Root;
	
}

class Node extends binaryTree
{
	int num;
	Node Left;
	Node Right;
	public Node(int num)
	{
		this.num=num;  Left=Right=null;
	}
}

class binaryTreePrint
{
	//http://w...content-available-to-author-only...s.org/print-binary-tree-2-dimensions/#comment-2684457828
	public int count = 10;
	public static void main(String args[])throws IOException
	{
		binaryTree bTree =CreateBinaryTree();
		printVerticalOrder(bTree.Root);
	}
	
	private static binaryTree CreateBinaryTree()
	{
		binaryTree bTree  = new binaryTree();
		bTree.Root   = new Node(1);
	    bTree.Root.Left   = new Node(2);
	    bTree.Root.Right  = new Node(3);
	 
	    bTree.Root.Left.Left  = new Node(4);
	    bTree.Root.Left.Right = new Node(5);
	    
	    bTree.Root.Right.Left  = new Node(6);
	    bTree.Root.Right.Right = new Node(7);
	 
	    bTree.Root.Left.Left.Left  = new Node(8);
	    bTree.Root.Left.Left.Right  = new Node(9);
	    
	    bTree.Root.Left.Right.Left  = new Node(10);
	    bTree.Root.Left.Right.Right  = new Node(11);
	    
	   bTree.Root.Right.Left.Left  = new Node(12);
	    bTree.Root.Right.Left.Right  = new Node(13);
	    
	    bTree.Root.Right.Right.Left  = new Node(14);
	    bTree.Root.Right.Right.Right  = new Node(15); 
	    
	    bTree.Root.Right.Right.Left.Right  = new Node(16);
	    bTree.Root.Right.Right.Left.Right.Right  = new Node(17);
	    
	    bTree.Root.Right.Right.Left.Right.Right.Right  = new Node(18);
	    bTree.Root.Right.Right.Left.Right.Right.Right.Right  = new Node(19);
	    bTree.Root.Right.Right.Left.Right.Right.Right.Right.Right  = new Node(20);
     
     	return bTree;
	}
	
	
	private static void getVerticalOrder(Node root, int hd, int vd, HashMap<Integer, HashMap<Integer,ArrayList<Integer>>> m, int parentDirection)
	{
	    // Base case
	    if (root == null)
	        return;
	 
	    // Store current node in map 'm'
	    HashMap<Integer,ArrayList<Integer>> verticalMap=m.containsKey(hd)?m.get(hd):new HashMap<>();
	    ArrayList<Integer> arr;
	    if (verticalMap.containsKey(vd))
	    {
	    arr =  verticalMap.get(vd);
	    }
	    else
	    	{
	    	arr=new ArrayList<>();
	    	arr.add(0); arr.add(0);
	    	}
	    if(parentDirection==-1)
	    {	    	arr.set(0, root.num);		} 
	    else if (parentDirection==1)
	    {	    	arr.set(1,root.num);		}	
	    
	    verticalMap.put(vd,arr);
	    m.put(hd,verticalMap);
	 
	    // Store nodes in left subtree
	    getVerticalOrder(root.Left, hd-1,vd+1, m, 1);
	 
	    // Store nodes in right subtree
	    getVerticalOrder(root.Right, hd+1,vd+1, m, -1);
	}
	
	private static void printVerticalOrder(Node root)
	{
	    // Create a map and store vertical oder in map using
	    // function getVerticalOrder()
	    HashMap <Integer,HashMap<Integer,ArrayList<Integer>>> m =new HashMap<>();
	    int hd = 0;
	    getVerticalOrder(root, hd,hd,m,-1);
	 
	    // Traverse the map and print nodes at every horigontal
	    // distance (hd)
	    
		Object[] hds=m.keySet().toArray();
		Comparator<Object> cmp =new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return (Integer)o2 - (Integer)o1;
			}
		};
	    Arrays.sort(hds, cmp);
	    for (Object i:hds)
	    {
	    	HashMap <Integer,ArrayList<Integer>> verticalMap=m.get((Integer)i);
	    	Object[] vds=verticalMap.keySet().toArray();
	    	Comparator<Object> cmp2 =new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return (Integer)o2 - (Integer)o1;
				}
			};
		    Arrays.sort(vds, cmp2);
	    	int prevHistValue=0;
	    	int prevHistj=0;
	    	int prevHisti=0;
		    for (Object j:vds)
		    {
		    	ArrayList<Integer> arr = (verticalMap.get((Integer)j));
		    	//System.out.println(arr);
		    	if (arr.get(1)!=0)
		    	{
		    	for(int k=0;k<(Integer)j;k++)
		    		System.out.print("  ");
		    		System.out.println(arr.get(1));
		    	}
		    	if (prevHistj!=0 && (prevHistValue!=0))
		    	{
		    	for(int k=0;k<prevHistj;k++)
		    		System.out.print("  ");
		    		System.out.println(prevHistValue);
		    	}
		    	prevHistj=(Integer)j;
		    	prevHisti=(Integer)i;
		    	prevHistValue=arr.get(0);
		    	
		    }
		    if (prevHistj!=0 && (prevHistValue!=0))
	    	{
	    	for(int k=0;k<prevHistj;k++)
	    		System.out.print("  ");
	    		System.out.println(prevHistValue);
	    	}
	    }
	}
}
