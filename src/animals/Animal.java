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
import utilities.MessageUtility;

/**
 * animal class - present all the animals.
 * @author Mahdi
 *
 */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior, Runnable
{
	//Added Attributes
	protected final int EAT_DISTANCE = 5;
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
	protected String colorstr; //added
	/**
	 * 
	 */
	protected String name;
	/**
	 * 
	 */
	private double weight;
	/**
	 * 
	 */
	private IDiet diet;
	
	
	//Constructors

	//my ctor
	public Animal(int Size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{		
		x_dir = 1;
		y_dir = 1;
		coordChanged = false;
	    thread = new Thread(this);
	    thread.start();
		this.setLocation(location);
		this.setSize(Size);
		this.horSpeed = HSpeed;
		this.verSpeed = VSpeed;
		if(color == "Red")
			this.col = Color.RED;
		else if(color == "Blue")
			this.col = Color.BLUE;
		else
			this.col = null; //natural
		this.panel = panel;
	}
	/**
	 * Animal Constructor
	 * @param name
	 * @param location
	 */
	public Animal(String name, Point location, String color, ZooPanel panel)
	{
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		this.setLocation(location);
		if(color == "Red")
			//this.col = Color.RED;
		    colorstr = "Red";
		else if(color == "Blue")
			//this.col = Color.BLUE;
		    colorstr = "Blue";

		else
			//this.col = null; //natural
	        colorstr = "Natural";
		this.panel = panel;
	}
	

	
	//Methods
	/**
	 * 	setName function
	 * @param _name
	 * @return res
	 */
	public boolean setName(String _name)
	{
		boolean res = true;
		if(_name == null)
			res = false;
		this.name = _name;
		MessageUtility.logSetter(name, "setName", _name, res);
		return res;
	}
	/**
	 * setDiet function
	 * @param _diet
	 * @return res
	 */
	public boolean setDiet(IDiet _diet)
	{
		boolean res = false;
		if(_diet != null)
		{
			res = true;
		}
		this.diet = _diet;
		MessageUtility.logSetter(name, "setDiet", _diet, res);
		return res;
	}
	/**
	 * getDiet function
	 * @return this.diet
	 */
	public IDiet getDiet()
	{
		MessageUtility.logGetter(name, "getDiet", this.diet);
		return this.diet;
	}
	/**
	 * getWeight
	 * @return weight
	 */
	public double getWeight()
	{
		MessageUtility.logGetter(name, "getWeight", weight); 
		return weight;
	}
	/**
	 * setWeight - set Weight function.
	 * @param neweight
	 * @return res - result.
	 */
	public boolean setWeight(double neweight)
	{
		boolean res = true;
		if(neweight < 0)
			res = false;
		this.weight = neweight;
		//MessageUtility.logSetter(name, "setWeight", neweight, res);
		return res;
	}
	/**
	 * 
	 */
	public String toString() {return "[" + this.getClass().getSimpleName() + "]" + "(" + name + ")" ;}
	/**
	 * 
	 */
	public abstract void makeSound();
	/**
	 * eat function
	 * @param type 
	 * @return res - result
	 */
	public boolean eat(IEdible type)
	{
		boolean res = false;
		boolean x = this.diet.canEat(type.getFoodtype());
		if(x == true)
			res = this.diet.eat(this, type);
		MessageUtility.logBooleanFunction(name, "eat", type, res);
		return res;
	}
	/**
	 * getName
	 * @return this.name
	 */
	public String getName()
	{
		MessageUtility.logGetter(name, "getName", name);
		return this.name;
	}
	/**
	 * move function
	 */
	public double move(Point p)
	{
		double distance = super.move(p);
		boolean flag2 = false;
		if(Point.cheackBounderies(p))
		{
			boolean flag = false;
			if(distance != 0)
				flag = true;
			flag2 = flag;
			double getweight = this.getWeight();
			this.setWeight(getweight - (distance * getweight * 0.00025));			
		}
		MessageUtility.logBooleanFunction(name, "move", p, flag2);
		return distance;
	}	
	
	@Override
	/**
	 * getFoodtype - function getting the food type of animal.
	 */
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(name, "getFoodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}
	 
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("Panel width" + panel.getWidth() + ",Panel Height" + panel.getHeight());
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
				//asking if there are food
				if(this.panel.isFood())
				{
					//if(this.eat(food))
					if(this.panel.getFood() instanceof Meat && (this instanceof Lion || this instanceof Bear))
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
                       
							if((Math.abs(this.getLocation().getX() - this.panel.getWidth()/2) <= 10) && (Math.abs(this.getLocation().getY() - this.panel.getHeight()/2) <= 10))
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
					//if(this.eat(food))
					if((this.panel.getFood() instanceof Lettuce || this.panel.getFood() instanceof Cabbage) && (this instanceof Turtle || this instanceof Giraffe || this instanceof Elephant))
					{
						System.out.println(this.diet.canEat(EFoodType.MEAT));
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

						
                   
							if((Math.abs(this.getLocation().getX() - this.panel.getWidth()/2) <= 10) && (Math.abs(this.getLocation().getY() - this.panel.getHeight()/2) <= 10))
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
				}
			}
			catch (InterruptedException e)
			{
				//e.printStackTrace();
				return;
			}
            catch (ArithmeticException e)
            {
            	System.out.println(e.getMessage());
            }
		
		}
	}
	
	//added Methods.
	 public int getHorSpeed() { return horSpeed; }
	 public int getVerSpeed() { return verSpeed; }
	 
	 
	@Override
	public String getAnimalName() {return name;}

	@Override
	public int getSize() {return size;}

	@Override
	public void eatInc() {this.eatCount++;}

	@Override
	public int getEatCount() {return this.eatCount;}

	@Override
	public boolean getChanges() {return coordChanged;}

	@Override
	public void setSuspended() {this.threadSuspended = true;}
	
	@Override
	public synchronized void setResumed()
	{
		this.threadSuspended = false;
		notify(); //to wakeup the Animals 
	}

	@Override
	synchronized public void setChanges(boolean state) {coordChanged = state;}

	@Override
	public String getColor() {return this.colorstr;}	
	@Override
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
	@Override
	public void drawObject(Graphics g)
	{
	   g.setColor(col);
	   if(x_dir == 1) //goes to the right side
		   g.drawImage(img1, getLocation().getX() - size/2, getLocation().getY() - size/2, size/2, size, panel);
	   else //goes to the left side
		   g.drawImage(img2, getLocation().getX(), getLocation().getY() - size/2, size/2, size, panel);
	}

	public boolean setSize(int _size)
	{
		Boolean res = true;
		if(_size > 0)
			this.size = _size;
		else
			res = false;
		return res;
	}
	
	synchronized public void stop() {thread.interrupt();}
} //abstract class Animal extends Mobile implements IEdible