/**
 * This is my code! It's goal is to be a number block.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
public class NumberBlock extends Block
{
    //Attributes
	protected int adjacentMineCount;
	protected boolean exposed;
    
    /**
     * Initialize NumberBlock to state as before game begins.
     */
    public NumberBlock()
    {
        this.adjacentMineCount = 0;
        this.exposed = false;
    }
    
    /**
     * Uncovers block and continues the game, does not lose game.
     */
    @Override
    public void guessSafe()
    {
        this.exposed = true;
        this.markedAsMine = false;
    }
    
    /**
     * Adjacent mine blocks increased due to mine.
     */
    public void incrementAdjacentMineCount()
    {
        this.adjacentMineCount++;
    }
    
    /**
     * Returns if marked as mine is correct.
     */
    @Override
    public boolean correctlyGuessed()
    {
        return !this.markedAsMine;
    }
    
    @Override
    public String displayAs()
    {
//        if(markedAsMine)
//            return "M";
//        if(exposed)
//            return adjacentMineCount + "";
//        return ".";
    	return adjacentMineCount + "";
    }

    /**
     * Returns true if block is a MineBlock
     */
    @Override
    public boolean isMine()
    {
        return false;
    }

    @Override
    public boolean isZero()
    {
        if(adjacentMineCount == 0)
            return true;
        return false;
    }

    @Override
    public boolean isExposed()
    {
        return exposed;
    }
}
