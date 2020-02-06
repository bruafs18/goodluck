package hello;

/** THE MODEL
 * Data related logic.
 * Interacts with the database.
 * Communicates with the controller.
 */
public class DivisionModel {
	private int ID;
	private String name;
	private int partnerID;
	private String sImage;
	
	
	
	public DivisionModel(int ID, String name, int partnerID, String sImage) {
		this.ID=ID;
		this.name=name;
		this.partnerID=partnerID;
		this.sImage=sImage;
	}

	public int getID(){
		return ID;
	}
	
	public String getName(){
		return name;
	}
	
	
	public int getPartnerID(){
		return partnerID;
	}
	
	public String getImage(){
		return sImage;
	
	}
}
