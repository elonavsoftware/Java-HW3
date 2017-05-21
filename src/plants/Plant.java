package plants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import utilities.MessageUtility;
import mobility.ILocatable;
import mobility.Point;
import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
/**
 * @author baroh
 *
 */
public abstract class Plant implements IEdible, ILocatable, IDrawable
{
	private ZooPanel panel;
	private BufferedImage food = null;

	
	//added these methods, care to implement it later!
	@Override
	public void loadImages(String nm)
	{
		try
		{
			food = ImageIO.read(new File(PICTURE_PATH + nm));
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		}
	}

	@Override
	public void drawObject(Graphics g)
	{
		if (food != null)
			g.drawImage(food,this.panel.getWidth()/2,this.panel.getHeight()/2, 50, 50, panel);
	}

	@Override
	public String getColor()
	{
		return null;
	}
	///////////////////////////////////////////////////
	/**
	 * 
	 */
	private double height;
	/**
	 * 
	 */
	private Point location;
	/**
	 * 
	 */
	private double weight;

	/**
	 * 
	 */
	public Plant(ZooPanel mypanel)
	{
		this.panel = mypanel;
		//Thread Th=new Thread();
		//Th.start();
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		MessageUtility.logConstractor("Plant", "Plant");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IFood#getFoodtype()
	 */
	@Override
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}

	/**
	 * @return
	 */
	public double getHeight()
	{
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation()
	 */
	@Override
	public Point getLocation()
	{
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return this.location;
	}

	/**
	 * @return
	 */
	public double getWeight()
	{
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * @param height
	 * @return
	 */
	public boolean setHeight(double height)
	{

		boolean isSuccess = (height >= 0);
		if (isSuccess)
			this.height = height;
		else
			this.height = 0;
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	@Override
	public boolean setLocation(Point newLocation)
	{
		boolean isSuccess = Point.cheackBounderies(newLocation);
		if (isSuccess)
			this.location = newLocation;
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}

	/**
	 * @param weight
	 * @return
	 */
	public boolean setWeight(double weight)
	{
		boolean isSuccess = (weight >= 0);
		if (isSuccess)
			this.weight = weight;
		else
			this.weight = 0;
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {return "[" + this.getClass().getSimpleName() + "]";}
} //abstract class Plant implements IEdible, ILocatable