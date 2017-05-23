package animals;

import graphics.ZooPanel;
import mobility.Point;

/**
 * an abstracted class that extends animal class
 * @author Elon Avisror
 *
 */

public abstract class AnimalThatRoars extends Animal
{
	/**
	 * AnimalThatRoars - Constructor
	 * @param name
	 * @param location
	 */
	public AnimalThatRoars(int Size,int HSpeed, int VSpeed, String color, ZooPanel panel, Point location) {super(Size, HSpeed, VSpeed, color, panel, location);}
} //abstract class AnimalThatRoars extends Animal