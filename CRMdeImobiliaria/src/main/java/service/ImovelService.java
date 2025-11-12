package service;


import dao.ComodoDao;
import dao.ImovelDao;
import modelo.*;

import java.util.List;

public class ImovelService {
    private ImovelDao dao = new ImovelDao();


    public void add(Endereco endereco, Double preco, Comodos comodos, StatusImovel statusImovel, Funcionario funcionario){
        Imovel Imovel = new Imovel(endereco,preco,comodos, statusImovel, funcionario);
        dao.add(Imovel);
    }

    public void add( String logradouro, String bairro, String cidade, String uf, Double preco, int quarto, int banheiro, int cozinha, int sala, int garagem, StatusImovel status, Funcionario funcionario) {
        Comodos comodos = new Comodos(quarto, banheiro, cozinha,sala,garagem);
        Endereco endereco = new Endereco(logradouro,bairro,cidade,uf);
        Imovel imovel = new Imovel(endereco,preco, comodos, status, funcionario);

        dao.add(imovel);
    }


    public List<Imovel> buscarTodos(){
        return dao.buscaTodos();
    }
}
