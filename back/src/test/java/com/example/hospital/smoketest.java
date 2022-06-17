package com.example.hospital;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hospital.controller.doctorController;

@SpringBootTest

public class smoketest {
	@Autowired
	private doctorController dc;
	
	public void contextLoads() throws Exception {
		assertThat(dc).isNotNull();
	}

}
