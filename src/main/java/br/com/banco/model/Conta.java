package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"transferencias"})
public class Conta {

    @Id
    @Column(name = "id_conta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias;

}
