package com.backendtest.xtramile.service;

import com.backendtest.xtramile.exception.ResourceNotFoundException;
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

    public Patient GetPatientById(Long pid) {
        Patient patient = patientRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with pid : " + pid));

        return patient;
    }

    public Patient UpdatePatient(Long pid, Patient patient) {
        Patient existingPatient = patientRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with pid : " + pid));

        existingPatient.setGender(patient.getGender());
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setPhoneNo(patient.getPhoneNo());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setState(patient.getState());
        existingPatient.setSuburb(patient.getSuburb());
        existingPatient.setPostcode(patient.getPostcode());
        patientRepository.save(existingPatient);

        return patient;
    }

    public void DeletePatient(Long pid) {
        Patient existingPatient = patientRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with pid : " + pid));

        patientRepository.delete(existingPatient);;
    }
}
