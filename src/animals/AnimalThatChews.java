/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/

package animals;

import mobility.Point;
/**
 * an abstracted class that extends animal class.
 * @author elon
 *
 */
public abstract class AnimalThatChews extends Animal {
	/**
	 * constructor AnimalThatChews
	 * @param name
	 * @param location
	 */
	public AnimalThatChews(String name, Point location) {
		super(name, location);
		// TODO Auto-generated constructor stub
	}
	/**
	 * makeSound function
	 */
	public void makeSound()
	{
		chew();
	}
	/**
	 * an abstracted function - chew
	 */
	public abstract void chew();
	
	

}
