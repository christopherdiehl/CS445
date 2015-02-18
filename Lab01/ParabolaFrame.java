import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ParabolaFrame
{
	public static void main(String[] args)
	{
		// Create an empty list of points (x,y) using Pair<Double,Double>
		
		ArrayList<PairInterface<Double,Double>> data = new ArrayList<PairInterface<Double,Double>>();
		
		// Generate (x,y) points: y = (8/25)x^2 - 3 from -5.0 to 5.0 at
		// at every 0.01.
		
		for(double i = -5.0; i <= 5.0; i = i + 0.01)
		{
			data.add(new Pair<Double,Double>(i,(((i*i)*8)/25)-3));
		}

		// Show the Parabola graph
		
		GraphComponent gc = new GraphComponent(data);
		JLabel label = new JLabel("Good Job!!!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JFrame frame = new JFrame();
		frame.setTitle("Example of Using Pair");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gc);
		frame.add(label, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}
