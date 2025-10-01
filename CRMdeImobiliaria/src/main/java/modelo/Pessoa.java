package modelo;

import javax.persistence.*;

@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(length = 200, nullable = true)
    private String email;

    @Column(length = 11, nullable = false)
    private String telefone;

    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

}
