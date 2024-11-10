// // UserControllerTest.java
// package com.example.hotelreservation;

// import com.example.hotelreservation.model.CreateUserParams;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class UserControllerTest {
//     @Autowired
//     private MockMvc mockMvc;

//     @Autowired
//     private ObjectMapper objectMapper;

//     @Test
//     public void testCreateUser() throws Exception {
//         CreateUserParams params = new CreateUserParams();
//         params.setEmail("some@foo.com");
//         params.setFirstName("James");
//         params.setLastName("Bond");
//         params.setPassword("randPasweord");

//         mockMvc.perform(post("/users")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(params)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id").isNotEmpty())
//                 .andExpect(jsonPath("$.email").value(params.getEmail()))
//                 .andExpect(jsonPath("$.firstName").value(params.getFirstName()))
//                 .andExpect(jsonPath("$.lastName").value(params.getLastName()));
//     }
// }