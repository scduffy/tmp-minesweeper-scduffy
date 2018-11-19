/**
 * This is my code! It's goal is to be an abstract block.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
public abstract class Block
{
    protected boolean markedAsMine;
    protected int adjacentMineCount;
    
    /**
     * Block initialization. 
     */
    public Block()
    {
        this.markedAsMine = false;
    }
    
    /**
     * Marks the block as a mine, changing its attribute. 
     */
    public void markAsMine()
    {
        this.markedAsMine = true;
    }
    
    /**
     * Returns what the Block is going to be represented as in interface.
     * @return
     */
    public String displayAs()
    {
        if(markedAsMine)
            return "M";
        return ".";
    }
    
    /**
     * Returns true if the block is already exposed.
     * @return
     */
    public abstract boolean isExposed();
    
    /**
     * Increases number representing adjacent mines.
     */
    public abstract void incrementAdjacentMineCount();
    
    /**
     * Returns true if is a mineblock and marked as mine, false otherwise.
     * @return
     */
    public abstract boolean correctlyGuessed();
    
    /**
     * Player guesses if a Block is safe.
     */
    public abstract void guessSafe();
    
    /**
     * Returns true if block is a MineBlock.
     */
    public abstract boolean isMine();
    
    /**
     * Returns true if the adjacent mine count is zero.
     * @return
     */
    public abstract boolean isZero();
}
