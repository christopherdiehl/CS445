
public class LInfiniteInteger implements InfiniteIntegerInterface
{
	private Node firstNode;
	private Node lastNode;
	private int numberOfDigits;
	private boolean isNegative;
	
	/**
	 * Constructor: Constructs this infinite integer from a string
	 * representing an integer.
	 * @param s  a string represents an integer
	 */
	public LInfiniteInteger(String s)
	{
		LInfiniteCreator (s);
		firstNode= null;

	}

	/**
	 * Constructor: Constructs this infinite integer from an integer.
	 * @param anInteger  an integer
	 */
	public LInfiniteInteger(int anInteger)
	{

		Integer temp= (Integer) anInteger;
		String str= temp.toString();
		LInfiniteCreator(str);
		firstNode= null;
		
	}
	/**
	 * Method called by "constructors" to actually initialize object
	 * 
	 * @param aString
	 */
	
	private void LInfiniteCreator (String aString){
		int digit;
		int placer=0;
		if(checkNegative(aString)==true)
			placer=1;
		 for (int i =placer; i < aString.length(); i++){
   		  digit=Character.getNumericValue(aString.charAt(i));
   		  
		     if (firstNode==null){
		    	 firstNode= new Node(null,digit,null);
		    	 lastNode= firstNode;
				 numberOfDigits++;
		     }
		     else{
		    	Node tempNode= new Node(null, digit, firstNode);
		    	firstNode = tempNode;
				numberOfDigits++;

		     }
		}

		 leadingZeros();
	}
	
	/**
	 * checks to see if value entered is negative
	 */
	
	private boolean checkNegative(String aString){
		if(aString.startsWith("-")){
			isNegative=true;
			return true;
		}
		else 
			return false;
			
	}
	/***
	 * gets rid of leading zeros if there are any
	 */
	
	private void leadingZeros(){

		while(true){
			if(firstNode.next == null && firstNode.data ==0)
				break;
			else if(firstNode.data == 0){
				firstNode=firstNode.next;
				numberOfDigits--;
			}
			else{
				break;
			}
		}
		
		
	}
	/**
	 * Gets the number of digits of this infinite integer.
	 * @return an integer representing the number of digits
	 * of this infinite integer.
	 */
	public int getNumberOfDigits()
	{
		return numberOfDigits;
	}

	/**
	 * Checks whether this infinite integer is a negative number.
	 * @return true if this infinite integer is a negative number.
	 * Otherwise, return false.
	 */
	public boolean isNegative()
	{
		return isNegative;
	}

	/**
	 * Calculates the result of this infinite integer plus anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to be added to this
	 * infinite integer.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer plus anInfiniteInteger
	 */
	public InfiniteIntegerInterface plus(final InfiniteIntegerInterface anInfiniteInteger)
	{		
		// TO DO
		return anInfiniteInteger;
	}

	/**
	 * Calculates the result of this infinite integer subtracted by anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to subtract.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer subtracted by anInfiniteInteger
	 */
	public InfiniteIntegerInterface minus(final InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
		return anInfiniteInteger;
	}
	
	/**
	 * Generates a string representing this infinite integer. If this infinite integer
	 * is a negative number a minus symbol should be in the front of numbers. For example,
	 * "-12345678901234567890". But if the infinite integer is a positive number, no symbol
	 * should be in the front of the numbers (e.g., "12345678901234567890").
	 * @return a string representing this infinite integer number.
	 */
	public String toString()
	{
		StringBuilder sb= new StringBuilder ();
		if(this.isNegative)
			sb.append("-");
		
		Node currNode = firstNode;
		
		while(currNode!=null){
			Integer tempI = (Integer) currNode.data;
			sb.append(tempI.toString()) ;
			currNode = currNode.next;			
			
		}
		
		return sb.toString();
		
	}
	
	/**
	 * Compares this infinite integer with anInfiniteInteger
	 * @return either -1, 0, or 1 as follows:
	 * If this infinite integer is less than anInfiniteInteger, return -1.
	 * If this infinite integer is equal to anInfiniteInteger, return 0.
	 * If this infinite integer is greater than anInfiniteInteger, return 1.
	 */
	public int compareTo(InfiniteIntegerInterface anInfiniteInteger)
	{	
		
		int variableNumberOfDigits =anInfiniteInteger.getNumberOfDigits();
		
		if(variableNumberOfDigits > numberOfDigits)
			return -1;
		else if( numberOfDigits > variableNumberOfDigits)
			return 1;
		
		int midP= numberOfDigits/2;
		
		for(int i=numberOfDigits; i < numberOfDigits; i++){
			getFrontValue(i, midP);
			
			if(getFrontValue(i, midP) >  ((LInfiniteInteger) anInfiniteInteger).getFrontValue(i,midP))
				return 1;
			
			
			if(((LInfiniteInteger) anInfiniteInteger).getFrontValue(i, midP) > getFrontValue(i, midP))
				return -1;
			
		}
		return 0;
	}

	/**
	 * Function that returns the rear most value in the class. 
	 * for example 369. if i= 0. return 9. i=1 returns 6 ....
	 * @param i
	 * @param middP
	 * @return
	 */
	
	public int getBackValue (int i, int middP){
		Node currNode=lastNode;
		int nodeIndex=0;
		
		if(i > middP){
			if(i==0)
				return currNode.data;
			else {
				while (i != nodeIndex)
					currNode = currNode.previous;
				return currNode.data;
			}
		}
		else {
			currNode = firstNode;
			while( nodeIndex != i)
				currNode = currNode.next;
			return currNode.data;
		}
	}
	
	/**
	 * function to return the data of the first node or most significant
	 * can be used with a for loop for easy retrieval of entire linked list
	 * @param i
	 * @return
	 */
	public int getFrontValue(int i, int middP){
		Node currNode= firstNode;
		int nodeIndex=0;
		if(i < middP){ 
			if(i==0)
				return currNode.data;
			else {
				while(nodeIndex != i)
			    currNode= currNode.next;
				
				return currNode.data;
			}
		}
		
		else{
			currNode = lastNode;
			while(i != nodeIndex)
				currNode = currNode.previous;
			
			return currNode.data;
		}
			
		
	}
	/**
	 * Calculates the result of this infinite integer multiplied by anInfiniteInteger
	 * @param anInfiniteInteger the multiplier.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer multiplied by anInfiniteInteger.
	 */
	public InfiniteIntegerInterface multiply(final InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
		return anInfiniteInteger;
	}
	
	private class Node
	{
		private int data; 
		private Node next;
		private Node previous;
		
		private Node(Node previousNode, int aData, Node nextNode)
		{
			previous = previousNode;
			data = aData;
			next = nextNode;
		}
		
		private Node(int aData)
		{
			this(null, aData, null);
		}
	}
}
