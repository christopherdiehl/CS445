import javax.swing.JFrame;


public class InfiniteIntegerCalculator
{
	public static void main(String[] args)
	{
		JFrame frame = new InfiniteIntegerCalculatorFrame();
		frame.setTitle("Infinite Integer Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,300);
		frame.setVisible(true);
	}
}
