package br.com.lucasladeira.olisaude.config;

import br.com.lucasladeira.olisaude.entities.HealthProblem;
import br.com.lucasladeira.olisaude.entities.Patient;
import br.com.lucasladeira.olisaude.repositories.HealthProblemRepository;
import br.com.lucasladeira.olisaude.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HealthProblemRepository healthProblemRepository;

    @Override
    public void run(String... args) throws Exception {

        Patient p1 = new Patient();
        p1.setId(null);
        p1.setName("José Santana");
        p1.setBirthDate(LocalDate.of(1997, 03, 10));
        p1.setGender("MALE");
        p1.setCreationDate(LocalDate.now());
        p1.setUpdateDate(LocalDate.now());
        patientRepository.save(p1);

        HealthProblem hp1 = new HealthProblem();
        hp1.setId(null);
        hp1.setName("Asthma");
        hp1.setDegree(2);
        hp1.setPatient(p1);

        HealthProblem hp2 = new HealthProblem();
        hp2.setId(null);
        hp2.setName("Rhinitis");
        hp2.setDegree(1);
        hp2.setPatient(p1);

        healthProblemRepository.saveAll(Arrays.asList(hp1, hp2));
    }
}
