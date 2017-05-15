package plants;
import utilities.MessageUtility;
/**
 * @author Elon Avisror
 *
 */
public class Cabbage extends Plant
{
	public Cabbage()
	{
		MessageUtility.logConstractor("Cabbage", "Cabbage");
		this.loadImages("cabbage.png");
	}
} //Cabbage extends Plant