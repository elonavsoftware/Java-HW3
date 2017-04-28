/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/

package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import utilities.MessageUtility;
/**
 * Omnivore class
 * @author Elon
 *
 */
public class Omnivore implements IDiet {
	//check this
	@Override
	/**
	 * eat function receive animal food as arguments and check if animal can eat food which received.
	 */
	public boolean eat(Animal animal, IEdible food) {	
		boolean res=false;
		if(this.canEat(food.getFoodtype()))
		{

		    if(food.getFoodtype()==EFoodType.VEGETABLE)
			{
				Herbivore a=new Herbivore();
				a.eat(animal, food);
				res=true;		
			}
		    
		    else if(food.getFoodtype()==EFoodType.MEAT)
			{
				Carnivore a=new Carnivore();
				a.eat(animal, food);
				res=true;		
			}
		}
		// TODO Auto-generated method stub
		//MessageUtility.logBooleanFunction(animal.getName(), "eat", food, res); //added by me
		return res;
	}
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}	
	
	
	@Override
	/**
	 * canEat checks if the food which recieved is meat if yes then return true else false;
	 */
	public boolean canEat(EFoodType food) {
		boolean res=false;

		if(food==EFoodType.MEAT)
		{
			res=true;
		}
		else if(food==EFoodType.VEGETABLE)
		{
			res=true;
		}
		// TODO Auto-generated method stub
		return res;
	}

}
