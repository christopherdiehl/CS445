
public class TowersTester
{
	public static void main(String[] args)
	{
		int numDiscs = 7;
		int point = 0;
		
		TowerOfHanoi t = new TowerOfHanoi(numDiscs);
		
		// Testing the method getNumberOfDiscs()
		
		System.out.println("Construct the Table of Hanoi puzzle with 7 disks using the following statement:");
		System.out.println("  TowerOfHanoi t = new TowerOfHanoi(7);");
		System.out.println("All test will be base on results of manipulating TowerOfHanoi t.\n");
		
		System.out.print("Testing the method getNumberOfDiscs(): ");
		
		if(t.getNumberOfDiscs() != numDiscs)
		{
			System.out.println("FAIL");
			System.out.println("The method getNumberOfDiscs() should return " + numDiscs + ".");
			System.out.println("But your method getNumberOfDiscs() returns " + t.getNumberOfDiscs() + ".\n");
		}
		else
		{
			point++;
			System.out.println("PASS");
		}
		System.out.println("Your current point is " + point + ".\n");
		
		// Testing initial puzzle
		
		System.out.println("Testing initial puzzle");

		int[][] tower0 = {{6,5,4,3,2,1,0},{},{}};
		
		int[] nd0 = {7,0,0};
		
		if(testPuzzle(t, nd0, tower0))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		
		System.out.println("Move top disc from tower 0 to tower 1");
		if(testMTD(t.moveTopDisc(0, 1), true, 0, 1))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		System.out.println("Testing the current puzzle");
		int[][] tower1 = {{6,5,4,3,2,1},{0},{}};
		int[] nd1 = {6,1,0};
		if(testPuzzle(t, nd1, tower1))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");

		// Move
		
		System.out.println("Move top disc from tower 0 to tower 2");
		if(testMTD(t.moveTopDisc(0, 2), true, 0, 2))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		System.out.println("Testing the current puzzle");
		int[][] tower2 = {{6,5,4,3,2},{0},{1}};
		int[] nd2 = {5,1,1};
		if(testPuzzle(t, nd2, tower2))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		
		// Move
		
		System.out.println("Move top disc from tower 1 to tower 2");
		if(testMTD(t.moveTopDisc(1, 2), true, 1, 2))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		System.out.println("Testing the current puzzle");
		int[][] tower3 = {{6,5,4,3,2},{},{1,0}};
		int[] nd3 = {5,0,2};
		if(testPuzzle(t, nd3, tower3))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		
		// Move (false)
		
		System.out.println("Move top disc from tower 0 to tower 2 (MUST RETURN FALSE)");
		if(testMTD(t.moveTopDisc(0, 2), false, 0, 2))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		System.out.println("Testing the current puzzle (MUST REMAIN UNCHANGED FROM PREVIOUS TEST)");
		if(testPuzzle(t, nd3, tower3))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		
	}

	private static boolean testMTD(boolean aResult, boolean eResult, int fromTower, int toTower)
	{
		System.out.print("Test return value of the method moveTopDisc(): ");
		if(aResult != eResult)
		{
			System.out.println("FAIL");
			System.out.println("t.moveTopDisc(" + fromTower + "," + toTower + ") should return " + eResult + ".");
			System.out.println("But your method moveTopDisc(" + fromTower + "," + toTower + ") return " + aResult + ".");
		}
		else
		{
			System.out.println("PASS");
		}
		
		return aResult == eResult;
	}
	
	private static boolean testPuzzle(TowerOfHanoi t, int[] numDiscs, int[][] tower)
	{
		boolean result = true;
		
		for(int i = 0; i < 3; i++)
		{
			System.out.print("Testing the method getNumberOfDiscs(" + i + "): ");
			
			if(t.getNumberOfDiscs(i) != numDiscs[i])
			{
				System.out.println("FAIL");
				System.out.println("The method getNumberOfDiscs(" + i + ") should return " + numDiscs[i] + ".");
				System.out.println("But your method getNumberOfDiscs(" + i + ") returns " + t.getNumberOfDiscs(i) + ".\n");
				result = false;
			}
			else
			{
				System.out.println("PASS");
			}

			// Testing the method getArrayOfDiscs(0)
			
			System.out.print("Testing the method getArrayOfDiscs(" + i + "): ");
			
			if(!arrayToString(tower[i]).equals(arrayToString(t.getArrayOfDiscs(i))))
			{
				System.out.println("FAIL");
				System.out.println("The method getArrayOfDiscs(" + i + ") should return the array " + arrayToString(tower[i]) + ".");
				System.out.println("But your method getArrayOfDiscs(" + i + ") returns the array " + arrayToString(t.getArrayOfDiscs(i)) + ".\n");
				result = false;
			}
			else
			{
				System.out.println("PASS");
			}
		}
		
		return result;
	}
	
	private static String arrayToString(int[] array)
	{
		String result = "[";
		
		if(array.length > 0)
		{
			for(int i = 0; i < array.length - 1; i++)
			{
				result = result + array[i] + ",";
			}
		
			result = result + array[array.length - 1];
		}
		
		return result + "]";
	}
}
