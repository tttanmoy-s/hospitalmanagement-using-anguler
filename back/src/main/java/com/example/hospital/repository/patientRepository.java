package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.patient;

public interface patientRepository extends JpaRepository<patient, Long> {

}
