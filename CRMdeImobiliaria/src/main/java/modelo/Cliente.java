package modelo;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{

    @Transient
    private String nomeCorretor;

    public Cliente() {}

    public Cliente(String nome, String cpf, String email, String telefone) {
        super(nome,cpf, email,telefone);
    }

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }



    static public boolean validarCpf(String cpf){
        boolean validado = false;
        char[] cpfArray = cpf.toCharArray();
        int[] digitoVerif = new int[2];
        int[] cpfInt  = new int[11];
        for (int x=0; x<11;x++){
            cpfInt[x] = cpfArray[x] - '0';
        }
        int soma = 0;
        int i= 0;
        for (int x=10; x>1; x--){
            soma += (cpfInt[i]*x);
            i++;
        }
        int resto = soma%11;
        if (resto < 2) digitoVerif[0] = 0;
        else digitoVerif[0] = 11-resto;

        if (cpfInt[9] != digitoVerif[0]) return false;
        soma = 0;
        i = 0;
        for (int x=11; x>1; x--){
            soma += (cpfInt[i]*x);
            i++;
        }
        resto = soma%11;
        if (resto < 2) digitoVerif[0] = 0;
        else digitoVerif[1] = 11-resto;

        if (cpfInt[10] == digitoVerif[1]) validado = true;

        return validado;
    }

    public String getNomeCorretor() {
        return nomeCorretor;
    }

    public void setNomeCorretor(String nomeCorretor) {
        this.nomeCorretor = nomeCorretor;
    }
}
