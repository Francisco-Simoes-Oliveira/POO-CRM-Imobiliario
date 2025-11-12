package modelo;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double salarioBase;

    public Cargo() {
    }

    public Cargo(String nome, Double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }
}
