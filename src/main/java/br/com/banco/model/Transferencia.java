package br.com.banco.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_transferencia", nullable = false)
    private LocalDateTime dataTransferencia;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "nome_operador_transacao")
    private String nomeOperadorTransacao;

    @ManyToOne()
    @JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
    private Conta conta;

}
