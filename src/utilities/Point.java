package utilities;

/**
 * a Point Class , creating a point which contain x ,y 
 * each of x , y is a 2d position.
 * @author Mahdi Asali 
 *
 */
public class Point
{
	 private int x, y;
	 /**
	  * Class constructor to init the values of self object.
	  * @param x
	  * @param y
	  */
	 public Point(int x, int y)
	 {
		 this.x = x;
		 this.y = y;
	 }
     public Point(Point p)
     {
    	    this(p.GetX(), p.GetY());
    	    //no defensive copies are created here, since 
    	    //there are no mutable object fields (String is immutable)
     }
	 /**
	  * this method receive two integers , and init the object point. 
	  * @param x
	  * @param y
	  * @return true or false , if the point in the boundaries x must be between 0 and 800 , y must be between 0 and 600.
	  */
	 public boolean set(int x, int y)
	 {
		 boolean res = false;
		 if((0 <= x && x <= 800) &&(0 <= y && y <= 600))
		 {
			 this.x = x;
			 this.y = y;
			 res = true;
		 }
		 return res;
	 }
	 /**
	  * 
	  * @return x
	  */
	 public static boolean cheackBounderies(Point newLocation)
	 {
		 if(newLocation.GetX() < 0 || newLocation.GetY() > 800)
			 return false;
		 else if(newLocation.GetY() < 0 || newLocation.GetY() > 600)
			 return false;
		 else
			 return true;
	 }
	 public int GetX() {return x;}
	 /**
	  * 
	  * @return y
	  */
	 public int GetY() {return y;}
} //class Point