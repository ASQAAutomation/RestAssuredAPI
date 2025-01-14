package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	
	public void beforeScenario() throws IOException {
		placeValidation m = new placeValidation();
		
		if(placeValidation.place_id==null) {
		m.add_place_payload_with("Alex", "Englis", "USA");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Alex", "getPlaceAPI");
		}
		
	}
	

}
