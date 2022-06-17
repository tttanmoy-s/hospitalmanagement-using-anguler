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
import com.example.hospital.model.doctor;
import com.example.hospital.repository.doctorRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class doctorController {
	
	@Autowired
	private   doctorRepository  docr;
	
   //get all data
   @GetMapping("/doctors")
	public List<doctor> getAllDoctor() {
		return docr.findAll();
	}
	
	// create employee 
		@PostMapping("/doctors")
		public doctor createEmployee(@RequestBody doctor doct) {
			return docr.save(doct);
		}
		
		// get doctor by id 
		@GetMapping("/doctors/{id}")
		public ResponseEntity<doctor> getEmployeeById(@PathVariable Long id) {
			doctor doct = docr.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("doctor not exist with id :" + id));
			return ResponseEntity.ok(doct);
		}
		
		// update doctor
		
		@PutMapping("/doctors/{id}")
		public ResponseEntity<doctor> updatedoctor(@PathVariable Long id, @RequestBody doctor doctDetails){
			doctor doct = docr.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("doctor not exist with id :" + id));
			
			doct.setName(doctDetails.getName());
			doct.setGender(doctDetails.getGender());
			doct.setSpecialist(doctDetails.getSpecialist());
			
			doctor updateddoctor = docr.save(doct);
			return ResponseEntity.ok(updateddoctor);
		}
		
		// delete doctor
		@DeleteMapping("/doctors/{id}")
		public ResponseEntity<Map<String, Boolean>> deletedoctor(@PathVariable Long id){
			doctor doct = docr.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("doctor not exist with id :" + id));
			
			docr.delete(doct);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
