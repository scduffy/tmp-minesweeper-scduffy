import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * This is my code! It's goal is to be a GUI.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
public class Minesweeper extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	View v;
	GameBoard gb;
	List<MineButton> minesActive = new ArrayList<>();

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
				System.out.println(gb.grid[i][j].displayAs());
				arrIndex++;
			}
		}
		
		frame.setLayout(new GridLayout(size, size));
		
	    for (int i = 0; i < (size*size); i++) 
	    {
	    	if(arr[i].isMine())
	    	{
	    		MineButton button = new MineButton(this);
	    		minesActive.add(button);
	    		frame.add(button);
	    	}
	    	else
	    	{
	    		NumberButton button = new NumberButton(arr[i].displayAs());
	    		frame.add(button);
	    	}
	    }

	}
	
	public boolean checkIfDone()
	{
		for(MineButton button : minesActive)
		{
			System.out.println("CHECKING BUTTON");
			if(!button.isMarked)
				return false;
		}
		return true;
	}

}
