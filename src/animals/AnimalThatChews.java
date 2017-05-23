package animals;

import graphics.ZooPanel;
import mobility.Point;

/**
 * an abstracted class that extends animal class
 * @author Elon Avisror
 *
 */

public abstract class AnimalThatChews extends Animal
{
	/**
	 * constructor AnimalThatChews
	 * @param name
	 * @param location
	 */
	public AnimalThatChews(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location) {super(Size, HSpeed, VSpeed, color, panel, location);}
} //abstract class AnimalThatChews extends Animal