package com.ravi.firebase.demo.controller;

import com.ravi.firebase.demo.model.Patient;
import com.ravi.firebase.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class FBController {
    @Autowired
    private PatientService patientService;


    @GetMapping("/getPatientDetails")
    public Patient getPatient(@RequestParam String name) throws InterruptedException, ExecutionException {
        return patientService.getPatientDetails(name);
    }

    @PostMapping("/createPatient")
    public String createPatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
        return patientService.savePatientDetails(patient);
    }

    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
        return patientService.updatePatientDetails(patient);
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam String name) {
        return patientService.deletePatient(name);
    }
}
