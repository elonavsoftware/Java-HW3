package plants;
import utilities.MessageUtility;
/**
 * @author baroh
 *
 */
public class Lettuce extends Plant
{
	public Lettuce()
	{
		MessageUtility.logConstractor("Lettuce", "Lettuce");
		this.loadImages("lettuce.png");
	}
} //class Lettuce extends Plant