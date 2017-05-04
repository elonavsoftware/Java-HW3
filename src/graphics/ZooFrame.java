package graphics;

import javax.swing.JFrame;

public class ZooFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private final static String ZOO_FRAME_TEXT = "Zoo";
	static ZooPanel MyZooPanel;
	public static void main(String[] args)
	{ 
        JFrame frame = new JFrame(ZOO_FRAME_TEXT);
        ZooPanel panel = new ZooPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 740);
        frame.setVisible(true);
	}
} //class ZooFrame extends JFrame


