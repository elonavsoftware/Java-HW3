package diet;

import food.EFoodType;
import animals.Animal;
import food.IEdible;;

/**
 * IDiet interface, for animals
 * @author Elon Avisror
 *
 */

public interface IDiet
{
	boolean canEat(EFoodType food);
	boolean eat(Animal animal, IEdible food);
} //interface IDiet