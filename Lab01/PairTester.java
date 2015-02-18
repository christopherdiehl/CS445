import java.util.Random;

public class PairTester
{
	public static void main(String[] args)
	{
		int point = 0;
		Random rand = new Random();
		
		// Test a pair of string and integer
		
		System.out.print("Testing Pair<String,Integer>: ");

		int l1 = rand.nextInt(10) + 10;
		String s1 = randomString(l1);
		PairInterface<String,Integer> p1 = new Pair<String,Integer>(s1,l1);

		if(checkFromToString("(" + s1 + "," + l1 + ")", p1.toString()))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		
		// Test a pair of integer and string
		
		System.out.print("Testing Pair<Integer,String>: ");
		int l2 = rand.nextInt(10) + 10;
		String s2 = randomString(l2);
		PairInterface<Integer,String> p2 = new Pair<Integer,String>(l2,s2);
		if(checkFromToString("(" + l2 + "," + s2 + ")", p2.toString()))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
	
		// Test a pair of String and pair
		
		System.out.print("Testing Pair<String,Pair<Integer,String>>: ");
		int l3_1 = rand.nextInt(10) + 10;
		int l3_2 = rand.nextInt(10) + 10;
		String s3_1 = randomString(l3_1);
		String s3_2 = randomString(l3_2);
		PairInterface<Integer,String> p3_1 = new Pair<Integer,String>(l3_1 + l3_2, s3_1);
		PairInterface<String, PairInterface<Integer,String>> p3_2 = new Pair<String, PairInterface<Integer,String>>(s3_2, p3_1);
		if(checkFromToString("(" + s3_2 + ",(" + (l3_1 + l3_2) + "," + s3_1 + "))", p3_2.toString()))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");

		// Test a pair of pair and Integer
		
		System.out.print("Testing Pair<String,Pair<Integer,String>>: ");
		int l4_1 = rand.nextInt(10) + 10;
		int l4_2 = rand.nextInt(10) + 10;
		String s4 = randomString(l4_1 + l4_2);
		PairInterface<String,Integer> p4_1 = new Pair<String,Integer>(s4,l4_1);
		Pair<Integer, PairInterface<String,Integer>> p4_2 = new Pair<Integer, PairInterface<String,Integer>>(l4_2, p4_1);
		if(checkFromToString("(" + l4_2 + ",(" + s4 + "," + l4_1 + "))", p4_2.toString()))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");

		// Test 5-tuple
		
		System.out.print("Testing 5-tuple (e.g., (1,(2,(3,(4,5))))): ");
		int[] l5 = new int[5];
		for(int i = 0; i < 5; i++)
		{
			l5[i] = rand.nextInt(10) + 10;
		}
		String s5 = "(" + l5[0] + ",(" + l5[1] + ",(" + l5[2] + ",(" + l5[3] + "," + l5[4] + "))))";
		PairInterface<Integer,Integer> p5_1 = new Pair<Integer,Integer>(l5[3],l5[4]);
		PairInterface<Integer,PairInterface<Integer,Integer>> p5_2 = new Pair<Integer,PairInterface<Integer,Integer>>(l5[2],p5_1);
		PairInterface<Integer,PairInterface<Integer,PairInterface<Integer,Integer>>> p5_3 =
				new Pair<Integer,PairInterface<Integer,PairInterface<Integer,Integer>>>(l5[1],p5_2);
		PairInterface<Integer,PairInterface<Integer,PairInterface<Integer,PairInterface<Integer,Integer>>>> p5_4 =
				new Pair<Integer,PairInterface<Integer,PairInterface<Integer,PairInterface<Integer,Integer>>>>(l5[0],p5_3);
		if(checkFromToString(s5, p5_4.toString()))
		{
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");

		if(point != 5)
		{
			System.out.println("This test class will use variables generated in");
			System.out.println("previous tests. Your class Pair fails one or more");
			System.out.println("test(s). This test class will terminated. Fix");
			System.out.println("your class Pair first and run the test class again.");
			System.out.println("Your current point is " + point + ".\n");
			return;
		}
		
		// Testing the method equals()
		
		System.out.println("Testing the method equals()");
		
		PairInterface<String,Integer> p6 = new Pair<String,Integer>(s1,l1);

		System.out.print("Test whether " + p1 + " is equals to " + p6 + ": ");
		if(!p1.equals(p6))
		{
			System.out.println("FAIL");
			System.out.println("The pair " + p1 + " and the pair " + p6 + " are equal.");
			System.out.println("But your method equals() returned false.");
			System.out.println("Fix your method equals() first and run the test class again.");
			System.out.println("Your current point is " + point + ".\n");
			return;
		}
		else
		{
			System.out.println("PASS");
		}
		
		PairInterface<String,Integer> p6_2 = new Pair<String,Integer>(s1.substring(1,s1.length()), l1);
		System.out.print("Test whether " + p1 + " is equals to " + p6_2 + ": ");
		if(p1.equals(p6_2))
		{
			System.out.println("FAIL");
			System.out.println("The pair " + p1 + " and the pair " + p6_2 + " are not equal.");
			System.out.println("But your method equals() returned true.");
			System.out.println("Fix your method equals() first and run the test class again.");
			System.out.println("Your current point is " + point + ".\n");
			return;
		}
		else
		{
			System.out.println("PASS");
		}
		
		PairInterface<String,Integer> p6_3 = new Pair<String,Integer>(s1, l1 + 1);
		System.out.print("Test whether " + p1 + " is equals to " + p6_3 + ": ");
		if(p1.equals(p6_3))
		{
			System.out.println("FAIL");
			System.out.println("The pair " + p1 + " and the pair " + p6_3 + " are not equal.");
			System.out.println("But your method equals() returned true.");
			System.out.println("Fix your method equals() first and run the test class again.");
			System.out.println("Your current point is " + point + ".\n");
			return;
		}
		else
		{
			System.out.println("PASS");
		}
		
		point++;
		System.out.println("Your current point is " + point + ".\n");
		
		

		System.out.print("Testing the method equals() (x,(y,z)) = (x,(y,z)): ");
		PairInterface<Integer,String> p7_1 = new Pair<Integer,String>(l3_1 + l3_2, s3_1);
		Pair<String, PairInterface<Integer,String>> p7_2 = new Pair<String, PairInterface<Integer,String>>(s3_2, p7_1);
		if(!p3_2.equals(p7_2))
		{
			System.out.println("FAIL");
			System.out.println("The pair " + p3_2 + " and the pair " + p7_2 + " are equal.");
			System.out.println("But your method equals() returned false.");
			System.out.println("Fix your method equals() first and run the test class again.");
			System.out.println("Your current point is " + point + ".\n");
			return;
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");

		// Testing the method fst()

		System.out.print("Testing the method fst(): ");
		if(!s1.equals(p1.fst()))
		{
			System.out.println("FAIL");
			System.out.println("First element of the pair " + p1 + " is " + s1 + ".");
			System.out.println("But the method fst() of your class returned " + p1.fst() + ".\n");
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		
		// Testing the method snd()
		
		System.out.print("Testing the method snd(): ");
		if(!s2.equals(p2.snd()))
		{
			System.out.println("FAIL");
			System.out.println("Second element of the pair " + p2 + " is " + s2 + ".");
			System.out.println("But the method snd() of your class returned " + p2.fst() + ".\n");
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		System.out.println("Your current point is " + point + ".\n");
		
		// Test setFst() and setSnd()
		
		System.out.print("Testing the methods setFst() and setSnd(): ");
		PairInterface<String,Integer> p10_1 = new Pair<String,Integer>("Hello",123);
		PairInterface<String,Integer> p10_2 = new Pair<String,Integer>("How are you?",54321);
		
		p10_1.setFst("How are you?");
		p10_1.setSnd(54321);
		
		if(!p10_1.equals(p10_2))
		{
			System.out.println("FAIL");
			System.out.println("The pair p10_1 was constructed using the following statement:");
			System.out.println("   PairInterface<String,Integer> p10_1 = new Pair<String,Integer>(\"Hello\",123);");
			System.out.println("Then the folloiwng statements are executed:");
			System.out.println("   p10_1.setFst(\"How are you?\");");
			System.out.println("   p10_1.setSnd(54321);");
			System.out.println("After above statements, the pair p10_1 should be " + p10_2 + ".");
			System.out.println("But the method toString() of our pair p10_1 is returns " + p10_1 + ".\n");
		}
		else
		{
			System.out.println("PASS");
			point++;
		}
		System.out.println("Your final point is " + point + ".\n");

		if(point == 10)
		{
			System.out.println("Contratulation! Your class Pair works perfectly (I guess).");
			System.out.println("You can run ParabolaFrame to see how Pair can be used in a program.");
		}
		else
		{
			System.out.println("There is one or more errors in your class.");
			System.out.println("Fix your bugs to get more points.");
		}
	}
	
	public static boolean checkFromToString(String s1, String s2)
	{
		if(s1.equals(s2))
		{
			System.out.println("PASS");
			return true;
		}
		else
		{
			System.out.println("FAILED");
			System.out.println("The method toString() should to return: " + s1);
			System.out.println("But your method toString() returns    : " + s2);
			return false;
		}
	}
	
	public static String randomString(int length)
	{
		String result = "";
		
		for(int i = 0; i < length; i++)
		{
			result = result + randomChar();
		}
		
		return result;
	}
	
	public static char randomChar()
	{
		Random rand = new Random();
		int modifier = rand.nextInt(26);
		
		if(rand.nextBoolean())
		{
			return (char) ('a' + modifier); 
		}
		else
		{
			return (char) ('A' + modifier);
		}
	}
}
