import java.util.ArrayList;

public class HuffmanTree
{
	private String str;
	private BinaryNodeInterface<Character> root;
	private ArrayList<Character> charList;
	private ArrayList<Integer> freqList;
	
	public HuffmanTree(String aString)
	{
		str = aString;
		root = null;
		
		generateFrequencyList();
		generateHuffmanTree();
	}
	
	public BinaryNodeInterface<Character> getRootNode()
	{
		return root;
	}
	
	private void generateHuffmanTree()
	{
		if(str == null || str.equals(""))
		{
			root = null;
			return;
		}
		
		MinHeapInterface<BinaryNodeFrequency<Character>> heap = new MinHeap<BinaryNodeFrequency<Character>>();
		
		while(!charList.isEmpty())
		{
			char c = charList.remove(0);
			int freq = freqList.remove(0);
			
			BinaryNodeInterface<Character> newNode = new BinaryNode<Character>(c);
			BinaryNodeFrequency<Character> newBNode = new BinaryNodeFrequency<Character>(newNode, freq);
			heap.add(newBNode);
		}
		
		while(!heap.isEmpty())
		{
			BinaryNodeFrequency<Character> left = heap.removeMin();
			if(heap.isEmpty())
			{
				root = left.node;
				break;
			}
			
			BinaryNodeFrequency<Character> right = heap.removeMin();
			
			int newFrequency = left.frequency + right.frequency;
			BinaryNodeInterface<Character> newNode = new BinaryNode<Character>(null, (BinaryNode<Character>) left.node, (BinaryNode<Character>) right.node);
			BinaryNodeFrequency<Character> newBNode = new BinaryNodeFrequency<Character>(newNode, newFrequency);
			heap.add(newBNode);
		}
		
		if(root.isLeaf())
		{
			BinaryNodeInterface<Character> newNode = new BinaryNode<Character>(null, (BinaryNode<Character>) root, null);
			root = newNode;
		}
		
	}
	
	private void generateFrequencyList()
	{
		charList = new ArrayList<Character>();
		freqList = new ArrayList<Integer>();
		
		int strLength = str.length();
		
		for(int i = 0; i < strLength; i++)
		{
			char c = str.charAt(i);
			int charIndex = charList.indexOf(c);
			
			if(charIndex != -1)
			{
				freqList.set(charIndex, freqList.get(charIndex) + 1);
			}
			else
			{
				charList.add(c);
				freqList.add(1);
			}
		}
	}
	
	/* The min heap requires the object to implement comparable. According
	 * to the algorithm, we need to add BinaryNode into the min heap. However,
	 * BinaryNodes are not comparable, so we need a new type of object that
	 * can be used to represent a BinaryNode that implements Comparable.
	 * In this situation, our BinaryNode will be used to store a character.
	 * To compare, we compare the frequency of the character. 
	 */
	private class BinaryNodeFrequency<T> implements Comparable<BinaryNodeFrequency<T>>
	{
		private BinaryNodeInterface<T> node;
		private int frequency;
		
		private BinaryNodeFrequency(BinaryNodeInterface<T> aNode, int aFrequency)
		{
			node = aNode;
			frequency = aFrequency;
		}
		
		public int compareTo(BinaryNodeFrequency<T> otherBNF)
		{
			if(frequency < otherBNF.frequency)
			{
				return -1;
			}
			else if(frequency > otherBNF.frequency)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
}
