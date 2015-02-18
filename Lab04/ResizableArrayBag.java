
public class ResizableArrayBag <T>
{

	private int numberOfEntries;
	private T [] array;
	
	public ResizableArrayBag(){
		numberOfEntries=0;
	}
	public boolean isFull(){
		return false;
	}
		public int getCurrentSize(){
		return numberOfEntries;
	}
 	public void clear(){
		numberOfEntries=0;
	}
	public boolean add (T anEntry){
	  if (numberOfEntries==0){
		  @SuppressWarnings("unchecked")
		 [T] array = [T] [10];
		  array[0]= anEntry;
	  }
	}
	

}
