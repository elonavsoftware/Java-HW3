package animals;

import diet.Herbivore;
import diet.IDiet;
import graphics.ZooPanel;
import mobility.Point;

/**
 * Turtle class, extends AnimalThatChews class
 * @author Mahdi Asali
 *
 */

public class Turtle extends AnimalThatChews
{
	private int Age;
	/**
	 * 
	 * @param size
	 * @param HSpeed
	 * @param VSpeed
	 * @param color
	 * @param panel
	 * @param location
	 */
	public Turtle(int size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{
		super(size, HSpeed, VSpeed, color, panel, location); 
		this.setWeight(0.5 * size);
		this.loadImages("trt"); 
	  	IDiet diet = new Herbivore();
		this.setDiet(diet);
		this.setName("Turtle");
	}
	
	/**
	 * set age function
	 * @param age
	 * @return res = result
	 */
	public boolean setAge(int age)
	{
		boolean res = true;
		if(age < 0 || Age > 500)
			res = false;
		this.Age = age;
		return res;
	}
} //class Turtle extends AnimalThatChews