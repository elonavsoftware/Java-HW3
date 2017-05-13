package animals;
import diet.Herbivore;
import diet.IDiet;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
public class Giraffe extends AnimalThatChews
{
	private double neckLength;
	
	public Giraffe(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location)
	{
		 super(Size, HSpeed,VSpeed,color,panel,location); 
		 this.loadImages("\\grf_n_1.png"); 

	}
	
	/**
	 * Giraffe ctor
	 * @param name
	 */
	/*public Giraffe(String name, Color clr,ZooPanel pan)
	{
		super(name, new Point(0, 50),clr,pan);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);	
		super.setWeight(450);
		this.setNeckLength(1.5);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
	}*/

	/**
	 * Giraffe ctor
	 * @param name
	 * @param _neckLenght
	 */
	/*public Giraffe(String name, double _neckLenght,Color clr,ZooPanel pan)
	{
		super(name, new Point(0, 50),clr,pan);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(450);
		this.setNeckLength(_neckLenght);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
	}*/
	/**
	 * setNeckLength boolean function, sets the new neck length of giraffe.
	 * @param newNeckLen
	 * @return
	 */
	public boolean setNeckLength(double newNeckLen)
	{
		boolean res = false;
		if(newNeckLen >= 1 && newNeckLen <= 2.5)
		{
			this.neckLength = newNeckLen;
			res = true;
		}
		MessageUtility.logSetter(name, "setNeckLength", newNeckLen, res);
		return res;
		
	}
	/**
	 * chew function.
	 */
	public void chew() {MessageUtility.logSound(name, "Bleats and Stomps its legs, then chews");}
}//class Giraffe extends AnimalThatChews