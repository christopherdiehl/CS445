import java.util.Random;


public class RecursionLLTester
{
	public static void main(String[] args)
	{
		RecursionLinkedList rll = new RecursionLinkedList();
		int point = 0;
		boolean isError = false;
		
		System.out.println("Create an empty RecursionLinkedList named rll.");
		
		System.out.print("Test the method contains() on an empty RecursionLinkedList: ");
		if(rll.contains(5) != false)
		{
			System.out.println("FAIL");
			System.out.println("Nothing is added into RecursionLinkedList rll.");
			System.out.println("rll.contains(5) should return 0.");
			System.out.println("But your rll.contains(5) returns " + rll.contains(5) + ".");
		}
		else
		{
			System.out.println("PASS");
			point++;
		}

		System.out.print("Test the method getFrequencyOf() on an empty RecursionLinkedList: ");
		if(rll.getFrequencyOf(5) != 0)
		{
			System.out.println("FAIL");
			System.out.println("Nothing is added into RecursionLinkedList rll.");
			System.out.println("rll.getFrequencyOf(5) should return 0.");
			System.out.println("But your rll.getFrequencyOf(5) returns " + rll.getFrequencyOf(5) + ".");
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		
		Random rand = new Random();
		int num = 20;
		int[] array = new int[5];
		for(int i = 0; i < 5; i++)
		{
			array[i] = 0;
		}
		
		System.out.println("Add the following integer into rll:");
		String s = "]";
		
		for(int i = 0; i < num  - 1; i++)
		{
			int temp = rand.nextInt(5);
			System.out.print(temp + " ");
			s = "," + temp + s;
			array[temp]++;
			rll.add(temp);
		}
		int temp = rand.nextInt(5);
		System.out.println(temp);
		s = "[" + temp + s;
		array[temp]++;
		rll.add(temp);
		
		
		System.out.println("\nTest the method contains() on a non-empty RecursionLinkedList");
		System.out.print("  - Test rll.contains(-1): ");
		if(rll.contains(-1) != false)
		{
			System.out.println("FAIL");
			System.out.println("No -1 has been added into the RecursionLinkedList rll.");
			System.out.println("rll.contains(-1) should return 0.");
			System.out.println("But your rll.contains(-1) returns " + rll.contains(-1));
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		
		for(int i = 0; i < 5; i++)
		{
			System.out.print("  - Test rll.contains(" + i + "): ");
			if(rll.contains(i) != (array[i] != 0))
			{
				System.out.println("FAIL");
				System.out.println("There are " + array[i] + " in RecursiveLinkedList rll.");
				System.out.println("rll.contains(" + i + ") should return " + (array[i] != 0));
				System.out.println("But your rll.contains(" + i + ") returns " + rll.contains(i));
				isError = true;
			}
			else
			{
				System.out.println("PASS");
			}
		}
		
		if(!isError)
		{
			point++;
			isError = false;
		}

		System.out.print("  - Test rll.contains(5): ");
		if(rll.contains(5) != false)
		{
			System.out.println("FAIL");
			System.out.println("No 5 has been added into the RecursionLinkedList rll.");
			System.out.println("rll.contains(5) should return 0.");
			System.out.println("But your rll.contains(5) returns " + rll.contains(5));
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		
		System.out.println("Test the method getFrequencyOf() on a non-empty RecursionLinkedList");
		System.out.print("  - Test rll.getFrequencyOf(-1): ");
		if(rll.getFrequencyOf(-1) != 0)
		{
			System.out.println("FAIL");
			System.out.println("No -1 has been added into the RecursionLinkedList rll.");
			System.out.println("rll.getFrequencyOf(-1) should return 0.");
			System.out.println("But your rll.getFrequencyOf(-1) returns " + rll.getFrequencyOf(-1));
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		
		for(int i = 0; i < 5; i++)
		{
			System.out.print("  - Test rll.getFrequencyOf(" + i + "): ");
			if(rll.getFrequencyOf(i) != array[i])
			{
				System.out.println("FAIL");
				System.out.println(i + " has been added to the RecursionLinkedList " + array[i] + " times.");
				System.out.println("rll.getFrequencyOf(" + i + ") should return " + array[i] + ".");
				System.out.println("But your rll.getFrequencyOf(" + i + ") returns " + rll.getFrequencyOf(i));
				isError = true;
			}
			else
			{
				System.out.println("PASS");
			}
		}
		
		if(!isError)
		{
			point++;
			isError = false;
		}

		System.out.print("  - Test rll.getFrequencyOf(5): ");
		if(rll.getFrequencyOf(5) != 0)
		{
			System.out.println("FAIL");
			System.out.println("No 5 has been added into the RecursionLinkedList rll.");
			System.out.println("rll.getFrequencyOf(5) should return 0.");
			System.out.println("But your rll.getFrequencyOf(5) returns " + rll.getFrequencyOf(5));
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		
		System.out.print("Test the method toString(): ");
		if(!s.equals(rll.toString()))
		{
			System.out.println("FAIL");
			System.out.println("rll.toString() should return the string \"" + s + "\".");
			System.out.println("But your rll.toString() returns the string \"" + rll.toString() + "\".");
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		
		
		System.out.println("Test the method getIndexOf()");
		System.out.println("Currently the rll is " + rll + ".");

		String[] str = rll.toString().split(",");
		str[0] = str[0].substring(1);
		str[str.length - 1] = str[str.length - 1].substring(0, 1);
		
		for(int i = -1; i <= 5; i++)
		{
			System.out.print("Test the method getIndexOf(" + i + "): ");
			if(getIndex(str,i) != rll.getIndexOf(i))
			{
				System.out.println("FAIL");
				System.out.println("The index of " + i + " should be " + getIndex(str,i) + ".");
				System.out.println("But your rll.getIndexOf(" + i + ") returns " + rll.getIndexOf(i) + ".");
				isError = true;
			}
			else
			{
				System.out.println("PASS");
			}
		}
		
		if(!isError)
		{
			point++;
			isError = false;
		}

		System.out.println("Your current point is " + point + ".");
	}
	
	public static int getIndex(String[] str, int s)
	{
		int result = -1;
				
		for(int i = 0; i < str.length; i++)
		{
			if(s == Integer.parseInt(str[i]))
			{
				return i;
			}
		}
		
		return result;
	}
}
