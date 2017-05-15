package mobility;

import utilities.MessageUtility;

/**
 * a Point Class, creating a point which contain x, y 
 * each of x, y is a 2d position.
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
	 public Point(int x,int y)
	 {
		 this.setX(x);
		 this.setY(y);
	 }
	 /**
	  * Point ctor
	  * @param p
	  */
     public Point(Point p)
     {
    	    this(p.getX(), p.getY());
    	    //no defensive copies are created here, since 
    	    //there are no mutable object fields (String is immutable)
     }
     /**
      * setX sets the cord x of point.
      * @param x
      * @return
      */
	 public boolean setX(int _x)
	 {
		 boolean res = false;
		 if(x >= 0 && x <= 800)
		 {
			 this.x = _x;
			 res = true;
			 MessageUtility.logSetter("Test", "SetX", this.x, res);
		 }
		 return res;
	 }
	 /**
	  * setY sets the cord y of point.
	  * @param y
	  * @return
	  */
	 public boolean setY(int _y)
	 {
		 boolean res = false;
		 if(y >= 0 && y <= 600)
		 {
			 this.y = _y;
			 res = true;
			 //MessageUtility.logSetter("Test", "SetY", this.y, res);
		 }
		 return res;
	 }
	 /**
	  * 
	  */
	public String toString() {return "(" + this.getX() +","+this.getY() +")";}
	 /**
	  * checkBounderies function checks if the point in the right and limited position.
	  * @return x
	  */
	 public static boolean cheackBounderies(Point newLocation)
	 {
		 boolean x = false;
		 if((newLocation.getX() < 0 || newLocation.getX() > 800)||(newLocation.getY() < 0 || newLocation.getY() > 600))
			 x = false;
		 else
			 x = true;
		 return x;
	 }
	 /**
	  * getX method
	  * @return x
	  */
	 public int getX() {return x;}
	 /**
	  * getY method
	  * @return y
	  */
	 public int getY() {return y;}
} //class Point