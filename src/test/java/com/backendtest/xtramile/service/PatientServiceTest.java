package com.backendtest.xtramile.service;

import com.backendtest.xtramile.model.Patient;
import com.backendtest.xtramile.repository.PatientRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    PatientService patientService;

    @BeforeEach
    void beforeEachTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getPatients() {
        Patient patient = new Patient();
        patient.setPid(1);
        when(patientRepository.findAll()).thenReturn(Collections.singletonList(patient));
        List<Patient> res = patientService.GetPatients();
        Assert.assertEquals(patient, res.get(0));
    }

    @Test
    void createPatients() {
        Patient patient = new Patient();
        patient.setFirstName("first name");
        when(patientRepository.save(patient)).thenReturn(patient);
        patientService.CreatePatients(patient);
        verify(patientRepository, times(1)).save(any());
    }

    @Test
    void getPatientById() {
        Patient patient = new Patient();
        patient.setPid(1L);
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
        Patient res = patientService.GetPatientById(1L);
        Assert.assertEquals(patient, res);
    }

    @Test
    void updatePatient() {
        Patient patient = new Patient();
        patient.setPid(1L);
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
        Patient res = patientService.UpdatePatient(1L, patient);
        verify(patientRepository, times(1)).save(any());
        Assert.assertEquals(patient, res);
    }

    @Test
    void deletePatient() {
        Patient patient = new Patient();
        patient.setPid(1L);
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
        patientService.DeletePatient(1L);
        verify(patientRepository, times(1)).delete(any());
    }
}