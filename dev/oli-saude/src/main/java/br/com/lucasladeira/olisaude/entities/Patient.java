package br.com.lucasladeira.olisaude.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String gender;

    private LocalDate creationDate;

    private LocalDate updateDate;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private List<HealthProblem> healthProblems = new ArrayList<>();
}
