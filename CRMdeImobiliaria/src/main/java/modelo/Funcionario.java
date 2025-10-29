package modelo;

import javax.persistence.*;

@Entity
@Table(name = "corretor")
public class Funcionario extends Pessoa{

    public Funcionario(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
    }


}
