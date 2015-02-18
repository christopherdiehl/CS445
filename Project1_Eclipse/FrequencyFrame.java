import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class FrequencyFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		
		FrequencyBag<Integer> normal = new FrequencyBag<Integer>();
		FrequencyBag<Integer> laplace = new FrequencyBag<Integer>();
		FrequencyBag<Integer> uniform = new FrequencyBag<Integer>();
		FrequencyBag<Integer> clock = new FrequencyBag<Integer>();
		
		FrequencyGraphComponent normalFC = new FrequencyGraphComponent(normal, -500, 500, 1);
		FrequencyGraphComponent laplaceFC = new FrequencyGraphComponent(laplace, -500, 500, 1);
		FrequencyGraphComponent uniformFC = new FrequencyGraphComponent(uniform, -500, 500, 1);
		FrequencyGraphComponent clockFC = new FrequencyGraphComponent(clock, 0, 1000, 1);
		
		JPanel normalPanel = new JPanel();
		normalPanel.setLayout(new BorderLayout());
		normalPanel.setBorder(new TitledBorder("Normal Distribution"));
		normalPanel.add(normalFC);
		
		JPanel laplacePanel = new JPanel();
		laplacePanel.setLayout(new BorderLayout());
		laplacePanel.setBorder(new TitledBorder("Laplace Distribution"));
		laplacePanel.add(laplaceFC);
		
		JPanel uniformPanel = new JPanel();
		uniformPanel.setLayout(new BorderLayout());
		uniformPanel.setBorder(new TitledBorder("Uniform Distribution"));
		uniformPanel.add(uniformFC);
		
		JPanel clockPanel = new JPanel();
		clockPanel.setLayout(new BorderLayout());
		clockPanel.setBorder(new TitledBorder("Clock Distributioin"));
		clockPanel.add(clockFC);
		
		frame.setSize(800,800);
		frame.setTitle("Probability Distributions");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2,2));
		frame.add(normalPanel);
		frame.add(laplacePanel);
		frame.add(uniformPanel);
		frame.add(clockPanel);
		frame.setVisible(true);
		
		for(int i = 0; i < 20000; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				normal.add(RandomDistribution.normalDistributionInt(-500, 500));
				laplace.add(RandomDistribution.laplaceDistributionInt(-500, 500));
				uniform.add(RandomDistribution.uniformDistributionInt(-500, 500));
				clock.add(RandomDistribution.clockDistribution(0, 1000, 50, 50));
			}
			normalFC.repaint();
			laplaceFC.repaint();
			uniformFC.repaint();
			clockFC.repaint();
			Thread.sleep(1);
		}
	}

}
