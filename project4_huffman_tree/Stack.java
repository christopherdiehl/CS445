
public class Stack <T> {
	private Node firstNode;
	
	public Stack(){
		firstNode = null;
	}
	public void push(T anEntry){
		Node tempNode = new Node(anEntry, firstNode);
		firstNode = tempNode;
	}
	public T pop(){
		T result = null;
		if(firstNode != null){
			result = firstNode.data;
			firstNode = firstNode.next;
		}
		return result;
	}
	
	public T peek(){
		return firstNode.data;
	}
	
	public boolean isEmpty(){
		return firstNode == null;
	}
	
	public void clear(){
		firstNode = null;
	}
	
private class Node{
	private T data;
	private Node next;
	private Node(T aData){
		this(aData,null);
	}
	private Node(T aData, Node nextNode){
		data = aData;
		next = nextNode;
	}
	
	}
}