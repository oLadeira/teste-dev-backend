package br.com.lucasladeira.olisaude.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePatientDto implements Serializable {

    private String name;
    private String gender;
    private LocalDate birthDate;

}
