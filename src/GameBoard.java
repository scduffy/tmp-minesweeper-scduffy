import java.util.Random;

/**
 * This is my code! It's goal is to hold all the blocks and mines for the game.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
public class GameBoard
{
    //Attributes
    protected int BOARD_SIZE = 9;
    protected Block[][] grid = new Block[BOARD_SIZE][BOARD_SIZE];
    protected View view;
    
    /**
     * Initializes the GameBoard object so that it can hold blocks.
     */
    public GameBoard(View v)
    //public GameBoard()
    {
        //BOARD_SIZE = 10;
        view = v;
        for(int r1 = 0; r1 < BOARD_SIZE; r1++)
            grid[0][r1] = new MineBlock();
        for(int i = 1; i < BOARD_SIZE; i++)
            for(int j = 0; j < BOARD_SIZE; j++)
                grid[i][j] = new NumberBlock();
        
        // Swaps elements randomly
        Random rand = new Random();
        int newR;
        int newC;
        
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            for(int j = 0; j < BOARD_SIZE; j++)
            {
                newR = rand.nextInt(BOARD_SIZE);
                newC = rand.nextInt(BOARD_SIZE);
                Block temp = grid[i][j];
                
                grid[i][j] = grid[newR][newC];
                grid[newR][newC] = temp;
                
            } 
        }
        
        //Increments surrounding number blocks
        for(int i = 0; i < BOARD_SIZE; i++)
            for(int j = 0; j < BOARD_SIZE; j++)
                if(grid[i][j].isMine())
                    incrementCountForSurroundingBlocks(i, j);
        
    }
    
    /**
     * Checks block if it is safe, either loses game or it clears.
     * @param r
     * @param c
     */
    public void guessBlockIsSafe(int r, int c)
    {
        grid[r][c].guessSafe();
        view.update(r, c);
    }
    
    /**
     * Increments blocks surrounding given coordinates by one.
     * This indicates that the block at the given coords is a mine.
     * @param row
     * @param column
     */
    public void incrementCountForSurroundingBlocks(int row, int column)
    {
        int [][] coords = { {row-1, column},{row+1, column},{row, column-1},
                            {row, column+1},{row+1, column+1},{row-1, column-1},
                            {row-1, column+1}, {row+1, column-1} };
        
        for(int[] coord : coords)
        {
            int r = coord[0];
            int c = coord[1];
            
            try
            {
                grid[r][c].incrementAdjacentMineCount();
            }
            catch(Exception e){}
        }
    }
    
    /**
     * Turns marked as mine flag to true on specified block. 
     * @param r
     * @param c
     */
    public void markBlockAsMine(int r, int c)
    {
        grid[r][c].markAsMine();
        view.update(r, c);
    }
    
    /**
     * Returns true if all mines have been found and marked as mines.
     * @return
     */
    public boolean minesAllFound()
    {
        for(int r = 0; r < BOARD_SIZE; r++)
            for(int c = 0; c < BOARD_SIZE; c++)
                if(!grid[r][c].correctlyGuessed())
                    return false;
        return true;
    }
    
    /**
     * Clears all blocks not adjacent to a mine around the one selected
     * if it was also a non-adjacent block. This was a pretty lit method,
     * Jack got mad that I managed to get it working so fast. 
     */
    public void clearSurrounding(int row, int column)
    {
        if(grid[row][column].isZero())
        {
            try
            {
                //Coordinates for all adjacent blocks to block at given (row, column)
                int [][] coords = { {row-1, column},{row+1, column},
                                    {row, column-1},{row, column+1},
                                    {row+1, column+1},{row-1, column-1},
                                    {row-1, column+1}, {row+1, column-1} };
                
                //Iterates through adjacent coordinates and uncovers it if proper
                for(int[] coord : coords)
                {
                    int r = coord[0];
                    int c = coord[1];
                    
                    if(!grid[r][c].isMine() && !grid[r][c].isExposed())
                    {
                        //Checks to see if the block has be marked as a mine
                        //even though it is a number. If it is then leave the
                        //error as is and do not uncover.
                        if(!grid[r][c].correctlyGuessed())
                            clearSurrounding(r,c);
                        else
                        {
                            grid[r][c].guessSafe();
                            clearSurrounding(r,c);
                        }
                    }
                }
            }
            catch(Exception e){}
            view.update(0,0);
        }
    }
    
    /**
     * Displays the block at the specified coordinates
     * @param r
     * @param c
     * @return
     */
    public String displayAs(int r, int c)
    {
        return grid[r][c].displayAs();
    }
}
