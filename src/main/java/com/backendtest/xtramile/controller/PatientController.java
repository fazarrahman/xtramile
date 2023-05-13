package com.backendtest.xtramile.controller;

import com.backendtest.xtramile.model.Patient;
import com.backendtest.xtramile.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    PatientService patientService;
    @GetMapping(path = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> getPatients() {
        return patientService.GetPatients();
    }

    @PostMapping(path = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient createPatient(@RequestBody Patient patient) {

        return patientService.CreatePatients(patient);
    }
}
