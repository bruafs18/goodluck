package hello;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPartners extends DBGetTemplate<PartnerModel> {

	public GetPartners()
	{
		super.Query="SELECT * FROM partner";
	}
	
	@Override
	public PartnerModel TakeCareOfTheRecord(ResultSet rs) throws SQLException {
		int num= rs.getInt("id");
		String name= rs.getString("name");
		return new PartnerModel(num,name);
	}

}
