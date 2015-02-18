
public class SimpleRGB
{
	// TO DO: Instant Variables
	int height;
	int width;
	int red [][], green [][], blue [][];

	
	
	
	

	public SimpleRGB(int aWidth, int aHeight)
	{
		// TO DO: Constructor
		height= aHeight;
		width= aWidth;
		red= new int [width][height];
		green= new int [width][height];
		blue= new int [width][height];
		
		
	}
	
	/**
	 * Gets the width of this image.
	 * @return the width of this image.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * assign width and height of the class
	 * allocate memory for the 3 2-d arrays
	 * and initialize the value of the 3 2-d arrays
	 */
	public int getWidth()
	{
		// TO DO
		return width;
	}
	
	/**
	 * Gets the height of this image.
	 * @return the height of this image.
	 */
	public int getHeight()
	{
		// TO DO
		return height;
	}
	
	/**
	 * Sets the red value at coordinate (x,y) to aRed.
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @param aRed the red value (0 - 255)
	 */
	public void setRed(int x, int y, int aRed)
	{
		// TO DO
		//go to the ,y position of the 2-d array and set the value to aRed
		if(aRed>=0 && aRed<=255)
		red[x][y]=aRed;
		
	}

	/**
	 * Sets the green value at coordinate (x,y) to aGreen.
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @param aGreen the green value (0 - 255)
	 */
	public void setGreen(int x, int y, int aGreen)
	{
		// TO DO
		if(aGreen<=255 && aGreen>=0)
		green[x][y]=aGreen;
	}

	/**
	 * Sets the blue value at coordinate (x,y) to aBlue.
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @param aBlue the blue value (0 - 255)
	 */
	public void setBlue(int x, int y, int aBlue)
	{
		// TO DO
		if(aBlue<=255 && aBlue>=0)
		 blue[x][y]=aBlue;
	}
	
	/**
	 * Gets the red value at coordinate (x,y).
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @return the value of red at coordinate (x,y). 
	 */
	public int getRed(int x, int y)
	{
		// TO DO
		return red[x][y];
	}

	/**
	 * Gets the green value at coordinate (x,y).
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @return the value of green at coordinate (x,y). 
	 */
	public int getGreen(int x, int y)
	{
		return green[x][y];
		// TO DO
	}
	
	/**
	 * Gets the blue value at coordinate (x,y).
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @return the value of blue at coordinate (x,y). 
	 */
	public int getBlue(int x, int y)
	{
		// TO DO
		return blue[x][y];
	}
	
	/**
	 * Get the NEW image containing only the red color.
	 * The red values of this new image should be exactly
	 * the same as red value of this image. The green and
	 * blue values of this new image should be 0s.
	 * @return the NEW image (SimpleRGB) containing only
	 * the red color of this image.
	 */
	public SimpleRGB getRedImage()
	{
		// TO DO
		//create a new image (that means a new simpleRGB object)
		//use a nested for-loop to set the red 2-d array of the new simpleRGB to the red 2-d array of this simpleRGB
		//use a nested for-loop to set the green & blue 2-d array to all zeros
		// return the new simpleRGB object
	    SimpleRGB newImage= new SimpleRGB(width,height);
	    for (int x=0; x<newImage.width-1; x++){
	    	for(int y=0; y<newImage.height-1; y++){
	    	 newImage.setRed(x, y, getRed(x,y));
	    	 newImage.setGreen(x, y, 0);
	    	 newImage.setBlue(x, y, 0);
	    	}
	    	
	    }
	    
	    return newImage;
	}
	
	/**
	 * Get the NEW image containing only the green color.
	 * The green values of this new image should be exactly
	 * the same as green value of this image. The red and
	 * blue values of this new image should be 0s.
	 * @return the NEW image (SimpleRGB) containing only
	 * the green color of this image.
	 */
	public SimpleRGB getGreenImage()
	{
		// TO DO
		SimpleRGB newImage= new SimpleRGB(width,height);
	    for (int x=0; x<newImage.width-1; x++){
	    	for(int y=0; y<newImage.height-1; y++){
	    	 newImage.setGreen(x,y, getGreen(x,y));
	    	 newImage.setRed(x, y, 0);
	    	 newImage.setBlue(x, y, 0);
	    	}
	    	
	    }
	    
	    return newImage;
	}
	
	/**
	 * Get the NEW image containing only the blue color.
	 * The blue values of this new image should be exactly
	 * the same as blue value of this image. The red and
	 * green values of this new image should be 0s.
	 * @return the NEW image (SimpleRGB) containing only
	 * the blue color of this image.
	 */
	public SimpleRGB getBlueImage()
	{
		// TO DO
		SimpleRGB newImage= new SimpleRGB(width,height);
	    for (int x=0; x<newImage.width-1; x++){
	    	for(int y=0; y<newImage.height-1; y++){
	    	 newImage.setBlue(x,y, getBlue(x,y));
	    	 newImage.setGreen(x, y, 0);
	    	 newImage.setRed(x, y, 0);
	    	}	
	    }
	    
	    return newImage;
	}
	
	/**
	 * Get the NEW image representing the greyscale of this
	 * image. The grey colors are colors that the red, green
	 * and blue value are exactly the same. To convert an RGB
	 * image into a greyscale image, use the following formula
	 * to calculate the new value.
	 *    (0.21 * red) + (0.72 * green) + (0.07 * blue)
	 * For example, suppose the (R,G,B) value of this image at
	 * coordinate (10,20) are (10,100,200), since
	 *    (0.21 * 10) + (0.72 * 100) + (0.07 * 200) = 88
	 * the (R,G,B) value of the new greyscale image at (10,20)
	 * should be (88,88,88).
	 * @return the NEW image representing the greyscale of this
	 * image.
	 */
	public SimpleRGB getGreyImage()
	{
		// TO DO
		//for int
		//greyColor [x] [y]= (0.21 * red) + (0.72 * green) + (0.07 * blue);
		// red [x][y] =green[x][y]=blue[x][y]=greyColor[x][y];
		SimpleRGB newImage= new SimpleRGB(width,height);
		int greyColor [][]=new int [width][height];
	    for (int x=0; x<newImage.width-1; x++){
	    	for(int y=0; y<newImage.height-1; y++){
	    	  greyColor[x][y]= (int) ( (0.21 * getRed(x,y)) + (0.72 * getGreen(x,y)) + (0.07 * getBlue(x,y)) );
	    	  newImage.setRed(x, y, greyColor[x][y]);
	    	  newImage.setGreen(x, y, greyColor[x][y]);
	    	  newImage.setBlue(x, y, greyColor[x][y]);
	    	  
	    	} 
	    	
	    }
	    
	    return newImage;
	}
}
