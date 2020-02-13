package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class GetSlotByPartnerID extends DBGetTemplate<SlotModelForDivision> {

	public GetSlotByPartnerID(int id)
	{
		super.Query="SELECT Availability,uTime,DivisionID FROM slot inner join division on slot.DivisionID=division.ID where PartnerID="+id;
	}
	
	@Override
	public SlotModelForDivision TakeCareOfTheRecord(ResultSet rs) throws SQLException {
		Boolean avail = rs.getBoolean("Availability");
		Timestamp uTime = rs.getTimestamp("uTime");
		int divisionid = rs.getInt("DivisionID");
		return new  SlotModelForDivision(avail,uTime.toString(),divisionid);
	}
}
