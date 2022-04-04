package br.com.lucasladeira.olisaude.repositories;

import br.com.lucasladeira.olisaude.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
