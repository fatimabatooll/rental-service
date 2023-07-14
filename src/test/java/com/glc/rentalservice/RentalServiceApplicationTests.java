package com.glc.rentalservice;

import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glc.rentalservice.Controller.RentalCon;
import com.glc.rentalservice.Model.Rental;
import com.glc.rentalservice.Repository.RentalRepo;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
class RentalServiceApplicationTests {
	private MockMvc mvc;
	@Mock
	private RentalRepo rentalRepo;

	@InjectMocks
	private RentalCon carCon;

	private JacksonTester<Rental>  jsonRental;

	private JacksonTester<Collection<Rental>> jsonRentals;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(carCon).build();
	}
	
	@Test
    public void addRental() throws Exception {
		Rental rental =  new Rental (2L,null, "javeria","F C Area","012333333334","12345753344334",null,null, null, 239000);
		when(rentalRepo.save(rental)).thenReturn((rental));
		mvc.perform(MockMvcRequestBuilders   
		           .post("/rentals/add")
				   .contentType(MediaType.APPLICATION_JSON)
				   .content(jsonRental.write(rental).getJson()))
				   .andExpect(MockMvcResultMatchers.status().isOk());
	 }


	void contextLoads() {
	}

}
