import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class THComponent extends JComponent
{
	private int width;
	private int height;
	private int leftMargin = 10;
	private int rightMargin = 10;
	private int topMargin = 10;
	private int bottomMargin = 10;
	private int baseHeight = 10;
	private double poleWidth = 10;
	private TowerOfHanoi towers;
	private int numberOfDiscs;
	private double largestDiscSize;
	private double smallestDiscSize = 20;
	private double defaultReductionSize = 20.0;
	private double defaultDiscHeight = 20.0;
	private double[] discSizes;
	
	public THComponent(TowerOfHanoi aTowers)
	{
		towers = aTowers;
		numberOfDiscs = towers.getNumberOfDiscs();
		discSizes = new double[numberOfDiscs];
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		width = this.getWidth();
		height = this.getHeight();

		int drawingWidth = width - (leftMargin + rightMargin);
		int drawingHeight = height - (topMargin + bottomMargin);

		// draw the base;
		
		Rectangle2D.Double rect = new Rectangle2D.Double(leftMargin , height - (bottomMargin + baseHeight), drawingWidth, baseHeight);
		g2.draw(rect);
		
		// draw poles;
		
		double halfDistance = ((double) drawingWidth / 6);
		largestDiscSize = (halfDistance * 2) - poleWidth;
		
		for(int i = 1; i <= 5; i = i + 2)
		{
			rect.setRect((leftMargin + (halfDistance * i)) - (poleWidth / 2), topMargin, poleWidth, drawingHeight - baseHeight);
			g2.draw(rect);
		}
		
		// draw discs
		
		double totalReduction = (largestDiscSize - smallestDiscSize) / (numberOfDiscs - 1);
		double actualReduction;
		
		if(totalReduction > defaultReductionSize)
		{
			actualReduction = defaultReductionSize;
		}
		else
		{
			actualReduction = totalReduction;
		}
		
		double totalHeight = drawingHeight - baseHeight;
		double tempDiscHeight = totalHeight / (numberOfDiscs + 1);
		double actualDiscHeight;
		
		if(tempDiscHeight > defaultDiscHeight)
		{
			actualDiscHeight = defaultDiscHeight;
		}
		else
		{
			actualDiscHeight = tempDiscHeight;
		}
		
		for(int i = 0; i < numberOfDiscs; i++)
		{
			discSizes[i] = largestDiscSize - (actualReduction * ((numberOfDiscs - 1) - i));
		}
		
		int[][] t = new int[3][];
		for(int i = 0; i < 3; i++)
		{
			t[i] = towers.getArrayOfDiscs(i);
		}
			
		for(int i = 0; i <= 2; i++)
		{
			for(int j = 0; j < t[i].length; j++)
			{
				double x = (leftMargin + (halfDistance * (1 + (2 * i)))) - (discSizes[t[i][j]] / 2);
				double y = ((topMargin + drawingHeight) - baseHeight) - (actualDiscHeight * (j + 1));
				rect.setRect(x,y,discSizes[t[i][j]],actualDiscHeight);
				g2.setColor(Color.GREEN);
				g2.fill(rect);
				g2.setColor(Color.BLACK);
				g2.draw(rect);
			}
		}
	}
}
