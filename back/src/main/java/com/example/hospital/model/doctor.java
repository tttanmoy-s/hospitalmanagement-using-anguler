package com.example.hospital.model;

import java.util.HashSet;
import java.util.Set;

//import com.example.hospital.model.String;
import com.example.hospital.model.patient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "doctors")

public class doctor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long docid;
	    @Column(name = "name")
		private String name;
	    @Column(name = "gender")
		private String gender;
	    @Column(name = "specialist")
		private String specialist;
	    @OneToMany
	    private Set<patient> patient = new HashSet<>();
	    
		public doctor() {
			super();
		}
		public doctor(String name, String gender, String specialist, Set<patient> patient) {
			super();
			this.name = name;
			this.gender = gender;
			this.specialist = specialist;
			this.patient = patient;
		}
		public long getDocid() {
			return docid;
		}
		public void setDocid(long docid) {
			this.docid = docid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getSpecialist() {
			return specialist;
		}
		public void setSpecialist(String specialist) {
			this.specialist = specialist;
		}
		public Set<patient> getPatient() {
			return patient;
		}
		public void setPatient(Set<patient> patient) {
			this.patient = patient;
		}

}
