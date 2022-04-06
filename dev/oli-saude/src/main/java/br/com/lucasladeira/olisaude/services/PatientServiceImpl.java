package br.com.lucasladeira.olisaude.services;

import br.com.lucasladeira.olisaude.dto.HealthProblemDto;
import br.com.lucasladeira.olisaude.dto.NewPatientDto;
import br.com.lucasladeira.olisaude.dto.UpdatePatientDto;
import br.com.lucasladeira.olisaude.entities.HealthProblem;
import br.com.lucasladeira.olisaude.entities.Patient;
import br.com.lucasladeira.olisaude.repositories.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient createPatient(Patient patient) {
        patient.setId(null);
        patient.setCreationDate(LocalDate.now());
        patient.setUpdateDate(LocalDate.now());
        log.info("Creating new Patient");
        return patientRepository.save(patient);
    }

    @Override
    public Page<Patient> getPatients(Pageable pageable) {
        log.info("Listing all Patients");
        return patientRepository.findAll(pageable);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Patient updatePatient(Long id, UpdatePatientDto patient) {
        Patient dbPatient = patientRepository.findById(id)
                .orElseThrow();
        dbPatient.setName(patient.getName());
        dbPatient.setGender(patient.getGender());
        dbPatient.setBirthDate(patient.getBirthDate());

        dbPatient.setUpdateDate(LocalDate.now());
        return patientRepository.save(dbPatient);
    }

    @Override
    public List<Patient> getHigherRiskPatients(){

        //listing all patients
        List<Patient> allPatients = patientRepository.findAll();

        Map<Patient, Double> patientsAndScore = new HashMap<>();
        List<Patient> higherRiskPatients = new ArrayList<>();

        for (Patient patient : allPatients){
            var score = 0.0;
            var sd = 0.0;
            for (HealthProblem healthProblem : patient.getHealthProblems()){
                //calculating the sum of the degrees
                sd += healthProblem.getDegree();
            }
            //calculating the score
            score = (1 / (1 + Math.E - (-2.8 + sd))) * 100;

            //puting patient and score in a map, where patient is the key and score is the value
            patientsAndScore.put(patient, score);
        }

        //list used to sort the set by value
        List<Map.Entry<Patient, Double>> aux = new ArrayList<>(patientsAndScore.entrySet());

        //sorting the list by map value
        aux.sort(Map.Entry.comparingByValue());

        //reversing the order
        Collections.reverse(aux);

        //adding all map keys (Patients) in higherRiskPatients List
        aux.forEach(map -> {
            higherRiskPatients.add(map.getKey());
            log.info(map.getKey().toString());
        });

        //returning the list with a limit of 10 patients
        return higherRiskPatients.stream().limit(10).collect(Collectors.toList());
    }


    public Patient fromDTO(NewPatientDto patientDto){
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setBirthDate(patientDto.getBirthDate());
        patient.setGender(patientDto.getGender());

        if (patientDto.getHealthProblems() != null){
            for (HealthProblemDto healthProblemDto : patientDto.getHealthProblems()){
                HealthProblem healthProblem = new HealthProblem();
                healthProblem.setName(healthProblemDto.getName());
                healthProblem.setDegree(healthProblemDto.getDegree());
                healthProblem.setPatient(patient);
                patient.getHealthProblems().add(healthProblem);
            }
        }
        return patient;
    }
}
