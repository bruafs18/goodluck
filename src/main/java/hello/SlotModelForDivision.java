package hello;

public class SlotModelForDivision {
	public boolean availability;
	public String uTime;
	public int divisionID;

	public SlotModelForDivision(boolean availability, String uTime, int divisionID)
	{
		this.availability = availability;
		this.uTime = uTime;
		this.divisionID = divisionID;
	}
	
	
	public boolean availability()
	{
		return availability;
	}
	
	public String uTime()
	{
		return uTime;
	}
	
	public int divisionID()
	{
		return divisionID;
	}		
}
