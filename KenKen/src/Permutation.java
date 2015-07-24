import java.util.ArrayList;


public class Permutation
{
	
	public static ArrayList<ArrayList<Integer>> permutation(final ArrayList<Integer> list)
	{
		if(list.size()==1){
			ArrayList<ArrayList<Integer>> baseList= new ArrayList<ArrayList<Integer>> ();
			baseList.add( (list));
			return  baseList;
		}

			ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>> ();
			ArrayList<Integer> copyList = new ArrayList<Integer>(list);
			int firstEntry = copyList.remove(0);
			ArrayList<ArrayList<Integer>> returnedList = permutation(copyList);
			for(ArrayList<Integer> al : returnedList){
				
					for (int i = 0; i <= al.size(); i++){
						ArrayList<Integer> tempArray = new ArrayList<Integer>(al);
						tempArray.add(i, firstEntry);
						returnList.add(tempArray);
					}
			}
			
		return returnList;		
	}
}	
	//make a method to store the entries

	//make a method to sort the arrayList
	