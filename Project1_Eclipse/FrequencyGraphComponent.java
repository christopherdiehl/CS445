import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class FrequencyGraphComponent extends JComponent
{
	private FrequencyBag<Integer> fb;
	private int min;
	private int max;
	private int delta;
	private int width;
	private int height;
	private int leftMargin = 10;
	private int rightMargin = 10;
	private int topMargin = 10;
	private int bottomMargin = 10;
	
	public FrequencyGraphComponent(FrequencyBag<Integer> afb, int aMin, int aMax, int aDelta)
	{
		fb = afb;
		min = aMin;
		max = aMax;
		delta = aDelta;
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		
		width = this.getWidth();
		height = this.getHeight();

		int maxFrequency = fb.getMaxFrequency();
		double deltaWidth = (double) (width - (leftMargin + rightMargin)) / ((max - min) / delta);
		double deltaHeight = (double) (height - (topMargin + bottomMargin)) / maxFrequency;
		
		Line2D.Double line = new Line2D.Double(0,0,0,0);
		
		for(int i = min; i < max; i = i + delta)
		{
			double sx = ((i - min) * deltaWidth) + leftMargin;
			double ex = (((i + delta) - min) * deltaWidth) + leftMargin;
			double sy = (height - bottomMargin) - (fb.getFrequencyOf(i) * deltaHeight);
			double ey = (height - bottomMargin) - (fb.getFrequencyOf(i + delta) * deltaHeight);
			line.setLine(sx,sy,ex,ey);
			g2.draw(line);
		}
		
		g2.setColor(Color.GREEN);
		double accProp = 0.0;
			
		for(int i = min; i < max; i = i + delta)
		{
			accProp = accProp + fb.getProbabilityOf(i);
			double nextProp = fb.getProbabilityOf(i + delta);
				
			double sx = ((i - min) * deltaWidth) + leftMargin;
			double ex = (((i + delta) - min) * deltaWidth) + leftMargin;
			double sy = (height - bottomMargin) * (1 - accProp);
			double ey = (height - bottomMargin) * (1 - (accProp + nextProp));
			line.setLine(sx,sy,ex,ey);
			g2.draw(line);
		}
	}
}
