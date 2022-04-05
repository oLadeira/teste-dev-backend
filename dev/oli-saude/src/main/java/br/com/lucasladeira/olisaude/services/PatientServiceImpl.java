package br.com.lucasladeira.olisaude.services;

import br.com.lucasladeira.olisaude.dto.HealthProblemDto;
import br.com.lucasladeira.olisaude.dto.PatientDto;
import br.com.lucasladeira.olisaude.entities.HealthProblem;
import br.com.lucasladeira.olisaude.entities.Patient;
import br.com.lucasladeira.olisaude.repositories.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getPatients() {
        return null;
    }

    public Patient fromDTO(PatientDto patientDto){
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
