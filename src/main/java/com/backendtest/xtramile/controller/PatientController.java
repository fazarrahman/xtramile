package com.backendtest.xtramile.controller;

import com.backendtest.xtramile.model.Patient;
import com.backendtest.xtramile.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = patientService.GetPatients();
        return ResponseEntity.ok(patients);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient patientRes = patientService.CreatePatients(patient);
        return ResponseEntity.ok(patientRes);
    }

    @GetMapping(path = "{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> getPatientById(@PathVariable Long pid) {
        Patient patient = patientService.GetPatientById(pid);
        return ResponseEntity.ok(patient);
    }

    @PutMapping(path = "{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> updatePatient(@PathVariable Long pid, @RequestBody Patient patient) {
        Patient patientRes = patientService.UpdatePatient(pid, patient);
        return ResponseEntity.ok(patientRes);
    }

    @DeleteMapping(path = "{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePatient(@PathVariable Long pid) {
        patientService.DeletePatient(pid);
        return ResponseEntity.ok("success");
    }
}
