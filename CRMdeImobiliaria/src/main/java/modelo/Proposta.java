package modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idFuncionario", nullable = false)
    private Funcionario funcionario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idImovel", nullable = false)
    private Imovel imovel;

    private Double valorProposto;

    private LocalDateTime horarioDeEnvio;

    @Enumerated(EnumType.STRING)
    private StatusProposta statusProposta;

    private LocalDate prazoResposta;

    public Proposta() {
    }

    public Proposta(Cliente cliente, Funcionario funcionario, Imovel imovel, Double valorProposto, LocalDateTime horarioDeEnvio, StatusProposta statusProposta, LocalDate prazoResposta) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.imovel = imovel;
        this.valorProposto = valorProposto;
        this.horarioDeEnvio = horarioDeEnvio;
        this.statusProposta = statusProposta;
        this.prazoResposta = prazoResposta;
    }
}
