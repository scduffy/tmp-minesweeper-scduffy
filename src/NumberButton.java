import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 * This is my code! It's goal is to be an number button.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
public class NumberButton extends JButton implements MouseListener
{
	
	private static final long serialVersionUID = 1L;
	
	//private Dimension size = new Dimension(36,36);
	
	private boolean isUncovered = false;
	private boolean isMarked = false;
	
	NumberBlock nb;
	private String adjacentMines;
	
	/**
	 * Default constructor when object is called.
	 */
	public NumberButton(String adjacentMines)
	{
		super();
		enableInputMethods(true);   
		addMouseListener(this);
		nb = new NumberBlock();
		this.adjacentMines = adjacentMines;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		if(arg0.getButton() == 1)
		{
			isUncovered = true;
			repaint();
		}
		else if(SwingUtilities.isRightMouseButton(arg0))
		{
			if(!isUncovered)
			{
				isMarked = true;
				repaint();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension getPreferredSize()  
	{
		return new Dimension(30, 30);
		
	}

	@Override
	public Dimension getMinimumSize()  
	{
		return getPreferredSize();
	}
	
	@Override
	public Dimension getMaximumSize()
	{
		return getPreferredSize();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{	
		if(!isUncovered)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawRect(0, 0, getWidth(), getHeight());
			
			if(isMarked)
			{
				super.paintComponent(g);
				this.setFont(this.getFont().deriveFont(20f));
				this.setText("M");
				this.setForeground(Color.RED);
			}
		}
		else
		{
			
			super.paintComponent(g);
			this.setFont(this.getFont().deriveFont(20f));
			int parsed = Integer.parseInt(adjacentMines) / 2;
			if(parsed == 1)
			{
				this.setText("1");
				this.setContentAreaFilled(false);
				this.setForeground(Color.BLUE);
			}
			else if(parsed == 2)
			{
				this.setText("2");
				this.setContentAreaFilled(false);
				this.setForeground(Color.GREEN);
			}
			else if(parsed == 3)
			{
				this.setText("3");
				this.setContentAreaFilled(false);
				this.setForeground(Color.RED);
			}
			else if(parsed == 4)
			{
				this.setText("4");
				this.setContentAreaFilled(false);
				this.setForeground(new Color(0,0,128));
			}
			else if(parsed == 5)
			{
				this.setText("5");
				this.setContentAreaFilled(false);
				this.setForeground(new Color(165,42,42));
			}
			else if(parsed == 6)
			{
				this.setText("6");
				this.setContentAreaFilled(false);
				this.setForeground(Color.CYAN);
			}
			else if(parsed == 7)
			{
				this.setText("7");
				this.setContentAreaFilled(false);
				this.setForeground(Color.BLACK);
			}
			else if(parsed == 8)
			{
				this.setText("8");
				this.setContentAreaFilled(false);
				this.setForeground(Color.GRAY);
			}
			else
			{
				this.setText("0");
				this.setContentAreaFilled(false);
				this.setForeground(Color.GRAY);
			}

			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		}
	}
	
}
