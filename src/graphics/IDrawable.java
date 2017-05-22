package graphics;

import java.awt.Graphics;

/**
 * 
 * @author Elon Avisror
 *
 */

public interface IDrawable
{
	public final static String PICTURE_PATH = "pictures\\";
	public void loadImages(String nm);
	public void drawObject (Graphics g);
	public String getColor();
} //interface IDrawable