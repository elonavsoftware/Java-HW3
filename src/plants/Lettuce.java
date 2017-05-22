package plants;

import graphics.ZooPanel;

/**
 * @author Elon Avisror
 *
 */

public class Lettuce extends Plant
{
	ZooPanel mypanel;
	
	/**
	 * Lettuce constructor
	 * @param mypan
	 */
	public Lettuce(ZooPanel mypan)
	{	
		super(mypan);
		this.loadImages("lettuce.png");
	}
} //class Lettuce extends Plant