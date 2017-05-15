package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import animals.Animal;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;

public class ZooPanel extends JPanel implements ActionListener, Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
    final static String SafariImg = "C:\\Users\\USER\\Desktop\\pictures\\savanna.jpg";
	static int Counter = 0;
	private HashSet<Animal> animal;
	private Thread controller; // data member of class ZooPanel 
	private String[] buttonNames = {"Add Animal", "Sleep", "Wake Up", "Clear", "Food", "Info", "Exit"};
	private JButton[] button;
	private Cabbage cabbage;
	private Meat meat;
	private Lettuce lettuce;
	ZooFrame ZooFrm;
	JDialog jdialog;
	//Constructor
	public ZooPanel(ZooFrame zooframe)
	{
		//create a main thread which control the main panel.
		controller = new Thread(this);
		controller.start();
		button = new JButton[buttonNames.length]; //array of JButton		
		createbtn();
		animal = new HashSet<Animal>(); //iterator of swimmable 
		this.ZooFrm = zooframe;		
	}
	public void createbtn()
	{
		int i, x = 0;
		JPanel subpanel = new JPanel(); //adding to this sub panel the buttons to make it in SOUTH position.
		this.setLayout(new BorderLayout());
		GridLayout GridL = new GridLayout(1, 7);
		subpanel.setLayout(GridL);
		for(i = 0; i < buttonNames.length; i++)
		{			
			button[i] = new JButton(buttonNames[i]);// the Button name
			button[i].setPreferredSize(new Dimension(110, 23));
			button[i].setBounds(x, 610, 110, 23);
			button[i].addActionListener(this); //to set the button in Action listener			
			x += 100; //this is about coordinate x in the panel (the place of button)
			subpanel.add(button[i]);  
		}		
		this.add(subpanel, BorderLayout.SOUTH);
	}
	public void setBackgr(int num)
	{
		if(num == 0) //if we select the blue
		{
			try
			{
				setLayout(null);
				setBackground(null); //we clean the background
				this.paintComponent(this.getGraphics());
			    background = ImageIO.read(new File(SafariImg));
			}
			catch (IOException e)
			{
			    e.printStackTrace();
			}
		}
		if(num == 1) //if we select the blue
		{
			setLayout(null);
			setBackground(null); //we clean the background
			this.paintComponent(this.getGraphics());
			setBackground(Color.GREEN);			
			background = null;
		}
		else if(num == 2) //if we select the image
		{			
			setLayout(null);
			setBackground(null); //clean the Background
			this.paintComponent(this.getGraphics());
			setBackground(null); //set background none
			background = null;
		}
	}

	//adding animal to our list .
	public void addanimal(Animal s)
	{		
		animal.add(s);
		Counter++; //to increase the counter of add animal 
	}

	@Override
	public void run()
	{
		while(true)
		{
			repaint();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource() == button[0]) //add animal button
			{
				if(Counter < 10)
				{
					Counter++;
					jdialog = new AddAnimalDialog(this.ZooFrm, this);
					jdialog.setSize(300, 250);
				}
				else
				{
					//ERROR
					JOptionPane.showMessageDialog(this, "You cannot add more than 10 animals");
				}
			}
		
		else if(e.getSource() == button[1]) //Sleep
		{
			Iterator<Animal> i = animal.iterator();
			while(i.hasNext())
			{
				i.next().setSuspended(); //pause all animals
			}
		}
		else if(e.getSource() == button[2]) //wake up
		{
			Iterator<Animal> i = animal.iterator();
			while(i.hasNext())
			{				
				i.next().setResumed(); //enable
			}
		}
		else if(e.getSource() == button[3]) //clear
		{
			////////////////////////////////////////////
			//interuped!!!! -> animal
			// and in  run method care to return inside exception .
			//////////////////////////////////////////
			Iterator<Animal> i = animal.iterator();
			while(i.hasNext())
			{				
				i.next().stop(); //enable
			}
			animal.clear();	//clearing the board
			Counter = 0; //reset counter to 0 so we can add new animals
		}
		else if(e.getSource() == button[4]) //food
		{
			int mc = JOptionPane.QUESTION_MESSAGE;
			String[] opts = {"Meat", "Cabbage", "Lettuce"};
			int ch = JOptionPane.showOptionDialog (null, "Please choose food", "Food for animals", 0, mc, null, opts, opts[0]);
			System.out.println(ch);
			switch(ch)
			{
				//Meat
				case 0:
					meat = new Meat();
					break;
					
				//Cabbage
				case 1:
					cabbage = new Cabbage();
					break;
					
				//Lettuce
				case 2:
					lettuce = new Lettuce();
					break;
			}
			/*
			Object[] options = {"Meat, Cabbage", "Lettuce"};
			int result = JOptionPane.showOptionDialog (ZooFrm, "Choose", "Title", 0, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			System.out.println(result);
			*/
		}
		else if(e.getSource() == button[5]) //info
		{
			
		}
		else if(e.getSource() == button[6]) //exit button
		{
			System.exit(0);
		}
	}	
	public void paintComponent(java.awt.Graphics g)
	{
	    super.paintComponent(g);
	    Iterator<Animal> i = animal.iterator(); //the beginning of iterator
	    
	    while(i.hasNext())
    		i.next().drawObject(g);
	    if (meat != null)
	    	meat.drawObject(g);
	    else if (cabbage != null)
	    	cabbage.drawObject(g);
	    else if (lettuce != null)
	    	lettuce.drawObject(g);
	    if(background != null)
	    	g.drawImage(background, 0, 0, this);
	    revalidate();
	    repaint(); //added
	    

    }
} //class ZooPanel extends JPanel implements ActionListener, Runnable