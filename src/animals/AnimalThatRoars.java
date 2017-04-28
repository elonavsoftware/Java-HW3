/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/

package animals;

import mobility.Point;
/**
 * an abstracted class that extends animal class.
 * @author Elon
 *
 */
public abstract class AnimalThatRoars extends Animal {
	/**
	 * AnimalThatRoars- Constructor.
	 * @param name
	 * @param location
	 */
	public AnimalThatRoars(String name, Point location) {
		super(name, location);
	}
		// TODO Auto-generated constructor stub
	public void makeSound()
	{
		roar();
	}
	public abstract void roar();
}




