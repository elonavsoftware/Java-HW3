package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	public final static String PICTURE_PATH = "pictures\\";
	private static final long serialVersionUID = 1L;
	private Image SafariImg = new ImageIcon(PICTURE_PATH + "savanna.jpg").getImage();
	protected int Counter = 0;
	private ArrayList<Animal> animal;
	private Thread controller; //data member of class ZooPanel 
	private String[] buttonNames = {"Add Animal", "Sleep", "Wake Up", "Clear", "Food", "Info", "Exit"};
	private JButton[] button;
	private IEdible food;
	ZooFrame ZooFrm;
	JDialog jdialog;
	//Info Table
	private String[][] info1 = new String[11][6];
	private String[] info2 = {"Animal", "Color" ,"Weight" ,"HorSpeed" ,"VerSpeed" ,"Eat Counter"};
	private JTable table;
    private int totalEat;// the total of eat Worm 
    private int count;
	////////////////////////////////////////////////////////////////////////////////////////
	private Boolean flag = false;
	private JPanel subpanel;
	//Constructor
	public ZooPanel(ZooFrame zooframe)
	{
		//create a main thread which control the main panel
		button = new JButton[buttonNames.length]; //array of JButton		
		createbtn();
		animal = new ArrayList<Animal>(); //iterator of animals
		count = 0;
		totalEat = 0;
		this.ZooFrm = zooframe;		
		controller = new Thread(this);
		controller.start();
	}
	
	//this function check's weither there are food or not
	public Boolean isFood()
	{
		Boolean res = false;
		if(food!=null)
			res=true;
		return res;
	}
	
	public void createbtn()
	{
		int i;
	    subpanel = new JPanel(); //adding to this sub panel the buttons to make it in SOUTH position.
		this.setLayout(new BorderLayout());
		GridLayout GridL = new GridLayout(1, 7);
		subpanel.setLayout(GridL);
		for(i = 0; i < buttonNames.length; i++)
		{			
			button[i] = new JButton(buttonNames[i]);// the Button name
			button[i].addActionListener(this); //to set the button in Action listener			
			subpanel.add(button[i]);  
		}		
		this.add(subpanel, BorderLayout.SOUTH);
	}
	public void setBackgr(int num)
	{
		if(num == 0) //if we select the image
		{
				flag = true;
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
	public boolean isChanges(){
		
		boolean res=false;
		/*if(animal==null)
			return false;*/
		for(Animal an:animal)
		{
			if(an.getChanges())
			{
				an.setChanges(false);
				res=true;
			}
		}
		return res;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Override
public void run(){
	while(true)
	{
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isChanges()){repaint();} 
		boolean flag = false;
		for(Animal predator: animal)
		{
			for(Animal prey: animal)
			{
				if (predator != prey && predator.eat(prey) && Math.abs(predator.getLocation().getX()-prey.getLocation().getX())<=50 &&Math.abs(predator.getLocation().getY()-prey.getLocation().getY())<=50 &&(predator.getWeight())>= 2*(prey.getWeight()) )
				{
					prey.stop();
					animal.remove(prey);
					predator.eatInc();
					cleanTable(); //clean the table. (To reUPDATE the fields.)
					fullupInfo1(); //refill the fields.
					this.Counter--; //we have to reupdate the counter because animal removed
					flag = true;
					break;
				}
			}
			if(flag)break;}
	}
}





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Function for the Info Button
	public void Table()
	{
		fullupInfo1();
		table = new JTable(info1, info2);
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);
		this.revalidate();	
	}
	private void fullupInfo1()
	{
		int i = 0;
		Iterator<Animal> k = animal.iterator();
		totalEat = 0;
		while(k.hasNext())
		{
			Animal s = k.next();
			info1[i][0] = s.getName();
			info1[i][1] = s.getColor();
			info1[i][2] = "" + s.getWeight();;
			info1[i][3] = "" + s.getHorSpeed();
			info1[i][4] = "" + s.getVerSpeed();
			info1[i][5] = "" + s.getEatCount();
			totalEat += s.getEatCount();
			i++;
		}
		info1[10][0] = "Total";
		info1[10][5] = "" + totalEat;
		
	}
	public void cleanTable(){
	if(table!=null)
	{
	int rows=table.getRowCount();
	int c=table.getColumnCount();
	for(int i=0;i<rows;i++)
		for(int j=0;j<c;j++)
			info1[i][j]="";
	}
	}
	public void clearTable()
	{
		//table = new JTable(info1, info2);
		//add(table.getTableHeader(), BorderLayout.PAGE_START);
		//add(table, BorderLayout.CENTER);
		this.revalidate();
		totalEat = 0;
		for (int i = 0; i < Counter + 1; i++)
		{
			info1[i][0] = "";
			info1[i][1] = "";
			info1[i][2] = "";
			info1[i][3] = "";
			info1[i][4] = "";
			info1[i][5] = "";
			i++;
		}
		info1[10][0] = "Total";
		info1[10][5] = "" + 0;
	}
	
	public synchronized void killPlants()
	{
		food=null;	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource() == button[0]) //add animal
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
		
		else if(e.getSource() == button[1]) //sleep
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
			Counter = 0; //reset counter to 0 so we can add new animals
			food=null;
			cleanTable();
			repaint();
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
					food = new Meat(this);
					repaint();
					break;
					
				//Cabbage
				case 1:
					food = new Cabbage(this);
					repaint();
					break;
					
				//Lettuce
				case 2:
					food = new Lettuce(this);
					repaint();
					break;
			}
		}
		else if(e.getSource() == button[5]) //info
		{
			count++; //number of clicking in the button info 
			Iterator<Animal> i = animal.iterator();
			if(i.hasNext())
			{
				if(count == 1) //if the clicking equal to 1 we work the function table
					Table();
				else //to remove the table 
				{
					count = 0;
					this.remove(table); //to remove the JTable from panel
					this.remove(table.getTableHeader());
					this.revalidate();
					repaint();
				}		
			}
			else
			{
				if(count == 1) //if the clicking equal to 1 we work the function table
					Table();
				else
				{
					count = 0;
					this.remove(table); //to remove the JTable from panel
					this.remove(table.getTableHeader());
					this.revalidate();
					repaint();
				}	
				
			}

		}
		else if(e.getSource() == button[6]) //exit button
		{
			System.exit(0);
		}
	}	
	public void paintComponent(java.awt.Graphics g)
	{
	    super.paintComponent(g);
	    if(flag) //flag == true
	    {
	    	Dimension size = this.getSize();
	    	g.drawImage(SafariImg, 0, 0, size.width, size.height, this);
	    } //to set Background Image
	    
	    for(Animal myanimals: animal)
	    {
	    	myanimals.drawObject(g);
	    }
	    if(food!=null)
	    	food.drawObject(g);

    }
	public IEdible getFood()
	{
		return food; 
	}

} //class ZooPanel extends JPanel implements ActionListener, Runnable