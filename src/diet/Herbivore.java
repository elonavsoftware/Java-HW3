/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/

package diet;
import animals.Animal;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import utilities.MessageUtility;

/**
 * Herbivore class .
 * @author Mahdi
 *
 */
public class Herbivore implements IDiet {
	@Override
	/**
	 * canEat checks if the food which recieved is meat if yes then return true else false;
	 */
	public boolean canEat(EFoodType food) {
		boolean res=false;

		// TODO Auto-generated method stub
		if(EFoodType.VEGETABLE==food)
		{
			res=true;
		}
		return res;
	}
	@Override
	/**
	 * 
	 */
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}
	@Override
	/**
	 * eat function receive animal food as arguments and check if animal can eat food which received.
	 */
	public boolean eat(Animal animal, IEdible food) {
		boolean res=false;
		// TODO Auto-generated method stub
		if(this.canEat(food.getFoodtype()))
		{
			double currweight=animal.getWeight();
			animal.setWeight(currweight*0.07+currweight);
			animal.makeSound();
			//return true;
			res=true;
		}
		//return false;
		//MessageUtility.logBooleanFunction(animal.getName(), "eat", food, res); //added by me
		return res;
	}

}
