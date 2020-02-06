package hello;

//has data 
public class SlotsModel 
{

	public String ID;
	public int pixelX;
	public int pixelY;
	public boolean availability;
	public String uTime;
	public int divisionID;

	public SlotsModel(String ID, int pixelX, int pixelY, boolean availability, String uTime, int divisionID)
	{
		this.ID = ID;
		this.pixelX = pixelX;
		this.pixelY = pixelY;
		this.availability = availability;
		this.uTime = uTime;
		this.divisionID = divisionID;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public int getpixelX()
	{
		return pixelX;
	}
	
	public int pixelY()
	{
		return pixelY;
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