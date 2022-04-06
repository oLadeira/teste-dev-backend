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
import java.time.Month;
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
        p1.setBirthDate(LocalDate.of(1997, Month.MARCH, 10));
        p1.setGender("MALE");
        p1.setCreationDate(LocalDate.now());
        p1.setUpdateDate(LocalDate.now());

        Patient p2 = new Patient();
        p2.setId(null);
        p2.setName("Caleb Marcelo da Cruz");
        p2.setBirthDate(LocalDate.of(2001, Month.JANUARY, 12));
        p2.setGender("MALE");
        p2.setCreationDate(LocalDate.now());
        p2.setUpdateDate(LocalDate.now());

        Patient p3 = new Patient();
        p3.setId(null);
        p3.setName("Vitor Leonardo Almeida");
        p3.setBirthDate(LocalDate.of(2000, Month.MARCH, 17));
        p3.setGender("MALE");
        p3.setCreationDate(LocalDate.now());
        p3.setUpdateDate(LocalDate.now());

        Patient p4 = new Patient();
        p4.setId(null);
        p4.setName("Bruno Anthony Vieira");
        p4.setBirthDate(LocalDate.of(1995, Month.OCTOBER, 1));
        p4.setGender("MALE");
        p4.setCreationDate(LocalDate.now());
        p4.setUpdateDate(LocalDate.now());
        patientRepository.saveAll(Arrays.asList(p1,p2,p3,p4));


        //patient 1
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

        //patient 2
        HealthProblem hp3 = new HealthProblem();
        hp3.setId(null);
        hp3.setName("Nasch Karatsukovy");
        hp3.setDegree(1);
        hp3.setPatient(p2);

        //patient 3
        HealthProblem hp4 = new HealthProblem();
        hp4.setId(null);
        hp4.setName("Nasch Karatsukovy");
        hp4.setDegree(2);
        hp4.setPatient(p3);
        HealthProblem hp5 = new HealthProblem();
        hp5.setId(null);
        hp5.setName("Mezujok Yachykov");
        hp5.setDegree(2);
        hp5.setPatient(p3);
        HealthProblem hp6 = new HealthProblem();
        hp6.setId(null);
        hp6.setName("Tawqan Sidokovy");
        hp6.setDegree(2);
        hp6.setPatient(p3);

        //patient 4
        HealthProblem hp7 = new HealthProblem();
        hp7.setId(null);
        hp7.setName("Maxwe Tsrimovy");
        hp7.setDegree(1);
        hp7.setPatient(p4);

        healthProblemRepository.saveAll(Arrays.asList(hp1, hp2, hp3, hp4, hp5, hp6, hp7));
    }
}
