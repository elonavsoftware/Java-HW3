package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;
import animals.Lion;

/**
 * Carnivore class
 * @author Mahdi Asali
 *
 */

public class Carnivore implements IDiet
{
	/**
	 * eat function receive animal food as arguments and check if animal can eat food which received
	 * @return res = return
	 */
 	public boolean eat(Animal animal, IEdible food)
 	{
		boolean res = false;
		if(this.canEat(food.getFoodtype()))
		{
			if(animal instanceof Lion)
				((Lion)animal).setScars();
			res = true;
		}
		return res;
 	}

 	/**
 	 * @return string
 	 */
	public String toString() {return ("[" + this.getClass().getSimpleName() + "]");}
	
	/**
	 * canEat checks if the food which received is meat if yes then return true, else false
	 * @return res = result
	 */
	public boolean canEat(EFoodType food)
	{
		boolean res = false;		
		if(food == EFoodType.MEAT)
			res=true;
		return res;
	}
} //class Carnivore implements IDiet