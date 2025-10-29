package modelo;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCorretor", nullable = false)
    private Funcionario funcionario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idImovel", nullable = false)
    private Imovel imovel;

    private LocalDateTime horarioVisita;

    private StatusVisita statosVisita;

    @Column(length = 350)
    private String observacao;

}
