package dao;

import modelo.Funcionario;

public class FuncionarioDao extends DaoImplementacao<Funcionario,Long>{
    public FuncionarioDao() {
        super(Funcionario.class);
    }
}
