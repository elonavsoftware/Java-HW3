package animals;
import java.awt.Image;
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
	public AnimalThatChews(String name, Point location, Image rm, Image lm) { super(name, location, rm, lm); }
	/**
	 * makeSound function
	 */
	public void makeSound() { chew(); }
	/**
	 * an abstracted function - chew
	 */
	public abstract void chew();
} //abstract class AnimalThatChews extends Animal