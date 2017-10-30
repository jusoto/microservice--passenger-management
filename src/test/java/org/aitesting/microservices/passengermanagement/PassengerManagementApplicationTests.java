package org.aitesting.microservices.passengermanagement;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PassengerManagementApplicationTests {

	 @Autowired
	 private MockMvc mockMvc;
	 
	@Test
	public void contextLoads() {
	}
	
	@Ignore
	public void createNewPassenger_S001() throws Exception {
		this.mockMvc.perform(get("/api/passengers/login").param("username", "daenerys").param("password", "daenerys"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.content").value("{\n" + 
        		"\"idpassenger\": 1,\n" + 
        		"\"city\": {\n" + 
        		"\"idcity\": 2,\n" + 
        		"\"state\": {\n" + 
        		"\"idstate\": 9,\n" + 
        		"\"country\": {\n" + 
        		"\"idcountry\": 1,\n" + 
        		"\"name\": \"United States\"\n" + 
        		"},\n" + 
        		"\"name\": \"Florida\",\n" + 
        		"\"abbreviation\": \"FL\"\n" + 
        		"},\n" + 
        		"\"name\": \"Weston\"\n" + 
        		"},\n" + 
        		"\"fname\": \"Daenerys\",\n" + 
        		"\"lname\": \"Targaryen\",\n" + 
        		"\"username\": \"daenerys\",\n" + 
        		"\"password\": \"daenerys\",\n" + 
        		"\"email\": \"jusoto@gmail.com\",\n" + 
        		"\"lastLocationLat\": null,\n" + 
        		"\"lastLocationLon\": null,\n" + 
        		"\"address\": \"2000 Ultimate Way\",\n" + 
        		"\"phone\": \"7867734490\",\n" + 
        		"\"active\": 1\n" + 
        		"}"));
	}

}
