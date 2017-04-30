package graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lab5.MyPanel;
public class ZooFrame extends JFrame
{
	static ZooPanel MyZooPanel;
	public static void main(String[] args)
	{ 
		JFrame frame = new JFrame("Zoo"); 
		final JLabel label = new JLabel(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(label); 
		frame.setSize(1200, 800);
		frame.setVisible(true);
	}
	class MyPanel extends JPanel implements ActionListener
	{

		public MyPanel()
		{

		}
		
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
} //class ZooFrame extends JFrame