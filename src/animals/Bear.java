package animals;

import diet.IDiet;
import diet.Omnivore;
import graphics.ZooPanel;
import mobility.Point;

/**
 * Bear class ,extends 'AnimalThatRoars' class.
 * @author Elon Avisror
 *
 */

public class Bear extends AnimalThatRoars
{
	private String furColor;
	
	/**
	 * 
	 * @param size
	 * @param HSpeed
	 * @param VSpeed
	 * @param color
	 * @param panel
	 * @param location
	 */
	public Bear(int size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{
		super(size, HSpeed, VSpeed, color, panel, location); 
		IDiet diet = new Omnivore();
		this.setDiet(diet);
		this.setWeight(size * 1.5);
		this.loadImages("bea"); //this is the bear folder.
		this.setName("Bear");
	}
	
	/**
	 * 
	 * @return this.furColor
	 */
	public String getFurColor() {return this.furColor;}
	
	/**
	 * setFurColor function which sets the color of bear.
	 * @param newFurColor
	 * @return res = result
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
			res = false;
		return res;
	}
} //class Bear extends AnimalThatRoars