package diet;

import animals.Animal;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;

/**
 * Herbivore class
 * @author Mahdi Asali
 *
 */

public class Herbivore implements IDiet
{
	/**
	 * canEat checks if the food which received is meat if yes then return true, else false
	 * @return res = result
	 */
	public boolean canEat(EFoodType food)
	{
		boolean res = false;
		if(EFoodType.VEGETABLE == food)
			res = true;
		return res;
	}

	/**
	 * @return string
	 */
	public String toString() {return ("[" + this.getClass().getSimpleName() + "]");}

	/**
	 * eat function receive animal food as arguments and check if animal can eat food which received
	 * @return res = result
	 */
	public boolean eat(Animal animal, IEdible food)
	{
		boolean res = false;
		if(this.canEat(food.getFoodtype()))
			res = true;
		return res;
	}
} //class Herbivore implements IDiet