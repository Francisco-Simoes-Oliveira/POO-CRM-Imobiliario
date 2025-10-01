package modelo;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{

    public Cliente(String nome, String cpf, String email, String telefone) {
        super(nome,cpf, email,telefone);
    }


}
