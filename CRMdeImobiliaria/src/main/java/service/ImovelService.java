package service;


import dao.ImovelDao;
import modelo.Comodos;
import modelo.Funcionario;
import modelo.Imovel;
import modelo.StatusImovel;

import java.util.List;

public class ImovelService {
    private ImovelDao dao = new ImovelDao();

    public void add(Double preco, Comodos comodos, StatusImovel statusImovel, Funcionario funcionario){
        Imovel Imovel = new Imovel(preco,comodos, statusImovel, funcionario);
        dao.add(Imovel);
    }

   /* public void add(String nome, String cpf){
        Imovel Imovel = new Imovel(nome, cpf, null, null);
        dao.add(Imovel);
    }*/

    public List<Imovel> buscarTodos(){
        return dao.buscaTodos();
    }
}
