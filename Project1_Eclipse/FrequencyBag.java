//Implement using a linked list
public class FrequencyBag<T>
{
	// TO DO: Instance Variables
	private Node firstNode;
	private int numOfItems;
	
	private class Node{
	//Node Instance Variables
		
		private T data;
		private int frequency;
		private Node next;
		
		private Node(T Data, Node nextNode){
			data= Data;
			next=nextNode;
			frequency=1;
		}
		 
		private void addF(){
			frequency++;
		}
		
		private int getF(){
			return frequency;
		}
		
	}
	
	
	/**
	 * Constructor
	 * Constructs an empty frequency bag.
	 */
	public FrequencyBag()
	{
	 firstNode=null;
	 numOfItems =0;
	}
	
	/**
	 * Adds new entry into this frequency bag.
	 * @param aData the data to be added into this frequency bag.
	 */
	public void add(T aData)
	{

	  boolean found =false;
	  Node currNode=firstNode;
	 
	  while(currNode !=null){
		  if(currNode.data.equals(aData)){
			  currNode.addF();
			  found=true;
			  break;
		  }
	   
		  currNode= currNode.next;
	  }
	  
	  if(!found){
		  Node tempNode=firstNode;
		  firstNode= new Node(aData,tempNode);
	 
	  }
	  numOfItems++; 
	  
	  }
	/**
	 * Gets the number of occurrences of aData in this frequency bag.
	 * @param aData the data to be checked for its number of occurrences.
	 * @return the number of occurrences of aData in this frequency bag.
	 */
	public int getFrequencyOf(T aData)
	{
		Node currNode= firstNode;
		while(currNode!=null){
			if(currNode.data.equals(aData)){
				return currNode.getF();
			}
		 currNode= currNode.next;
		}
		
		return 0;
	}

	/**
	 * Gets the maximum number of occurrences in this frequency bag.
	 * @return the maximum number of occurrences of an entry in this
	 * frequency bag.
	 */
	public int getMaxFrequency()
	{
		if(firstNode!=null){
		Node currNode= firstNode;
		Node maxNode= firstNode;
		while(currNode!=null){
			if(currNode.getF()>=maxNode.getF()){
				maxNode=currNode;
			}
			currNode=currNode.next;
		}
		return maxNode.getF();
		}
		else{
			return 0;
		}
	}
	
	/**
	 * Gets the probability of aData
	 * @param aData the specific data to get its probability.
	 * @return the probability of aData
	 */
	public double getProbabilityOf(T aData)
	{
	  if(firstNode!=null){
		boolean flag=true;
		double dataF=0;
		double prob=0;
		Node currNode= firstNode;
		while(currNode!=null){
			if(currNode.data.equals(aData)){
				 dataF=(double)currNode.getF();
				 flag=false;
				 break;
			}
		 currNode= currNode.next;
		}	
		if(!flag){
		  prob= dataF/(double)numOfItems;
		}
		return prob;
	  }
	  else{
		  return 0;
	  }
	}

	/**
	 * Empty this bag.
	 */
	public void clear()
	{
		firstNode=null;
	    numOfItems=0;
	}
	
	/**
	 * Gets the number of entries in this bag.
	 * @return the number of entries in this bag.
	 */
	public int size()
	{
		return numOfItems;
	}
	

}
