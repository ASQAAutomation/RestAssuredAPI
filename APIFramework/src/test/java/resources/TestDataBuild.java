package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.locationdata;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address) {
		
		AddPlace addplace = new AddPlace();
		addplace.setAccuracy(50);
		addplace.setAddress(address);
		addplace.setLanguage(language);
		addplace.setName(name);
		addplace.setPhone_number("(+91) 983 893 3937");
		addplace.setWebsite("http://google.com");
		locationdata l = new locationdata();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addplace.setLocation(l);
		List <String> typeslist = new ArrayList<String>();
		typeslist.add("shoe park");
		typeslist.add("shop");
		addplace.setTypes(typeslist);
		return addplace;
		
	}
	
	public String deletepayload(String placeid) {
		
		return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}";
	}
	
	
	

}
