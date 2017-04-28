/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/


package animals;
import utilities.MessageUtility;
import diet.IDiet;
import mobility.Point;
import diet.Herbivore;
/**
 * Elephant class
 * @author Mahdi
 *
 */
public class Elephant extends AnimalThatChews{
//Atributes:
	/**
	 * 
	 */
	private double trunkLength;
//Ctors:
	//This Ctor added by me to make possiblity of default necklen.
	/**
	 * Elephant constructor
	 * @param name
	 */
	public Elephant(String name)
	{
		super(name, new Point(50,90));
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(500);
		this.settrunkLength(1);//By Default.
		IDiet _diet=new Herbivore();
		this.setDiet(_diet);

	}
	/**
	 * Elephant ctor receive two arguments
	 * @param name
	 * @param trunkLen
	 */
	public Elephant(String name,double trunkLen)
	{
		super(name, new Point(50,90));
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(500);
		this.settrunkLength(trunkLen);//By Default.
		IDiet _diet=new Herbivore();
		this.setDiet(_diet);

	}

//Methods:
	/**
	 * settrunkLength - boolean function which sents the the Elephant trunklen.
	 * @param newtrunk
	 * @return
	 */
	public boolean settrunkLength(double newtrunk){
		boolean res=false;
		if(newtrunk>=0.5 && newtrunk <=3)
		{
			this.trunkLength=newtrunk;
			res=true;
		}
		MessageUtility.logSetter(name, "settrunkLength", newtrunk, res);
		return res;
	}
	/**
	 * chew function.
	 */
	public void chew()
	{
		 MessageUtility.logSound(name, "Trumpets with joy while flapping its ears, then chews");
	}
}

