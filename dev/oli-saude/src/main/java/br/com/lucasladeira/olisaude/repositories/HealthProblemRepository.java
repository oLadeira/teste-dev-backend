package br.com.lucasladeira.olisaude.repositories;

import br.com.lucasladeira.olisaude.entities.HealthProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthProblemRepository extends JpaRepository<HealthProblem, Long> {
}
