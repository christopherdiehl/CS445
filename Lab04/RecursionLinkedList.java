
public class RecursionLinkedList
{
	private Node firstNode;
	private Node tempNode;
	private int numberOfEntries;
	private int cf;
	private int index;
	public RecursionLinkedList()
	{	
		tempNode=firstNode;
		firstNode = null;
		numberOfEntries = 0;
		cf=0;
		index=0;

	}
	
	public void add(int aData)
	{
		if(numberOfEntries == 0)
		{
			firstNode = new Node(aData);
		}
		else
		{
			firstNode = new Node(aData, firstNode);

		}
		
		numberOfEntries++;
	}
	
	/**
	 * boolean contains(int aData)
	 * 
	 * See whether this RecursionLinkedList contains aData
	 * @param aData  a data to be located
	 * @return true if this RecursionLinkedList contains aData,
	 *         or false otherwise.
	 */
	public boolean contains(int aData)
	{
		
		if (tempNode==null){
			tempNode=firstNode;
			return false;
		}
		if (tempNode.data == aData){
			tempNode=firstNode;
			return true;
		}
		
		else{
			tempNode=tempNode.next;
			return contains(aData);
		}
		
		
	}
	
	/**
	 * int getFrequencyOf(int aData)
	 * 
	 * Counts the number of times a given data appears in this
	 * RecursionLinkedList.
	 * 
	 * @param aData  the data to be counted
	 * @return the number of times aData appears in this RecursionLinkedList
	 */
	public int getFrequencyOf(int aData)
	{
		if (tempNode==null){
			tempNode=firstNode;
			int temp=cf;
			cf=0;
			return temp;	
		}
		if (tempNode.data== aData){
			tempNode= tempNode.next;
			cf++;
			return getFrequencyOf(aData);
		}
		else{
			tempNode=tempNode.next;
			return getFrequencyOf(aData);
		}
		

	}
	
	/**
	 * String toString()
	 * 
	 * Return a string representation of this RecursionLinkedList. For example,
	 * if this RecursionLinkedList contains 1, 2, 3, 5, 2 and 3 from the first
	 * index to the last index, the returned string should be
	 * "[1,2,3,5,2,3]"
	 * @return the string representation of this RecursionLinkedList.
	 */
	public String toString()
	{
		StringBuilder sb= new StringBuilder();
		sb.append("[");
		sb.append(recursiveToString());
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();

	}
	
	private String recursiveToString(){
		if(tempNode==null){
			tempNode=firstNode;
			return "";
		}	
		else {
			int tempI= tempNode.data;
			tempNode= tempNode.next;
			return tempI+"," + recursiveToString();
			
		}
	}
	
	/**
	 * int getIndexOf(int aData)
	 * 
	 * Return the index of the first aData where the first index of
	 * the first item in this RecursionLinkedList is 0.
	 * 
	 * @param aData  the data to be located
	 * @return the index of the first aData.
	 */
	public int getIndexOf(int aData)
	{
		index=0;
		if(this.contains(aData)!=true)
			return -1;
		else
			return recursiveGetIndexOf(aData, firstNode);
		
	}
	
	private int recursiveGetIndexOf (int aData, Node temp)
	{
		Node tempNode= temp;
		if(tempNode==null)
			return 0;
		
		else if (tempNode.data == aData){

			return index;
		}
		
		else{
			tempNode=tempNode.next;
			index ++;
			return recursiveGetIndexOf(aData, tempNode);
		}
		
	}
		
	private class Node
	{
		private int data;
		private Node next;
		
		private Node(int aData, Node nextNode)
		{
			data = aData;
			next = nextNode;
		}
		
		private Node(int aData)
		{
			this(aData, null);
		}
	}
}
