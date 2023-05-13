package com.backendtest.xtramile.repository;

import com.backendtest.xtramile.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
