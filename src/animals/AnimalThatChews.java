package animals;
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
	public AnimalThatChews(String name, Point location) {super(name, location);}
	/**
	 * makeSound function
	 */
	public void makeSound() {chew();}
	/**
	 * an abstracted function - chew
	 */
	public abstract void chew();
} //abstract class AnimalThatChews extends Animal