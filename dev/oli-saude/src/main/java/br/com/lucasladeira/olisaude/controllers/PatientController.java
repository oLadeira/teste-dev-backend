package br.com.lucasladeira.olisaude.controllers;

import br.com.lucasladeira.olisaude.dto.NewPatientDto;
import br.com.lucasladeira.olisaude.dto.UpdatePatientDto;
import br.com.lucasladeira.olisaude.entities.Patient;
import br.com.lucasladeira.olisaude.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;


    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody NewPatientDto patientDto){
        Patient createdPatient = patientService.createPatient(patientService.fromDTO(patientDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @GetMapping
    public ResponseEntity<Page<Patient>> getPatients(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient (@PathVariable Long id, @RequestBody UpdatePatientDto patient){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.updatePatient(id, patient));
    }

    //Higher Risk Patients endpoint
    @GetMapping("/higherRiskPatients")
    public ResponseEntity<List<Patient>> getHigherRiskPatients(){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getHigherRiskPatients());
    }

}
