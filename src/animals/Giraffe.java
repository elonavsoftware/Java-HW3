package animals;
import diet.Herbivore;
import diet.IDiet;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
public class Giraffe extends AnimalThatChews
{
	private double neckLength;
	/**
	 * Giraffe ctor
	 * @param name
	 */
	public Giraffe(String name, Color clr,ZooPanel pan, BufferedImage limg,BufferedImage rimg)
	{
		super(name, new Point(0, 50),clr,pan,limg,rimg);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);	
		super.setWeight(450);
		this.setNeckLength(1.5);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
	}

	/**
	 * Giraffe ctor
	 * @param name
	 * @param _neckLenght
	 */
	public Giraffe(String name, double _neckLenght,Color clr,ZooPanel pan, BufferedImage limg,BufferedImage rimg)
	{
		super(name, new Point(0, 50),clr,pan,limg,rimg);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(450);
		this.setNeckLength(_neckLenght);
		IDiet _diet = new Herbivore();
		this.setDiet(_diet);
	}
	/**
	 * setNeckLength boolean function, sets the new neck length of giraffe.
	 * @param newNeckLen
	 * @return
	 */
	public boolean setNeckLength(double newNeckLen)
	{
		boolean res = false;
		if(newNeckLen >= 1 && newNeckLen <= 2.5)
		{
			this.neckLength = newNeckLen;
			res = true;
		}
		MessageUtility.logSetter(name, "setNeckLength", newNeckLen, res);
		return res;
		
	}
	/**
	 * chew function.
	 */
	public void chew() {MessageUtility.logSound(name, "Bleats and Stomps its legs, then chews");}
	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		   /*g.setColor(col);
		   if(x_dir==1) // giraffe goes to the right side
			g.drawImage(img1, location.x-size/2, location.y-size/10, size/2, size, pan);
		   else // giraffe goes to the left side
			g.drawImage(img2, location.x, location.y-size/10, size/2, size, pan);*/
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
}//class Giraffe extends AnimalThatChews