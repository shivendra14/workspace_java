package spelling;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
		size=0;
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		boolean containsWord=true;
		word=word.toLowerCase();
		TrieNode child = root;
		for(char c : word.toCharArray())
		{
			if (child.getValidNextCharacters().contains(c) && containsWord)
			{
			child = child.getChild(c);
			}
			else
			{
				containsWord=false;
				child=child.insert(c);
			}
			//System.out.println(child.getText() + containsWord);
		}
		if (containsWord)
	    return false;
		else
		{
			child.setEndsWord(true);
			return true;
		}
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
		return size(root);
		
	}
	
	private int size(TrieNode current)
	{
		int size=0;
		if (current.endsWord())
			size=1;
		for (char c :current.getValidNextCharacters())
		{
			size+=size(current.getChild(c));
		}
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String word) 
	{
	    // TODO: Implement this method
		return (pointOfDifference(word)==null)?true:false;
		
	}

	private TrieNode pointOfDifference(String word) 
	{
	    // TODO: Implement this method
		boolean containsWord=true;
		word=word.toLowerCase();
		TrieNode child = root;
		for(char c : word.toCharArray())
		{
			if (child.getValidNextCharacters().contains(c) && containsWord)
			child = child.getChild(c);
			else
			{
				containsWord=false;
				return child;
			}
			
		}
		if (child.endsWord() && child.getText().equals(word))
			return null;
		else
			return child;
		
	}
	
	private TrieNode findStem(String word) 
	{
	    // TODO: Implement this method
		boolean containsWord=true;
		word=word.toLowerCase();
		TrieNode child = root;
		for(char c : word.toCharArray())
		{
			if (child.getValidNextCharacters().contains(c) && containsWord)
			child = child.getChild(c);
			else
			{
				containsWord=false;
				return null;
			}
			
		}
		if (child.getText().equals(word))
			return child;
		else
			return null;
		
	}
	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
    	 List<String> predictions=new ArrayList<>();
    	 Queue<TrieNode> qu=new LinkedList<>();
    	 List <TrieNode> visited= new ArrayList<>();
    	 prefix=prefix.toLowerCase();
    	 TrieNode curr=findStem(prefix);
    	 if(curr==null)
    		 return predictions;    	 
    	 qu.add(curr);
    	 visited.add(curr);
    	 while (!qu.isEmpty())
    	 {
    		 curr=qu.poll();
    		 if(curr.endsWord())
    			 predictions.add(curr.getText());
    		 for (char c :curr.getValidNextCharacters())
    		 {
    			 TrieNode next=curr.getChild(c);
    			 if(!visited.contains(next))
    			 {
    				 qu.add(next);
    				 visited.add(next);
    			 }
    		 }
    	 }
    	 
    	 
         return predictions.size()>numCompletions? predictions.subList(0, numCompletions) : predictions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}