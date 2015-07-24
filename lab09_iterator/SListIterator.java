import java.util.NoSuchElementException;


public class SListIterator<T>
{
	private Node firstNode;
	private int numberOfEntries;
	private IteratorForSList Iterator;
	
	public SListIterator()
	{
		firstNode = null;
		numberOfEntries = 0;

	}
	
	public void addToFirst(T aData)
	{
		firstNode = new Node(aData, firstNode);
		numberOfEntries++;
	}
	
	public T getEntry(int givenPosition)
	{
		T result = null;
		
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			result = (getNodeAt(givenPosition)).data;
		}
		
		return result;
	}
	
	private Node getNodeAt(int givenPosition)
	{
		Node currentNode = firstNode;
		
		for(int counter = 1; counter < givenPosition; counter++)
		{
			currentNode = currentNode.next;
		}
		
		return currentNode;
	}
	
	public Iterator<T> getIterator()
	{
		Iterator = new IteratorForSList();
		return (Iterator<T>) Iterator;
	}
	
	private class IteratorForSList implements Iterator<T>
	{
		// TO DO: instance variable for IteratorForSList
		Node currNode;
		
		
		private IteratorForSList()
		{
			currNode = firstNode;
		}
		
		public boolean hasNext()
		{
			if (currNode == null)
				return false;
			
			return true;
			
		}
		
		public T next()
		{
			Node tempNode = currNode;
			currNode = currNode.next;
			return tempNode.data;
		}
		
		public T remove()
		{
			throw new UnsupportedOperationException("remove() is not supported by this iterator");
		}
	}
	
	private class Node
	{
		private T data;
		private Node next;
		
		private Node(T aData, Node nextNode)
		{
			data = aData;
			next = nextNode;
		}
	}
}
