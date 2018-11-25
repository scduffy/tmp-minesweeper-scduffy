import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 * This is my code! It's goal is to be a mine button.
 * CS 312 - Assignment 8
 * @author scduffy
 * @version 1.0 11/16/2018
 */
public class MineButton extends JButton implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	protected boolean isMarked;
	private MineBlock mb;
	private Minesweeper game;
	
	public MineButton(Minesweeper game)
	{
		super();
		this.game = game;
		enableInputMethods(true);   
		addMouseListener(this);
		mb = new MineBlock();
		isMarked = mb.markedAsMine;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		if(arg0.getButton() == MouseEvent.BUTTON1)
		{
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Popup frame = new Popup(false);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			this.isMarked = true;
			repaint();
		}
		else if(SwingUtilities.isRightMouseButton(arg0))
		{
			this.isMarked = true;
			if(game.checkIfDone())
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Popup frame = new Popup(true);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			repaint();
		}
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
		if(!isMarked)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			this.setText("");
			g.drawRect(0, 0, getWidth(), getHeight());
		}
		else
		{
			super.paintComponent(g);
			this.setFont(this.getFont().deriveFont(20f));
			this.setText("M");
			this.setForeground(Color.RED);
		}
	}

	/**
	 * These are required to have in the class but i'm not going to implement them because i dont need to.
	 */
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
}
	
