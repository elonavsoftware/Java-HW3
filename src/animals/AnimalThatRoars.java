package animals;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import graphics.ZooPanel;
import mobility.Point;
/**
 * an abstracted class that extends animal class.
 * @author Elon Avisror
 *
 */
public abstract class AnimalThatRoars extends Animal
{
	/**
	 * AnimalThatRoars- Constructor.
	 * @param name
	 * @param location
	 */
	//public AnimalThatRoars(String name, Point location,  Color clr,ZooPanel pan) { super(name, location, clr, pan); }
	public AnimalThatRoars(int Size,int HSpeed, int VSpeed, String color ,ZooPanel panel,Point location) { super(Size, HSpeed,VSpeed,color,panel,location); }
	public void makeSound() { roar(); }
	public abstract void roar();
}//abstract class AnimalThatRoars extends Animal