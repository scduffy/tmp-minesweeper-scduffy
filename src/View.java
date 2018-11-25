/**
 * This is partially my code! It's goal is to control what the user sees.
 * CS 312 - Assignment 8
 * @author scduffy / binkley
 * @version 1.0 11/16/2018
 */
interface View
{
    public void setModel(GameBoard m);
    public void initialDisplay();
    abstract public void update(int r, int c);
    abstract public void gameOver(String msg);
}

/**
 * This is partially my code! It's goal is to control what the user sees.
 * CS 312 - Assignment 8
 * @author scduffy / binkley
 * @version 1.0 11/16/2018
 */
abstract class aView implements View
{
    protected GameBoard model = null;

    public void setModel(GameBoard m) {model = m;}
    public void initialDisplay() {update(0, 0);}
    public void gameOver(String msg) {System.out.println(msg); System.exit(0);}

    abstract public void update(int r, int c);
}

/**
 * This is partially my code! It's goal is to control what the user sees.
 * CS 312 - Assignment 8
 * @author scduffy / binkley
 * @version 1.0 11/16/2018
 */
class TTYView extends aView
{
    public void update(int _r, int _c)
    {
        //Labels the top row for easier coordinate id use by user. 
        String topCoords = "  ";
        for(int i = 0; i < model.BOARD_SIZE; i++)
            topCoords += i + " ";
        
        System.out.println(topCoords + "C");
        
        for(int i = 0; i < model.BOARD_SIZE; i++)
        {
            System.out.print(i + " ");
            for(int j = 0; j < model.BOARD_SIZE; j++)
            {
                System.out.print(model.displayAs(i, j) + " ");
            }
            System.out.println("");
        }
        System.out.println("R\n");
    }
}

class TestView extends aView
{
	public void update(int _r, int _c)
    {
        //Labels the top row for easier coordinate id use by user. 
        String topCoords = "  ";
        for(int i = 0; i < model.BOARD_SIZE; i++)
            topCoords += i + " ";
        
        System.out.println(topCoords + "C");
        
        for(int i = 0; i < model.BOARD_SIZE; i++)
        {
            System.out.print(i + " ");
            for(int j = 0; j < model.BOARD_SIZE; j++)
            {
                System.out.print(model.displayAs(i, j) + " ");
            }
            System.out.println("");
        }
        System.out.println("R\n");
    }
}
