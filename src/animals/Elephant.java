package animals;

import diet.IDiet;
import graphics.ZooPanel;
import mobility.Point;
import diet.Herbivore;

/**
 * Elephant class
 * @author Mahdi Asali
 *
 */

public class Elephant extends AnimalThatChews
{
	private double trunkLength;
	
	/**
	 * 
	 * @param size
	 * @param HSpeed
	 * @param VSpeed
	 * @param color
	 * @param panel
	 * @param location
	 */
	public Elephant(int size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{
		super(size, HSpeed, VSpeed, color, panel, location); 
		IDiet diet = new Herbivore();
		this.setDiet(diet);
		this.setWeight(size * 10);
		this.loadImages("elf");
		this.setName("Elephant");
	}

	/**
	 * settrunkLength - boolean function which sents the the Elephant trunklen
	 * @param newtrunk
	 * @return res = result
	 */
	public boolean settrunkLength(double newtrunk)
	{
		boolean res = false;
		if(newtrunk >= 0.5 && newtrunk <= 3)
		{
			this.trunkLength = newtrunk;
			res = true;
		}
		return res;
	}
} //class Elephant extends AnimalThatChews