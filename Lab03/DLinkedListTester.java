import java.util.Random;

public class DLinkedListTester
{
	public static void main(String[] args)
	{
		// Construct a list and add entries
		
		int numberOfData = 100000;	// number of data to add to the list
		int maxDataValue = 10000;	// number of different values to add to the list
		int numSampling = 10000;	// number of calling the method getEntry
		int dryRunReps = numSampling / 1000;
		
		DLinkedList<Integer> list = new DLinkedList<Integer>();
		
		Random rand = new Random();
		rand.setSeed(System.nanoTime());
		
		System.out.print("Adding data into the list: ");
		
		for(int i = 0; i < numberOfData; i++)
		{
			list.add(rand.nextInt(maxDataValue));
		}
		
		System.out.println("DONE");
		
		int[] positions = new int[numSampling];
		int[] returnValues = new int[numSampling];

		System.out.print("Dry run for the method getEntry(): ");
		
		// Dry run for the method getEntry1 (no timer)
		// Also store all result for testing the method getEntry2()
		
		for(int i = 0; i < numSampling; i++)
		{
			int aPosition = rand.nextInt(numberOfData) + 1;
			positions[i] = aPosition;
			returnValues[i] = list.getEntry(aPosition);
		}
		
		System.out.println("DONE");
		
		double startTime;	// Start time millisecond
		double endTime;		// End time millisecond

		System.out.print("Time the method getEntry(): ");
		
		// Timing the method getEntry()
		
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < numSampling; i++)
		{
			if(returnValues[i] != list.getEntry(positions[i]))
			{
				System.out.println("There is something wrong.");
				System.out.println("The entry in position " + positions[i] + " should be " + returnValues[i] + ".");
				System.out.println("But the method getEntry(" + positions[i] + ") returns " + list.getEntry(positions[i]) + ".");
				System.out.println("Fix the method getNodeAt() first.");
				return;
			}
		}
		
		endTime = System.currentTimeMillis();
		
		double getEntryTime = endTime - startTime;
		
		System.out.println("DONE");

		// getEntry1() - Solution 1

		// Dry run (no timer)

		System.out.print("Dry run for the method getEntry1(): ");
		
		for(int i = 0; i < dryRunReps; i++)
		{
			if(returnValues[i] != list.getEntry1(positions[i]))
			{
				System.out.println("There is something wrong.");
				System.out.println("The entry in position " + positions[i] + " should be " + returnValues[i] + ".");
				System.out.println("But the method getEntry1(" + positions[i] + ") returns " + list.getEntry1(positions[i]) + ".");
				System.out.println("Fix the method getNodeAt1() first.");
				return;
			}
		}

		System.out.println("DONE");
		
		// Timing the method getEntry1()
		
		System.out.print("Time the method getEntry1(): ");
		
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < numSampling; i++)
		{
			if(returnValues[i] != list.getEntry1(positions[i]))
			{
				System.out.println("There is something wrong.");
				System.out.println("The entry in position " + positions[i] + " should be " + returnValues[i] + ".");
				System.out.println("But the method getEntry1(" + positions[i] + ") returns " + list.getEntry1(positions[i]) + ".");
				System.out.println("Fix the method getNodeAt1() first.");
				return;
			}
		}
		
		endTime = System.currentTimeMillis();
		
		double getEntry1Time = endTime - startTime;
		
		System.out.println("DONE");
	
		// getEntry2() - Solution 2

		// Dry run (no timer)

		System.out.print("Dry run for the method getEntry2(): ");
		
		for(int i = 0; i < dryRunReps; i++)
		{
			if(returnValues[i] != list.getEntry2(positions[i]))
			{
				System.out.println("There is something wrong.");
				System.out.println("The entry in position " + positions[i] + " should be " + returnValues[i] + ".");
				System.out.println("But the method getEntry2(" + positions[i] + ") returns " + list.getEntry2(positions[i]) + ".");
				System.out.println("Fix the method getNodeAt2() first.");
				return;
			}
		}

		System.out.println("DONE");
		
		// Timing the method getEntry2()
		
		System.out.print("Time the method getEntry2(): ");
		
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < numSampling; i++)
		{
			if(returnValues[i] != list.getEntry2(positions[i]))
			{
				System.out.println("There is something wrong.");
				System.out.println("The entry in position " + positions[i] + " should be " + returnValues[i] + ".");
				System.out.println("But the method getEntry2(" + positions[i] + ") returns " + list.getEntry2(positions[i]) + ".");
				System.out.println("Fix the method getNodeAt2() first.");
				return;
			}
		}
		
		endTime = System.currentTimeMillis();
		
		double getEntry2Time = endTime - startTime;
		
		System.out.println("Done\n");
		
		
		System.out.println("The method getEntry() took " + getEntryTime + " millisecond.");
		System.out.println("The method getEntry1() took " + getEntry1Time + " millisecond.");
		System.out.println("The method getEntry2() took " + getEntry2Time + " millisecond.\n");
		
		System.out.println("If getEntry1() took roughly about half the time of getEntry(), you get 5 points.");
		System.out.println("If getEntry2() took roughly about a quarter the time of getEntry(), you get 5 points.");
	}
}
