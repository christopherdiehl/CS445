import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class RGBComponent extends JComponent
{
	private SimpleRGB image;
	private int width;
	private int height;
	
	public RGBComponent(SimpleRGB anImage)
	{
		image = anImage;
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Line2D.Double line = new Line2D.Double(0,0,0,0);
		
		// Draw the Board

		for(int w = 0; w < width; w++)
		{
			for(int h = 0; h < height; h++)
			{
				g2.setColor(new Color(image.getRed(w, h), image.getGreen(w, h), image.getBlue(w, h)));
				line.setLine(w, h, w, h);
				g2.draw(line);
			}
		}
	}
	
	public void setImage(SimpleRGB anImage)
	{
		image = anImage;
		repaint();
	}
}
