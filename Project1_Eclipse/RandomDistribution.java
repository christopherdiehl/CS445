import java.util.Random;


public class RandomDistribution
{
	public static int normalDistributionInt(int min, int max)
	{
		int result;
		do
		{
			result = (int) Math.round(boxMuller() * 100);
		}
		while(result < min || result > max);
		
		return result;
	}
	
	private static double boxMuller()
	{
		Random rand = new Random();
		double u = rand.nextDouble();
		double v = rand.nextDouble();
		return Math.sqrt(-2 * (Math.log(u)/Math.log(Math.E))) * Math.cos(2 * Math.PI * v);
	}
	
	public static int laplaceDistributionInt(int min, int max)
	{
		int result;
		do
		{
			result = (int) Math.round(laplaceDistribution() * 100);
		}
		while(result < min || result > max);
		
		return result;
	}
	
	private static double laplaceDistribution()
	{
		Random rand = new Random();
		double u = rand.nextDouble() - 0.5;
		
		return 0 - (Math.signum(u) * Math.log(1 - (2 * Math.abs(u))));
	}

	public static int uniformDistributionInt(int min, int max)
	{
		Random rand = new Random();
		
		return rand.nextInt((max - min) + 1) + min;
	}
	
	public static int clockDistribution(int min, int max, int hWidth, int lWidth)
	{
		int result;
		
		do
		{
			result = uniformDistributionInt(min, max);
			int modResult = result % (hWidth + lWidth);
			if(modResult < hWidth)
			{
				break;
			}
			else
			{
				if(uniformDistributionInt(0,1) == 1)
				{
					break;
				}
			}
		}
		while(true);
		
		return result;
	}
}
