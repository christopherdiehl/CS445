import javax.swing.JFrame;

public class THFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int numDiscs = 4;
		TowerOfHanoi towers = new TowerOfHanoi(numDiscs);
		THComponent thc = new THComponent(towers);
		
		
		JFrame frame = new JFrame();
		frame.setTitle("Tower of Hanoi");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(thc);
		
		frame.setVisible(true);
		
		Thread.sleep(5000);
		
		towers.moveTopDisc(0, 1);
		thc.repaint();
		Thread.sleep(500);

		towers.moveTopDisc(0, 2);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(1, 2);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(0, 1);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(2, 0);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(2, 1);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(0, 1);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(0, 2);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(1, 2);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(1, 0);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(2, 0);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(1, 2);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(0, 1);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(0, 2);
		thc.repaint();
		Thread.sleep(500);
		
		towers.moveTopDisc(1, 2);
		thc.repaint();
		Thread.sleep(500);
		
	}
}
