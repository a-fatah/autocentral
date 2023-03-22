package io.freevariable.autocentral;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.freevariable.autocentral.entity.Contract;
import io.freevariable.autocentral.entity.Customer;
import io.freevariable.autocentral.entity.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AutocentralApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testCreateCustomer() throws Exception {
		// Create a new customer object to send in the request body
		Customer customer = new Customer();
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setBirthDate(LocalDate.of(1980, 1, 1));

		// Convert the customer object to JSON
		String requestBody = objectMapper.writeValueAsString(customer);

		// Send a POST request to create the customer
		mockMvc.perform(post("/customers")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isCreated());
	}

    @Test
    public void testCreateCustomerWithEmptyFirstName() throws Exception {
		// Create a new customer object to send in the request body
		Customer customer = new Customer();
		customer.setFirstName("");
		customer.setLastName("Doe");
		customer.setBirthDate(LocalDate.of(1980, 1, 1));

		// Convert the customer object to JSON
		String requestBody = objectMapper.writeValueAsString(customer);

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Validation failed"))
                .andExpect(jsonPath("$.errors", hasSize(1)))
                .andExpect(jsonPath("$.errors[0]").value("firstName must not be blank"));
    }

	@Test
	public void testCreateCustomerWithFutureBirthdate() throws Exception {
		// Create a new customer object with a birthdate in the future
		Customer customer = new Customer();
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setBirthDate(LocalDate.now().plusYears(1));

		// Convert the customer object to JSON
		String requestBody = objectMapper.writeValueAsString(customer);

		// Send a POST request to create the customer
		mockMvc.perform(post("/customers")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Validation failed"))
				.andExpect(jsonPath("$.errors", hasSize(1)))
				.andExpect(jsonPath("$.errors[0]").value("birthDate must be a past date"));
	}

	@Test
	public void shouldCreateContract() throws JsonProcessingException {
		// Create a new customer object for the contract
		Customer customer = new Customer();
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setBirthDate(LocalDate.of(1980, 1, 1));

		// Create vehicle object for the contract
		Vehicle vehicle = new Vehicle();
		vehicle.setBrand("Toyota");
		vehicle.setModel("Camry");
		vehicle.setModelYear(2019);
		vehicle.setVin("12345678901234567");
		vehicle.setPrice(2000000);


		// Create a new contract object
		Contract contract = new Contract();
		contract.setCustomer(customer);
		contract.setVehicle(vehicle);
		contract.setContractNumber("1234567890");
		contract.setMonthlyRate(10000);

		// Convert the contract object to JSON
		String requestBody = objectMapper.writeValueAsString(contract);

		// Send a POST request to create the contract
		try {
			mockMvc.perform(post("/contracts")
							.contentType(MediaType.APPLICATION_JSON)
							.content(requestBody))
					.andExpect(status().isCreated())
					.andExpect(header().exists("Location"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
