package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(secure = false)
public class SurveyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Test
    public void retrieveDetailsForQuestions() throws Exception {
        Question mockQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        when(surveyService.retrieveQuestion(anyString(), anyString()))
                .thenReturn(mockQuestion);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/surveys/Survey1/questions/Question1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{id:Question1,description:\"Largest Country in the World\",correctAnswer:Russia}";

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);

    }

    @Test
    public void createSurveyQuestion() throws Exception {
        Question mockQuestion = new Question("1", "Smallest Number", "1",
                Arrays.asList("1", "2", "3", "4"));

        String questionJson = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";

        when(surveyService.addQuestion(anyString(), any(Question.class))).thenReturn(mockQuestion);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                                .post("/surveys/Survey1/questions")
                                                .accept(MediaType.APPLICATION_JSON)
                                                .content(questionJson)
                                                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }


}
