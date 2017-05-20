package plants;
import graphics.ZooPanel;
import utilities.MessageUtility;
/**
 * @author Elon Avisror
 *
 */
public class Cabbage extends Plant
{
		ZooPanel mypanel;
		public Cabbage(ZooPanel mypan)
		{	
			super(mypan);
		MessageUtility.logConstractor("Cabbage", "Cabbage");
		this.loadImages("cabbage.png");
	}
} //Cabbage extends Plant