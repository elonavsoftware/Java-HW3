package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import animals.Animal;
import food.IEdible;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;

public class ZooPanel extends JPanel implements ActionListener, Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   //final static String SafariImg = "C:\\Users\\USER\\Desktop\\pictures\\savanna.jpg";
	private Image SafariImg =new ImageIcon("savanna.jpg").getImage();

   protected int Counter = 0;
	private HashSet<Animal> animal;
	private Thread controller; //data member of class ZooPanel 
	private String[] buttonNames = {"Add Animal", "Sleep", "Wake Up", "Clear", "Food", "Info", "Exit"};
	private JButton[] button;
	private Cabbage cabbage;
	private Meat meat;
	private Lettuce lettuce;
	private IEdible food;
	private HashSet<IEdible> plants;
	ZooFrame ZooFrm;
	JDialog jdialog;
	
	//Info Table
	private String[][]info1=new String[6][6];
	private JTable table;
    private int totaleEat;// the total of eat Worm 
    private int count;

	private String[]info2={"Animal","Color","Size","HorSpeed","VerSpeed","eat Counter"};
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	private Boolean flag=false;
	private JPanel subpanel;
	//Constructor
	public ZooPanel(ZooFrame zooframe)
	{
		//create a main thread which control the main panel.
		controller = new Thread(this);
		controller.start();
		button = new JButton[buttonNames.length]; //array of JButton		
		createbtn();
		animal = new HashSet<Animal>(); //iterator of animals
		plants= new HashSet<IEdible>();//iterator of plants cabbage lettuce meat.
		count=0;
		totaleEat=0;
		this.ZooFrm = zooframe;		
	}
	
	//this function check's weither there are food or not.
	public Boolean isFood()
	{
		Boolean res = false;
		Iterator<IEdible> i = plants.iterator();
		if(i.hasNext())
		{							
			res = true;
		}		
		return res;
	}
	public void createbtn()
	{
		int i, x = 0;
	    subpanel = new JPanel(); //adding to this sub panel the buttons to make it in SOUTH position.
		this.setLayout(new BorderLayout());
		GridLayout GridL = new GridLayout(1, 7);
		subpanel.setLayout(GridL);
		for(i = 0; i < buttonNames.length; i++)
		{			
			button[i] = new JButton(buttonNames[i]);// the Button name
			//button[i].setPreferredSize(new Dimension(110, 23));
			//button[i].setBounds(x, 610, 110, 23);
			button[i].addActionListener(this); //to set the button in Action listener			
			//x += 100; //this is about coordinate x in the panel (the place of button)
			subpanel.add(button[i]);  
		}		
		this.add(subpanel, BorderLayout.SOUTH);
	}
	public void setBackgr(int num)
	{
		if(num == 0) //if we select the image
		{
				flag=true;
				//setLayout(null);
				setBackground(null); //we clean the background
				this.paintComponent(this.getGraphics());
		}
		if(num == 1) //if we select the green
		{
			flag = false;
			//setLayout(null);
			setBackground(null); //we clean the background
			this.paintComponent(this.getGraphics());
			setBackground(Color.GREEN);			
		}
		else if(num == 2) //if we select the image
		{			
			flag = false;
			//setLayout(null);
			setBackground(null); //clean the Background
			//setBackground(null); //set background none
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
	
	
	// Function for the Info Button
	public void Table()
	{
		fullupInfo1();
		table=new JTable(info1,info2);
		//table.setBounds(50, 50, 300, 300);
		//setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);
		this.revalidate();
		
	}
	private void fullupInfo1(){
		int i=0;
		Iterator<Animal> k=animal.iterator();
		totaleEat=0;
		while(k.hasNext()){
			Animal s=k.next();
			
					info1[i][0]=s.getName();
					info1[i][1]=s.getColor();
					info1[i][2]=""+s.getSize();;
					info1[i][3]=""+s.getHorSpeed();
					info1[i][4]=""+s.getVerSpeed();
					info1[i][5]=""+s.getEatCount();
					
					totaleEat+=s.getEatCount();

					i++;
		}
		info1[5][0]="Total";
		info1[5][5]=""+totaleEat;
		
	}

	public void killPlants()
	{
		plants.clear();	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource() == button[0]) //add animal button
			{
				if(Counter < 10)
				{
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
			//killing the threads of animals
			while(i.hasNext())
			{				
				i.next().stop(); //enable
			}
			//killing the threads of Plants
			animal.clear();	//clearing the board
			plants.clear();
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
					//clear Board from food.
					plants.clear();			
					//creating new food
					food=new Meat(this);
					plants.add(food);
					break;
					
				//Cabbage
				case 1:
					//clear Board from food.
					plants.clear();			
					//creating new food
					food=new Cabbage(this);
					plants.add(food);
					break;
					
				//Lettuce
				case 2:
					//clear Board from food.
					plants.clear();			
					//creating new food
					food=new Lettuce(this);
					plants.add(food);
					break;
			}
		}
		else if(e.getSource() == button[5]) //info
		{
			count++;// number of Cliking in the button info 
			if(count==1){// if the cliking equal to 1 we work the function table 
				Table();
			}
			else// to remove the table 
			{
				count=0;
				this.remove(table);//to remove the JTable from panel
				this.remove(table.getTableHeader());
				this.revalidate();
				repaint();
			}		}
		else if(e.getSource() == button[6]) //exit button
		{
			System.exit(0);
		}
	}	
	public void paintComponent(java.awt.Graphics g)
	{
	    super.paintComponent(g);
	    Iterator<Animal> i = animal.iterator(); //the beginning of iterator
	    Iterator<IEdible> j = plants.iterator(); //the beginning of iterator

	    if(flag) //flag == true
	    {
	    	Dimension size = this.getSize();
	    	g.drawImage(SafariImg, 0, 0,size.width, size.height, this);
	    } //to set Background Image
	    
	    /*for(animal an :   )
	    {
	    	
	    }*/
	    while(i.hasNext())
    		i.next().drawObject(g);
	    while(j.hasNext())
	    	j.next().drawObject(g);

    }

	
} //class ZooPanel extends JPanel implements ActionListener, Runnable