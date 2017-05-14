package graphics;

public interface IAnimalBehavior
{
    public String getAnimalName();
	 public int getSize();
	 public void eatInc();
	 public int getEatCount();
	 public boolean getChanges ();
	 public void setSuspended();
	 public void setResumed();
	 public void setChanges (boolean state);
} //interface IAnimalBehavior