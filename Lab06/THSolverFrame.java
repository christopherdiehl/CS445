import javax.swing.JFrame;

public class THSolverFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int numberOfDiscs = 64;
		TowerOfHanoi towers = new TowerOfHanoi(numberOfDiscs);
		THComponent thc = new THComponent(towers);
		
		
		JFrame frame = new JFrame();
		frame.setTitle("Tower of Hanoi");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(thc);
		
		frame.setVisible(true);
		
		Thread.sleep(5000);
		int numOfDiscs = towers.getNumberOfDiscs();
	/*	int [] startPole = towers.getArrayOfDiscs(0);
		int [] tempPole= towers.getArrayOfDiscs(1);
		int [] endPole = towers.getArrayOfDiscs(2);*/
		int startPole=0;
		int tempPole=1;
		int endPole=2;
		solveTower(towers, thc, numOfDiscs, startPole, tempPole, endPole);
		
		System.out.println("DONE!!!");
	}
	
	public static void solveTower(TowerOfHanoi towers, THComponent thc, int numOfDiscs, int startPole, int tempPole, int  endPole) throws InterruptedException
	{
		if(numOfDiscs== 1){
			
			towers.moveTopDisc(startPole, endPole);
			thc.repaint();
			Thread.sleep(100);
		}
		else{
			solveTower(towers , thc , numOfDiscs-1, startPole, endPole, tempPole);
			towers.moveTopDisc(startPole, endPole);
			solveTower(towers, thc, numOfDiscs -1, tempPole , startPole, endPole);
		}
	}
	
}
