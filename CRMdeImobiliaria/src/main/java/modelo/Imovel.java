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

    @ManyToMany
    @JoinColumn(name = "idCorretor", referencedColumnName = "id")
    private Corretor Corretor;
}
