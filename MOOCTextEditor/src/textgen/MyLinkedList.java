package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head=new LLNode<E> ();
		tail=new LLNode<E> ();
		head.next=tail;
		tail.prev=head;
		size=0;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null) throw new IndexOutOfBoundsException("null can't be added");
		tail.data=element;
		tail.next=new LLNode<E>();
		tail.next.prev=tail;
		tail=tail.next;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index<0) throw new IndexOutOfBoundsException("negative index not allowed!");
		LLNode<E> node = head.next;
		while (index!=0)
		{
			node=node.next;			
			index--;
			if(node==tail) throw new IndexOutOfBoundsException("index not found!");		
			
		}
		if(node==tail) throw new IndexOutOfBoundsException("empty list!");
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index<0) throw new IndexOutOfBoundsException("negative index not allowed!");
		LLNode<E> nextNode = head.next;
		LLNode<E> prevNode = head;
		while (index!=0)
		{			
		    prevNode=nextNode;
			nextNode=nextNode.next;
			index--;
			if(prevNode==tail) throw new IndexOutOfBoundsException("index not found!");			
		}
		if(element==null) throw new IndexOutOfBoundsException("null can't be added");
		LLNode <E>newNode = new LLNode<E>(element);
		newNode.prev=prevNode;
		newNode.next=nextNode;
		prevNode.next=newNode;
		nextNode.prev=newNode;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index<0) throw new IndexOutOfBoundsException("negative index not allowed!");
		LLNode<E> node = head.next;
		LLNode<E> prevNode = head;
		while (index!=0)
		{
			prevNode=node;
			node=node.next;
			index--;
			if(node==tail) throw new IndexOutOfBoundsException("index not found!");	
		}
		if(node==tail) throw new IndexOutOfBoundsException("empty list!");
		prevNode.next=node.next;
		node.next.prev=prevNode;
		size--;
		return node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index<0) throw new IndexOutOfBoundsException("negative index not allowed!");
		LLNode<E> node = head.next;
		while (index!=0)
		{			
			node=node.next;
			index--;
			if(node==tail) throw new IndexOutOfBoundsException("index not found!");	
		}
		if(node==tail) throw new IndexOutOfBoundsException("empty list!");
		E temp=node.data;
		if(element==null) throw new IndexOutOfBoundsException("null can't be added");
		node.data=element;
		return temp;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode()
	{
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prev, LLNode<E> next) 
	{
		this.data = e;
		this.prev = prev;
		this.next = next;
	}

}
