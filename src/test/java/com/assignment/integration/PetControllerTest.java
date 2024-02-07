package com.assignment.integration;

import com.assignment.Application;
import com.assignment.dto.AddressDTO;
import com.assignment.dto.UsersDTO;
import com.assignment.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.assignment.dataprovider.DataProvider.getUsersDetails;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PetControllerTest {


    @LocalServerPort
    private int randomServerPort;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void beforeEach() {
        userRepository.saveAll(getUsersDetails());
    }

    @AfterEach
    void tearDown() {
    }

    @Nested
    @TestInstance(PER_CLASS)
    class shouldFetchAllPersons {
        @Test
        void shouldFetchAllPersons() {
            String url = "http://localhost:" + randomServerPort + "/public/users";
            Response response = given().when().get(url);
            response.then().statusCode(200);
        }
    }

    @Nested
    @TestInstance(PER_CLASS)
    class shouldFetchUsersById {
        @Test
        void shouldFetchUsersById() {
            Long id = 1L;
            String url = "http://localhost:" + randomServerPort + "/public/users/" + id;
            Response response = given().when().get(url);
            response.then().statusCode(200);
        }
    }

    @Nested
    @TestInstance(PER_CLASS)
    class shouldFetchUsersNames {
        @Test
        void shouldFetchByFirstName() {
            String firstName = "first";
            String url = "http://localhost:" + randomServerPort + "/public/users/search?firstName=" + firstName;
            Response response = given().when().get(url);
            response.then().statusCode(200);
        }

        @Test
        void shouldFetchByLastName() {
            String lastName = "last";
            String url = "http://localhost:" + randomServerPort + "/public/users/search?lastName=" + lastName;
            Response response = given().when().get(url);
            response.then().statusCode(200);
        }

        @Test
        void shouldFetchByLastNameAndFirstName() {
            String lastName = "last";
            String firstName = "first";
            String url = "http://localhost:" + randomServerPort + "/public/users/search?firstName=" + firstName
                    + "&lastName=" + lastName;
            Response response = given().when().get(url);
            response.then().statusCode(200);
        }
    }

    @Nested
    @TestInstance(PER_CLASS)
    class shouldSaveUser{
        @Test
        void shouldSaveUser() throws JsonProcessingException {
            UsersDTO userDTO = new UsersDTO();
            userDTO.setDateOfBirth("28/06/1993");
            userDTO.setFirstName("Yash");
            userDTO.setLastName("Dun");
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setHouseNumber("9");
            addressDTO.setCity("Amsterdam");
            addressDTO.setCountry("NL");
            addressDTO.setZipCode("1024VH");
            addressDTO.setStreetName("Duinluststratt");
            userDTO.setAddressDTO(addressDTO);
            String requestBody = objectMapper.writeValueAsString(userDTO);
            String url = "http://localhost:" + randomServerPort + "/public/users";
            Response response = given()
                    .contentType(ContentType.JSON)
                    .when().body(requestBody).post(url);
            response.then().statusCode(201);
        }
    }
}
