import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class MineButton extends JButton implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	private boolean isMarked;
	private MineBlock mb;
	
	public MineButton()
	{
		super();
		//TODO: Replace this with the adjacent mine count
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
		//else if(arg0.getButton() == MouseEvent.BUTTON2)
		{
			this.isMarked = true;
			repaint();
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
			//g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		}
	}
}
	
