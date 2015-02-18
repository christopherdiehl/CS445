import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class GraphComponent extends JComponent
{
	private int leftMargin = 10;
	private int rightMargin = 10;
	private int topMargin = 10;
	private int bottomMargin = 10;
	private double largest;
	private double largestX;
	private double smallestX;
	private double largestY;
	private double smallestY;
	private int numData;
	private int width;
	private int height;
	private ArrayList<PairInterface<Double,Double>> data;
	
	public GraphComponent(ArrayList<PairInterface<Double,Double>> aData)
	{
		data = aData;
		numData = data.size();
		PairInterface<Double,Double> tempData = data.get(0);

		largestX = tempData.fst();
		smallestX = largestX;
		largestY = tempData.snd();
		smallestY = largestY;
		
		for(int i = 1; i < numData; i++)
		{
			tempData = data.get(i);

			if(largestX < tempData.fst())
			{
				largestX = tempData.fst();
			}

			if(smallestX > tempData.fst())
			{
				smallestX = tempData.fst();
			}

			if(largestY < tempData.snd())
			{
				largestY = tempData.snd();
			}

			if(smallestY > tempData.snd())
			{
				smallestY = tempData.snd();
			}
		}
		
		if(Math.abs(largestX) < Math.abs(smallestX))
		{
			largestX = Math.abs(smallestX);
		}
		else
		{
			largestX = Math.abs(largestX);
		}
		
		if(Math.abs(largestY) < Math.abs(smallestY))
		{
			largestY = Math.abs(smallestY);
		}
		else
		{
			largestY = Math.abs(largestY);
		}
		
		if(largestX > largestY)
		{
			largest = largestX;
		}
		else
		{
			largest = largestY;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		width = this.getWidth();
		height = this.getHeight();

		
		
		Line2D.Double line = new Line2D.Double(0,0,0,0);
		
		// Draw Axis;
		
		g2.setColor(Color.BLACK);

		line.setLine(getX(0),getY(0),getX(-largest),getY(0));
		g2.draw(line);
		line.setLine(getX(0),getY(0),getX(0),getY(largest));
		g2.draw(line);
		line.setLine(getX(0),getY(0),getX(largest),getY(0));
		g2.draw(line);
		line.setLine(getX(0),getY(0),getX(0),getY(-largest));
		g2.draw(line);
		
		// Draw frequency the graph
		
		g2.setColor(Color.GREEN);
		
		for(int i = 0; i < numData - 1; i++)
		{
			line.setLine(getX(data.get(i).fst()), getY(data.get(i).snd()), getX(data.get(i + 1).fst()), getY(data.get(i + 1).snd()));
			g2.draw(line);
		}
	}
	
	public int getX(double aValue)
	{
		int numberOfPixels = width - (leftMargin + rightMargin);
		double range = largest + largest;
		double deltaWidth = numberOfPixels / range;
		return (int) ((aValue + largest) * deltaWidth) + leftMargin;
	}
	
	public int getY(double aValue)
	{
		int numberOfPixels = height - (topMargin + bottomMargin);
		double range = largest + largest;
		double deltaWidth = numberOfPixels / range;
		return (int) ((-aValue + largest) * deltaWidth) + topMargin;
	}
}
