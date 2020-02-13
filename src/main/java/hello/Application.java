package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {
	
	
	@RequestMapping("/")
	public String home() {
		return "Welcome to our webservice";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/partners")
	public static ArrayList<PartnerModel> GetPartners() {
		return new GetPartners().RunQuery();
	}
	
	@RequestMapping("/divisions/{id}")
	public static ArrayList<DivisionModel> GetDivisionsByPartnerID(@PathVariable("id") int id) {
		return new GetDivisionsByPartnerID(id).RunQuery();
	}

	@RequestMapping("/slot/{id}")
	public static ArrayList<SlotsModel> GetSlotByDivisionID(@PathVariable("id") int id) {
		return new GetSlotByDivisionID(id).RunQuery();
	}
	
	@RequestMapping("/slot/partnerid/{id}")
	public static ArrayList<SlotModelForDivision> GetSlotByPartnerID(@PathVariable("id") int id) {
		return new GetSlotByPartnerID(id).RunQuery();
	}
	
}
