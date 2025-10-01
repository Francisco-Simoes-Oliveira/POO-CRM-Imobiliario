package modelo;

import javax.persistence.*;

@Entity
@Table(name = "corretor")
public class Corretor extends Pessoa{

    public Corretor(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
    }


}
