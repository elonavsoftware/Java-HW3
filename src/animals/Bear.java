/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/

package animals;
import diet.Carnivore;
import diet.IDiet;
import diet.Omnivore;
import mobility.Point;
import utilities.MessageUtility;
/**
 * Bear class ,extends 'AnimalThatRoars' class.
 * @author Elon
 *
 */
public class Bear extends AnimalThatRoars{
	//Attributes
	/**
	 * 
	 */
	private String furColor;
	
	//Ctors.
	/**
	 * Bear Constructor
	 * @param name
	 * @param newFurColor
	 */
	public Bear(String name, String newFurColor)
	{
		super(name,new Point(100,5));
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(308.2);
		boolean res=this.setFurColor(newFurColor);
		IDiet _diet=new Omnivore();
		//IDiet _diet = new Carnivore();
		if(!res)
		{
			this.setFurColor("GRAY");
		}
		this.setDiet(_diet);
	}
	/**
	 * roar function prints a message of utility .
	 */
//Methods:
	public void roar()
	{
		MessageUtility.logSound(name, "Stands on its hind legs, roars and scratches its belly");
	}
	///////////////My Methods///////////////
	/**
	 * getFurColor
	 * @return this.furColor
	 */
	public String getFurColor(){
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
		boolean res=false;
		if(newFurColor=="BLACK" || newFurColor =="WHITE" || newFurColor == "GRAY")
		{
			this.furColor=newFurColor;
			res=true;
		}
		else
		{
			res=false;
		}
		MessageUtility.logSetter(name, "setFurColor", newFurColor, res);
		return res;
	}
}

