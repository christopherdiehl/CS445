import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InfiniteIntegerCalculatorFrame extends JFrame
{
	private JButton[] numberButtons;	// number buttons (0 to 9)
	private JButton plusButton;			// plus button (+)
	private JButton minusButton;		// minus button (-)
	private JButton multiplyButton;		// multiply button (*)
	private JButton backButton;			// back button (<-)
	private JButton equalButton;		// equal button (=)
	private JButton clearButton;		// clear button (C)
	private JTextArea textArea;			// Text area for expression and result
	private JPanel buttonPanel;			// panel for all buttons
	private ArrayList<String> ppString;	// Pretty printing string
	private KeyListener kListener;
	
	public InfiniteIntegerCalculatorFrame()
	{
		textArea = new JTextArea();
		textArea.setText("0");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		kListener = new KeyEvent();
		textArea.addKeyListener(kListener);
		
		Font font = new Font(Font.SERIF, Font.BOLD, 20);
		textArea.setFont(font);

		setButtonsAndPanel();

		add(buttonPanel, BorderLayout.EAST);
		add(textArea, BorderLayout.CENTER);
		
		ppString = new ArrayList<String>();
		ppString.add("0");
	}
	
	public class KeyEvent implements KeyListener
	{
		public void keyPressed(java.awt.event.KeyEvent arg0)
		{
			int keyCode = arg0.getKeyCode();
			char keyChar = arg0.getKeyChar();
			
			if(keyCode >= 48 && keyCode <=57 && keyChar != '*')
			{
				ButtonListener bl = new ButtonListener(keyCode - 48);
				bl.actionPerformed(new ActionEvent(numberButtons[keyCode - 48], 1001, "" + (keyCode - 48)));
			}
			else if(keyCode >= 96 && keyCode <= 105)
			{
				ButtonListener bl = new ButtonListener(keyCode - 96);
				bl.actionPerformed(new ActionEvent(numberButtons[keyCode - 96], 1001, "" + (keyCode - 96)));
			}
			else if(keyCode == 61 && keyChar == '+')
			{
				ButtonListener bl = new ButtonListener(10);
				bl.actionPerformed(new ActionEvent(equalButton, 1001, "+"));
			}
			else if(keyCode == 107)
			{
				ButtonListener bl = new ButtonListener(10);
				bl.actionPerformed(new ActionEvent(equalButton, 1001, "+"));
			}
			else if(keyCode == 45 && keyChar == '-')
			{
				ButtonListener bl = new ButtonListener(11);
				bl.actionPerformed(new ActionEvent(minusButton, 1001, "-"));
			}
			else if(keyCode == 109)
			{
				ButtonListener bl = new ButtonListener(11);
				bl.actionPerformed(new ActionEvent(minusButton, 1001, "-"));
			}
			else if(keyCode == 56 && keyChar == '*')
			{
				ButtonListener bl = new ButtonListener(12);
				bl.actionPerformed(new ActionEvent(multiplyButton, 1001, "*"));
			}
			else if(keyCode == 106)
			{
				ButtonListener bl = new ButtonListener(12);
				bl.actionPerformed(new ActionEvent(multiplyButton, 1001, "*"));
			}
			else if(keyCode == 8)
			{
				ButtonListener bl = new ButtonListener(13);
				bl.actionPerformed(new ActionEvent(backButton, 1001, "<-"));
			}
			else if(keyCode == 61 && keyChar == '=')
			{
				ButtonListener bl = new ButtonListener(14);
				bl.actionPerformed(new ActionEvent(equalButton, 1001, "="));
			}
			else if(keyCode == 10)
			{
				ButtonListener bl = new ButtonListener(14);
				bl.actionPerformed(new ActionEvent(equalButton, 1001, "="));
			}
			else if(keyCode == 67)
			{
				ButtonListener bl = new ButtonListener(15);
				bl.actionPerformed(new ActionEvent(clearButton, 1001, "C"));
			}
		}

		public void keyReleased(java.awt.event.KeyEvent arg0)
		{
		}

		public void keyTyped(java.awt.event.KeyEvent arg0)
		{
		}
	}
	
	/**
	 * setButtonsAndPanel
	 * 
	 * Initialize all buttons, initialize the button panel,
	 * and add all buttons into button panel.
	 */
	private void setButtonsAndPanel()
	{
		numberButtons = new JButton[10];
		ButtonListener[] nbls = new ButtonListener[16];
		for(int i = 0; i <= 9; i++)
		{
			numberButtons[i] = new JButton("" + i);
			nbls[i] = new ButtonListener(i);
			numberButtons[i].addActionListener(nbls[i]);
		}
		
		plusButton = new JButton("+");
		nbls[10] = new ButtonListener(10);
		plusButton.addActionListener(nbls[10]);
		
		minusButton = new JButton("-");
		nbls[11] = new ButtonListener(11);
		minusButton.addActionListener(nbls[11]);
		
		multiplyButton = new JButton("*");
		nbls[12] = new ButtonListener(12);
		multiplyButton.addActionListener(nbls[12]);
		
		backButton = new JButton("<-");
		nbls[13] = new ButtonListener(13);
		backButton.addActionListener(nbls[13]);
		
		equalButton = new JButton("=");
		nbls[14] = new ButtonListener(14);
		equalButton.addActionListener(nbls[14]);
		
		clearButton = new JButton("C");
		nbls[15] = new ButtonListener(15);
		clearButton.addActionListener(nbls[15]);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4));
		
		buttonPanel.add(numberButtons[7]);
		buttonPanel.add(numberButtons[8]);
		buttonPanel.add(numberButtons[9]);
		buttonPanel.add(plusButton);
		buttonPanel.add(numberButtons[4]);
		buttonPanel.add(numberButtons[5]);
		buttonPanel.add(numberButtons[6]);
		buttonPanel.add(minusButton);
		buttonPanel.add(numberButtons[1]);
		buttonPanel.add(numberButtons[2]);
		buttonPanel.add(numberButtons[3]);
		buttonPanel.add(multiplyButton);
		buttonPanel.add(numberButtons[0]);
		buttonPanel.add(equalButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(backButton);
	}

	private class ButtonListener implements ActionListener
	{
		private int number;
		
		private ButtonListener(int aNumber)
		{
			/* Number associated with each button as follows:
			 *   - 0 to 9 for number buttons
			 *   - 10 for +
			 *   - 11 for -
			 *   - 12 for *
			 *   - 13 for <-
			 *   - 14 for =
			 *   - 15 for C
			 */
			number = aNumber;
		}
		
		public void actionPerformed(ActionEvent arg0)
		{
			int ppSize = ppString.size();
			boolean error = false;
			
			if(number < 10)
			{
				if(ppSize == 1)
				{
					String temp = ppString.get(0);
					
					if(temp.equals("+") || temp.equals("*"))
					{
						ppString.add("" + number);
					}
					else if(temp.equals("0"))
					{
						ppString.set(0, "" + number);
					}
					else
					{
						ppString.set(0,temp + number);
					}
				}
				else
				{
					String temp = ppString.get(ppSize - 1);
					
					if(temp.equals("+") || temp.equals("*"))
					{
						ppString.add("" + number);
					}
					else if(temp.equals("-"))
					{
						if(ppString.get(ppSize - 2).equals("+") || ppString.get(ppSize - 2).equals("*"))
						{
							ppString.set(ppSize - 1, temp + number);
						}
						else
						{
							ppString.add("" + number);
						}
					}
					else
					{
						ppString.set(ppSize - 1, temp + number);
					}
				}
			}
			else if(number == 10)
			{
				ppString.add("+");
			}
			else if(number == 11)
			{
				ppString.add("-");
			}
			else if(number == 12)
			{
				ppString.add("*");
			}
			else if(number == 13)
			{
				if(ppSize > 0)
				{
					String temp = ppString.get(ppSize - 1);
				
					if(temp.length() > 1)
					{
						ppString.set(ppSize - 1, temp.substring(0, temp.length() - 1));
					}
					else
					{
						ppString.remove(ppSize - 1);
					}
				}
			}
			else if(number == 14)
			{
				InfiniteIntegerInterface result = calculateResult();
				
				if(result == null)
				{
					error = true;
				}
				else
				{
					ppString.clear();
					ppString.add(result.toString());
				}
			}
			else if(number == 15)
			{
				ppString.clear();
				ppString.add("0");
			}
			
			// Set textArea according to ppString
			
			ppSize = ppString.size();
			String displayString = "";

			if(ppSize > 0)
			{
				for(int i = 0; i < ppSize; i++)
				{
					displayString = displayString + ppString.get(i) + " ";
				}
			}
			else
			{
				displayString = "0";
			}
			
			if(error)
			{
				displayString = displayString + "\nInvalid Expression";
			}
			
			textArea.setText(displayString);
		}
	}
	
	/**
	 * calculateResult()
	 * 
	 * This method constructs a postfix expression base on the infix expression
	 * stored in the array list of string ppString using stack as explained in
	 * class. Then evaluate the postfix expression using stack.
	 * 
	 * @return an infinite integer as a result if the expression is valid.
	 * Otherwise, return null to indicate invalid expression.
	 */
	private InfiniteIntegerInterface calculateResult()
	{
		ArrayList<String> postFix = new ArrayList<String>();		// Postfix expression
		StackInterface<String> operators = new LStack<String>();	// Stack to store operators
		
		// Convert infix expression into postfix expression
		
		int expSize = ppString.size();
		
		for(int i = 0; i < expSize; i++)
		{
			String temp = ppString.get(i);
			
			if(temp.length() > 1)
			{
				postFix.add(temp);
			}
			else if(isOperator(temp.charAt(0)))
			{
				if(temp.equals("+") || temp.equals("-"))
				{
					while(!operators.isEmpty())
					{
						postFix.add(operators.pop());
					}
					operators.push(temp);
				}
				else
				{
					while(!operators.isEmpty() && operators.peek().equals("*"))
					{
						postFix.add(operators.pop());
					}
					operators.push(temp);
				}
			}
			else
			{
				postFix.add(temp);
			}
		}
		
		while(!operators.isEmpty())
		{
			postFix.add(operators.pop());
		}
		
		// Display postfix expression
		
		System.out.print("Postfix: ");
		
		for(int i = 0; i < postFix.size(); i++)
		{
			System.out.print(postFix.get(i) + " ");
		}
		System.out.println();
		
		// Evaluate postfix expression
		
		StackInterface<InfiniteIntegerInterface> resultStack = new LStack<InfiniteIntegerInterface>();
		
		int postFixSize = postFix.size();
		
		for(int i = 0; i < postFixSize; i++)
		{
			String temp = postFix.get(i);
			
			if(temp.length() == 1 && isOperator(temp.charAt(0)))
			{
				/* Encounter an operator, pop the top of the stack
				 * twice to use those numbers as operand, calculate
				 * the result, and push the result back onto the
				 * stack.
				 */
				InfiniteIntegerInterface op1, op2;		// operand 1 and 2
				
				if(resultStack.isEmpty())
				{
					return null;				// if the stack is empty, invalid expression
				}
				else
				{
					op2 = resultStack.pop();	// Pop the second operand
				}
				
				if(resultStack.isEmpty())
				{
					return null;				// if the stack is empty, invalid expression
				}
				else
				{
					op1 = resultStack.pop();	// Pop the first operand
				}
				
				/* Calculating result of "op1 operator op2"
				 * and push the result back onto the stack.
				 */
				if(temp.equals("+"))
				{
					resultStack.push(op1.plus(op2));
				}
				else if(temp.equals("-"))
				{
					resultStack.push(op1.minus(op2));
				}
				else
				{
					resultStack.push(op1.multiply(op2));
				}
			}
			else
			{
				// Encounter a number, push the number onto the stack.
				
				resultStack.push(new LInfiniteInteger(temp));
			}
		}
		
		/* The expression is valid if the stack contain exactly
		 * one item. That one single item is the result of evaluating
		 * the arithmetic expression.
		 */
		
		InfiniteIntegerInterface result = null;
		
		if(resultStack.isEmpty())
		{
			return null;				// The stack is empty, invalid expression
		}
		else
		{
			result = resultStack.pop();	// Pop the result out of the stack
			
			if(!resultStack.isEmpty())
			{
				result = null;			// The stack is NOT empty, invalid expression
			}
		}
		
		return result;
	}
	
	/**
	 * isOperator: Return true if the character c is an
	 * operator, +, -, or *. Otherwise, return false.
	 * @param c the character to be tested whether it is
	 * an operator.
	 * @return true if c is an operator. Otherwise, return false.
	 */
	private boolean isOperator(char c)
	{
		return c == '+' || c == '-' || c == '*';
	}
}
