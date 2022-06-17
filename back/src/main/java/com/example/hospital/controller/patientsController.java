package com.example.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.hospital.controller.Boolean;
//import com.example.hospital.controller.Long;
//import com.example.hospital.controller.String;
import com.example.hospital.excpetion.ResourceNotFoundException;
import com.example.hospital.model.patient;
import com.example.hospital.repository.patientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class patientsController {
	
	@Autowired
	private   patientRepository  patr;
	
   //get all data
   @GetMapping("/patients")
	public List<patient> getAllDoctor() {
		return patr.findAll();
	}
	
	// create patient 
		@PostMapping("/patients")
		public patient createEmployee(@RequestBody patient pati) {
			return patr.save(pati);
		}
		
		// get patient by id 
		@GetMapping("/patients/{id}")
		public ResponseEntity<patient> getEmployeeById(@PathVariable Long id) {
			patient pati = patr.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("patient not exist with id :" + id));
			return ResponseEntity.ok(pati);
		}
		
		// update patient
		
		@PutMapping("/patients/{id}")
		public ResponseEntity<patient> updatepatient(@PathVariable Long id, @RequestBody patient patiDetails){
			patient pati = patr.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("patient not exist with id :" + id));
			
			pati.setPname(patiDetails.getPname());
			pati.setPage(patiDetails.getPage());
			pati.setPgender(patiDetails.getPgender());
			pati.setDateOfVisit(patiDetails.getDateOfVisit());
			pati.setDoctorid(patiDetails.getDoctorid());
			
			
			
			patient updatedpatient = patr.save(pati);
			return ResponseEntity.ok(updatedpatient);
		}
		
		// delete patient
		@DeleteMapping("/patients/{id}")
		public ResponseEntity<Map<String, Boolean>> deletepatient(@PathVariable Long id){
			patient pati = patr.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("patient not exist with id :" + id));
			
			patr.delete(pati);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
