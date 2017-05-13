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
/**
 * Turtle Class contain's type,name,weight,position(X,Y),distance of the Turtle Object.
 * @author Mahdi Asali
 *
 */
public class Turtle extends AnimalThatChews
{
	private int Age;
	public Turtle(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location)
	{
		 super(Size, HSpeed,VSpeed,color,panel,location); 
		 this.setWeight(0.5*size);
		 this.loadImages("trt_"); 
	}
	
	/**
	 * ctor of turtle
	 * @param name
	 */
	/*public Turtle(String name, Color clr,ZooPanel pan)
	{
		super(name,new Point(0, 80),clr,pan);
		super.setWeight(1);
		this.setAge(1);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);	
	}*/

	/**
	 * ctor of turtle
	 * @param name
	 * @param age
	 */
	/*public Turtle(String name, int age,Color clr,ZooPanel pan)
	{
		super(name,new Point(0, 80), clr,pan);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		super.setWeight(1);
		this.setAge(age);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
	}*/
	/**
	 * setage function
	 * @param _Age
	 * @return res
	 */
	public boolean setAge(int _Age)
	{
		boolean res=true;
		if(_Age < 0 || Age > 500)
			res = false;
		this.Age = _Age;
		MessageUtility.logSetter(name, "setAge", _Age, res);
		return res;
	}
	/**
	 * chew function
	 */
	public void chew() {MessageUtility.logSound(name, "Retracts its head in then eats quietly");}

} //class Turtle extends AnimalThatChews