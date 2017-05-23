package animals;

import mobility.Mobile;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import diet.IDiet;

/**
 * animal class - present all the animals
 * @author Mahdi Asali
 *
 */

public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior, Runnable
{
	/*Added Attributes*/
	protected final int EAT_DISTANCE = 30;
	protected int size;
	protected Color col;
	protected int horSpeed;
	protected int verSpeed;
	protected boolean coordChanged;
	protected Thread thread;
	protected int x_dir;
	protected int y_dir;
	protected int eatCount;
	protected ZooPanel panel;
	protected boolean threadSuspended;	 
	protected BufferedImage img1, img2;
	protected String colorStr;
	protected String name;
	private double weight;
	private IDiet diet;
	
	
	/*Constructor*/
	public Animal(int size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{		
		x_dir = 1;
		y_dir = 1;
		this.setLocation(location);
		this.setSize(size);
		this.horSpeed = HSpeed;
		this.verSpeed = VSpeed;
		if(color == "Red")
		{
			this.col = Color.RED;
			this.colorStr = "Red";
		}
		else if(color == "Blue")
		{
			this.col = Color.BLUE;
			this.colorStr = "Blue";
		}
		else
		{
			this.col = null; //natural
			this.colorStr = "Natural";
		}
		
		this.panel = panel;
		coordChanged = false;
	    thread = new Thread(this);
	    thread.start();
	}
	
	
	//Methods
	/**
	 * 	setName function
	 * @param _name
	 * @return res = result
	 */
	public boolean setName(String name)
	{
		boolean res = true;
		if(name == null)
			res = false;
		this.name = name;
		return res;
	}
	
	/**
	 * setDiet function
	 * @param _diet
	 * @return res = result
	 */
	public boolean setDiet(IDiet diet)
	{
		boolean res = false;
		if(diet != null)
			res = true;
		this.diet = diet;
		return res;
	}
	
	/**
	 * getDiet function
	 * @return this.diet
	 */
	public IDiet getDiet() {return this.diet;}
	
	/**
	 * getWeight
	 * @return this.weight
	 */
	public double getWeight() {return weight;}
	
	/**
	 * setWeight - set Weight function
	 * @param neweight
	 * @return res = result
	 */
	public boolean setWeight(double weight)
	{
		boolean res = true;
		if(weight < 0)
			res = false;
		this.weight = weight;
		return res;
	}
	
	public String toString() {return ("[" + this.getClass().getSimpleName() + "]" + "(" + name + ")");}
	
	/**
	 * eat function
	 * @param type 
	 * @return res = result
	 */
	public boolean eat(IEdible type)
	{
		boolean res = false;
		boolean x = this.diet.canEat(type.getFoodtype());
		if(x == true)
			res = this.diet.eat(this, type);
		return res;
	}
	
	/**
	 * getName
	 * @return this.name
	 */
	public String getName() {return this.name;}
	
	/**
	 * move function
	 * @return distance
	 */
	public double move(Point p)
	{
		double distance = super.move(p);
		if(Point.cheackBounderies(p))
		{
			double getweight = this.getWeight();
			this.setWeight(getweight - (distance * getweight * 0.00025));			
		}
		return distance;
	}	
	
	/**
	 * getFoodtype - function getting the food type of animal
	 */
	public EFoodType getFoodtype() {return EFoodType.MEAT;}
	
	public void run()
	{
		while(true)
		{
			try
			{
				coordChanged  = true;
				this.getLocation().setX(this.getLocation().getX() + horSpeed * x_dir);
				this.getLocation().setY(this.getLocation().getY() + verSpeed * y_dir);
			 	if(this.getLocation().getX() + size/2 >= panel.getWidth()) //-->
			 		x_dir = -1;
			 	else if(this.getLocation().getX() - size/2 <= 0) //<--
			 		x_dir = 1;
			 	if(this.getLocation().getY() + size/2 + 30 >= panel.getHeight()) //down
			 		y_dir = -1;
			 	else if(this.getLocation().getY() - size/2 - 5 <= 0) //up
			 		y_dir = 1;
				synchronized(this)
				{
					if(this.threadSuspended == true) //sleep the Animals
						wait();
				}			
				Thread.sleep(50);			
				
				if(this.panel.isFood()) //asking if there are food on the panel
				{
					/*1*/
					if(this.panel.getFood() instanceof Meat && (this instanceof Lion || this instanceof Bear))
						mathFood();
					
					/*2*/
					if((this.panel.getFood() instanceof Lettuce || this.panel.getFood() instanceof Cabbage) && (this instanceof Turtle || this instanceof Giraffe || this instanceof Elephant || this instanceof Bear))
						mathFood();
				}
			}
			catch (InterruptedException e)
			{
				return;
			}
            catch (ArithmeticException e) //divide by zero
            {
            	//do nothing
            }
		}
	}

	/**
	 * 
	 * @return this.horSpeed
	 */
	public int getHorSpeed() {return this.horSpeed;}
	
	/**
	 * 
	 * @return this.verSpeed
	 */
	public int getVerSpeed() {return this.verSpeed;}
	
	/**
	 * 
	 * @return this.name
	 */
	public String getAnimalName() {return this.name;}
	
	/**
	 * 
	 * @return this.size
	 */
	public int getSize() {return this.size;}
	
	public void eatInc() {this.eatCount++;}
	
	/**
	 * 
	 * @return this.eatCount
	 */
	public int getEatCount() {return this.eatCount;}
	
	/**
	 * 
	 * @return this.coordChanged
	 */
	public boolean getChanges() {return this.coordChanged;}
	
	public void setSuspended() {this.threadSuspended = true;} //true
	
	public synchronized void setResumed() //false
	{
		this.threadSuspended = false;
		notify(); //to wake-up the Animals 
	}
	synchronized public void setChanges(boolean state) {coordChanged = state;}
	
	/**
	 * @return this.colorStr
	 */
	public String getColor() {return this.colorStr;}
	
	public void loadImages(String nm)
	{
		if(this.col == Color.red)
		{
			try
			{
				this.img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_1.png"));
				this.img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_2.png"));
			} 
			catch (IOException e)
			{
				e.printStackTrace();
				System.out.println("Unable to load the image!");
			}
    	}
		else if(this.col == Color.blue)
		{
	    	try
	    	{
				this.img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_1.png"));
				this.img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_2.png"));
			} 
	    	catch (IOException e)
	    	{
				e.printStackTrace();
				System.out.println("Unable to load the image!");
			}
		}
		else
		{
	    	try
	    	{
				this.img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_1.png"));
				this.img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_2.png"));
			} 
	    	catch (IOException e)
	    	{
				e.printStackTrace();
				System.out.println("Unable to load the image!");
			}
		}
	}
	
	public void drawObject(Graphics g)
	{
	   g.setColor(col);
	   if(x_dir == 1) //goes to the right side
		   g.drawImage(img1, getLocation().getX() - size/2, getLocation().getY() - size/2, size/2, size, panel);
	   else //goes to the left side
		   g.drawImage(img2, getLocation().getX(), getLocation().getY() - size/2, size/2, size, panel);
	}
	
	/**
	 * 
	 * @param _size
	 * @return res = result
	 */
	public boolean setSize(int size)
	{
		Boolean res = true;
		if(size > 0)
			this.size = size;
		else
			res = false;
		return res;
	}
	
	synchronized public void stop() {thread.interrupt();}
	
	/*Move food direction*/
	public void mathFood()
	{
		double hor_new = horSpeed, ver_new = verSpeed, ver_old = verSpeed, hor_old = horSpeed;
		double v_old = Math.sqrt(hor_old * hor_old + ver_old * ver_old);
		try
		{
			double k = Math.abs((getLocation().getY() - panel.getHeight()/2) / (getLocation().getX() - panel.getWidth()/2));
			double h_ns = v_old / Math.sqrt(k * k + 1);
			double v_ns = h_ns * k;

			if(h_ns > 10)
				h_ns = 10;
			else if(h_ns < 1)
			{
				if(getLocation().getY() != (panel.getWidth()/2))
					h_ns = 1;
				else
					h_ns = 0;
			}
			if(v_ns > 10)
				v_ns = 10;
			else if(v_ns < 1)
			{
				if(getLocation().getX() != (panel.getHeight()/2))
					v_ns = 1;
				else
					v_ns = 0;
			}
			if (getLocation().getY() > panel.getHeight()/2)
				y_dir = -1;
			else
				y_dir = 1;

			if (getLocation().getX() > panel.getWidth()/2)
				x_dir = -1;
			else
				x_dir = 1;
			if((Math.abs(this.getLocation().getX() - this.panel.getWidth()/2) <= EAT_DISTANCE) && (Math.abs(this.getLocation().getY() - this.panel.getHeight()/2) <= EAT_DISTANCE))
			{
				panel.killPlants();
				this.eatCount++;	
			}
			else if (Math.abs(this.getLocation().getX() - this.panel.getWidth()/2) <= 10) //x
				this.getLocation().setX(this.getLocation().getX() + (int)(hor_new * x_dir));
			else if (Math.abs(this.getLocation().getY() - this.panel.getHeight()/2) <= 10) //y
				this.getLocation().setY(this.getLocation().getY() + (int)(ver_new * y_dir));
			else
			{
				this.getLocation().setX(this.getLocation().getX() + (int)(hor_new * x_dir));
				this.getLocation().setY(this.getLocation().getY() + (int)(ver_new * y_dir));
			}
		}
		finally {}
	}
} //abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior, Runnable