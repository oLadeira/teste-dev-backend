package br.com.lucasladeira.olisaude.dto;

import br.com.lucasladeira.olisaude.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthProblemDto implements Serializable {

    private String name;

    private Integer degree;

}
