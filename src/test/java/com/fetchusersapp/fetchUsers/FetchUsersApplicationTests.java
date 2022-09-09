package com.fetchusersapp.fetchUsers;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.fetchusersapp.controller.FetchUsersController;
import com.fetchusersapp.service.FetchUserService;


@SpringBootTest
@AutoConfigureMockMvc
class FetchUsersApplicationTests {

	@Autowired
	private MockMvc mockMvc;



	@Test
	void givenCall_expectJson() throws Exception {
		mockMvc
			.perform(get("/my-api/users")
				.contentType("application/json")).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith("application/json"));
  	}
	
	@Test 
	void givenGenderMale_expectOnlyMale() throws Exception {
		MvcResult mvc = mockMvc
			.perform(get("/my-api/users?gender=male"))
			.andReturn(); 
		JSONObject json = new JSONObject(mvc.getResponse().getContentAsString());
		String expectedGender = "male"; 
		for (int i = 0; i < json.getJSONArray("data").length(); i++) {
			assertEquals(json.getJSONArray("data").getJSONObject(i).getString("gender"), expectedGender); 
		}
	}
	@Test 
	void givenGenderFemale_expectOnlyFemale() throws Exception {
		MvcResult mvc = mockMvc
			.perform(get("/my-api/users?gender=female"))
			.andReturn(); 
		JSONObject json = new JSONObject(mvc.getResponse().getContentAsString());
		String expectedGender = "female"; 
		for (int i = 0; i < json.getJSONArray("data").length(); i++) {
			assertEquals(json.getJSONArray("data").getJSONObject(i).getString("gender"), expectedGender); 
		}
	}
			
		
}
