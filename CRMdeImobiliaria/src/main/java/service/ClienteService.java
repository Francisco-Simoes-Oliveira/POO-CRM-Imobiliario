package service;

import dao.ClienteDao;
import modelo.Cliente;

public class ClienteService {
    private ClienteDao dao = new ClienteDao();

    public void add(String nome, String cpf, String email, String telefone){
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        dao.add(cliente);
    }

    public void add(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf, null, null);
        dao.add(cliente);
    }
}
