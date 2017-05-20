package plants;
import graphics.ZooPanel;
import utilities.MessageUtility;
/**
 * @author Elon Avisror
 *
 */
public class Meat extends Plant
{
	ZooPanel mypanel;
	public Meat(ZooPanel mypan)
	{	
		super(mypan);
		MessageUtility.logConstractor("Meat", "Meat");
		this.loadImages("meat.gif");
	}
} //Cabbage extends Meat