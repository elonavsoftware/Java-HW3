package animals;

import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import diet.Carnivore;

/**
 * Lion class related to animal and AnimalThatRoars
 * @author Mahdi Asali
 *
 */

public class Lion extends AnimalThatRoars
{
	private int scarCount;
	
	/**
	 * 
	 * @param size
	 * @param HSpeed
	 * @param VSpeed
	 * @param color
	 * @param panel
	 * @param location
	 */
	public Lion(int size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{
		super(size, HSpeed, VSpeed, color, panel, location); 
		this.loadImages("lio");  
		this.setDiet(new Carnivore());
		this.setName("Lion");
		this.setWeight(size);
	}
	
	/**
	 * eat function to check if the animal can eat specific food which is received as argument 'type'
	 * @return res = result
	 */
	public boolean eat(IEdible type)
	{		
		boolean res = false;
		res = super.eat(type);
		if(res)
			this.setScars();
		return res;
	}
	
	/**
	 * setScars of lion function , counter is incremented by 1 if random equals 1
	 * @return res = result
	 */
	public boolean setScars()
	{
		int x = (Math.random() < 0.5) ? 0:1;
		boolean res = false;
		int tempscar = this.scarCount + 1;
		if(x == 1)
		{
			this.scarCount++;
			res = true;
		}
		return res;
	}

	/**
	 * getFoodtype-returns the animal food type
	 * @return EFoodType.NOTFOOD
	 */
	public EFoodType getFoodtype() {return EFoodType.NOTFOOD;}
} //public class Lion extends AnimalThatRoars