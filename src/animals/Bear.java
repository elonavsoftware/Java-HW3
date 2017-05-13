package animals;
import diet.IDiet;
import diet.Omnivore;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
	public Bear(String name, String newFurColor,Color clr,ZooPanel pan, BufferedImage limg,BufferedImage rimg)
	{
		super(name, new Point(100, 5),clr,pan,limg,rimg);
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(308.2);
		boolean res=this.setFurColor(newFurColor);
		IDiet _diet = new Omnivore();
		if(!res)
			this.setFurColor("GRAY");
		this.setDiet(_diet);
		//added this:
		x_dir=1;
		y_dir=1;
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
		   g.setColor(col);
		   if(x_dir==1) // giraffe goes to the right side
			g.drawImage(img1, getLocation().getX()-size/2, getLocation().getY()-size/10, size/2, size, pan);
		   else // giraffe goes to the left side
			g.drawImage(img2, getLocation().getX(), getLocation().getY()-size/10, size/2, size, pan);
	}
	

	@Override
	public void run()
	{
		/*while(true){
			try {
				synchronized(this){
					if(this.threadSuspended==true)// sleep the Animals 
						wait();
				}
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ap.getIsFood()==false){
				if(this.getLocation().getX()>ap.getWidth())
					x_dir=-1;
				else if(this.getLocation().getX()<0)
					x_dir=1;
				if(this.getLocation().getY()>ap.getHeight())
					y_dir=-1;
				else if(this.getLocation().getY()<0)
					y_dir=1;
				//x_front+=(int)horSpeed*x_dir;
				//y_front+=(int)verSpeed*y_dir;
				
			}
			else{
					if(x_front>ap.getWidth()/2)
						x_dir=-1;
					else
						x_dir=1;
					if(y_front>ap.getHeight()/2)
						y_dir=-1;
					else
						y_dir=1;
					
					newspeeds();
					if(flag==true){
						try{
							barrier.await();
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						flag=false;
					}
					
					x_front += (int)newhorSpeed*x_dir;
					y_front += (int)newverSpeed*y_dir;
					if((Math.abs(x_front-ap.getWidth()/2)<=5) && (Math.abs(y_front-ap.getHeight()/2)<=5)){
						ap.setifFood(false);// to eat to Worm 
						ap.callback(this);
					}
		}
			ap.repaint();
	}*/
	}

} //class Bear extends AnimalThatRoars