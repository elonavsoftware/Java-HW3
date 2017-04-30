package graphics;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

public class ZooFrame extends JFrame
{
	private final static String ZOO_FRAME_TEXT = "Zoo";
	static ZooPanel MyZooPanel;
	public static void main(String[] args)
	{ 
        JFrame frame = new JFrame(ZOO_FRAME_TEXT);
        MyPanel panel = new MyPanel();
        frame.add(panel);
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
		BorderLayout myBorderLayout = new BorderLayout();
		//Sets the LayoutManager to the Layout
		this.setLayout(myBorderLayout);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
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
		 
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		
		//up-left
		panel1.add(menu1);
		panel1.add(menu2);
		panel1.add(menu3);
		
		//down-left
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(button7);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
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