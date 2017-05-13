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
	public AnimalThatChews(String name, Point location,  Color clr,ZooPanel pan, BufferedImage limg,BufferedImage rimg) { super(name, location,clr,pan,limg,rimg); }
	/**
	 * makeSound function
	 */
	public void makeSound() { chew(); }
	/**
	 * an abstracted function - chew
	 */
	public abstract void chew();
} //abstract class AnimalThatChews extends Animal