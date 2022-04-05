package br.com.lucasladeira.olisaude.services;

import br.com.lucasladeira.olisaude.dto.UpdatePatientDto;
import br.com.lucasladeira.olisaude.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {

    Patient createPatient(Patient patient);

    Page<Patient> getPatients(Pageable pageable);

    Patient getPatientById(Long id);

    Patient updatePatient(Long id, UpdatePatientDto patient);
}
