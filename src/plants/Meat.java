package plants;
import utilities.MessageUtility;
/**
 * @author Elon Avisror
 *
 */
public class Meat extends Plant
{
	public Meat()
	{
		MessageUtility.logConstractor("Meat", "Meat");
		this.loadImages("meat.gif");
	}
} //Cabbage extends Meat