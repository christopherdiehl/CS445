
public class SimpleRGBTester
{
	public static void main(String[] args)
	{
		int width = 500;
		int height = 650;
		int x = 123;
		int y = 321;
		int red = 1;
		int green = 11;
		int blue = 111;
		int point = 0;
		SimpleRGB rgb = new SimpleRGB(width, height);

		System.out.println("Constructing an SimpleRGB object using the following statement:");
		System.out.println("   SimpleRGB rgb = new SimpleRGB(" + width + "," + height + ");");
		
		// Testing the method getWidth()
		
		System.out.print("Testing the method getWidth(): ");
		
		if(rgb.getWidth() != width)
		{
			System.out.println("FAIL");
			System.out.println("You method getWidth() should return " + width + ".");
			System.out.println("But your method getWidth() return " + rgb.getWidth() + ".\n");
		}
		else
		{
			point++;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");
		
		// Testing the method getHeight()
		
		System.out.print("Testing the method getHeight(): ");
		
		if(rgb.getHeight() != height)
		{
			System.out.println("FAIL");
			System.out.println("You method getHeight() should return " + height + ".");
			System.out.println("But your method getHeight() return " + rgb.getHeight() + ".\n");
		}
		else
		{
			point++;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");
		
		// Testing methods setRed() and getRed()
		
		System.out.print("Testing method setRed() and getRed(): ");
		
		rgb.setRed(x, y, red);
		
		if(rgb.getRed(x,y) != red)
		{
			System.out.println("FAIL");
			System.out.println("After calling rgb.setRed(" + x + "," + y + "," + red + ")");
			System.out.println("The method rgb.getRed(" + x + "," + y + ") should return " + red + ".");
			System.out.println("But your method rgb.getRed(" + x + "," + y + ") return " + rgb.getRed(x, y) + ".\n");
		}
		else
		{
			point += 1;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");

		// Testing methods setGreen() and getGreen()
		
		System.out.print("Testing method setGreen() and getGreen(): ");
		
		rgb.setGreen(x, y, green);
		
		if(rgb.getGreen(x,y) != green)
		{
			System.out.println("FAIL");
			System.out.println("After calling rgb.setGreen(" + x + "," + y + "," + green + ")");
			System.out.println("The method rgb.getGreen(" + x + "," + y + ") should return " + green + ".");
			System.out.println("But your method rgb.getGreen(" + x + "," + y + ") return " + rgb.getGreen(x, y) + ".\n");
		}
		else
		{
			point += 1;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");
		
		// Testing methods setBlue() and getBlue()
		
		System.out.print("Testing method setBlue() and getBlue(): ");
		
		rgb.setBlue(x, y, blue);
		
		if(rgb.getBlue(x,y) != blue)
		{
			System.out.println("FAIL");
			System.out.println("After calling rgb.setBlue(" + x + "," + y + "," + blue + ")");
			System.out.println("The method rgb.getBlue(" + x + "," + y + ") should return " + blue + ".");
			System.out.println("But your method rgb.getBlue(" + x + "," + y + ") return " + rgb.getBlue(x, y) + ".\n");
		}
		else
		{
			point += 1;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");
		
		// getRedImage();
		
		System.out.print("Testing method getRedImage(): ");
		
		SimpleRGB redImage = rgb.getRedImage();
		
		if(redImage.getRed(x, y) != red || redImage.getGreen(x,y) != 0 || redImage.getBlue(x,y) != 0)
		{
			System.out.println("FAIL");
			System.out.println("The variable redImage of type SimpleRGB was initialized using the following statement:");
			System.out.println("   SimpleRGB redImage = rgb.getRedImage();");
			System.out.println("The (R,G,B) values of the rgb image at (" + x + "," + y + ") are (" + red + "," + green + "," + blue + ").");
			System.out.println("The (R,G,B) values of the redImage at (" + x + "," + y + ") should be (" + red + ",0,0).");
			System.out.println("But your method");
			System.out.println("   redImage.getRed(" + x + "," + y + ") returns " + redImage.getRed(x,y) + ".");
			System.out.println("   redImage.getGreen(" + x + "," + y + ") returns " + redImage.getGreen(x,y) + ".");
			System.out.println("   redImage.getBlue(" + x + "," + y + ") returns " + redImage.getBlue(x,y) + ".");
		}
		else
		{
			point += 1;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");
		
		// getGreenImage();
		
		System.out.print("Testing method getGreenImage(): ");
		
		SimpleRGB greenImage = rgb.getGreenImage();
		
		if(greenImage.getRed(x, y) != 0 || greenImage.getGreen(x,y) != green || greenImage.getBlue(x,y) != 0)
		{
			System.out.println("FAIL");
			System.out.println("The variable greenImage of type SimpleRGB was initialized using the following statement:");
			System.out.println("   SimpleRGB greenImage = rgb.getGreenImage();");
			System.out.println("The (R,G,B) values of the rgb image at (" + x + "," + y + ") are (" + red + "," + green + "," + blue + ").");
			System.out.println("The (R,G,B) values of the greenImage at (" + x + "," + y + ") should be (0," + green + ",0).");
			System.out.println("But your method");
			System.out.println("   greenImage.getRed(" + x + "," + y + ") returns " + greenImage.getRed(x,y) + ".");
			System.out.println("   greenImage.getGreen(" + x + "," + y + ") returns " + greenImage.getGreen(x,y) + ".");
			System.out.println("   greenImage.getBlue(" + x + "," + y + ") returns " + greenImage.getBlue(x,y) + ".");
		}
		else
		{
			point += 1;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");

		// getBlueImage();
		
		System.out.print("Testing method getBlueImage(): ");
		
		SimpleRGB blueImage = rgb.getBlueImage();
		
		if(blueImage.getRed(x, y) != 0 || blueImage.getGreen(x,y) != 0 || blueImage.getBlue(x,y) != blue)
		{
			System.out.println("FAIL");
			System.out.println("The variable blueImage of type SimpleRGB was initialized using the following statement:");
			System.out.println("   SimpleRGB blueImage = rgb.getBlueImage();");
			System.out.println("The (R,G,B) values of the rgb image at (" + x + "," + y + ") are (" + red + "," + green + "," + blue + ").");
			System.out.println("The (R,G,B) values of the blueImage at (" + x + "," + y + ") should be (0,0," + blue + ").");
			System.out.println("But your method");
			System.out.println("   blueImage.getRed(" + x + "," + y + ") returns " + blueImage.getRed(x,y) + ".");
			System.out.println("   blueImage.getGreen(" + x + "," + y + ") returns " + blueImage.getGreen(x,y) + ".");
			System.out.println("   blueImage.getBlue(" + x + "," + y + ") returns " + blueImage.getBlue(x,y) + ".");
		}
		else
		{
			point += 1;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");
		
		// getGreyImage();
		
		System.out.print("Testing method getGreyImage(): ");
		
		SimpleRGB greyImage = rgb.getGreyImage();
		
		int greyValue = (int) ((0.21 * rgb.getRed(x, y)) + (0.72 * rgb.getGreen(x,y)) + (0.07 * rgb.getBlue(x,y)));
		
		if(greyImage.getRed(x, y) != greyValue || greyImage.getGreen(x,y) != greyValue || greyImage.getBlue(x,y) != greyValue)
		{
			System.out.println("FAIL");
			System.out.println("The variable greyImage of type SimpleRGB was initialized using the following statement:");
			System.out.println("   SimpleRGB greyImage = rgb.getGreyImage();");
			System.out.println("The (R,G,B) values of the rgb image at (" + x + "," + y + ") is (" + red + "," + green + "," + blue + ").");
			System.out.println("The (R,G,B) values of the greyImage at (" + x + "," + y + ") should be (" + greyValue + "," + greyValue + "," + greyValue + ").");
			System.out.println("But your method");
			System.out.println("   greyImage.getRed(" + x + "," + y + ") returns " + greyImage.getRed(x,y) + ".");
			System.out.println("   greyImage.getGreen(" + x + "," + y + ") returns " + greyImage.getGreen(x,y) + ".");
			System.out.println("   greyImage.getBlue(" + x + "," + y + ") returns " + greyImage.getBlue(x,y) + ".");
		}
		else
		{
			point += 2;
			System.out.println("PASS");
		}
		System.out.println("You current point is " + point + ".\n");
		
		System.out.println("Your final point is " + point + ".");
		
		if(point == 10)
		{
			System.out.println("Contratulation! Your class SimpleRGB works perfectly (I guess).");
			System.out.println("You can run ImageViewer to see how SimpleRGB can be used in a program.");
		}
		else
		{
			System.out.println("There is one or more errors in your class.");
			System.out.println("Fix your bugs to get more points.");
		}		
	}
}
