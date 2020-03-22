package hello;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDivisionsByPartnerID extends DBGetTemplate<DivisionModel> {

	public GetDivisionsByPartnerID(int PartnerID)
	{
		super.Query="SELECT * FROM division where PartnerID="+PartnerID;
	}
	
	@Override
	public DivisionModel TakeCareOfTheRecord(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		String name = rs.getString("Name");
		String sImage = rs.getString("sImage");
		Double longi = rs.getDouble("longitude");
		Double lati = rs.getDouble("latitude");
		int partnerid = rs.getInt("PartnerID");
		return new DivisionModel(id,name,partnerid,longi,lati,sImage);
	}

}
