package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.doctor;


@Repository
public interface doctorRepository extends JpaRepository<doctor, Long>{

}
