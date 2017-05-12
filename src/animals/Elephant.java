package animals;
import utilities.MessageUtility;
import diet.IDiet;
import mobility.Point;

import java.awt.Graphics;
import java.awt.Image;
import diet.Herbivore;
/**
 * Elephant class
 * @author Mahdi
 *
 */
public class Elephant extends AnimalThatChews
{
	/**
	 * 
	 */
	private double trunkLength;
	/**
	 * Elephant constructor
	 * @param name
	 */
	public Elephant(String name, Image rm, Image lm)
	{
		super(name, new Point(50, 90), rm, lm);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(500);
		this.settrunkLength(1); //By Default.
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
		//NEW Fields
		this.setImage(rm, lm);
	}
	/**
	 * Elephant ctor receive two arguments
	 * @param name
	 * @param trunkLen
	 */
	public Elephant(String name, double trunkLen, Image rm, Image lm)
	{
		super(name, new Point(50, 90), rm, lm);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(500);
		this.settrunkLength(trunkLen);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
		//NEW Fields
		this.setImage(rm, lm);
	}
	//NEW Method.
	public Boolean setImage(Image rm,Image lm)
	{
		boolean res=false;
		if(rm !=null && lm!=null)
		{
			this.lImage=lm;
			this.rImage=rm;
			res=true;
		}
		return res;
	}
	/**
	 * settrunkLength - boolean function which sents the the Elephant trunklen.
	 * @param newtrunk
	 * @return
	 */
	public boolean settrunkLength(double newtrunk)
	{
		boolean res = false;
		if(newtrunk >= 0.5 && newtrunk <= 3)
		{
			this.trunkLength = newtrunk;
			res = true;
		}
		MessageUtility.logSetter(name, "settrunkLength", newtrunk, res);
		return res;
	}
	/**
	 * chew function.
	 */
	public void chew() {MessageUtility.logSound(name, "Trumpets with joy while flapping its ears, then chews");}
	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAnimalName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void eatInc() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getEatCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean getChanges() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setSuspended() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setResumed() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setChanges(boolean state) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
} //class Elephant extends AnimalThatChews