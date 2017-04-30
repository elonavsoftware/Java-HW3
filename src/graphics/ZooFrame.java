package graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		JButton button1 = new JButton();
		button1.setName("File");
		frame.getContentPane().add(button1, null);
		frame.setVisible(true);
	}
} //class ZooFrame extends JFrame