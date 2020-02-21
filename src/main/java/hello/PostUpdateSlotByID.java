package hello;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostUpdateSlotByID extends DBPostTemplate {

	String ID;
	boolean Availability;
	public PostUpdateSlotByID(String ID, boolean Availability)
	{
		super.Query="update slot set Availability=?, uTime=current_timestamp() where ID=?";
		this.ID=ID;
		this.Availability=Availability;
	}
	
	@Override
	public PreparedStatement TakeCareOfParams(PreparedStatement pst) throws SQLException {
		pst.setBoolean(1, Availability);
		pst.setString(2, ID);
		return pst;
	}

}
