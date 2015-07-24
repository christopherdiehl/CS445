/**
 * It is okay to use ArrayList class but you are not allowed to use any other
 * predefined class supplied by Java.
 */
import java.util.ArrayList;

public class CompressDecompress
{
	/**
	 * Get a string representing a Huffman tree where its root node is root
	 * @param root the root node of a Huffman tree
	 * @return a string representing a Huffman tree
	 */
	public static String getTreeString(final BinaryNodeInterface<Character> root)
	{
		String returnVal= "";
		if(root == null){
			return "";
		}
		if(root.hasLeftChild()){
			returnVal += "I" +getTreeString(root.getLeftChild());
		}
		if (root.hasRightChild()){
			returnVal += getTreeString(root.getRightChild());

		}            
		if(! root.hasLeftChild() && !root.hasRightChild()){
			returnVal+= "L";
			returnVal+= root.getData();
		}

		return returnVal;	// Do not forget to change this line!!!
	}

	/**
	 * Compress the message using Huffman tree represented by treeString
	 * @param root the root node of a Huffman tree
	 * @param message the message to be compressed
	 * @return a string representing compressed message.
	 */
	public static String compress(final BinaryNodeInterface<Character> root, final String message)
	{
		String returnVal = "";
		char[] charArray = message.toCharArray();
		for (int i = 0; i < charArray.length; i++){
			returnVal += privateCompress(root, charArray[i]);
		}
		return returnVal;
// Do not forget to change this line!!!
	}

	public static String privateCompress (final BinaryNodeInterface<Character> root, final char searchValue){
		 String returnVal = "";
		 String tempVal;
		 	if (root.isLeaf())
		 		if (searchValue != root.getData())
		 			return null;
		 		else
		 			return "";
		    if (! root.isLeaf()) {
		        tempVal =privateCompress(root.getLeftChild(), searchValue);
		        if(tempVal != null)
		        {
		        	returnVal += "0" + tempVal;
		        	return returnVal;
		        }
		        
		        tempVal  =  privateCompress(root.getRightChild(), searchValue);
		        if(tempVal != null)
		        {
		        	returnVal += "1" +tempVal  ;
		        	return returnVal;
		        }
		    }
		
		return null;
	}
	/**
	 * Decompress the message using Huffman tree represented by treeString
	 * @param treeString the string represents the Huffman tree of the
	 * compressed message
	 * @param message the compressed message to be decompressed
	 * @return a string representing decompressed message
	 */
	public static String decompress(final String treeString, final String message)
	{ 
		if (message.equals("")){
			return "";
		}
		String generator= "";
		char [] treeCharArray = treeString.toCharArray();

		ArrayList <Character> treeArrayList = new ArrayList <Character>();
		for (char c : treeCharArray){
			treeArrayList.add(c);
		}
		BinaryNodeInterface<Character> tempRoot = new BinaryNode<Character>();
		BinaryNodeInterface <Character> root = createTree(treeArrayList);
		System.out.println("compress: " +getTreeString(root));
		BinaryNodeInterface <Character> temp = root;
		String returnString = "";
		char [] messageCharArray = message.toCharArray();
		ArrayList <Character> messageArrayList = new ArrayList <Character>();
		for (char c : messageCharArray){
			messageArrayList.add(c);
		}
		int i = 0;
		while (i < messageCharArray.length){
			if(temp.isLeaf()){
				returnString += temp.getData();
				temp = root;
				//i++;
			}
			else if(messageCharArray[i] == '0'){
				temp = temp.getLeftChild();
				i++;
			}
			else if(messageCharArray[i] == '1'){
				temp = temp.getRightChild();
				i++;
			}
			
		}
		returnString += temp.getData();
		return returnString;	
	}

	private static BinaryNodeInterface<Character> createTree ( ArrayList<Character> chars){
		BinaryNodeInterface<Character> root = new BinaryNode<Character>();
		if (!chars.isEmpty()){
			Character c = chars.get(0);
			chars.remove(0);
			if (c == 'I'){
				if (!root.hasLeftChild()){
					root.setLeftChild( createTree(chars));
				}
				if(!root.hasRightChild()){
					root.setRightChild(createTree(chars));
				}
			}
			if (c == 'L'){
				c = chars.get(0);
				chars.remove(0);
				root.setData(c);
				return root;
			}
		}
		return root;
	}
	
	
}
