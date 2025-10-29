package service;

import dao.FuncionarioDao;
import modelo.Funcionario;


public class FuncionarioService {
    FuncionarioDao dao = new FuncionarioDao();
    
    public void add(Funcionario funcionario){
        dao.add(funcionario);
    }

    public void add(String nome, String cpf, String email, String telefone){
        Funcionario funcionario = new Funcionario(nome, cpf, email, telefone);
        dao.add(funcionario);
    }

    public void add(String nome, String cpf){
        Funcionario funcionario = new Funcionario(nome, cpf, null, null);
        dao.add(funcionario);
    }

    public Funcionario buscaPorId(long id){
        return dao.buscaPorId(id);
    }
}
