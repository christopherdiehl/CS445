
public class CompressDecompressTester
{
	public static void main(String[] args)
	{
		int numErrors = 0;
		
		// Test getTreeString()
		
		System.out.print("Testing the method getTreeString() with an empty tree: ");
		if(CompressDecompress.getTreeString(null) != "")
		{
			System.out.println("FAIL");
			System.out.println("CompressDecompress.getTreeString(null) shoudl return an empty string (\"\").");
			System.out.println("But your method getTreeString(null) returns " + CompressDecompress.getTreeString(null) + ".\n");
			numErrors++;
		}
		else
		{
			System.out.println("PASS\n");
		}
		
		System.out.println("A two node tree was constructed (from nodes) using the following statements:");
		System.out.println("   BinaryNodeInterface<Character> nodeA = new BinaryNode<Character>('a');");
		System.out.println("   BinaryNodeInterface<Character> twoNodeTreeRoot = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeA, null);");
		System.out.print("Testing the method getTreeString() with two node tree: ");
		BinaryNodeInterface<Character> nodeA = new BinaryNode<Character>('a');
		BinaryNodeInterface<Character> twoNodeTreeRoot = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeA, null);
		if(!CompressDecompress.getTreeString(twoNodeTreeRoot).equals("ILa"))
		{
			System.out.println("FAIL");
			System.out.println("The method getTreeString(twoNodeTreeRoot) should return ILa.");
			System.out.println("But your method getTreeString(twoNodeTreeRoot) returns " + CompressDecompress.getTreeString(twoNodeTreeRoot) + ".\n");
			numErrors++;
		}
		else
		{
			System.out.println("PASS\n");
		}
		
		System.out.println("A nine node tree was constructed (from nodes) using the following statements:");
		System.out.println("   BinaryNodeInterface<Character> nodeA = new BinaryNode<Character>('a');");
		System.out.println("   BinaryNodeInterface<Character> nodeB = new BinaryNode<Character>('b');");
		System.out.println("   BinaryNodeInterface<Character> nodeC = new BinaryNode<Character>('c');");
		System.out.println("   BinaryNodeInterface<Character> nodeD = new BinaryNode<Character>('d');");
		System.out.println("   BinaryNodeInterface<Character> nodeE = new BinaryNode<Character>('e');");
		System.out.println("   BinaryNodeInterface<Character> nodeAB = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeA, (BinaryNode<Character>) nodeB);");
		System.out.println("   BinaryNodeInterface<Character> nodeCD = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeC, (BinaryNode<Character>) nodeD);");
		System.out.println("   BinaryNodeInterface<Character> nodeABCD = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeAB, (BinaryNode<Character>) nodeCD);");
		System.out.println("   BinaryNodeInterface<Character> nodeABCDE = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeABCD, (BinaryNode<Character>) nodeE);");
		System.out.print("Testing the method getTreeString() with nine node tree: ");
		BinaryNodeInterface<Character> nodeB = new BinaryNode<Character>('b');
		BinaryNodeInterface<Character> nodeC = new BinaryNode<Character>('c');
		BinaryNodeInterface<Character> nodeD = new BinaryNode<Character>('d');
		BinaryNodeInterface<Character> nodeE = new BinaryNode<Character>('e');
		BinaryNodeInterface<Character> nodeAB = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeA, (BinaryNode<Character>) nodeB);
		BinaryNodeInterface<Character> nodeCD = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeC, (BinaryNode<Character>) nodeD);
		BinaryNodeInterface<Character> nodeABCD = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeAB, (BinaryNode<Character>) nodeCD);
		BinaryNodeInterface<Character> nodeABCDE = new BinaryNode<Character>(null, (BinaryNode<Character>) nodeABCD, (BinaryNode<Character>) nodeE);
		if(!CompressDecompress.getTreeString(nodeABCDE).equals("IIILaLbILcLdLe"))
		{
			System.out.println("FAIL");
			System.out.println("The method getTreeString(nodeABCDE) should return IIILaLbILcLdLe.");
			System.out.println("But your method getTreeString(nodeABCDE) returns " + CompressDecompress.getTreeString(nodeABCDE) + ".\n");
			numErrors++;
		}
		else
		{
			System.out.println("PASS\n");
		}
		
		// Test compress()
		
		System.out.print("Testing the method compress with an empty input string: ");
		if(!CompressDecompress.compress(null, "").equals(""))
		{
			System.out.println("FAIL");
			System.out.println("CompressDecompress.compress(null,\"\") shoudl return an empty string (\"\").");
			System.out.println("But your method compress(null,\"\") returns " + CompressDecompress.compress(null,"") + ".\n");
			numErrors++;
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Testing the method compress using two node tree from previous test and the input string is \"aaaa\": ");
		if(!CompressDecompress.compress(twoNodeTreeRoot, "aaaa").equals("0000"))
		{
			System.out.println("FAIL");
			System.out.println("CompressDecompress.compress(twoNodeTreeRoot,\"aaaa\") should return \"0000\".");
			System.out.println("But your method compress(twoNodeTreeRoot,\"aaaa\") returns " + CompressDecompress.compress(twoNodeTreeRoot,"aaaa") + ".");
			numErrors++;
		}
		else
		{
			System.out.println("PASS");
		}

		System.out.print("Testing the method compress using nine node tree from previous test and the input string is \"abcde\": ");
		if(!CompressDecompress.compress(nodeABCDE, "abcde").equals("0000010100111"))
		{
			System.out.println("FAIL");
			System.out.println("CompressDecompress.compress(nodeABCDE,\"abcde\") should return \"0000010100111\".");
			System.out.println("But your method compress(twoNodeTreeRoot,\"abcde\") returns " + CompressDecompress.compress(nodeABCDE,"abcde") + ".");
			numErrors++;
		}
		else
		{
			System.out.println("PASS");
		}
		
		// Test decompress()
		
		System.out.println();
		
		System.out.print("Testing the method decompress with empty tree and empty string: ");
		if(!CompressDecompress.decompress("", "").equals(""))
		{
			System.out.println("FAIL");
			System.out.println("CompressDecompress.decompress(\"\", \"\") should return an empty string (\"\").");
			System.out.println("But your method decompress(\"\", \"\") returns " + CompressDecompress.decompress("", "") + ".");
			numErrors++;
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.print("Testing the method decompress with the tree string IIILaLbILcLdLe and input string 1011010001000: ");
		if(!CompressDecompress.decompress("IIILaLbILcLdLe", "1011010001000").equals("edcba"))
		{
			System.out.println("FAIL");
			System.out.println("CompressDecompress.decompress(\"IIILaLbILcLdLe\", \"1011010001000\" should return edcba.");
			System.out.println("But your method decompress(\"IIILaLbILcLdLe\", \"1011010001000\" returns " + CompressDecompress.decompress("IIILaLbILcLdLe", "1011010001000") + ".");
			numErrors++;
		}
		else
		{
			System.out.println("PASS");
		}
		
		System.out.println();

		if(numErrors == 0)
		{
			System.out.println("Your CompressDecompress works perfectly (I guess). Here is your reward:\n");
			String jokeTree = "IIILeILaIIL\nILWIL?LvILgLkIILuLoILnLsIIIIIL,LbIL\"LfLtIILrLlIIILTIILILSILALmLyIIL.L'IIILYLGIL!LHLwIIILdILpLcILhLiL ";
			String jokeCompressed = "1011001101111100110101101100111110010010010010001010011101111100111101100001101100110001110111100101001100000001101001111110110111111011110010100110001011011101101100011101110100011011000000101001110010111100110100000000111001001101100011100100110010110011101000010100111110010010010101101010111111010011001011101010110111001011110001110101001001111101010110111101100001011111111100001110110011110001011100111101100011010000111100011110111010001111001111011110010100110000000110100111100100111001111011110000011110001000110101101000010100000101110111000111101101010101001110011100001001111100111010001010010011011010001000110000110010110001101000011101111001010011000000011010011110101011011110011101000011110000111011001111000111101000001100101010111011000011110000011110001000110101101011011101010001111011001001111011111001001111110111100101001100010110111011011000111011101010100100101111101111000000100000111001011110000100000100100100111011100011010010101111001110110111010010101111110010010010101101010001100011101001100101110101011011111010000101001111000011101100111100010111001111011001011101000011110010101010100111111101011000111000111110010101011010111111010000101001111100111010101011001110100000111111001001101100011101110010110111100010000011110111011011110000101010011111001100100110111110100010001101110001110010011010110110011101011011011000111011110110101010100111101111100100110100110111011011100100010001100001100101100011010000111100011110111010001111001111011110010100110000000110100111110100000011111001001010110110000111100000111100010101111001010101011100011111001111010010111011110011000101111010111101111011000101001111100111010101011001110100000111111110010101000101100001001010000110101101101111101111101010100101011100001101011101100111111010001000110111000111100011110111001111101101010101001011100100010";
			
			System.out.println(CompressDecompress.decompress(jokeTree, jokeCompressed));
		}
		else
		{
			System.out.println("There are " + numErrors + " errors in your CompressDecompress.java");
			System.out.println("Fix your code and try again.");
		}
	}
}
 