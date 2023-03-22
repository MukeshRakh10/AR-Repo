package in.mk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.mk.rest.controller.CitizenAppRestController;
import in.mk.service.ICitizenAppRegService;

//@SpringBootTest
@WebMvcTest(value = CitizenAppRestController.class) 
// Its is represent which class is testing and it provides required environment for that.
@ComponentScan(basePackages = {"in.mk.ar.*"})
class ArApiApplicationTests {

	@MockBean // It create the mock object for class/ interface.
	private ICitizenAppRegService cMock;

	// MockMvc  : This class provides method to make HTTP Request. 
	@Autowired
	private MockMvc mvc;

	@Test
	public void testMsg() throws Exception {
		
		when(cMock.welcome("Good Morning..")).thenReturn("Good Night");
		//Preparing request
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/welcome");
		//Sending  http request and return the result and store into  mvcResult.
		MvcResult mvcResult = mvc.perform(reqBuilder).andReturn(); 
		
		//get the response.
		MockHttpServletResponse response = mvcResult.getResponse();
		
		String s = response.getContentAsString();
		System.out.println(s);
		//validate the status code.
		int statusCode = response.getStatus();
		assertEquals(200,statusCode);
	}

}
