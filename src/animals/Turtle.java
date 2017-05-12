package animals;
import diet.Herbivore;
import diet.IDiet;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Graphics;
import java.awt.Image;
/**
 * Turtle Class contain's type,name,weight,position(X,Y),distance of the Turtle Object.
 * @author Mahdi Asali
 *
 */
public class Turtle extends AnimalThatChews
{
	private int Age;
	/**
	 * ctor of turtle
	 * @param name
	 */
	public Turtle(String name, Image rm, Image lm)
	{
		super(name,new Point(0, 80), rm, lm);
		super.setWeight(1);
		this.setAge(1);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);	
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
	 * ctor of turtle
	 * @param name
	 * @param age
	 */
	public Turtle(String name, int age, Image rm, Image lm)
	{
		super(name,new Point(0, 80), rm, lm);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		super.setWeight(1);
		this.setAge(age);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
		//NEW Fields
		this.setImage(rm, lm);
	}
	/**
	 * setage function
	 * @param _Age
	 * @return res
	 */
	public boolean setAge(int _Age)
	{
		boolean res=true;
		if(_Age < 0 || Age > 500)
			res = false;
		this.Age = _Age;
		MessageUtility.logSetter(name, "setAge", _Age, res);
		return res;
	}
	/**
	 * chew function
	 */
	public void chew() {MessageUtility.logSound(name, "Retracts its head in then eats quietly");}
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
} //class Turtle extends AnimalThatChews