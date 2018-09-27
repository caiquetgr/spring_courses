package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.Application;
import com.in28minutes.springboot.model.Question;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

    @LocalServerPort
    private int port;

    HttpHeaders httpHeaders;

    @Test
    public void jsonTest() throws JSONException {
        JSONAssert.assertEquals("{id:1}", "{id:1, nome:'Caique'}", false);
    }

    private HttpHeaders createHttpHeaders(String user, String password) {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = user + ":" + password;

        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authorization = "Basic " + new String(encodedAuth);

        httpHeaders.add("Authorization", authorization);
        return httpHeaders;
    }

    @Before
    public void before() {
        this.httpHeaders = createHttpHeaders("user1", "secret1");
        this.httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getQuestion() throws JSONException {
        String url = createUrlWithPort("/surveys/Survey1/questions/Question1");

        TestRestTemplate restTemplate = new TestRestTemplate();

        //ResponseEntity<String> output = restTemplate.getForEntity(url, String.class);

        HttpEntity httpEntity = new HttpEntity<String>(null, httpHeaders);

        ResponseEntity<String> output = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        String expected = "{id:Question1,description:\"Largest Country in the World\",correctAnswer:Russia}";

        JSONAssert.assertEquals(expected, output.getBody(), false);

    }

    @Test
    public void postQuestion() {

        String url = createUrlWithPort("/surveys/Survey1/questions/");

        TestRestTemplate restTemplate = new TestRestTemplate();

        Question question1 = new Question("DOESNTMATTER ",
                "Question", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        HttpEntity<Question> httpEntity = new HttpEntity<>(question1, httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        URI uri = responseEntity.getHeaders().getLocation();

        System.out.println(uri.getPath());

        assertTrue(uri.getPath().contains("/surveys/Survey1/questions/"));

    }

    private String createUrlWithPort(String path) {
        return "http://localhost:" + port + path;
    }

}
