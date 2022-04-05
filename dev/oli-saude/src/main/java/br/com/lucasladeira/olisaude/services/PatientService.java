package br.com.lucasladeira.olisaude.services;

import br.com.lucasladeira.olisaude.dto.PatientDto;
import br.com.lucasladeira.olisaude.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {

    Patient createPatient(Patient patient);

    Page<Patient> getPatients(Pageable pageable);

    Patient getPatientById(Long id);

    Patient updatePatient(Long id, Patient patient);
}
