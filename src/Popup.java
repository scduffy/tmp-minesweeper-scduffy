import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Popup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean didWin = false;
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Popup frame = new Popup(didWin);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Popup(boolean didWin) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		if(!didWin)
		{
			BufferedImage image = ImageIO.read(new File("879.jpg"));
		    JLabel label = new JLabel(new ImageIcon(image));
		    
		    label.setLayout(new FlowLayout());
		    contentPane.add(label);
		    
		    JButton button = new JButton();
		    button.setText("BOOM! YOU LOSE!");
		    label.add(button);
		}
		else
		{
			BufferedImage image = ImageIO.read(new File("bob-esponja--feliz_5923_1024x768.jpg"));
		    JLabel label = new JLabel(new ImageIcon(image));
		    
		    label.setLayout(new FlowLayout());
		    contentPane.add(label);
		    
		    JButton button = new JButton();
		    button.setText("YAY! YOU WIN!");
		    label.add(button);
		}
	}

}
