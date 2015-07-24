import java.util.Random;

public class SListIteratorTester
{
	public static void main(String[] args)
	{
		// Construct a list and add entries
		
		int numberOfData = 50000;	// number of data to add to the list
		int maxDataValue = 10;	// number of different values to add to the list
		int[] getEntryArray = new int[numberOfData];
		int[] iteratorArray = new int[numberOfData];
		
		SListIterator<Integer> list = new SListIterator<Integer>();
		
		Random rand = new Random();
		rand.setSeed(System.nanoTime());
		
		System.out.print("Adding data into the list: ");
		
		for(int i = 0; i < numberOfData; i++)
		{
			list.addToFirst(rand.nextInt(maxDataValue));
		}
		
		System.out.println("Done");

		System.out.print("Dry run for the method getEntry(): ");
		for(int i = 1; i <= 10; i++)
		{
			list.getEntry(i);
		}
		System.out.println("Done");
		
		
		double startTime;	// Start time millisecond
		double endTime;		// End time millisecond

		System.out.print("Time the method getEntry(): ");
		
		// Timing the method getEntry()
		
		startTime = System.currentTimeMillis();		
		
		for(int i = 1; i <= numberOfData; i++)
		{
			getEntryArray[i - 1] = list.getEntry(i);
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Done");
		double getEntryTime = endTime - startTime;
		
		System.out.print("Time the iterator: ");

		Iterator<Integer> iterator = list.getIterator();
		
		startTime = System.currentTimeMillis();
		
		int index = 0;
		
		while(iterator.hasNext())
		{
			iteratorArray[index] = iterator.next();
			index++;
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Done");
		double iteratorTime = endTime - startTime;

		for(int i = 0; i < numberOfData; i++)
		{
			if(getEntryArray[i] != iteratorArray[i])
			{
				System.out.println("Error at : " +i);
				System.out.println("There is something wrong with your iterator.");
			}
		}
		
		System.out.println("The method getEntry() took " + getEntryTime + " milliseconds.");
		System.out.println("Using iterator took " + iteratorTime + " milliseconds.");
	}
}