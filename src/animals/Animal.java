package animals;
import mobility.Mobile;
import mobility.Point;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
public abstract class Animal extends Mobile implements IEdible,IDrawable,IAnimalBehavior,Runnable
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
	protected ZooPanel pan;
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
	public Animal(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location)
	{		
	     thread= new Thread(this);
	     thread.start();
		this.setLocation(location);
		this.setSize(Size);
		this.horSpeed=HSpeed;
		this.verSpeed=VSpeed;
		if(color=="Red")
		{
			this.col=Color.RED;
		}
		else if(color=="Blue")
		{
			this.col=Color.BLUE;
		}
		else{
			//nothing
			this.col=null; //natural
		}
		this.pan=panel;
	}
	/**
	 * Animal Constructor
	 * @param name
	 * @param location
	 */
	public Animal(String name, Point location, String  color,ZooPanel panel)
	{
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		this.setLocation(location);
		//////////////////////////////////////////////////////////////////////////////
		if(color=="Red")
		{
			this.col=Color.RED;
		}
		else if(color=="Blue")
		{
			this.col=Color.BLUE;
		}
		else{
			//nothing
			this.col=null; //natural
		}
		this.pan=panel;
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
			res=true;
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
		MessageUtility.logGetter(name, "getDiet",this.diet);
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
			res=false;
		this.weight = neweight;
		MessageUtility.logSetter(name, "setWeight", neweight, res);
		return res;
	}
	/**
	 * 
	 */
	public String toString() {return "[" + this.getClass().getSimpleName() + "]"+"("+name+")";}
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
		boolean res=false;
		boolean x=this.diet.canEat(type.getFoodtype());
		if(x == true)
			res=this.diet.eat(this, type);
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
		MessageUtility.logBooleanFunction(name, "move", p,flag2);
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
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	 
	@Override
	public void run()
	{
		while(true){
			try {
				synchronized(this){
					if(this.threadSuspended==true)// sleep the Animals 
						wait();
				}
				Thread.sleep(500);
				this.getLocation().setX(this.getLocation().getX()+4);
				this.getLocation().setY(this.getLocation().getY()+4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//this function initilaizing the animal photos.
	public Boolean  setImage(BufferedImage  limg,BufferedImage  rimg){
		Boolean res=false;
		if(limg!=null && rimg !=null)
		{
			this.img1=limg;
			this.img2=rimg;
			res=true;
		}
		return res;
	}

	@Override
	public String getAnimalName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void eatInc() {
		// TODO Auto-generated method stub
		this.eatCount++;
	}

	@Override
	public int getEatCount() {
		// TODO Auto-generated method stub
		return this.eatCount;
	}

	@Override
	public boolean getChanges() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSuspended() {
		// TODO Auto-generated method stub
		this.threadSuspended=true;
	}

	@Override
	public void setResumed() {
		// TODO Auto-generated method stub		
		this.threadSuspended=false;
		this.notify();// to wakeup the Animals 
	}

	@Override
	public void setChanges(boolean state) {
		// TODO Auto-generated method stub	
	}


	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return colorstr;
	}
	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub	
    	try {
			this.img1 = ImageIO.read(new File(PICTURE_PATH+nm));
			this.img2 = ImageIO.read(new File(PICTURE_PATH+nm));			
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void drawObject(Graphics g) {
	   g.setColor(col);
	   if(x_dir==1) // giraffe goes to the right side
		g.drawImage(img1, getLocation().getX()-size/2, getLocation().getY()-size/10, size/2, size, pan);
	   else // giraffe goes to the left side
		g.drawImage(img2, getLocation().getX(), getLocation().getY()-size/10, size/2, size, pan);
	}


	
	public boolean setSize(int _size)
	{
		Boolean res=true;
		if(_size>0)
			this.size=_size;
		else{
			res=false;
		}
		return res;
	}
} //abstract class Animal extends Mobile implements IEdible