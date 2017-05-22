package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * Omnivore class
 * @author Elon Avisror
 *
 */

public class Omnivore implements IDiet
{
	/**
	 * eat function receive animal food as arguments and check if animal can eat food which received
	 * @return res = result
	 */
	public boolean eat(Animal animal, IEdible food)
	{	
		boolean res = false;
		if(this.canEat(food.getFoodtype()))
		{
		    if(food.getFoodtype() == EFoodType.VEGETABLE)
			{
				Herbivore a = new Herbivore();
				a.eat(animal, food);
				res = true;		
			}
		    else if(food.getFoodtype() == EFoodType.MEAT)
			{
				Carnivore a = new Carnivore();
				a.eat(animal, food);
				res = true;		
			}
		}
		return res;
	}

	/**
	 * @return string
	 */
	public String toString() {return ("[" + this.getClass().getSimpleName() + "]");}	
	
	/**
	 * canEat checks if the food which received is meat if yes then return true, else false
	 * @return res result
	 */
	public boolean canEat(EFoodType food)
	{
		boolean res = false;
		if(food == EFoodType.MEAT)
			res = true;
		else if(food == EFoodType.VEGETABLE)
			res = true;
		return res;
	}
} //class Omnivore implements IDiet