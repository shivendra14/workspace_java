package schoolShs;
import java.io.*;

class node
{
int info;
node ptr;
}

class link_list
{
node list,newptr,first;
public void input()throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter the number--> ");
newptr=new node();
newptr.info=Integer.parseInt(br.readLine());
newptr.ptr=null;
    }
public void create()
{

first=list=newptr;

list.ptr=newptr;
list=newptr;
}
public void insert(int p)
{
list=first;
node prev = null;
int pos=1;
while(pos!=p)
{
pos++;
prev=list;
list=list.ptr;
    }
   newptr.ptr=prev.ptr;
    prev.ptr=newptr;
}
public void delete()
{}
public static void main(String args[])throws IOException
{}
    }