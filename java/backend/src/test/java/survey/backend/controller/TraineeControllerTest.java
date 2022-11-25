package survey.backend.controller;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import survey.backend.dto.TraineeDto;
import survey.backend.service.TraineeService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(TraineeController.class)
class TraineeControllerTest {
     //For http requests we need
    final static String BASE_URL = "/api/trainee";
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TraineeService traineeService;

    @Test
    void testFindByIdOk() throws Exception {

        // prepare
        int id = 123;

        var traineeDto = TraineeDto.builder()
                .id(id)
                .firstName("Alex")
                .lastName("Billoz")
                .build();

        BDDMockito.given(traineeService.findById(id))
                .willReturn(Optional.of(traineeDto));

        //when
        mockMvc.perform(
                get( BASE_URL + "/" + id) //   MockMvcRequestBuilders was imported static to allow us to just enter get
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id)); // log request/response  //$. to represent object


        //THEN /verify
        // -TODO : HTTP
        // - HTTP , - MockService

        BDDMockito.then(traineeService)
                .should().findById(id);

    }

    @Test
    void testFindByIdKoNotFound() throws Exception {

        int id  = 0;

        BDDMockito.given(traineeService.findById(id))
                .willReturn(Optional.empty());


        mockMvc.perform(
                        get(BASE_URL+ "/" +id) //   MockMvcRequestBuilders was imported static to allow us to just enter get
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(
                        (MockMvcResultMatchers.content()
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                )
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.error").value("Trainee with id " + id + " not found")
                );


        BDDMockito.then(traineeService)
                .should().findById(id);

    }

}