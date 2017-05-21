package diet;
import food.EFoodType;
import food.IEdible;
import animals.Animal;
import animals.Lion;
/**
 * Carnivore class
 * @author Mahdi
 *
 */
public class Carnivore implements IDiet
{
	@Override
	/**
	 * eat function receive animal food as arguments and check if animal can eat food which received.
	 */
 	public boolean eat(Animal animal ,IEdible food)
 	{
		boolean res = false;
		if(this.canEat(food.getFoodtype()))
		{
			double currweight = animal.getWeight();
			animal.setWeight(currweight*0.1+currweight);
			animal.makeSound();
			if(animal instanceof Lion)
				((Lion)animal).setScars();
			res = true;
		}
		return res;
 	}
	@Override
	/**
	 * 
	 */
	public String toString() {return "[" + this.getClass().getSimpleName() + "]";}
	@Override
	/**
	 * canEat checks if the food which recieved is meat if yes then return true else false;
	 */
	public boolean canEat(EFoodType food)
	{
		boolean res = false;		
		if(food == EFoodType.MEAT)
			res=true;
		return res;
	}
} //class Carnivore implements IDiet