import java.awt.*;
import java.awt.geom.Line2D;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class KenKenComponent extends JComponent
{

    public KenKenComponent(String fileName, JFrame frame)
        throws IOException
    {
        xOffset = 10;
        yOffset = 10;
        cellSize = 60;
        thin = new BasicStroke(1.0F);
        thick = new BasicStroke(5F);
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str = in.readLine();
        size = Integer.parseInt(str);
        bottom = new boolean[size][size];
        right = new boolean[size][size];
        numbers = new int[size][size];
        cages = new int[size][size];
        targetNumber = new int[size][size];
        operator = new char[size][size];
        numColors = new Color[size][size];
        for(int row = 0; row < size; row++)
        {
            for(int column = 0; column < size; column++)
                numColors[row][column] = Color.BLUE;

        }

        frame.setSize(cellSize * size + 2 * xOffset + 2, cellSize * size + 2 * yOffset + 29);
        frame.setTitle("KenKen");
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        str = in.readLine();
        numCages = Integer.parseInt(str);
        cageTargetNumber = new int[numCages];
        cageOperator = new char[numCages];
        for(int i = 0; i < numCages; i++)
        {
            str = in.readLine();
            String temp[] = str.split(",");
            int target = Integer.parseInt(temp[0]);
            char op = temp[1].charAt(0);
            int numCells = Integer.parseInt(temp[2]);
            for(int j = 0; j < numCells; j++)
            {
                str = in.readLine();
                temp = str.split(",");
                int row = Integer.parseInt(temp[0]);
                int column = Integer.parseInt(temp[1]);
                cages[row][column] = i;
                numbers[row][column] = 0;
                if(j == 0)
                {
                    targetNumber[row][column] = target;
                    cageTargetNumber[i] = target;
                    operator[row][column] = op;
                    cageOperator[i] = op;
                } else
                {
                    targetNumber[row][column] = -1;
                    operator[row][column] = ' ';
                }
            }

        }

        in.close();
        setLines();
        frame.add(this);
    }

    private void setLines()
    {
        for(int row = 0; row < size; row++)
        {
            for(int column = 0; column < size; column++)
                if(column == size - 1)
                    right[row][column] = true;
                else
                    right[row][column] = cages[row][column] != cages[row][column + 1];

        }

        for(int column = 0; column < size; column++)
        {
            for(int row = 0; row < size; row++)
                if(row == size - 1)
                    bottom[row][column] = true;
                else
                    bottom[row][column] = cages[row][column] != cages[row + 1][column];

        }

    }

    public void setNumber(int nums[][])
    {
        numbers = nums;
        checkRowColumn();
        checkCages();
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        java.awt.geom.Line2D.Double line = new java.awt.geom.Line2D.Double(0.0D, 0.0D, 0.0D, 0.0D);
        g2.setColor(Color.BLACK);
        for(int i = 0; i < size; i++)
        {
            g2.setStroke(thick);
            line.setLine(xOffset + i * cellSize, yOffset, xOffset + (i * cellSize + cellSize), yOffset);
            g2.draw(line);
            line.setLine(xOffset + i * cellSize, yOffset + size * cellSize, xOffset + (i * cellSize + cellSize), yOffset + size * cellSize);
            g2.draw(line);
        }

        for(int i = 0; i < size; i++)
        {
            g2.setStroke(thick);
            line.setLine(xOffset, yOffset + i * cellSize, xOffset, yOffset + (i * cellSize + cellSize));
            g2.draw(line);
            line.setLine(xOffset + size * cellSize, yOffset + i * cellSize, xOffset + size * cellSize, yOffset + (i * cellSize + cellSize));
            g2.draw(line);
        }

        for(int row = 0; row < size; row++)
        {
            for(int column = 0; column < size - 1; column++)
            {
                line.setLine(xOffset + (column + 1) * cellSize, yOffset + row * cellSize, xOffset + (column + 1) * cellSize, yOffset + (row + 1) * cellSize);
                if(right[row][column])
                    g2.setStroke(thick);
                else
                    g2.setStroke(thin);
                g2.draw(line);
            }

        }

        for(int column = 0; column < size; column++)
        {
            for(int row = 0; row < size - 1; row++)
            {
                line.setLine(xOffset + column * cellSize, yOffset + (row + 1) * cellSize, xOffset + (column + 1) * cellSize, yOffset + (row + 1) * cellSize);
                if(bottom[row][column])
                    g2.setStroke(thick);
                else
                    g2.setStroke(thin);
                g2.draw(line);
            }

        }

        g2.setStroke(thin);
        g2.setFont(new Font("Dialog", 1, 14));
        for(int row = 0; row < size; row++)
        {
            for(int column = 0; column < size; column++)
                if(targetNumber[row][column] != -1)
                {
                    String str = (new StringBuilder()).append(targetNumber[row][column]).append(operator[row][column]).toString();
                    g2.drawString(str, xOffset + column * cellSize + 5, yOffset + row * cellSize + 17);
                }

        }

        g2.setStroke(thin);
        g2.setFont(new Font("Dialog", 0, 32));
        for(int row = 0; row < size; row++)
        {
            for(int column = 0; column < size; column++)
                if(numbers[row][column] != -1 && numbers[row][column] != 0)
                {
                    g2.setColor(numColors[row][column]);
                    String str = (new StringBuilder()).append(numbers[row][column]).toString();
                    g2.drawString(str, xOffset + column * cellSize + 22, yOffset + row * cellSize + 45);
                }

        }

    }

    private void checkRowColumn()
    {
        for(int row = 0; row < size; row++)
        {
            for(int column = 0; column < size; column++)
            {
                int currentNumber = numbers[row][column];
                for(int i = 0; i < size; i++)
                    if(i != column && currentNumber == numbers[row][i])
                    {
                        numColors[row][column] = Color.red;
                        numColors[row][i] = Color.red;
                    }

                for(int i = 0; i < size; i++)
                    if(i != row && currentNumber == numbers[i][column])
                    {
                        numColors[row][column] = Color.red;
                        numColors[i][column] = Color.red;
                    }

            }

        }

    }

    private void checkCages()
    {
        for(int i = 0; i < numCages; i++)
        {
            ArrayList list = new ArrayList();
            for(int row = 0; row < size; row++)
            {
                for(int column = 0; column < size; column++)
                    if(cages[row][column] == i)
                        list.add(Integer.valueOf(numbers[row][column]));

            }

            if(!isValid(list, i))
            {
                for(int row = 0; row < size; row++)
                {
                    for(int column = 0; column < size; column++)
                        if(cages[row][column] == i)
                            numColors[row][column] = Color.red;

                }

            }
        }

    }

    private ArrayList permutation(ArrayList list)
    {
        ArrayList result = new ArrayList();
        int numElements = list.size();
        if(numElements == 0)
        {
            result.add(new ArrayList());
            return result;
        }
        for(int i = 0; i < numElements; i++)
        {
            ArrayList clonedList = new ArrayList();
            for(int j = 0; j < list.size(); j++)
                clonedList.add(j, (Integer)list.get(j));

            Integer removedEntry = (Integer)clonedList.remove(i);
            ArrayList tempList = permutation(clonedList);
            int numTempList = tempList.size();
            for(int j = 0; j < numTempList; j++)
            {
                ArrayList x = (ArrayList)tempList.remove(0);
                x.add(0, removedEntry);
                result.add(x);
            }

        }

        return result;
    }

    public boolean isValid(ArrayList cageList, int cageNumber)
    {
        ArrayList allLists = permutation(cageList);
        int numAllLists = allLists.size();
        for(int i = 0; i < numAllLists; i++)
        {
            ArrayList currentList = (ArrayList)allLists.get(i);
            int numEntries = currentList.size();
            int tempResult = ((Integer)currentList.get(0)).intValue();
            for(int j = 1; j < numEntries; j++)
                if(cageOperator[cageNumber] == '+')
                    tempResult += ((Integer)currentList.get(j)).intValue();
                else
                if(cageOperator[cageNumber] == '-')
                    tempResult -= ((Integer)currentList.get(j)).intValue();
                else
                if(cageOperator[cageNumber] == '*')
                    tempResult *= ((Integer)currentList.get(j)).intValue();
                else
                if(cageOperator[cageNumber] == '/')
                {
                    if(tempResult % ((Integer)currentList.get(j)).intValue() != 0)
                        tempResult = 0;
                    tempResult /= ((Integer)currentList.get(j)).intValue();
                }

            if(cageTargetNumber[cageNumber] == tempResult)
                return true;
        }

        return false;
    }

    private boolean bottom[][];
    private boolean right[][];
    private int numbers[][];
    private Color numColors[][];
    private int cages[][];
    private int cageTargetNumber[];
    private int size;
    private int numCages;
    private int targetNumber[][];
    private char operator[][];
    private char cageOperator[];
    private int xOffset;
    private int yOffset;
    private int cellSize;
    private BasicStroke thin;
    private BasicStroke thick;
}