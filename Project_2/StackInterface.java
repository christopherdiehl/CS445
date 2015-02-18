
public interface StackInterface<T>
{
	public void push(T anEntry);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public void clear();
}
