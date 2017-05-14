package animals;
import utilities.MessageUtility;
import diet.IDiet;
import graphics.ZooPanel;
import mobility.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import diet.Herbivore;
/**
 * Elephant class
 * @author Mahdi
 *
 */
public class Elephant extends AnimalThatChews
{
	/**
	 * 
	 */
	private double trunkLength;
	
	//myctor
	
	public Elephant(int Size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{
		 super(Size, HSpeed, VSpeed, color, panel, location); 
		 this.setWeight(size * 10);
		 this.loadImages("elf_");
	}
	
	
	/**
	 * Elephant constructor
	 * @param name
	 */
	/*public Elephant(String name, Color clr,ZooPanel pan)
	{
		super(name, new Point(50, 90),clr,pan);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(500);
		this.settrunkLength(1); //By Default.
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
	}*/
	/**
	 * Elephant ctor receive two arguments
	 * @param name
	 * @param trunkLen
	 */
	/*public Elephant(String name, double trunkLen, Color clr,ZooPanel pan)
	{
		super(name, new Point(50, 90),clr,pan);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(500);
		this.settrunkLength(trunkLen);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
	}*/

	/**
	 * settrunkLength - boolean function which sents the the Elephant trunklen.
	 * @param newtrunk
	 * @return
	 */
	public boolean settrunkLength(double newtrunk)
	{
		boolean res = false;
		if(newtrunk >= 0.5 && newtrunk <= 3)
		{
			this.trunkLength = newtrunk;
			res = true;
		}
		MessageUtility.logSetter(name, "settrunkLength", newtrunk, res);
		return res;
	}
	/**
	 * chew function.
	 */
	public void chew() {MessageUtility.logSound(name, "Trumpets with joy while flapping its ears, then chews");}
} //class Elephant extends AnimalThatChews