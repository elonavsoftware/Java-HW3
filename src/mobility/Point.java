package mobility;

/**
 * a Point Class, creating a point which contain x, y 
 * each of x, y is a 2d position
 * @author Mahdi Asali 
 *
 */

public class Point
{
	 private int x, y;
	 
	 /**
	  * Class constructor to initiate the values of self object
	  * @param x
	  * @param y
	  */
	 public Point(int x, int y)
	 {
		 this.setX(x);
		 this.setY(y);
	 }
	 
	 /**
	  * Point ctor
	  * @param p
	  */
     public Point(Point p) {this(p.getX(), p.getY());}
     
     /**
      * setX sets the cord x of point.
      * @param x
      * @return res = result
      */
	 public boolean setX(int x)
	 {
		 boolean res = false;
		 this.x = x;
		 res = true;
		 return res;
	 }
	 
	 /**
	  * setY sets the cord y of point.
	  * @param y
	  * @return res = result
	  */
	 public boolean setY(int y)
	 {
		 boolean res = false;
		 this.y = y;
		 res = true;
		 return res;
	 }
	 
	 /**
	  * @return string
	  */
	public String toString() {return ("(" + this.getX() + "," + this.getY() + ")");}
	
	 /**
	  * checkBounderies function checks if the point in the right and limited position
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
	  * @return this.x
	  */
	 public int getX() {return this.x;}
	 
	 /**
	  * getY method
	  * @return this.y
	  */
	 public int getY() {return this.y;}
} //class Point