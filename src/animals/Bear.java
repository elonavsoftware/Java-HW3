package animals;
import diet.IDiet;
import diet.Omnivore;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Graphics;
import java.awt.Image;
/**
 * Bear class ,extends 'AnimalThatRoars' class.
 * @author Elon
 *
 */
public class Bear extends AnimalThatRoars
{
	/**
	 * 
	 */
	private String furColor;
	/**
	 * Bear Constructor
	 * @param name
	 * @param newFurColor
	 */
	public Bear(String name, String newFurColor, Image rm, Image lm,String Color)
	{
		super(name, new Point(100, 5), rm, lm);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(308.2);
		boolean res=this.setFurColor(newFurColor);
		IDiet _diet = new Omnivore();
		if(!res)
			this.setFurColor("GRAY");
		this.setDiet(_diet);
		//NEW Fields
		this.setImage(rm, lm);
		this.setColor(Color);
	}
	//NEW Method.
	public boolean setColor(String C){
		boolean res=false;
		if(C!=null)
		{
			if(C=="Red")
				this.col=col.red;
			res=true;
		}
		return res;
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
	 * roar function prints a message of utility .
	 */
	public void roar() {MessageUtility.logSound(name, "Stands on its hind legs, roars and scratches its belly");}
	/**
	 * getFurColor
	 * @return this.furColor
	 */
	public String getFurColor()
	{
		MessageUtility.logGetter(name, "getFurColor", this.furColor);
		return this.furColor;
	}
	/**
	 * setFurColor function which sets the color of bear.
	 * @param newFurColor
	 * @return
	 */
	public boolean setFurColor(String newFurColor)
	{
		boolean res = false;
		if(newFurColor == "BLACK" || newFurColor == "WHITE" || newFurColor == "GRAY")
		{
			this.furColor = newFurColor;
			res = true;
		}
		else
		{
			res = false;
		}
		MessageUtility.logSetter(name, "setFurColor", newFurColor, res);
		return res;
	}
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
} //class Bear extends AnimalThatRoars