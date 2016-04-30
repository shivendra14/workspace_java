package officeQc;
class node
{
	int data;
	node next;
}

public class nthToLast {
	public static void main(String args[])
	{
		int size=10; //example list of given size and elements
		node list=new node();
		node first=list;
		for (int i=0;i<size;i++)
		{
			node temp=new node();
			temp.data=i;
			temp.next=null;
			list.next=temp;
			list=temp;
		}
		int n=4;  //example n
		list=first;
		node window=first;
		while (n-- >1)
			window=window.next;
		while (window.next!=null)
		{
			window=window.next;
			list=list.next;
		}
		System.out.println(list.data);
	}

}
