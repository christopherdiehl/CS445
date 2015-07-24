import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class VisualSortingComponent extends JComponent
{
	private int leftMargin = 10;
	private int rightMargin = 10;
	private int topMargin = 10;
	private int bottomMargin = 10;
	private int max;
	private int min;
	private int width;
	private int height;
	private int[] data;
	private int numData;
	
	public VisualSortingComponent(int[] aData)
	{
		data = aData;
		numData = data.length;
		
		if(numData > 0)
		{
			max = data[0];
			min = data[0];
			
			for(int i = 1; i < numData; i++)
			{
				if(data[i] > max)
				{
					max = data[i];
				}
				
				if(min > data[i])
				{
					min = data[i];
				}
			}
		}
	}
		
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		width = this.getWidth();
		height = this.getHeight();

		double dataWidth = (width - (leftMargin + rightMargin)) / numData;
		double heightFactor = (height - (topMargin + bottomMargin)) / numData;
		
		// draw the base;
		
		Line2D.Double line = new Line2D.Double(leftMargin, height - bottomMargin, width - leftMargin, height - bottomMargin);
		g2.draw(line);
		
		// draw aata
		
		Rectangle2D.Double rect = new Rectangle2D.Double(0,0,0,0);
		
		for(int i = 0; i < numData; i++)
		{
			double x = leftMargin + (dataWidth * i);
			double y = (height - bottomMargin) - (heightFactor * data[i]);
			rect.setRect(x,y,dataWidth,data[i] * heightFactor);
			
			g2.setColor(Color.GREEN);
			g2.fill(rect);
			g2.setColor(Color.BLACK);
			g2.draw(rect);
		}
	}
}
