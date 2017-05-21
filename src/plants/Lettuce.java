package plants;
import graphics.ZooPanel;
import utilities.MessageUtility;
/**
 * @author baroh
 *
 */
public class Lettuce extends Plant
{
	ZooPanel mypanel;
	public Lettuce(ZooPanel mypan)
	{	
		super(mypan);
		MessageUtility.logConstractor("Lettuce", "Lettuce");
		this.loadImages("lettuce.png");
	}
} //class Lettuce extends Plant