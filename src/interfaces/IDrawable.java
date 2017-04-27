package interfaces;
public interface IDrawable
{
	public final static String PICTURE_PATH = "...";
	public void loadImages(String nm);
	public void drawObject(String g); //Graphics
	public String getColor();
}//IDrawable