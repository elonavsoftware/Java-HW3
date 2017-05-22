package plants;

import graphics.ZooPanel;

/**
 * @author Elon Avisror
 *
 */

public class Meat extends Plant
{
	ZooPanel mypanel;
	
	/**
	 * Meat constructor
	 * @param mypan
	 */
	public Meat(ZooPanel mypan)
	{	
		super(mypan);
		this.loadImages("meat.gif");
	}
} //class Meat extends Plant