package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * ZooFrame class, extends JFrame and implements ActionListener, the main frame of the zoo
 * @author Elon Avisror
 *
 */

public class ZooFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private String[] names = {"Exit", "Image", "Green", "None", "Help"};
    private JMenu m1, m2, m3;
    private JMenuItem[] mi;
    private JMenuBar mb;
	static ZooPanel MyZooPanel;
    ZooFrame zooFrame;
    ZooPanel zooPanel;
    
    /**
     * constructor
     */
	public ZooFrame()
	{
		super("Zoo Frame");	
		zooPanel = new ZooPanel(this);
	    add(zooPanel);
	    zooPanel.setVisible(true);
		mb = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Background");
		m3 = new JMenu("Help");
		mi = new JMenuItem[names.length];
		for(int i = 0 ; i < names.length; i++)
		{
		    mi[i] = new JMenuItem(names[i]);
		    mi[i].addActionListener(this);
		}
		m1.add(mi[0]);
		m2.add(mi[1]);
		m2.addSeparator();
		m2.add(mi[2]);
		m2.addSeparator();
		m2.add(mi[3]);
		m3.add(mi[4]);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		setJMenuBar(mb);
	}
	
	public static void main(String[] args)
	{      
        ZooFrame frame = new ZooFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == mi[0]) //exit
			destroy();
		else if(e.getSource() == mi[1]) //image
			zooPanel.setBackground(0);
		else if(e.getSource() == mi[2]) //green
			zooPanel.setBackground(1);
		else if(e.getSource() == mi[3]) //none
			zooPanel.setBackground(2);
		else if(e.getSource() == mi[4]) //help
			printHelp();
	}
	
	public void destroy() {System.exit(0);} //exit from all
	
	public void printHelp() {JOptionPane.showMessageDialog(this, "Home Work 3\nGUI @ Threads");}
} //class ZooFrame extends JFrame implements ActionListener