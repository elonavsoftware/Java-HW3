/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/

package diet;
import food.EFoodType;
import animals.Animal;
import food.IEdible;;
public interface IDiet {
boolean canEat(EFoodType food);
boolean eat(Animal animal , IEdible food);
}
