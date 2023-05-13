package com.backendtest.xtramile.service;

import com.backendtest.xtramile.model.Patient;
import com.backendtest.xtramile.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public List<Patient> GetPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients;
    }

    public Patient CreatePatients(Patient patient) {
        patient = patientRepository.save(patient);

        return patient;
    }
}
