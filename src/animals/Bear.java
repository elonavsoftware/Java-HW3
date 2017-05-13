package animals;
import diet.IDiet;
import diet.Omnivore;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 * Bear class ,extends 'AnimalThatRoars' class.
 * @author Elon
 *
 */
public class Bear extends AnimalThatRoars
{
	/**
	 * 
	 */
	
	private String furColor;
	
	
	//myctor
	
	public Bear(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location)
	{
		 super(Size, HSpeed,VSpeed,color,panel,location); 
		 this.loadImages("\\bea_n_1.png"); //this is the bear folder.
	}
	
	
	/**
	 * Bear Constructor
	 * @param name
	 * @param newFurColor
	 */
	/*public Bear(String name, String newFurColor,Color clr,ZooPanel pan)
	{
		super(name, new Point(100, 5),clr,pan);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(308.2);
		boolean res=this.setFurColor(newFurColor);
		IDiet _diet = new Omnivore();
		if(!res)
			this.setFurColor("GRAY");
		this.setDiet(_diet);
		//added this:
		x_dir=1;
		y_dir=1;
	}*/
	
	/**
	 * roar function prints a message of utility .
	 */
	public void roar() {MessageUtility.logSound(name, "Stands on its hind legs, roars and scratches its belly");}
	/**
	 * getFurColor
	 * @return this.furColor
	 */
	public String getFurColor()
	{
		MessageUtility.logGetter(name, "getFurColor", this.furColor);
		return this.furColor;
	}
	/**
	 * setFurColor function which sets the color of bear.
	 * @param newFurColor
	 * @return
	 */
	public boolean setFurColor(String newFurColor)
	{
		boolean res = false;
		if(newFurColor == "BLACK" || newFurColor == "WHITE" || newFurColor == "GRAY")
		{
			this.furColor = newFurColor;
			res = true;
		}
		else
		{
			res = false;
		}
		MessageUtility.logSetter(name, "setFurColor", newFurColor, res);
		return res;
	}
} //class Bear extends AnimalThatRoars