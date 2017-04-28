/*(Assignment: 2 || Campus: Beer Sheva || Author:  Mahdi Asali, Elon Avisror || ID: 206331795,305370801)*/

package mobility;

import utilities.MessageUtility;
/**
 * Mobile class which extends the ILocatable interface
 * @author Mahdi
 *
 */
public abstract class Mobile implements ILocatable{
	//Attributes.
	/**
	 * 
	 */
	private Point location; //Current location
	/**
	 * 
	 */
	private double totalDistance;//Distance the object traveled >0.
	//Methods.
	/**
	 * Mobile Ctor
	 */
	public Mobile(){
		
	}
	/**
	 * Mobile Ctor
	 * @param location
	 */
	public Mobile(Point location)
	{
		this.location=new Point(location);	 //New copy of 'Point'.
	}
	/**
	 * addTotalDistance fuction increment the total distance by 1.
	 * @param _totalDistance
	 */
	public void addTotalDistance(double _totalDistance)
	{
		this.totalDistance+=_totalDistance;
	}
	/**
	 * calcDistance - calculate the distance between two points as Petagoras method.
	 * @param p
	 * @return
	 */
	public double calcDistance(Point p)
	{
		double distance;
		distance=Math.sqrt((Math.pow(this.location.getY()-p.getY(),2)+Math.pow(this.location.getX()-p.getX(),2)));
		return distance;
	}
	/**
	 * move function updates the total distance and calculate the distance of the received argument 
	 * @param p
	 * @return
	 */
	public double move(Point p)
	{
		double dis=this.calcDistance(p);
		this.addTotalDistance(dis);
		return dis;
	}
	@Override
	/**
	 * getLocation returns the current point location.
	 */
	public Point getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	@Override
	/**
	 * setLocation updates the new location 
	 * @param other
	 * @return res
	 */
	public boolean setLocation(Point other) {
		boolean res=false;
		if(other!=null)
		{
			res=true;
			this.location=new Point(other);
		}
		// TODO Auto-generated method stub
		return res;
	}
	
	/////ADDED BY ME
	/**
	 * getDistance
	 */
	public double getDistance(){
		return this.totalDistance;
	}
}
