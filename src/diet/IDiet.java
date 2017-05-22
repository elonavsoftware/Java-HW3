package diet;

import food.EFoodType;
import animals.Animal;
import food.IEdible;;

public interface IDiet
{
	boolean canEat(EFoodType food);
	boolean eat(Animal animal, IEdible food);
} //interface IDiet