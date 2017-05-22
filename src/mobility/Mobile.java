package mobility;

/**
 * Mobile class which extends the ILocatable interface
 * @author Mahdi Asali
 *
 */

public abstract class Mobile implements ILocatable
{
	private Point location; //Current location
	private double totalDistance; //Distance the object traveled > 0
	
	/**
	 * Mobile default constructor
	 */
	public Mobile() {}
	
	/**
	 * Mobile constructor
	 * @param location
	 */
	public Mobile(Point location) {this.location=new Point(location);} //New copy of 'Point'.
	
	/**
	 * addTotalDistance function increment the total distance by 1
	 * @param _totalDistance
	 */
	public void addTotalDistance(double _totalDistance) {this.totalDistance += _totalDistance;}
	
	/**
	 * calcDistance - calculate the distance between two points as Petagoras method.
	 * @param p
	 * @return distance
	 */
	public double calcDistance(Point p)
	{
		double distance;
		distance = Math.sqrt((Math.pow(this.location.getY() - p.getY(), 2) + Math.pow(this.location.getX() - p.getX(), 2)));
		return distance;
	}
	
	/**
	 * move function updates the total distance and calculate the distance of the received argument 
	 * @param p = point
	 * @return distance
	 */
	public double move(Point p)
	{
		double distance = this.calcDistance(p);
		this.addTotalDistance(distance);
		return distance;
	}

	/**
	 * getLocation returns the current point location
	 * @return this.location
	 */
	public Point getLocation() {return this.location;}

	/**
	 * setLocation updates the new location 
	 * @param other
	 * @return res = result
	 */
	public boolean setLocation(Point other)
	{
		boolean res = false;
		if(other != null)
		{
			res = true;
			this.location = new Point(other);
		}
		return res;
	}
	
	/**
	 * getDistance
	 * @return this.totalDistance
	 */
	public double getDistance(){return this.totalDistance;}
} //abstract class Mobile implements ILocatable
