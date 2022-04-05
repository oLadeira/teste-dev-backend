package br.com.lucasladeira.olisaude.services;

import br.com.lucasladeira.olisaude.dto.PatientDto;
import br.com.lucasladeira.olisaude.entities.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatient(Patient patient);

    List<Patient> getPatients();
}
