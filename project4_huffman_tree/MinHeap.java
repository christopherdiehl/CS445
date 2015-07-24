
public class MinHeap<T extends Comparable<? super T>> implements MinHeapInterface<T>
{
	private T[] heap;
	private int lastIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 25;
	
	public MinHeap()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public MinHeap(int initialCapacity)
	{
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity];
		
		heap = tempHeap;
		lastIndex = 0;
	}
	
	public void add(T newEntry)
	{
		lastIndex++;
		ensureCapacity();
		
		int newIndex = lastIndex;
		int parentIndex = newIndex / 2;
		
		while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) < 0)
		{
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}
		
		heap[newIndex] = newEntry;
	}

	public T removeMin()
	{
		T root = null;
		
		if(!isEmpty())
		{
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		
		return root;
	}

	public T getMin()
	{
		T root = null;
		
		if(!isEmpty())
		{
			root = heap[1];
		}
		
		return root;
	}

	public boolean isEmpty()
	{
		return lastIndex < 1;
	}

	public int getSize()
	{
		return lastIndex;
	}

	public void clear()
	{
		for(int i = 0; i <= lastIndex; i++)
		{
			heap[i] = null;
		}
		
		lastIndex = 0;
	}

	private void ensureCapacity()
	{
		if(heap.length == lastIndex)
		{
			@SuppressWarnings("unchecked")
			T[] tempHeap = (T[]) new Comparable[heap.length * 2];
			
			for(int i = 0; i < lastIndex; i++)
			{
				tempHeap[i] = heap[i];
			}
			
			heap = tempHeap;
		}
	}

	private void reheap(int rootIndex)
	{
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = rootIndex * 2;
		
		while(!done && (leftChildIndex <= lastIndex))
		{
			int smallerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			if((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[smallerChildIndex]) < 0)
			{
				smallerChildIndex = rightChildIndex;
			}
			
			if(orphan.compareTo(heap[smallerChildIndex]) > 0)
			{
				heap[rootIndex] = heap[smallerChildIndex];
				rootIndex = smallerChildIndex;
				leftChildIndex = rootIndex * 2;
			}
			else
			{
				done = true;
			}
		}
		
		heap[rootIndex] = orphan;
	}
}
