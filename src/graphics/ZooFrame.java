package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ZooFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
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
	private static final long serialVersionUID = 1L;
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
	private static final String BACKGROUND_PATH = "C://";
	JPanel panel1, panel2;
	JMenuBar menuBar;
	JMenu file, background, help;
	JMenuItem f_exit, b_image, b_green, b_none, h_help;
	JButton addAnimal, sleep, wakeUp, clear, food, info, exit;
	public MyPanel()
	{
		BorderLayout myBorderLayout = new BorderLayout();
		//Sets the LayoutManager to the Layout
		this.setLayout(myBorderLayout);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		menuBar = new JMenuBar();
		
		f_exit = new JMenuItem("Exit");
		b_image = new JMenuItem("Image");
		b_green = new JMenuItem("Green");
		b_none = new JMenuItem("None");
		h_help = new JMenuItem("Help");
		
		file = new JMenu(MENU_TEXT1);
		file.add(f_exit);
		background = new JMenu(MENU_TEXT2);
		background.add(b_image);
		background.add(b_green);
		background.add(b_none);
		help = new JMenu(MENU_TEXT3);
		help.add(h_help);
		
		addAnimal = new JButton(BUTTON_TEXT1);
		sleep = new JButton(BUTTON_TEXT2);
		wakeUp = new JButton(BUTTON_TEXT3);
		clear = new JButton(BUTTON_TEXT4);
		food = new JButton(BUTTON_TEXT5);
		info = new JButton(BUTTON_TEXT6);
		exit = new JButton(BUTTON_TEXT7);
		 
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		
		//up-left
		menuBar.add(file);
		menuBar.add(background);
		menuBar.add(help);
		
		panel1.add(menuBar);
		
		//down-left
		panel2.add(addAnimal);
		panel2.add(sleep);
		panel2.add(wakeUp);
		panel2.add(clear);
		panel2.add(food);
		panel2.add(info);
		panel2.add(exit);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
		
		this.f_exit.addActionListener(this);
		this.b_image.addActionListener(this);
		this.b_green.addActionListener(this);
		this.b_none.addActionListener(this);
		this.h_help.addActionListener(this);
		
		this.addAnimal.addActionListener(this);
		this.exit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent event)
	{
		//JMenu
		if (event.getSource() == f_exit)
		{
			System.exit(0);	
		}
		if (event.getSource() == b_image)
		{
			BufferedImage img = null;
			try
			{
				img = ImageIO.read(new File(BACKGROUND_PATH));
			}
			catch (IOException e)
			{
				System.out.println("Error!");
			}	
		}
		if (event.getSource() == b_green)
		{
			this.setBackground(Color.GREEN);
		}
		if (event.getSource() == b_none)
		{
			this.setBackground(Color.WHITE);
		}
		if (event.getSource() == h_help)
		{
			JOptionPane.showMessageDialog(this, "Home Work 3\nGUI @ Threads");
		}
		
		//JButton
		if (event.getSource() == addAnimal)
		{
			
		}
		if (event.getSource() == exit)
		{
			System.exit(0);
		}
	}
} //class MyPanel extends JPanel implements ActionListener