package animals;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import graphics.ZooPanel;
import mobility.Point;
/**
 * an abstracted class that extends animal class.
 * @author elon
 *
 */
public abstract class AnimalThatChews extends Animal
{
	/**
	 * constructor AnimalThatChews
	 * @param name
	 * @param location
	 */
	//public AnimalThatChews(String name, Point location,  Color clr,ZooPanel pan) { super(name, location,clr,pan); }
	public AnimalThatChews(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location) { super(Size, HSpeed,VSpeed,color,panel,location); }
	/**
	 * makeSound function
	 */
	public void makeSound() { chew(); }
	/**
	 * an abstracted function - chew
	 */
	public abstract void chew();
} //abstract class AnimalThatChews extends Animal