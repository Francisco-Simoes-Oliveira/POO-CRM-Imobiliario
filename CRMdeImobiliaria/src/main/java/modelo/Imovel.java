package modelo;

import javax.persistence.*;

@Entity
@Table(name = "imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ENDEREÇO FICA PARA SER FEITA DEPOIS

    private Double preco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idComodos", referencedColumnName = "id")
    private Comodos comodos;

    private StatusImovel statusImovel;

    @ManyToOne
    @JoinColumn(name = "idCorretor", referencedColumnName = "id")
    private Funcionario Funcionario;

    public Imovel(Double preco, Comodos comodos, StatusImovel statusImovel, Funcionario funcionario) {
        this.preco = preco;
        this.comodos = comodos;
        this.statusImovel = statusImovel;
        Funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Comodos getComodos() {
        return comodos;
    }

    public void setComodos(Comodos comodos) {
        this.comodos = comodos;
    }

    public StatusImovel getStatusImovel() {
        return statusImovel;
    }

    public void setStatusImovel(StatusImovel statusImovel) {
        this.statusImovel = statusImovel;
    }

    public Funcionario getCorretor() {
        return Funcionario;
    }

    public void setCorretor(Funcionario funcionario) {
        Funcionario = funcionario;
    }
}
