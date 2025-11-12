package service;

import dao.ClienteDao;
import modelo.Cliente;

import java.util.List;

public class ClienteService extends ServiceImplementacao<ClienteDao,Cliente,Long> {
    private ClienteDao dao = new ClienteDao();

    public ClienteService() {
        super(ClienteDao.class);
    }

    public void add(String nome, String cpf, String email, String telefone){
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        dao.add(cliente);
    }

    public void add(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf, null, null);
        dao.add(cliente);
    }

    public void alter(String nome, String cpf, String email, String telefone){
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        dao.alter(cliente);
    }

    public void alter(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf, null, null);
        dao.alter(cliente);
    }

}
