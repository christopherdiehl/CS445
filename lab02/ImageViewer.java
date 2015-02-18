import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageViewer
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("pgh_640x480.jpg");
		BufferedImage originalImage = ImageIO.read(file);
		
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();

		final SimpleRGB[] rgb = new SimpleRGB[5];
		rgb[0] = new SimpleRGB(width, height);
		
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				Color c = new Color(originalImage.getRGB(j,i));
				rgb[0].setRed(j, i, c.getRed());
				rgb[0].setGreen(j, i, c.getGreen());
				rgb[0].setBlue(j,  i, c.getBlue());
			}
		}
		
		rgb[1] = rgb[0].getRedImage();
		rgb[2] = rgb[0].getGreenImage();
		rgb[3] = rgb[0].getBlueImage();
		rgb[4] = rgb[0].getGreyImage();
		
		final RGBComponent rgbc = new RGBComponent(rgb[0]);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,5));

		JButton[] button = new JButton[5];
		button[0] = new JButton("RGB");
		button[1] = new JButton("Red");
		button[2] = new JButton("Green");
		button[3] = new JButton("Blue");
		button[4] = new JButton("Greyscale");

		class colorButtonListener implements ActionListener
		{
			private int index;
			
			public colorButtonListener(int anIndex)
			{
				index = anIndex;
			}
			
			public void actionPerformed(ActionEvent arg0)
			{
				rgbc.setImage(rgb[index]);
			}
		}
		
		ActionListener[] cbl = new colorButtonListener[5];
		for(int i = 0; i < 5; i++)
		{
			cbl[i] = new colorButtonListener(i);
			button[i].addActionListener(cbl[i]);
			buttonPanel.add(button[i]);
		}
		
		JFrame frame = new JFrame("Image Viewer");
		frame.setSize(642,534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(rgbc);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}
