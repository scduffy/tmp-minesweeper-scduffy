/**
 * This is my code! It's goal is to control what the user sees.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
//public class View
//{
//    //Attributes
//    protected GameBoard model;
//    
//    /**
//     * Initializes the model
//     */
//    public void setModel(GameBoard m)
//    {
//        this.model = m;
//    }
//    
//    /**
//     * Prints the initial display to the console.
//     */
//    public void initialDisplay()
//    {
//        for(int i = 0; i < model.BOARD_SIZE; i++)
//        {
//            for(int j = 0; j < model.BOARD_SIZE; j++)
//            {
//                System.out.print(model.displayAs(i, j) + " ");
//            }
//            System.out.println();
//        }
//    }
//    
//    /**
//     * Updates what is displayed on the interface.
//     */
//    public void update()
//    {
//        System.out.println();
//        initialDisplay();
//    }
//}

interface View
{
  public void setModel(GameBoard m);
  public void initialDisplay();
  abstract public void update(int r, int c);
  abstract public void gameOver(String msg);
}

abstract class aView implements View
{
  protected GameBoard model = null;

  public void setModel(GameBoard m) {model = m;}
  public void initialDisplay() {update(0, 0);}
  public void gameOver(String msg) {System.out.println(msg); System.exit(0);}

  abstract public void update(int r, int c);
}

class TTYView extends aView
{
    public void update(int _r, int _c)
    {
        //Sets up the coordinates for the top row for easier use by user. 
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
        System.out.println("R");
    
//  public void update(int _r, int _c)   // tty version ignores _r and _c
//  {
//    for(int r = 0; r < GameBoard.BOARD_SIZE; r++)
//    {
//      String S = "";
//      for(int c = 0; c < GameBoard.BOARD_SIZE; c++)
//        S += model.displayAs(r, c) + " ";
//      System.out.println(S);
//    }
//  }
    }
}
