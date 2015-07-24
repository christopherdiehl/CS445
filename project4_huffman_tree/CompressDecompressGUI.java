import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class CompressDecompressGUI extends JFrame
{
	JPanel inputTextAreaPanel;
	JPanel outputTreePanel;
	JPanel outputCompressPanel;
	JPanel outputDecompressPanel;
	JPanel inputTextPanel;
	JPanel treeTextPanel;
	JPanel outputTextPanel;
	
	JTextArea inputTextArea;
	JTextArea outputTreeArea;
	JTextArea outputCompressArea;
	JTextArea outputDecompressArea;
	
	JScrollPane inputTextPane;
	JScrollPane outputTreePane;
	JScrollPane compressPane;
	JScrollPane decompressPane;
	
	JLabel inputNumberOfCharactersLabel;
	JLabel inputNumberOfBytesLabel;
	JLabel treeNumberOfCharactersLabel;
	JLabel treeNumberOfBytesLabel;
	JLabel outputNumberOfBytesLabel;
	JLabel outputTotalNumberOfBytesLabel;
	JLabel compressLabel;
	KeyListener kListener;
	
	public CompressDecompressGUI()
	{
		setLayout(new GridLayout(2,2));
		
		setTextAreasAndPanels();
	}

	private void setTextAreasAndPanels()
	{
		Font monoFont = new Font("Monospaced", Font.BOLD, 14);
		
		// Input Text
		
		inputTextAreaPanel = new JPanel();
		inputTextAreaPanel.setBackground(Color.WHITE);
		inputTextAreaPanel.setLayout(new BorderLayout());
		inputTextAreaPanel.setBorder(new TitledBorder("Type Your Message Here"));
		
		inputTextArea = new JTextArea();
		inputTextArea.setEditable(true);
		inputTextArea.setLineWrap(true);
		inputTextArea.setFont(monoFont);
		kListener = new InputKeyEvent();
		inputTextArea.addKeyListener(kListener);
		inputTextPane = new JScrollPane(inputTextArea);
		inputTextAreaPanel.add(inputTextPane);
		inputTextPanel = new JPanel();
		inputTextPanel.setLayout(new GridLayout(2,1));
		inputNumberOfCharactersLabel = new JLabel("Number of Characters: 0");
		inputNumberOfBytesLabel = new JLabel("Number of Bytes: 0");
		inputTextPanel.add(inputNumberOfCharactersLabel);
		inputTextPanel.add(inputNumberOfBytesLabel);
		inputTextAreaPanel.add(inputTextPanel, BorderLayout.SOUTH);
		
		// Output Tree
		
		outputTreePanel = new JPanel();
		outputTreePanel.setBackground(Color.WHITE);
		outputTreePanel.setLayout(new BorderLayout());
		outputTreePanel.setBorder(new TitledBorder("Tree Structure"));
		outputTreeArea = new JTextArea();
		outputTreeArea.setEditable(false);
		outputTreeArea.setLineWrap(true);
		outputTreeArea.setFont(monoFont);
		outputTreePane = new JScrollPane(outputTreeArea);
		outputTreePanel.add(outputTreePane);
		treeTextPanel = new JPanel();
		treeTextPanel.setLayout(new GridLayout(2,1));
		treeNumberOfCharactersLabel = new JLabel("Number of Characters: 0");
		treeNumberOfBytesLabel = new JLabel("Number of Bytes: 0");
		treeTextPanel.add(treeNumberOfCharactersLabel);
		treeTextPanel.add(treeNumberOfBytesLabel);
		outputTreePanel.add(treeTextPanel, BorderLayout.SOUTH);
		
		// Compressed Output
		
		outputCompressPanel = new JPanel();
		outputCompressPanel.setBackground(Color.WHITE);
		outputCompressPanel.setLayout(new BorderLayout());
		outputCompressPanel.setBorder(new TitledBorder("Compressed Message"));
		outputCompressArea = new JTextArea();
		outputCompressArea.setEditable(false);
		outputCompressArea.setLineWrap(true);
		outputCompressArea.setFont(monoFont);
		compressPane = new JScrollPane(outputCompressArea);
		outputCompressPanel.add(compressPane);
		outputTextPanel = new JPanel();
		outputTextPanel.setLayout(new GridLayout(3,1));
		outputNumberOfBytesLabel = new JLabel("Number of Bytes: 0");
		outputTotalNumberOfBytesLabel = new JLabel("Total Number of Bytes: 0");
		compressLabel = new JLabel("Compressed to 100% of the original size");
		outputTextPanel.add(outputNumberOfBytesLabel);
		outputTextPanel.add(outputTotalNumberOfBytesLabel);
		outputTextPanel.add(compressLabel);
		outputCompressPanel.add(outputTextPanel, BorderLayout.SOUTH);
		
		// Decompress Output
		
		outputDecompressPanel = new JPanel();
		outputDecompressPanel.setBackground(Color.WHITE);
		outputDecompressPanel.setLayout(new BorderLayout());
		outputDecompressPanel.setBorder(new TitledBorder("Decompress Message"));
		outputDecompressArea = new JTextArea();
		outputDecompressArea.setEditable(false);
		outputDecompressArea.setLineWrap(true);
		outputDecompressArea.setFont(monoFont);
		decompressPane = new JScrollPane(outputDecompressArea);
		outputDecompressPanel.add(decompressPane);
		
		add(inputTextAreaPanel);
		add(outputTreePanel);
		add(outputCompressPanel);
		add(outputDecompressPanel);
	}
	
	private class InputKeyEvent implements KeyListener
	{
		public void keyPressed(KeyEvent arg0)
		{
		}

		public void keyReleased(KeyEvent arg0)
		{
			/* Obtain the string from inputTextArea and
			 * calculate the number of bytes from its length.
			 * Assuming that we use unicode which is two bytes
			 * per character.
			 */
			String str = inputTextArea.getText();
			
			int inputStringLength = str.length();
			int inputStringBytes = str.length() * 2;
			inputNumberOfCharactersLabel.setText("Number of Characters: " + inputStringLength);
			inputNumberOfBytesLabel.setText("Number of Bytes: " + inputStringBytes);
			
			/* Generate Huffman tree from the input string
			 * and obtain the root node of the Huffman tree.			
			 */
			HuffmanTree ht = new HuffmanTree(str);
			BinaryNodeInterface<Character> root = ht.getRootNode();
			
			/* Generate a string representing the Huffman tree rooted
			 * at root and display the string on outputTreeArea.
			 */
			String treeString = CompressDecompress.getTreeString(root);
			outputTreeArea.setText(treeString);
			
			int treeStringLength = treeString.length();
			int treeStringBytes = treeStringLength * 2;
			
			treeNumberOfCharactersLabel.setText("Number of Characters: " + treeStringLength);
			treeNumberOfBytesLabel.setText("Number of Bytes: " + treeStringBytes);
			
			/* Compress the input string (str) using the Huffman tree rooted at
			 * root. The result is a new string containing just 0s and 1s. Then
			 * display the result on outputCompressArea.
			 */
			String compressedString = CompressDecompress.compress(root, str);
			outputCompressArea.setText(compressedString);
			int numBytes = compressedString.length() / 8;
			if(compressedString.length() % 8 != 0)
			{
				numBytes++;
			}
			outputNumberOfBytesLabel.setText("Number of Bytes: " +  numBytes);
			outputTotalNumberOfBytesLabel.setText("Total Number of Bytes: " + (numBytes + treeStringBytes));
			float percentCompression = (float) (numBytes + treeStringBytes) / inputStringBytes * 100; 
			compressLabel.setText("Compressed to " + String.format("%.2f", percentCompression) + "% of the original size");
			
			/* Decompress the compressed string (compressedString) using
			 * the string representing the Huffman tree (treeString). The
			 * result is a new string which should be exactly the same
			 * as the input string (str). Then display the result string
			 * on outputDecompressArea.
			 */
			String decompressedString = CompressDecompress.decompress(treeString, compressedString);
			outputDecompressArea.setText(decompressedString);
		}

		public void keyTyped(KeyEvent arg0)
		{
		}
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new CompressDecompressGUI();
		frame.setSize(700,600);
		frame.setTitle("Huffman Tree - Compression / Decompression");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}