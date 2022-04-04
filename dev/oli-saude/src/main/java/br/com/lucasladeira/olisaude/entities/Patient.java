package br.com.lucasladeira.olisaude.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private Date birthDate;

    private String gender;

    private Date creationDate;

    private Date updateDate;

    @OneToMany(mappedBy = "patient")
    private List<HealthProblem> healthProblems;
}
