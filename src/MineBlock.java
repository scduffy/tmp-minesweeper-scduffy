/**
 * This is my code! It's goal is to be a mine block.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
public class MineBlock extends Block
{
    /**
     * Player loses the game, a mine block is not safe :((((
     */
    @Override
    public void guessSafe()
    {
        System.out.println("BOOM!");
        System.exit(0);
    }
    
    /**
     * Notifies surrounding Blocks that this is a mine (so that NumberBlock
     * objects can change their value.
     */
    public void tellNeighborsAboutMine(GameBoard gb, int row, int column)
    {
        gb.incrementCountForSurroundingBlocks(row, column);
    }
    
    /**
     * Returns true if block correctly identified as a mine.
     * @return
     */
    @Override
    public boolean correctlyGuessed()
    {
        return markedAsMine;
    }
    
    public void incrementAdjacentMineCount()
    {
        return;
    }
    
    //TODO: Remove this tester method
    @Override
    public String displayAs()
    {
        if(markedAsMine)
            return "M";
        return ".";
    }
    
    @Override
    public boolean isExposed()
    {
        return false;
    }

    /**
     * Returns true if block is a MineBlock
     */
    @Override
    public boolean isMine()
    {
        return true;
    }

    @Override
    public boolean isZero()
    {
        return false;
    }
}
