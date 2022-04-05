package br.com.lucasladeira.olisaude.controllers;

import br.com.lucasladeira.olisaude.dto.PatientDto;
import br.com.lucasladeira.olisaude.entities.Patient;
import br.com.lucasladeira.olisaude.services.PatientService;
import br.com.lucasladeira.olisaude.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;


    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDto patientDto){
        Patient createdPatient = patientService.createPatient(patientService.fromDTO(patientDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }


}
