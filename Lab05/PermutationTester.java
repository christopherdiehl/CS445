import java.util.ArrayList;


public class PermutationTester
{
	public static void main(String[] args)
	{
		int point = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result;
		
		for(int i = 1; i <= 5; i++)
		{
			System.out.println("Testing permutation with " + i + " element(s)");
			list.add(i);
		
			result = Permutation.permutation(list);
			
			System.out.println("Your code said, the permutation of " + list + " is as follows:");
			System.out.println(result);
			
			boolean result1 = checkPermutationSize(list, result);
			boolean result2 = checkPermutation(list, result);
			if(result1 && result2)
			{
				point += 2;
				System.out.println("Your current point is " + point + ".");
				System.out.println();
			}
			else
			{
				System.out.println("Your current point is " + point + ".");
				System.out.println("There is someting wrong with your method permutation().");
				System.out.println("Fix your code and run this tester class again.");
				break;
			}
		}
	}
	
	private static int factorial(int n)
	{
		if(n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}
	
	private static boolean checkPermutation(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result)
	{
		int numberOfElements = list.size();
		int numberOfResults = result.size();
		
		System.out.print("Check the size of each element: ");
		for(int i = 0; i < numberOfResults; i++)
		{
			if(result.get(i).size() != list.size())
			{
				System.out.println("FAIL");
				System.out.println("Every element in your result should contains " + numberOfElements + " elements.");
				System.out.println("But an element of your result contains " + result.get(i).size() + " elements.");
				return false;
			}
		}
		
		System.out.println("PASS");
		
		System.out.print("Check for duplicate elements: ");
		
		for(int i = 0; i < numberOfResults; i++)
		{
			ArrayList<Integer> temp = result.get(i);
			
			for(int j = i + 1; j < numberOfResults; j++)
			{
				if(temp.equals(result.get(j)))
				{
					System.out.println("FAIL");
					System.out.println("Your result contains duplicate items which is " + temp + ".");
					return false;
				}
			}
		}
		
		System.out.println("PASS");

		System.out.print("Check each element: ");
		for(int i = 0; i < numberOfResults; i++)
		{
			ArrayList<Integer> temp = result.get(i);
			
			for(int j = 0; j < numberOfElements; j++)
			{
				int aNumber = list.get(j);
				
				if(!temp.contains(aNumber))
				{
					System.out.println("FAIL");
					System.out.println("The element " + temp + " in your result does not contain every element in " + list + ".");
				}
			}
		}
		
		System.out.println("PASS");
		
		return true;
	}
	
	private static boolean checkPermutationSize(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result)
	{
		System.out.print("Check the size of the result: ");
		
		int numberOfElements = list.size();
		int numberOfResults = result.size();
		
		if(factorial(numberOfElements) != numberOfResults)
		{
			System.out.println("FAIL");
			System.out.println("   The list " + list + " contains " + numberOfElements + " elements.");
			System.out.println("   Permutation of " + list + " should contains " + factorial(numberOfElements) + "elements.");
			System.out.println("   But your result contains " + numberOfResults + " elements.");
			return false;
		}
		else
		{
			System.out.println("PASS");
			return true;
		}
	}
}