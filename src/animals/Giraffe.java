/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/



package animals;
import diet.Herbivore;
import diet.IDiet;
import mobility.Point;
import utilities.MessageUtility;
public class Giraffe extends AnimalThatChews{
//Attributes:
	private double neckLenght;
//Ctors:
	
	/**
	 * Giraffe ctor
	 * @param name
	 */
	public Giraffe(String name)
	{
		super(name, new Point(0,50));
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);	
		super.setWeight(450);
		this.setNeckLength(1.5);
		IDiet _diet=new Herbivore();
		this.setDiet(_diet);
	}
	/**
	 * Giraffe ctor
	 * @param name
	 * @param _neckLenght
	 */
	public Giraffe(String name,double _neckLenght)
	{
		super(name, new Point(0,50));
		MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
		super.setWeight(450);
		this.setNeckLength(_neckLenght);
		IDiet _diet=new Herbivore();
		this.setDiet(_diet);
	}
	///////////My Methods//////////
	/**
	 * setNeckLength boolean function, sets the new neck length of giraffe.
	 * @param newNeckLen
	 * @return
	 */
	public boolean setNeckLength(double newNeckLen)
	{
		boolean res=false;
		if(newNeckLen>=1 && newNeckLen<=2.5)
		{
			this.neckLenght=newNeckLen;
			res=true;
		}
		MessageUtility.logSetter(name, "setNeckLength", newNeckLen, res);
		return res;
		
	}
//Methods:
	/**
	 * chew function.
	 */
	public void chew(){
		 MessageUtility.logSound(name, "Bleats and Stomps its legs, then chews");

	}
}

