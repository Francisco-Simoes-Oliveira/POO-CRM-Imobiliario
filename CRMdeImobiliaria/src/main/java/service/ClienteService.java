package service;

import dao.ClienteDao;
import dao.FuncionarioDao;
import modelo.Cliente;

import java.util.List;

public class ClienteService extends ServiceImplementacao<ClienteDao,Cliente,Long> {
    private ClienteDao dao = new ClienteDao();

    public ClienteService() {
        super(Cliente.class);
    }

    public void add(Cliente cliente){
        dao.add(cliente);
    }

    public void add(String nome, String cpf, String email, String telefone){
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        dao.add(cliente);
    }

    public void add(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf, null, null);
        dao.add(cliente);
    }

    public void alter(Cliente cliente){
        dao.alter(cliente);
    }

    public void alter(String nome, String cpf, String email, String telefone){
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        dao.alter(cliente);
    }

    public void alter(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf, null, null);
        dao.alter(cliente);
    }

    public List<Cliente> buscarTodos(){
       return dao.buscaTodos();
    }

    public List<Cliente> prencherTabela(){
        List<Cliente> clientes = buscarTodos();

        return clientes;
    }
}
