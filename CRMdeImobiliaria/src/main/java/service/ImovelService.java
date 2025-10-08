package service;


import dao.ImovelDao;
import modelo.Comodos;
import modelo.Corretor;
import modelo.Imovel;
import modelo.StatusImovel;

import java.util.List;

public class ImovelService {
    private ImovelDao dao = new ImovelDao();

    public void add(Double preco, Comodos comodos, StatusImovel statusImovel, Corretor corretor){
        Imovel Imovel = new Imovel(preco,comodos, statusImovel, corretor);
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
