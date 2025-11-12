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

    @Enumerated(EnumType.STRING)
    private StatusVisita statosVisita;

    @Column(length = 350)
    private String observacao;

    public Visita() {
    }

    public Visita(Cliente cliente, Funcionario funcionario, Imovel imovel, LocalDateTime horarioVisita, StatusVisita statosVisita, String observacao) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.imovel = imovel;
        this.horarioVisita = horarioVisita;
        this.statosVisita = statosVisita;
        this.observacao = observacao;
    }
}
