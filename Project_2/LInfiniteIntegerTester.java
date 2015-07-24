import java.util.Scanner;

public class LInfiniteIntegerTester
{
	public static void main(String[] args)
	{
		int option = 1;		// 1 to stop right after a FAIL
		int numErrors = 0;	// number of errors

		System.out.println("Welcome to AInfiniteInteger Tester");
		System.out.println("There are two options:");
		System.out.println("  1. Stop right after a FAIL");
		System.out.println("  2. Do not stop after a FAIL");
		System.out.print("Please select an option (1 or 2): ");

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		do		{	
			option = in.nextInt();
			if(option != 1 && option != 2)
			{
				System.out.print("Invalid option. Please select an option (1 or 2): ");
			}
		}
		while(option != 1 && option != 2);
		
		// Testing the method getNumberOfDigits()
		
		System.out.print("Checking the method getNumberOfDigits() of a positive integer: ");
		
		InfiniteIntegerInterface gd1 = new LInfiniteInteger("123456789");
		
		if(gd1.getNumberOfDigits() != 9)
		{
			System.out.println("FAIL");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd1 = new LInfiniteInteger(\"123456789\");");
			System.out.println("The integer 123456789 contains 9 digits.");
			System.out.println("But your gd1.getNumberOfDigits() returns " + gd1.getNumberOfDigits() + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method getNumberOfDigits()
		
		System.out.print("Checking the method getNumberOfDigits() of a negative integer: ");
		
		InfiniteIntegerInterface gd2 = new LInfiniteInteger("-123456789");
		
		if(gd2.getNumberOfDigits() != 9)
		{
			System.out.println("FAIL");
			System.out.println("The integer -123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd2 = new LInfiniteInteger(\"-123456789\");");
			System.out.println("The integer -123456789 contains 9 digits.");
			System.out.println("But your gd2.getNumberOfDigits() returns " + gd2.getNumberOfDigits() + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method getNumberOfDigits()
		
		System.out.print("Checking the method getNumberOfDigits() of a positive integer with leading 0s: ");
		
		InfiniteIntegerInterface gd3 = new LInfiniteInteger("000123456789");
		
		if(gd3.getNumberOfDigits() != 9)
		{
			System.out.println("FAIL");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd3 = new LInfiniteInteger(\"000123456789\");");
			System.out.println("The integer 123456789 contains 9 digits.");
			System.out.println("But your gd3.getNumberOfDigits() returns " + gd3.getNumberOfDigits() + ".");
			System.out.println("Did you handle leading 0s?");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method getNumberOfDigits()
		
		System.out.print("Checking the method getNumberOfDigits() of a negative integer with leading 0s: ");
		
		InfiniteIntegerInterface gd4 = new LInfiniteInteger("-000123456789");
		
		if(gd4.getNumberOfDigits() != 9)
		{
			System.out.println("FAIL");
			System.out.println("The integer -123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd4 = new LInfiniteInteger(\"-000123456789\");");
			System.out.println("The integer -123456789 contains 9 digits.");
			System.out.println("But your gd4.getNumberOfDigits() returns " + gd4.getNumberOfDigits() + ".");
			System.out.println("Did you handle leading 0s?");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method getNumberOfDigits()
		
		System.out.print("Checking the method getNumberOfDigits() of 0: ");
		
		InfiniteIntegerInterface gd5 = new LInfiniteInteger("0");
		
		if(gd5.getNumberOfDigits() != 1)
		{
			System.out.println("FAIL");
			System.out.println("The integer 0 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd5 = new LInfiniteInteger(\"0\");");
			System.out.println("The integer 0 contains 1 digits.");
			System.out.println("But your gd5.getNumberOfDigits() returns " + gd5.getNumberOfDigits() + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method getNumberOfDigits()
		
		System.out.print("Checking the method getNumberOfDigits() of 0 with leading 0s: ");
		
		InfiniteIntegerInterface gd6 = new LInfiniteInteger("0000");
		
		if(gd6.getNumberOfDigits() != 1)
		{
			System.out.println("FAIL");
			System.out.println("The integer 0 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd5 = new LInfiniteInteger(\"0000\");");
			System.out.println("The integer 0 contains 1 digits.");
			System.out.println("But your gd6.getNumberOfDigits() returns " + gd6.getNumberOfDigits() + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method toString()
		
		System.out.print("Checking the method toString() of a positive integer: ");
		
		if(!gd1.toString().equals("123456789"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd1 = new LInfiniteInteger(\"123456789\");");
			System.out.println("But your gd1.toString() returns " + gd1 + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method toString()
		
		System.out.print("Checking the method toString() of a negative integer: ");
		
		if(!gd2.toString().equals("-123456789"))
		{
			System.out.println("FAIL");
			System.out.println("The integer -123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd2 = new LInfiniteInteger(\"-123456789\");");
			System.out.println("But your gd2.toString() returns " + gd2 + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method toString()
		
		System.out.print("Checking the method toString() of a positive integer with leading 0s: ");
		
		if(!gd3.toString().equals("123456789"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd3 = new LInfiniteInteger(\"000123456789\");");
			System.out.println("But your gd3.toString() returns " + gd3 + ".");
			System.out.println("Did you handle leading 0s?");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method toString()
		
		System.out.print("Checking the method toString() of a negative integer with leading 0s: ");
		
		if(!gd4.toString().equals("-123456789"))
		{
			System.out.println("FAIL");
			System.out.println("The integer -123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd4 = new LInfiniteInteger(\"-000123456789\");");
			System.out.println("But your gd4.toString() returns " + gd4 + ".");
			System.out.println("Did you handle leading 0s?");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// Testing the method toString()
		
		System.out.print("Checking the method toString() of a 0: ");
		
		if(!gd5.toString().equals("0"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 0 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd5 = new LInfiniteInteger(\"0\");");
			System.out.println("But your gd5.toString() returns " + gd5 + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// Testing the method toString()
		
		System.out.print("Checking the method toString() of a 0 with leading 0s: ");
		
		if(!gd6.toString().equals("0"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 0 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface gd6 = new LInfiniteInteger(\"0000\");");
			System.out.println("But your gd6.toString() returns " + gd6 + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// Testing the method compareTo()
		
		System.out.print("Checking the method compareTo(): ");
		
		InfiniteIntegerInterface cp1 = new LInfiniteInteger("987654321");
		
		if(cp1.compareTo(cp1) != 0)
		{
			System.out.println("FAIL");
			System.out.println("The integer 987654321 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp1 = new LInfiniteInteger(\"987654321\");");
			System.out.println("cp1.compareTo(cp1) should return 0.");
			System.out.println("But your cp1.compareTo(cp1) returns " + cp1.compareTo(cp1) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method compareTo()
		
		System.out.print("Checking the method compareTo(): ");

		InfiniteIntegerInterface cp2 = new LInfiniteInteger("123456789");
		
		if(cp1.compareTo(cp2) != 1)
		{
			System.out.println("FAIL");
			System.out.println("The integer 987654321 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp1 = new LInfiniteInteger(\"987654321\");");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp2 = new LInfiniteInteger(\"123456789\");");
			System.out.println("cp1.compareTo(cp2) should return 1.");
			System.out.println("But your cp1.compareTo(cp2) returns " + cp1.compareTo(cp2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// Testing the method compareTo()
		
		System.out.print("Checking the method compareTo(): ");
		
		if(cp2.compareTo(cp1) != -1)
		{
			System.out.println("FAIL");
			System.out.println("The integer 987654321 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp1 = new LInfiniteInteger(\"987654321\");");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp2 = new LInfiniteInteger(\"123456789\");");
			System.out.println("cp2.compareTo(cp1) should return -1.");
			System.out.println("But your cp2.compareTo(cp1) returns " + cp2.compareTo(cp1) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method compareTo()
		
		System.out.print("Checking the method compareTo(): ");

		InfiniteIntegerInterface cp3 = new LInfiniteInteger("123456789");
		
		if(cp2.compareTo(cp3) != 0)
		{
			System.out.println("FAIL");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp2 = new LInfiniteInteger(\"123456789\");");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp3 = new LInfiniteInteger(\"123456789\");");
			System.out.println("cp2.compareTo(cp3) should return 0.");
			System.out.println("But your cp2.compareTo(cp3) returns " + cp2.compareTo(cp3) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method compareTo()
		
		System.out.print("Checking the method compareTo(): ");

		InfiniteIntegerInterface cp4 = new LInfiniteInteger("-123456789");
		
		if(cp3.compareTo(cp4) != 1)
		{
			System.out.println("FAIL");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp3 = new LInfiniteInteger(\"123456789\");");
			System.out.println("The integer -123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp4 = new LInfiniteInteger(\"-123456789\");");
			System.out.println("cp3.compareTo(cp4) should return 1.");
			System.out.println("But your cp3.compareTo(cp4) returns " + cp3.compareTo(cp4) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Testing the method compareTo()
		
		System.out.print("Checking the method compareTo(): ");

		if(cp4.compareTo(cp3) != -1)
		{
			System.out.println("FAIL");
			System.out.println("The integer 123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp3 = new LInfiniteInteger(\"123456789\");");
			System.out.println("The integer -123456789 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface cp4 = new LInfiniteInteger(\"-123456789\");");
			System.out.println("cp4.compareTo(cp3) should return -1.");
			System.out.println("But your cp4.compareTo(cp3) returns " + cp4.compareTo(cp3) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS\n");
		}
		
		// Testing the method plus()
		
		System.out.println("Testing the method plus()");
		System.out.println("=========================");
		
		System.out.println("The range of the infinite integer x is [-500,500].");
		System.out.println("The range of the infinite integer y is [-500,500].");
		System.out.print("Checking all possible values of x + y: ");
		
		for(int i = -500; i <= 500; i++)
		{
			for(int j = -500; j <= 500; j++)
			{
				InfiniteIntegerInterface x = new LInfiniteInteger(i);
				InfiniteIntegerInterface y = new LInfiniteInteger(j);

				if(!((i + j) + "").equals(x.plus(y).toString()))
					
				{
					System.out.println("FAIL");
					System.out.println("InfiniteInteger x was constructed using the following statement:");
					System.out.println("   InfiniteIntegerInterface x = new LInfiniteInteger(" + i + ");");
					System.out.println("InfiniteInteger y was constructed using the following statement:");
					System.out.println("   InfiniteIntegerInterface y = new LInfiniteInteger(" + j + ");");
					System.out.println("The result of " + i + " + " + j + " should be " + (i + j) + ".");
					System.out.println("But your x.plus(y) returns " + x.plus(y) + ".\n");
					if(option == 1)
					{
						return;
					}
					else
					{
						numErrors++;
					}
				}
			}
		}
		
		System.out.println("PASS\n");
		
		System.out.print("Calculating 12345678901234567890 + 12345678901234567890: ");
		InfiniteIntegerInterface tp1 = new LInfiniteInteger("12345678901234567890");
		if(!tp1.plus(tp1).toString().equals("24691357802469135780"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 12345678901234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp1 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("The result of 12345678901234567890 + 12345678901234567890 should be 24691357802469135780.");
			System.out.println("But your tp1.plus(tp1) returns " + tp1.plus(tp1) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating 12345678901234567890 + (-12345678901234567890): ");

		InfiniteIntegerInterface tp2_1 = new LInfiniteInteger("12345678901234567890");
		InfiniteIntegerInterface tp2_2 = new LInfiniteInteger("-12345678901234567890");
		if(!tp2_1.plus(tp2_2).toString().equals("0"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 12345678901234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp2_1 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("The integer -12345678901234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp2_2 = new LInfiniteInteger(\"-12345678901234567890\");");
			System.out.println("The result of 12345678901234567890 + (-12345678901234567890) should be 0.");
			System.out.println("But your tp2_1.plus(tp2_2) returns " + tp2_1.plus(tp2_2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating 100000000000000000000 + (-1): ");
		InfiniteIntegerInterface tp3_1 = new LInfiniteInteger("100000000000000000000");
		InfiniteIntegerInterface tp3_2 = new LInfiniteInteger("-1");
		if(!tp3_1.plus(tp3_2).toString().equals("99999999999999999999"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 100000000000000000000 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp3_1 = new LInfiniteInteger(\"100000000000000000000\");");
			System.out.println("The integer -1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp3_2 = new LInfiniteInteger(\"-1\");");
			System.out.println("The result of 100000000000000000000 + (-1) should be 99999999999999999999.");
			System.out.println("But your tp3_1.plus(tp3_2) returns " + tp3_1.plus(tp3_2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating (-1) + 100000000000000000000: ");
		InfiniteIntegerInterface tp4_1 = new LInfiniteInteger("-1");
		InfiniteIntegerInterface tp4_2 = new LInfiniteInteger("100000000000000000000");
		if(!tp4_1.plus(tp4_2).toString().equals("99999999999999999999"))
		{
			System.out.println("FAIL");
			System.out.println("The integer -1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp4_1 = new LInfiniteInteger(\"-1\");");
			System.out.println("The integer 100000000000000000000 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp4_2 = new LInfiniteInteger(\"100000000000000000000\");");
			System.out.println("The result of (-1) + 100000000000000000000 should be 99999999999999999999.");
			System.out.println("But your tp4_1.plus(tp4_2) returns " + tp4_1.plus(tp4_2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating 1 + (-100000000000000000000): ");
		InfiniteIntegerInterface tp5_1 = new LInfiniteInteger("1");
		InfiniteIntegerInterface tp5_2 = new LInfiniteInteger("-100000000000000000000");
		if(!tp5_1.plus(tp5_2).toString().equals("-99999999999999999999"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp5_1 = new LInfiniteInteger(\"1\");");
			System.out.println("The integer -100000000000000000000 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp5_2 = new LInfiniteInteger(\"-100000000000000000000\");");
			System.out.println("The result of 1 + (-100000000000000000000) should be -99999999999999999999.");
			System.out.println("But your tp5_1.plus(tp5_2) returns " + tp5_1.plus(tp5_2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating (-100000000000000000000) + 1: ");
		InfiniteIntegerInterface tp6_1 = new LInfiniteInteger("-100000000000000000000");
		InfiniteIntegerInterface tp6_2 = new LInfiniteInteger("1");
		if(!tp6_1.plus(tp6_2).toString().equals("-99999999999999999999"))
		{
			System.out.println("FAIL");
			System.out.println("The integer -100000000000000000000 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp6_1 = new LInfiniteInteger(\"-100000000000000000000\");");
			System.out.println("The integer 1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tp6_2 = new LInfiniteInteger(\"1\");");
			System.out.println("The result of (-100000000000000000000) + 1 should be -99999999999999999999.");
			System.out.println("But your tp6_1.plus(tp6_2) returns " + tp6_1.plus(tp6_2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS\n");
		}
		
		// Testing the method minus()
		
		System.out.println("Testing the method minus()");
		System.out.println("==========================");		
		
		System.out.println("The range of the infinite integer x is [-500,500].");
		System.out.println("The range of the infinite integer y is [-500,500].");
		System.out.print("Checking all possible values of x - y: ");
		
		for(int i = -500; i <= 500; i++)
		{
			for(int j = -500; j <= 500; j++)
			{
				InfiniteIntegerInterface x = new LInfiniteInteger(i);
				InfiniteIntegerInterface y = new LInfiniteInteger(j);

				if(!((i - j) + "").equals(x.minus(y).toString()))
				{
					System.out.println("FAIL");
					System.out.println("InfiniteInteger x was constructed using the following statement:");
					System.out.println("   InfiniteIntegerInterface x = new LInfiniteInteger(" + i + ");");
					System.out.println("InfiniteInteger y was constructed using the following statement:");
					System.out.println("   InfiniteIntegerInterface y = new LInfiniteInteger(" + j + ");");
					System.out.println("The result of " + i + " - " + j + " should be " + (i - j) + ".");
					System.out.println("But your x.minus(y) returns " + x.minus(y) + ".\n");
					if(option == 1)
					{
						return;
					}
					else
					{
						numErrors++;
					}
				}
			}
		}
		
		System.out.println("PASS\n");
		
		InfiniteIntegerInterface tm1 = new LInfiniteInteger("12345678901234567890");

		System.out.print("Calculating 12345678901234567890 - 12345678901234567890: ");
		if(!tm1.minus(tm1).toString().equals("0"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 12345678901234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tm1 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("The result of 12345678901234567890 - 12345678901234567890 should be 0.");
			System.out.println("But your tm1.minus(tm1) returns " + tm1.minus(tm1) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		InfiniteIntegerInterface tm2_1 = new LInfiniteInteger("12345678901234567890");
		InfiniteIntegerInterface tm2_2 = new LInfiniteInteger("1234567890");

		System.out.print("Calculating 12345678901234567890 - 1234567890: ");
		if(!tm2_1.minus(tm2_2).toString().equals("12345678900000000000"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 12345678901234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tm2_1 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("The integer 1234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tm2_2 = new LInfiniteInteger(\"1234567890\");");
			System.out.println("The result of 12345678901234567890 - 1234567890 should be 12345678900000000000.");
			System.out.println("But your tm2_1.minus(tm2_2) returns " + tm2_1.minus(tm2_2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		InfiniteIntegerInterface tm3_1 = new LInfiniteInteger("1234567890");
		InfiniteIntegerInterface tm3_2 = new LInfiniteInteger("12345678901234567890");
		
		System.out.print("Calculating 1234567890 - 12345678901234567890: ");
		if(!tm3_1.minus(tm3_2).toString().equals("-12345678900000000000"))
		{
			System.out.println("FAIL");
			System.out.println("The integer 1234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tm3_1 = new LInfiniteInteger(\"1234567890\");");
			System.out.println("The integer 12345678901234567890 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tm3_2 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("The result of 1234567890 - 12345678901234567890 should be -12345678900000000000.");
			System.out.println("But your tm3_1.minus(tm3_2) returns " + tm3_1.minus(tm3_2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS\n");
		}

		// Testing the method multiply()
		
		System.out.println("Testing the method multiply()");
		System.out.println("=============================");		
		
		System.out.println("The range of the infinite integer x is [-500,500].");
		System.out.println("The range of the infinite integer y is [-500,500].");
		System.out.print("Checking all possible values of x * y: ");
		
		for(int i = -500; i <= 500; i++)
		{
			for(int j = -500; j <= 500; j++)
			{
				InfiniteIntegerInterface x = new LInfiniteInteger(i);
				InfiniteIntegerInterface y = new LInfiniteInteger(j);

				if(!((i * j) + "").equals(x.multiply(y).toString()))
				{
					System.out.println("FAIL");
					System.out.println("InfiniteInteger x was constructed using the following statement:");
					System.out.println("   InfiniteIntegerInterface x = new LInfiniteInteger(" + i + ");");
					System.out.println("InfiniteInteger y was constructed using the following statement:");
					System.out.println("   InfiniteIntegerInterface y = new LInfiniteInteger(" + j + ");");
					System.out.println("The result of " + i + " * " + j + " should be " + (i * j) + ".");
					System.out.println("But your x.multiply(y) returns " + x.multiply(y) + ".\n");
					if(option == 1)
					{
						return;
					}
					else
					{
						numErrors++;
					}
				}
			}
		}
		
		System.out.println("PASS\n");
		
		System.out.print("Calculating 12345678901234567890 * 12345678901234567890: ");
		
		InfiniteIntegerInterface tml1 = new LInfiniteInteger("12345678901234567890");
		String tml1Result = "152415787532388367501905199875019052100";
		
		if(!tml1.multiply(tml1).toString().equals(tml1Result))
		{
			System.out.println("FAIL");
			System.out.println("InfiniteInteger tml1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml1 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("The result of " + tml1 + " * " + tml1 + " should be " + tml1Result + ".");
			System.out.println("But your tml1.multiply(tml1) returns " + tml1.multiply(tml1) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating 12345678901234567890 * -12345678901234567890: ");
		
		InfiniteIntegerInterface tml2 = new LInfiniteInteger("-12345678901234567890");
		
		if(!tml1.multiply(tml2).toString().equals("-" + tml1Result))
		{
			System.out.println("FAIL");
			System.out.println("InfiniteInteger tml1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml1 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("InfiniteInteger tml2 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml2 = new LInfiniteInteger(\"-12345678901234567890\");");
			System.out.println("The result of " + tml1 + " * " + tml2 + " should be -" + tml1Result + ".");
			System.out.println("But your tml1.multiply(tml2) returns " + tml1.multiply(tml2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating -12345678901234567890 * 12345678901234567890: ");
		
		if(!tml2.multiply(tml1).toString().equals("-" + tml1Result))
		{
			System.out.println("FAIL");
			System.out.println("InfiniteInteger tml1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml1 = new LInfiniteInteger(\"12345678901234567890\");");
			System.out.println("InfiniteInteger tml2 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml2 = new LInfiniteInteger(\"-12345678901234567890\");");
			System.out.println("The result of " + tml2 + " * " + tml1 + " should be -" + tml1Result + ".");
			System.out.println("But your tml2.multiply(tml1) returns " + tml2.multiply(tml1) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Calculating -12345678901234567890 * -12345678901234567890: ");
		
		if(!tml2.multiply(tml2).toString().equals(tml1Result))
		{
			System.out.println("FAIL");
			System.out.println("InfiniteInteger tml2 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml2 = new LInfiniteInteger(\"-12345678901234567890\");");
			System.out.println("The result of " + tml2 + " * " + tml2 + " should be " + tml1Result + ".");
			System.out.println("But your tml2.multiply(tml2) returns " + tml2.multiply(tml2) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}

		// Multiply by 0
		
		System.out.print("Calculating 12345678901234567890 * 0: ");
		
		InfiniteIntegerInterface tml0 = new LInfiniteInteger("0");
		
		if(!tml1.multiply(tml0).toString().equals("0"))
		{
			System.out.println("FAIL");
			System.out.println("InfiniteInteger tml1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml1 = new LInfiniteInteger(\"-12345678901234567890\");");
			System.out.println("InfiniteInteger tml0 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml0 = new LInfiniteInteger(\"0\");");
			System.out.println("The result of " + tml1 + " * " + tml0 + " should be " + tml1Result + ".");
			System.out.println("But your tml1.multiply(tml0) returns " + tml1.multiply(tml0) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Checking equivalent to zero (compareTo): ");
		
		InfiniteIntegerInterface tml3 = tml1.multiply(tml0);
		
		if(tml3.compareTo(tml0) != 0)
		{
			System.out.println("FAIL");
			System.out.println("InfiniteInteger tml1 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml1 = new LInfiniteInteger(\"-12345678901234567890\");");
			System.out.println("InfiniteInteger tml0 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml0 = new LInfiniteInteger(\"0\");");
			System.out.println("InfiniteInteger tml3 was constructed using the following statement:");
			System.out.println("   InfiniteIntegerInterface tml3 = tml1.multiply(tml0);");
			System.out.println("The result of calling tml3.compareTo(tml0) should be 0.");
			System.out.println("But your tml3.compareTo(tml0) returns " + tml3.compareTo(tml0) + ".\n");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		else
		{
			System.out.println("PASS");
		}
		
		
		System.out.println();
		
		// Crazy Tests
		
		System.out.println("Let's go crazy.");
		System.out.println("Calculating values of 2^1, 2^2, 2^4, 2^8, ..., 2^1024 using loops of additions");
		
		int resultNumber = 0;
		int[] resultNumDigits = new int[11];
		String[] resultStrings = new String[11];
		resultNumDigits[0] = 1;
		resultStrings[0] = "2";
		resultNumDigits[1] = 1;
		resultStrings[1] = "4";
		resultNumDigits[2] = 2;
		resultStrings[2] = "16";
		resultNumDigits[3] = 3;
		resultStrings[3] = "256";
		resultNumDigits[4] = 5;
		resultStrings[4] = "65536";
		resultNumDigits[5] = 10;
		resultStrings[5] = "4294967296";
		resultNumDigits[6] = 20;
		resultStrings[6] = "18446744073709551616";
		resultNumDigits[7] = 39;
		resultStrings[7] = "340282366920938463463374607431768211456";
		resultNumDigits[8] = 78;
		resultStrings[8] = "115792089237316195423570985008687907853269984665640564039457584007913129639936";
		resultNumDigits[9] = 155;
		resultStrings[9] = "13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084096";
		resultNumDigits[10] = 309;
		resultStrings[10] = "179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216";
		
		System.out.println("This test is done by first construct the infinit integer x using the followoing statement:");
		System.out.println("   InfiniteIntegerInterface x = new LInfiniteInteger(\"1\");");
		System.out.println("Then repeatedly executing the following statement:");
		System.out.println("   x = x.plus(x);\n");
		
		for(int n = 1; n <= 1024; n = n + n)
		{
			InfiniteIntegerInterface x = new LInfiniteInteger("1");

			for(int i = 1; i <= n; i++)
			{
				x = x.plus(x);
			}
			System.out.print("2^" + n + " is " + x + " containing " + x.getNumberOfDigits() + " digits: ");
			if(x.getNumberOfDigits() != resultNumDigits[resultNumber] || !x.toString().equals(resultStrings[resultNumber]))
			{
				System.out.println("FAIL");
				System.out.println("2^" + n + " should be " + resultStrings[resultNumber] + " which contains " + resultNumDigits[resultNumber] + " digits.");
				if(option == 1)
				{
					return;
				}
				else
				{
					numErrors++;
				}
			}
			else
			{
				System.out.println("PASS");
			}
			
			resultNumber++;
		}
		
		System.out.println();
		
		int numDigitsGoal = 1000;
		String crazyResultString = "1313879718456104225921995528497555855625152414017051819746489965175418594035237238181967239932841927943368022817082758088019245450978689926961358127631787144754373062120106902504163460853000843067796699510293924385333858122456855065858902248896798237625003273316840048212276610565777594650220087971045508055611314300070786176626378923084556948528977153135635206046615173944871186308702998089733796437598174864856900497873863589167218546523213052953471290292740839713119247294213720517263787354623928731924441813068650485005632246166869508621489664962699281739398162579362377493635567561343072827446535980932480283909225368443393486477711655376434350643031227524710815041165924570415486219444700695031601993251625411314037854648482400238147123249264167061961509379444920959953800364778020888142773659393688842351560111550969115614788364312559110854239694359378947557812483113318119934088060561737965196192041096299817733313038159648080136912212919336690293080257579650807503654066749005924284432908288";
		int resultOfx = 3319;
		
		System.out.println("Let's go to the extreme.");
		System.out.println("Let's find the number x where 2^x contains " + numDigitsGoal + " digits.");
		
		InfiniteIntegerInterface crazy = new LInfiniteInteger("1");
		int result = 0;
		while(crazy.getNumberOfDigits() < numDigitsGoal)
		{
			crazy = crazy.plus(crazy);
			result++;
		}
		
		System.out.println("2^" + result + " is " + crazy + ".");
		System.out.println("2^" + result + " contains " + numDigitsGoal + " digits.");
		
		System.out.print("Crazy test: ");
		
		if(resultOfx == result && crazyResultString.equals(crazy.toString()))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("The answer should be 2^" + resultOfx + ".");
			System.out.println("Where 2^" + resultOfx + " is equal to " + crazyResultString + ".");
			if(option == 1)
			{
				return;
			}
			else
			{
				numErrors++;
			}
		}
		
		// Show number of errors
		
		if(numErrors != 0)
		{
			System.out.println("\nThere are " + numErrors + " errors detected.");
		}
		else
		{
			System.out.println("\nThere are no errors detected. Good Job!!!");
		}
	}
}
