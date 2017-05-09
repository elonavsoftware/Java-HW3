package animals;
import mobility.Mobile;
import mobility.Point;
import food.EFoodType;
import food.IEdible;
import java.awt.Image;
import diet.IDiet;
import utilities.MessageUtility;

/**
 * animal class - present all the animals.
 * @author Mahdi
 *
 */
public abstract class Animal extends Mobile implements IEdible
{
	protected Image rImage;
	protected Image lImage;

	/**
	 * 
	 */
	protected String name;
	/**
	 * 
	 */
	private double weight;
	/**
	 * 
	 */
	private IDiet diet;
	//Constructors
	/**
	 * Animal Constructor
	 * @param name
	 * @param location
	 */
	public Animal(String name, Point location, Image rm, Image lm)
	{
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		this.setLocation(location);
		this.rImage = rm;
		this.lImage = lm;
	}
	
	//Methods
	/**
	 * 	setName function
	 * @param _name
	 * @return res
	 */
	public boolean setName(String _name)
	{
		boolean res = true;
		if(_name == null)
			res = false;
		this.name = _name;
		MessageUtility.logSetter(name, "setName", _name, res);
		return res;
	}
	/**
	 * setDiet function
	 * @param _diet
	 * @return res
	 */
	public boolean setDiet(IDiet _diet)
	{
		boolean res = false;
		if(_diet != null)
		{
			res=true;
		}
		this.diet = _diet;
		MessageUtility.logSetter(name, "setDiet", _diet, res);
		return res;
	}
	/**
	 * getDiet function
	 * @return this.diet
	 */
	public IDiet getDiet()
	{
		MessageUtility.logGetter(name, "getDiet",this.diet);
		return this.diet;
	}
	/**
	 * getWeight
	 * @return weight
	 */
	public double getWeight()
	{
		MessageUtility.logGetter(name, "getWeight", weight); 
		return weight;
	}
	/**
	 * setWeight - set Weight function.
	 * @param neweight
	 * @return res - result.
	 */
	public boolean setWeight(double neweight)
	{
		boolean res = true;
		if(neweight < 0)
			res=false;
		this.weight = neweight;
		MessageUtility.logSetter(name, "setWeight", neweight, res);
		return res;
	}
	/**
	 * 
	 */
	public String toString() {return "[" + this.getClass().getSimpleName() + "]"+"("+name+")";}
	/**
	 * 
	 */
	public abstract void makeSound();
	/**
	 * eat function
	 * @param type 
	 * @return res - result
	 */
	public boolean eat(IEdible type)
	{
		boolean res=false;
		boolean x=this.diet.canEat(type.getFoodtype());
		if(x == true)
			res=this.diet.eat(this, type);
		MessageUtility.logBooleanFunction(name, "eat", type, res);
		return res;
	}
	/**
	 * getName
	 * @return this.name
	 */
	public String getName()
	{
		MessageUtility.logGetter(name, "getName", name);
		return this.name;
	}
	/**
	 * move function
	 */
	public double move(Point p)
	{
		double distance = super.move(p);
		boolean flag2 = false;
		if(Point.cheackBounderies(p))
		{
			boolean flag = false;
			if(distance != 0)
				flag = true;
			flag2 = flag;
			double getweight = this.getWeight();
			this.setWeight(getweight - (distance * getweight * 0.00025));
			
		}
		MessageUtility.logBooleanFunction(name, "move", p,flag2);
		return distance;
	}
	
	@Override
	/**
	 * getFoodtype - function getting the food type of animal.
	 */
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(name, "getFoodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}
} //abstract class Animal extends Mobile implements IEdible