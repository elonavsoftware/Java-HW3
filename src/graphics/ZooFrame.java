package graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ZooFrame extends JFrame
{
	private final static String ZOO_FRAME_TEXT = "Zoo";
	static ZooPanel MyZooPanel;
	public static void main(String[] args)
	{ 
        JFrame frame = new JFrame(ZOO_FRAME_TEXT);
        MyPanel contents = new MyPanel();
        frame.add(contents, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setVisible(true);
	}
} //class ZooFrame extends JFrame

class MyPanel extends JPanel implements ActionListener
{
	private final static String MENU_TEXT1 = "File";
	private final static String MENU_TEXT2 = "Background";
	private final static String MENU_TEXT3 = "Help";
	private final static String BUTTON_TEXT1 = "Add Animal";
	private final static String BUTTON_TEXT2 = "Sleep";
	private final static String BUTTON_TEXT3 = "Wake Up";
	private final static String BUTTON_TEXT4 = "Clear";
	private final static String BUTTON_TEXT5 = "Food";
	private final static String BUTTON_TEXT6 = "Info";
	private final static String BUTTON_TEXT7 = "Exit";
	JMenu menu1, menu2, menu3;
	JButton button1, button2, button3, button4, button5, button6, button7;
	public MyPanel()
	{
		 menu1 = new JMenu(MENU_TEXT1);
		 menu2 = new JMenu(MENU_TEXT2);
		 menu3 = new JMenu(MENU_TEXT3);
		 button1 = new JButton(BUTTON_TEXT1);
		 button2 = new JButton(BUTTON_TEXT2);
		 button3 = new JButton(BUTTON_TEXT3);
		 button4 = new JButton(BUTTON_TEXT4);
		 button5 = new JButton(BUTTON_TEXT5);
		 button6 = new JButton(BUTTON_TEXT6);
		 button7 = new JButton(BUTTON_TEXT7);
		 
		 //up-left
		 add(menu1);
		 add(menu2);
		 add(menu3);
		 
		 //down-left
		 add(button1);
		 add(button2);
		 add(button3);
		 add(button4);
		 add(button5);
		 add(button6);
		 add(button7);
	}
		
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == menu1)
		{
			//menu1.add("Exit");
		}
		if (event.getSource() == menu2)
		{
			
		}
		if (event.getSource() == menu3)
		{
			
		}
	}
} //class MyPanel extends JPanel implements ActionListener