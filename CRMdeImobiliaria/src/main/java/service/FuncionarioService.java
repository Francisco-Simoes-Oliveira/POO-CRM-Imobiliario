package service;

import dao.FuncionarioDao;
import modelo.Cargo;
import modelo.Funcionario;


public class FuncionarioService extends ServiceImplementacao<FuncionarioDao,Funcionario,Long> {

    public FuncionarioService() {
        super(FuncionarioDao.class);
    }


    public void add(String nome, String cpf, String email, String telefone,Cargo cargo){
        Funcionario funcionario = new Funcionario(nome, cpf, email, telefone, cargo);
        dao.add(funcionario);
    }

    public void add(String nome, String cpf, Cargo cargo){
        Funcionario funcionario = new Funcionario(nome, cpf, null, null,cargo);
        dao.add(funcionario);
    }


}
