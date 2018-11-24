import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Minesweeper extends JFrame
{

	private JFrame frame;
	View v;
	GameBoard gb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Minesweeper window = new Minesweeper();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Minesweeper() 
	{
		v = new TestView();
		gb = new GameBoard(v);
		v.setModel(gb);
		v.update(0,0);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//gb = new GameBoard();
		Block [][] grid = gb.grid;
		int size = gb.BOARD_SIZE;
		Block [] arr = new Block[size*size];
		int arrIndex = 0;
		
		for(int i = 0; i < gb.BOARD_SIZE; i++)
            for(int j = 0; j < gb.BOARD_SIZE; j++)
                if(grid[i][j].isMine())
                    gb.incrementCountForSurroundingBlocks(i, j);
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				arr[arrIndex] = grid[i][j];
				//gb.guessBlockIsSafe(i, j);
				System.out.println(gb.grid[i][j].displayAs());
				arrIndex++;
			}
		}
		
		//Container pane = getContentPane();
		frame.setLayout(new GridLayout(size, size));
	    for (int i = 0; i < (size*size); i++) 
	    {
	      //JButton button = new JButton(Integer.toString(i + 1));
	    	//TODO: Possibly copy code from initial design to put into one long array and do standard switching. Then do adjacent mine adding.
	    	JButton button;
	    	
	    	if(arr[i].isMine())
	    		button = new MineButton();
	    	else
	    		button = new NumberButton(arr[i].displayAs());

	    	frame.add(button);
	    }

	}

}
