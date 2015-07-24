
public class SimpleQueue<T>
{
	private Node firstNode;
	private Node lastNode;
	
	public SimpleQueue()
	{
		firstNode = null;
		lastNode = null;
	}
	
	public void enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry);
		
		if(firstNode == null)
		{
			firstNode = newNode;
			lastNode = newNode;
		}
		else
		{
			lastNode.next = newNode;
			lastNode = newNode;
		}
	}
	
	public T dequeue()
	{
		T result = null;
		
		if(firstNode != null)
		{
			result = firstNode.data;
			if(lastNode == firstNode)
			{
				lastNode = null;
			}
			firstNode = firstNode.next;
		}
		
		return result;
	}
	
	public T getFront()
	{
		if(firstNode != null)
		{
			return firstNode.data;
		}
		
		return null;
	}
	
	private class Node
	{
		private T data;
		private Node next;
		
		public Node(T aData, Node nextNode)
		{
			data = aData;
			next = nextNode;
		}
		
		public Node(T aData)
		{
			this(aData, null);
		}
	}
}
