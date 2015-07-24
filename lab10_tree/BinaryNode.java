
public class BinaryNode<T> implements BinaryNodeInterface<T>
{
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild)
	{
		data = dataPortion;
		left = leftChild;
		right = rightChild;
	}
	
	public BinaryNode(T dataPortion)
	{
		this(dataPortion, null, null);
	}
	
	public BinaryNode()
	{
		this(null);
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public BinaryNodeInterface<T> getLeftChild()
	{
		return left;
	}
	
	public BinaryNodeInterface<T> getRightChild()
	{
		return right;
	}
	
	public void setLeftChild(BinaryNodeInterface<T> leftChild)
	{
		left = (BinaryNode<T>) leftChild;
	}
	
	public void setRightChild(BinaryNodeInterface<T> rightChild)
	{
		right = (BinaryNode<T>) rightChild;
	}
	
	public boolean hasLeftChild()
	{
		return left != null;
	}
	
	public boolean hasRightChild()
	{
		return right != null;
	}
	
	public boolean isLeaf()
	{
		return left == null && right == null;
	}
	
	public int getNumberOfNodes()
	{
		int leftNumber = 0;
		int rightNumber = 0;
		
		if(left != null)
			leftNumber = left.getNumberOfNodes();
		
		if(right != null)
			rightNumber = right.getNumberOfNodes();
		
		return 1 + leftNumber + rightNumber;
	}
	
	public int getHeight()
	{
		return getHeight(this);
	}
	
	private int getHeight(BinaryNode<T> node)
	{
		int height = 0;
		
		if(node != null)
		{
			height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		}
		
		return height;
	}
}
