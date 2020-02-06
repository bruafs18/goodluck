package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class GetSlotByDivisionID extends DBGetTemplate<SlotsModel> {

	public GetSlotByDivisionID(int id)
	{
		super.Query="SELECT * FROM slot where DivisionID="+id;
	}
	
	@Override
	public SlotsModel TakeCareOfTheRecord(ResultSet rs) throws SQLException {
		String id = rs.getString("ID");
		int pixelx = rs.getInt("pixelX");
		int pixely = rs.getInt("pixelY");
		Boolean avail = rs.getBoolean("Availability");
		Timestamp uTime = rs.getTimestamp("uTime");
		int divisionid = rs.getInt("DivisionID");
		return new  SlotsModel(id,pixelx,pixely,avail,uTime.toString(),divisionid);
	}

}
