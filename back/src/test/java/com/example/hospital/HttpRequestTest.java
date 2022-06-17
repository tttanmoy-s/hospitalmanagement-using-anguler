package com.example.hospital;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class HttpRequestTest {
	  
		@org.springframework.boot.web.server.LocalServerPort
		private int port;
		
		private  TestRestTemplate rt;
			
		
		
		@Test
		public void httppatientstest() throws Exception{
			assertThat(this.rt.getForObject("http://localhost:" + port + "/api/v1/patients",String.class));
		}

}
