
public class LStack<T> implements StackInterface<T>
{
	private Node firstNode;
	
	public LStack()
	{
		firstNode = null;
	}
	
	public void push(T anEntry)
	{
		Node newNode = new Node(anEntry, firstNode);
		firstNode = newNode;
	}
	
	public T pop()
	{
		T result = null;
		
		if(firstNode != null)
		{
			result = firstNode.data;
			firstNode = firstNode.next;
		}
		
		return result;
	}
	
	public T peek()
	{
		if(firstNode != null)
		{
			return firstNode.data;
		}
		
		return null;
	}
	
	public boolean isEmpty()
	{
		return firstNode == null;
	}
	
	public void clear()
	{
		firstNode = null;
	}
	
	private class Node
	{
		private T data;
		private Node next;
		
		private Node(T aData)
		{
			this(aData, null);
		}
		
		private Node(T aData, Node nextNode)
		{
			data = aData;
			next = nextNode;
		}
	}
}
