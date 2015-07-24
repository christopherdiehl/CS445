
public interface BinaryNodeInterface<T>
{
	public T getData();
	public void setData(T newData);
	public BinaryNodeInterface<T> getLeftChild();
	public BinaryNodeInterface<T> getRightChild();
	public void setLeftChild(BinaryNodeInterface<T> leftChild);
	public void setRightChild(BinaryNodeInterface<T> rightChild);
	public boolean hasLeftChild();
	public boolean hasRightChild();
	public boolean isLeaf();
	public int getNumberOfNodes();
	public int getHeight();
}
