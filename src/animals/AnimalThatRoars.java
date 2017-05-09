package animals;
import java.awt.Image;
import mobility.Point;
/**
 * an abstracted class that extends animal class.
 * @author Elon
 *
 */
public abstract class AnimalThatRoars extends Animal
{
	/**
	 * AnimalThatRoars- Constructor.
	 * @param name
	 * @param location
	 */
	public AnimalThatRoars(String name, Point location, Image rm, Image lm) { super(name, location, rm, lm); }
	public void makeSound() { roar(); }
	public abstract void roar();
}//abstract class AnimalThatRoars extends Animal