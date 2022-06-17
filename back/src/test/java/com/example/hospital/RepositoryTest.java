//package com.example.hospital;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.CoreMatchers.any;
//
//import java.util.List;
//
//import org.assertj.core.util.Arrays;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.example.hospital.model.doctor;
//import com.example.hospital.model.patient;
//import com.example.hospital.repository.doctorRepository;
//import com.example.hospital.repository.patientRepository;
//
//@SuppressWarnings("unused")
//@ExtendWith(MockitoExtension.class)
//@DataJpaTest
//
//public class RepositoryTest {
//	
//	@Autowired
//	private doctorRepository dr;
//	private patientRepository pr;
//	
//	 @Test
//	    void findAll_success1() {
//	        List<doctor> alldoctor = dr.findAll();
//	        assertThat(alldoctor.size()).isGreaterThanOrEqualTo(1);
//	    }
//	 
//	 @Test
//	    void findAll_success() {
//	        List<patient> allpatient = pr.findAll();
//	        assertThat(allpatient.size()).isGreaterThanOrEqualTo(1);
//	    }
//	
//	 
//	 @Test
//	 public void saveddoctor_Success() {
//	     doctor doc = new doctor();
//	     doc.setName("sam");
//	     doc.setGender("male");
//	     doc.setSpecialist("heart");
//	     doctor saveddoctor = dr.save(doc);
//	     assertThat(saveddoctor.getName()).isNotNull();
//	 }
//
//}
