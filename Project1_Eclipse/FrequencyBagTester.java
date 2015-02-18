import java.util.Random;
import java.util.Scanner;

public class FrequencyBagTester
{
	public static void main(String[] args)
	{
		int numberOfData = 20;
		int maxValueEx = 5;
		boolean wrongFrequency = false;
		int failed = 0;
		Scanner in = new Scanner(System.in);
		int option = 0;
		
		while(option == 0)
		{
			System.out.println("Please select a test option");
			System.out.println("  1. Stop the test as soon as an error is detected");
			System.out.println("  2. Do not stop the test when an error is detected");
			System.out.print("Enter an option (1 or 2): ");
			option = in.nextInt();
			
			if(option != 1 && option != 2)
			{
				System.out.println(option + " is not a valid choice.\n");
				option = 0;
			}
		}
		
		in.close();
		
		FrequencyBag<Integer> fb = new FrequencyBag<Integer>();
		
		// getFrequencyOf() empty bag
		
		System.out.print("Checking the method getFrequencyOf() of an empty frequency bag: ");
		for(int i = 0; i < maxValueEx; i++)
		{
			if(fb.getFrequencyOf(i) != 0)
			{
				if(!wrongFrequency)
				{
					System.out.println("FAIL");
					failed++;
				}
				System.out.println("The method getFrequencyOf(" + i + ") of an empty bag should return 0.");
				System.out.println("But your method getFrequencyOf(" + i + ") returns " + fb.getFrequencyOf(i) + ".");
				wrongFrequency = true;
			}
		}
		
		if(!wrongFrequency)
		{
			System.out.println("PASS");
		}
		else if(option == 1)
		{
			return;
		}
		
		
		// size() of empty bag.
		
		System.out.print("Checking the method size() of an empty bag: ");
		if(fb.size() != 0)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("The size of an empty bag should be 0.");
			System.out.println("But your method size() returns " + fb.size() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// getMaxFrequency() of empty bag
		
		System.out.print("Checking the method getMaxFrequency() of an empty frequency bag: ");
		if(fb.getMaxFrequency() != 0)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("The method getMaxFrequency() of an empty bag should return 0.");
			System.out.println("But your method getMaxFrequency() returns " + fb.getMaxFrequency() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS\n");
		}
		
		// Adding data into empty bag
		
		int dataSet[] = new int[5];
		
		for(int i = 0; i < maxValueEx; i++)
		{
			dataSet[i] = 0;
		}
		
		Random rand = new Random();
		
		System.out.println("Add the following data into your frequency bag (in that order):");
		
		for(int i = 0; i < numberOfData; i++)
		{
			int temp = rand.nextInt(maxValueEx);
			
			System.out.print(temp + " ");
			fb.add(temp);
			dataSet[temp]++;
		}
		System.out.println();
		
		// getFrequencyOf()
		
		System.out.println("Checking the method getFrequencyOf() of each data in this frequency bag: ");
		
		for(int i = 0; i < maxValueEx; i++)
		{
			System.out.print("Frequency of " + i + ": ");
			if(fb.getFrequencyOf(i) != dataSet[i])
			{
				failed++;
				System.out.println("FAIL");
				System.out.println("The frequency of " + i + " is " + dataSet[i] + ".");
				System.out.println("But the method getFrequencyOf(" + i + ") returns " + fb.getFrequencyOf(i) + ".\n");
				if(option == 1)
				{
					return;
				}
			}
			else
			{
				System.out.println("PASS");
			}
		}

		// getFrequencyOf()
		
		System.out.print("Checking the method getFrequencyOf() of a data that is not in this frequency bag: ");
		
		if(fb.getFrequencyOf(-1) != 0)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("The frequency of -1 is 0.");
			System.out.println("But the method getFrequencyOf(-1) returns " + fb.getFrequencyOf(-1) + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// getProbabilityOf()
		
		System.out.println("Checking the method getProbabilityOf() of each data in this frequency bag: ");
		
		for(int i = 0; i < maxValueEx; i++)
		{
			System.out.print("Probability of " + i + ": ");
			if(Math.abs(fb.getProbabilityOf(i) - ((double) dataSet[i]/numberOfData)) > 0.000001)
			{
				failed++;
				System.out.println("FAIL");
				System.out.println("The probability of " + i + " is " + ((double) dataSet[i]/numberOfData) + ".");
				System.out.println("But the method getProbabilityOf(" + i + ") returns " + fb.getProbabilityOf(i) + ".\n");
				if(option == 1)
				{
					return;
				}
			}
			else
			{
				System.out.println("PASS");
			}
		}
		
		// getProbabilityOf()
		
		System.out.print("Checking the method getProbabilityOf() of a data that is not in this frequency bag: ");
		
		if(fb.getProbabilityOf(-1) != 0.0)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("The probability of -1 is 0.");
			System.out.println("But the method getProbabilityOf(-1) returns " + fb.getProbabilityOf(-1) + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// size()

		System.out.print("Checking the method size() of this non-empty frequency bag: ");
		if(fb.size() != numberOfData)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("After adding " + numberOfData + " entries, the method size() should return " + numberOfData + ".");
			System.out.println("But your method size() returns " + fb.size() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// getMaxFrequency()
		
		System.out.print("Checking the method getMaxFrequency() of this non-empty frequency bag: ");
		
		int tempMax = 0;
		
		for(int i = 0; i < maxValueEx; i++)
		{
			if(tempMax < dataSet[i])
			{
				tempMax = dataSet[i];
			}
		}
		
		if(fb.getMaxFrequency() != tempMax)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("The method getMaxFrequency() of this non-empty frequency bag should return " + tempMax + ".");
			System.out.println("But your method getMaxFrequency() of this non-empty frequency bag returns " + fb.getMaxFrequency() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS\n");
		}
		
		// clear();
		
		fb.clear();
		
		System.out.println("Checking the method clear()");
		System.out.print("Checking the method size() after clear(): ");
		if(fb.size() != 0)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("After the bag is cleared, the method size() should return 0.");
			System.out.println("But your method size() returns " + fb.size() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// getFrequencyOf() after clear()
		
		System.out.print("Checking the method getFrequencyOf(3) after clear(): ");
		if(fb.getFrequencyOf(3) != 0)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("After the bag is cleared, the method getFrequencyOf(3) should return 0.");
			System.out.println("But your method getFrequencyOf(3) returns " + fb.getFrequencyOf(3) + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// getMaxFrequency() after clear()
		
		System.out.print("Checking the method getMaxFrequency() after clear(): ");
		if(fb.getMaxFrequency() != 0)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("After the bag is cleared, the method getMaxFrequency() should return 0.");
			System.out.println("But your method getMaxFrequency() returns " + fb.getMaxFrequency() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Generate large bag
		
		numberOfData = 1000000;
		maxValueEx = 1000;
		
		dataSet = new int[maxValueEx];
		
		for(int i = 0; i < maxValueEx; i++)
		{
			dataSet[i] = 0;
		}
		
		System.out.println("\nSo far so good.");
		System.out.println("Let's try adding " + numberOfData + " data into your frequency bag.");
		
		for(int i = 0; i < numberOfData; i++)
		{
			int temp = rand.nextInt(maxValueEx);
			
			fb.add(temp);
			dataSet[temp]++;
		}

		// size() of large bag.
		
		System.out.print("Checking the method size() of this non-empty frequency bag: ");
		if(fb.size() != numberOfData)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("After adding " + numberOfData + " entries, the method size() should return " + numberOfData + ".");
			System.out.println("But your method size() returns " + fb.size() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// getFrequencyOf() of large bag
		
		System.out.print("Checking the method getFrequencyOf() of each data in this frequency bag: ");

		wrongFrequency = false;
		
		for(int i = 0; i < maxValueEx; i++)
		{
			if(fb.getFrequencyOf(i) != dataSet[i])
			{
				wrongFrequency = true;
			}
		}

		if(wrongFrequency)
		{
			failed++;
			System.out.println("FAIL");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// getProbabilityOf() of large bag
		
		System.out.print("Checking the method getProbabilityOf() of each data in this frequency bag: ");

		boolean wrongProbability = false;
		
		for(int i = 0; i < maxValueEx; i++)
		{
			if(Math.abs(fb.getProbabilityOf(i) - ((double) dataSet[i]/numberOfData)) > 0.000001)
			{
				wrongProbability = true;
			}
		}

		if(wrongProbability)
		{
			failed++;
			System.out.println("FAIL");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// getMaxFrequency() of large bag
		
		System.out.print("Checking the method getMaxFrequency() of this non-empty frequency bag: ");
		
		tempMax = 0;
		
		for(int i = 0; i < maxValueEx; i++)
		{
			if(tempMax < dataSet[i])
			{
				tempMax = dataSet[i];
			}
		}
		
		if(fb.getMaxFrequency() != tempMax)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("The method getMaxFrequency() of this non-empty frequency bag should return " + tempMax + ".");
			System.out.println("But your method getMaxFrequency() of this non-empty frequency bag returns " + fb.getMaxFrequency() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// Frequency Bag of String
		
		System.out.println("\nSo far so good.");
		System.out.println("Let's construct a frequency bag of String.");
		
		FrequencyBag<String> sfb = new FrequencyBag<String>();
		
		String s = "hello how are you i am find thank you and you i am fine thank you";
		String[] str = s.split(" ");
		
		for(int i = 0; i < str.length; i++)
		{
			sfb.add(str[i]);
		}
		
		System.out.println("Adding the following strings into an empty frequency bag:");
		System.out.println(s + "\n");
		
		System.out.print("Checking the method size() of this non-empty frequency bag: ");
		if(sfb.size() != 16)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("After adding 16 entries, the method size() should return 16.");
			System.out.println("But your method size() returns " + sfb.size() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Checking the method getFrequencyOf(\"am\"): ");
		if(sfb.getFrequencyOf("am") != 2)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("There are two strings \"am\" added into this bag.");
			System.out.println("But your method getFrequencyOf(\"am\") returns " + sfb.getFrequencyOf("am") + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Checking the method getMaxFrequency(): ");
		if(sfb.getMaxFrequency() != 4)
		{
			failed++;
			System.out.println("FAIL");
			System.out.println("The maximum frequency should be 4 (the string \"you\").");
			System.out.println("But your method getMaxFrequency() returns " + sfb.getMaxFrequency() + ".\n");
			if(option == 1)
			{
				return;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.println();
		
		if(failed != 0)
		{
			System.out.println("Threre are " + failed + " in this test. Fix your program.");
		}
		else
		{
			System.out.println("Congratulation!!! Your FrequencyBag works perfectly (I hope).");
			System.out.println("Run the program FrequencyFrame and compare its result.");
		}
	}
}
